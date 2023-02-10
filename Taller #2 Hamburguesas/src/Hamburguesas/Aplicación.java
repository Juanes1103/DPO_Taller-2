package Hamburguesas;

public class Aplicación {

	public static void main(String[] args) {
		mostrarMenu();
		ejecutarOpcion();
		
		
	}
	
	public static void mostrarMenu() {
		
		System.out.println("Bienvenido al restaurante");
		System.out.println("Seleccione la opción de su gusto");
		System.out.println("1. Mostrar el menú");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerra pedido y guardar factura");
		System.out.println("5. Consultar la información de un pedido dada su id");
		
	}
	
	public static void ejecutarOpcion(){
		
		int opcion = 0;
		System.out.println("\nIngrese una opción: \n");
		
		if (opcion == 1) {
			
			System.out.println("Se esta cargando el menú...");
			
		} else if (opcion == 2) {
			
			System.out.println("Se ha iniciado un nuevo pedido...");
			
		} else if (opcion == 3) {
			
			System.out.println("Se va a agregar un nuevo pedido...");
			
		} else if (opcion == 4) {
			
			System.out.println("Se va a cerrar el pedido...");
			
		} else if (opcion == 5) {
			
			System.out.println("Se va a consultar el pedido...");
		} else {
			System.out.println("Seleccione una opción valida");
		}
		
		
	}

}
