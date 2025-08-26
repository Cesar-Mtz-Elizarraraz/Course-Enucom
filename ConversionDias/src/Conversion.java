import java.util.Scanner;

public class Conversion {
	
	public static void main(String[] args) {
		// Atributos
		int dias, horas, minutos, segundos;
		Scanner entrada;
		
		System.out.println("Ingrese los segundos a convertir: ");
		entrada = new Scanner(System.in);
		segundos = entrada.nextInt();
		
		if(segundos >= 0) {

			dias = segundos / (60 * 60 * 24);
			horas = (segundos % (60 * 60 * 24)) / 3600;
			minutos = (segundos % 3600) / 60;
			segundos = segundos % 60;
			
			System.out.println("Días: " + dias);
			System.out.println("Horas: " + horas);
			System.out.println("Minutos: " + minutos);
			System.out.println("Segundos: " + segundos);
			
		} else {
			System.out.println("Ingrese un valor valido para los segundos");
		}
	}
	
}
