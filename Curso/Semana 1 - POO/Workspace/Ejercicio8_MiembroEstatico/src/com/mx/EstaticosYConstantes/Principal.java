package com.mx.EstaticosYConstantes;

public class Principal {
	// MIEMBRO ESTÁTICO: Métodos o atributos que se asocian a una clase en lugar de una instancia
	// CONSTANTE: Son variables que se delegan con la palabra clave final y su valor nunca cambia durante la ejecución
	
	// MIEBRO ESTÁTICO
	public static String frase1 = "Miembro estático";
	
	// CONSTANTE O VARIABLE FINAL
	public final String frase2 = "Variable final constante"; // NECESITA INSTANCIA
	
	// CONSTANTE ESTÁTICA: No cambiar despúes de su inicialización
	public static final String frase3 = "Variable final estática";
	
	public static void main(String[] args) {
		// ACCESO A MIS MIEBROS ESTÁTICOS ASOCIADOS A MI CLASE
		System.out.println(frase1);
		System.out.println(frase3);
		
		float radio = 5;
		double area = calcularAreaCirculo(radio);
		System.out.println("El área del círculo con radio " + radio + " es" + area);
	}
	
	// MÉTODO QUE CALCULE EL ÁREA DE UN CPICULO
	private static double calcularAreaCirculo(float radio) {
		return Math.PI * (radio * radio);
	}
	
}
