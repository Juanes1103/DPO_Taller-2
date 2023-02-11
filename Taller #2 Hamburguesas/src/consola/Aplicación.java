package consola;

import java.util.Scanner;

import Hamburguesas.Restaurante;


public class Aplicación {

	public void main(String[] args) {
	
		ejecutarOpcion();
		
	}
	
	public void mostrarMenu() {
		
		System.out.println("Bienvenido al restaurante");
		System.out.println("Seleccione la opcion de su gusto");
		System.out.println("1. Mostrar el menu");
		System.out.println("2. Iniciar un nuevo pedido");
		System.out.println("3. Agregar un elemento a un pedido");
		System.out.println("4. Cerra pedido y guardar factura");
		System.out.println("5. Consultar la información de un pedido dada su id");
		
	}
	
	public void ejecutarOpcion(){
		
		boolean continuar = true;
		while(continuar)
		{
			try 
			{	
				mostrarMenu();
				System.out.println("\nIngrese una opcion: ");
				Scanner op = new Scanner(System.in);
				int opcion = op.nextInt();
				
				if (opcion == 1) {
					
					System.out.println("\nSe esta cargando el menú...");
					
				} else if (opcion == 2) {
					
					System.out.println("\nSe ha iniciado un nuevo pedido...");
					
				} else if (opcion == 3) {
					
					System.out.println("\nSe va a agregar un nuevo pedido...");
					
				} else if (opcion == 4) {
					
					System.out.println("\nSe va a cerrar el pedido...");
					
				} else if (opcion == 5) {
					
					System.out.println("\nSe va a consultar el pedido...");
				} else {
					System.out.println("\nSeleccione una opción valida");
				}
				
			}catch (NumberFormatException e) {
				
				System.out.println("\nSeleccione una opción valida");
				
			}
			
		}
		
		
	}

}
