package com.mx.PadreHijo.SecurityConfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration // Es anotación define una fuente de configuración que va a contener beans
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						// Rutas publicas
						.requestMatchers("/api/Hijo/listar", "/api/Padre/listar").permitAll()
						// Rutas privadas con un permiso
						.requestMatchers("/api/Hijo/guardar", "/api/Padre/guardar").hasAuthority("CREATE")
						.requestMatchers("/api/Hijo/editar", "/api/Padre/editar").hasAuthority("UPDATE")
						// .requestMatchers("/api/Hijo/eliminar", "/api/Padre/eliminar").hasAuthority("DELETE")
						.requestMatchers("/api/Hijo/buscar", "/api/Padre/buscar").hasAuthority("READ")
						// Rutas privadas con accesso de rol
						.requestMatchers("/api/Hijo/eliminar", "/api/Padre/eliminar").hasRole("DEVELOPER")
						// Rutas por defecto, todas las rutas que no fue especificado su filtro deben llevar autenticación
						.anyRequest().authenticated()
						)
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsService(passwordEncoder()))
				.passwordEncoder(passwordEncoder())
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		// return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder pwd) {
		List<UserDetails> userDetailsList = new ArrayList<>();
		
		userDetailsList.add(User.withUsername("Admin")
				.password(pwd.encode("1234"))
				// .roles("ADMIN")
				.authorities("ROLE_ADMIN", "READ", "CREATE", "UPDATE", "DELETE")
				.build());
		
		userDetailsList.add(User.withUsername("Desarrollador")
				.password(pwd.encode("1234"))
				// .roles("DEVELOPER")
				.authorities("ROLE_DEVELOPER", "READ", "CREATE", "UPDATE")
				.build());
		
		userDetailsList.add(User.withUsername("Usuario")
				.password(pwd.encode("1234"))
				// .roles("USER")
				.authorities("ROLE_USER", "READ", "CREATE")
				.build());
		
		userDetailsList.add(User.withUsername("Invitado")
				.password(pwd.encode("1234"))
				// .roles("INVITED")
				.authorities("ROLE_INVITED", "READ")
				.build());
		
		return new InMemoryUserDetailsManager(userDetailsList);
	}
	
}
