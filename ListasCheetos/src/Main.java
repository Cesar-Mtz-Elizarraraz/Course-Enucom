import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Cheeto cheeto1 = new Cheeto("Torciditos", "Sabritas", 100, 12.50, "2025-08-30", true);
		Cheeto cheeto2 = new Cheeto("Rifaditas", "Sol", 200, 30, "2025-07-25", true);
		Cheeto cheeto3 = new Cheeto("Toreadas", "Barcel", 100, 16, "2026-02-27", false);
		Cheeto cheeto4 = new Cheeto("Takis", "Barcel", 100, 18.50, "2026-01-30", false);
		Cheeto cheeto5 = new Cheeto("Falmin Hot", "Sabritas", 100, 25, "2025-09-15", true);
		
		// Instanciar lista
		List<Cheeto> listCheetos = new ArrayList<Cheeto>();
		
		// Agregar elementos
		listCheetos.add(cheeto1);
		listCheetos.add(cheeto2);
		listCheetos.add(cheeto3);
		listCheetos.add(cheeto4);
		listCheetos.add(cheeto5);
		
		// Comprobar la adición
		System.out.println("Lista de cheetos: " + listCheetos);
		
		// Buscar el 3er elemento
		Cheeto found_cheeto = listCheetos.get(2);
		System.out.println("\n3er elemento: " + found_cheeto);
		
		// Editar el elemento número 2
		int index_edit = 1;
		found_cheeto = listCheetos.get(index_edit);
		found_cheeto.setMarca("Del carrito");
		found_cheeto.setCaducidad("2026-12-31");
		
		listCheetos.set(index_edit, found_cheeto);
		System.out.println("Cheetos actualizados: " + listCheetos);
		
		// Listar con forEach
		int index = 1;
		System.out.println("\n");
		for(Cheeto c : listCheetos){
			System.out.println(index + ".- " + c);
			index++;
		}
		
		// Listar con for clásico
		System.out.println("\n");
		for(int i = 0; i < listCheetos.size(); i++){
			System.out.println((i + 1) + ".- " + listCheetos.get(i));
		}
		
	}
}
