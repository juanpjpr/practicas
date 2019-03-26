import java.util.ArrayList;

public class Lista {
	
	private static ArrayList<Item> listaItems=new ArrayList<>();
	
	void agregar(Item p){
		listaItems.add(p);
	}
	
	void mostrar(){
		for (Item p: listaItems) {
			System.out.println(p.toString());
		}
	}
	
	void buscar(int id){
		for (Item p: listaItems) {
			if (p.getId()==id){
				System.out.println(p.toString());
				return;
			}	
		}
		System.out.println("No se encontro id");
	}
}
