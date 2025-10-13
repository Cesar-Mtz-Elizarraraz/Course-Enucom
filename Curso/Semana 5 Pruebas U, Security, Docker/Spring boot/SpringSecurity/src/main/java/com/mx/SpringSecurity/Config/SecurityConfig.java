package com.mx.SpringSecurity.Config;

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
						.requestMatchers("/auth/public").permitAll()
						// Rutas privadas con accesso de rol
						.requestMatchers("/auth/rol").hasRole("ADMIN")
						// Rutas privadas con un permiso
						.requestMatchers("/auth/permiso").hasAuthority("READ")
						// Rutas por defecto, todas las rutas que no fue especificado su filtro deben llevar autenticación
						.anyRequest().authenticated())
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
		
		userDetailsList.add(User.withUsername("Santiago")
				.password(pwd.encode("1234"))
				//.roles("ADMIN")
				.authorities("ROLE_ADMIN", "READ", "CREATE")
				.build());
		
		userDetailsList.add(User.withUsername("Daniel")
				.password(pwd.encode("1234"))
				.roles("USER")
				.authorities("READ")
				.build());
		
		return new InMemoryUserDetailsManager(userDetailsList);
	}
	
}
