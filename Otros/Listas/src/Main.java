import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
	    Auto auto0 = new Auto("a100","Lobo","Ford",2020,8,4);
	    Auto auto1 = new Auto("a101","Versa","Nissan",2019,4,4);
	    Auto auto2 = new Auto("a102","Corrolla","Toyota",2018,6,2);
	    Auto auto3 = new Auto("a103","a200","Mercedez Benz", 2024,4,4);
	    
	    //Instanciar una lista vacia
	    List<Auto> listaAutos = new ArrayList<Auto>();
	    
	    //Agregar elementos a la lista
	    listaAutos.add(auto0);//indice 0
	    listaAutos.add(auto1);//indice 1
	    listaAutos.add(auto2);//indice 2
	    listaAutos.add(auto3);//indice 3
	    
	    //Mostrar el contenido de la lista
	    System.out.println(listaAutos);
	    
	    //Buscar un elemento de la lista o obtenerlo con el indice
	    Auto auto_aux = listaAutos.get(2);
	    System.out.println("El contenido de auto auxiliar es\n"+auto_aux);
	    
	    //Editar un elemento de la lista
	    auto_aux = listaAutos.get(3);
	    auto_aux.setCilindros(6);
	    listaAutos.set(3, auto_aux);
	    System.out.println("\n"+listaAutos);
	    
	    //Eliminar un elemento de la lista
	    listaAutos.remove(1);
	    System.out.println("\n"+listaAutos);
	    
	    //Recorrer lista
	    for(int i = 0; i < listaAutos.size();i++) {
	        System.out.println("["+i+"] "+listaAutos.get(i));	
	    }
	    
	    //Recorrer la lista for each
	    System.out.println("\n");
	    for(Auto a:listaAutos){
	        System.out.println(a);	
	    }
	    
	    //Vaciar la lista
	    listaAutos.clear();
	    System.out.println(listaAutos);
	    
	    
	    
	    
	}
}
