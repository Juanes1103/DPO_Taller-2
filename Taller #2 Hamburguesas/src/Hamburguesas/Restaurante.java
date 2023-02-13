package Hamburguesas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Hamburguesas.Ingrediente;
import Hamburguesas.ProductoMenu;
import Hamburguesas.Pedido;
import Hamburguesas.Combo;

public class Restaurante {
	
	//Métodos
	public Restaurante() {
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		
		System.out.println("Nombre registrado: " + nombreCliente + "\n");
		System.out.println("Direcion registrada: " + direccionCliente + "\n");
		
		
		
		
	}
	
	public void cerrarYGuardarPedido() {
		
	}
	
	public Pedido getPedidoEnCurso() {
		return null;
	}
	
	public ArrayList<Producto> getMenuBase(){
		return null;
	}
	
	public ArrayList<Ingrediente> getIngredientes(){
		return null;
		
	}
	
	public static Restaurante cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
		
		Map<Combo, Double> mCombo = new HashMap<>();
			
		System.out.println("\nLista de ingredientes disponibles\n");
		cargarIngredientes(archivoIngredientes);
		System.out.println("------------------------------------------------------------------------------");
			
		System.out.println("\nLista de productos disponibles\n");
		cargarMenu(archivoMenu);
		System.out.println("------------------------------------------------------------------------------");
			
		System.out.println("\nLista de combos disponibles\n");
		cargarCombos(archivoCombos);
		System.out.println("------------------------------------------------------------------------------");
		
		Restaurante restaurante = new Restaurante();
		
		return null;
		
		
		
	}
	
	private static void cargarIngredientes(File archivoIngredientes) throws IOException {
		
		Map<String, String> mIngredientes = new HashMap<>();
		
		BufferedReader arIngredientes = new BufferedReader(new FileReader(archivoIngredientes));
		String ingredientes = arIngredientes.readLine();
		while(ingredientes != null) {
			String[] partes = ingredientes.split(";");
			String nombreIngrediente = partes[0];
			String valorIngrediente = partes[1];
			
			String elIngrediente = mIngredientes.get(nombreIngrediente);
			if(elIngrediente == null)
			{
				mIngredientes.put(nombreIngrediente, valorIngrediente);
			}
			
			ingredientes = ingredientes.replace(";", " / valor: ");
			System.out.println(ingredientes);
			ingredientes = arIngredientes.readLine();
		}
		
	}
	
	private static void cargarMenu(File archivoMenu) throws IOException {
		
		Map<String, String> mMenu = new HashMap<>();
		
		BufferedReader arMenu = new BufferedReader(new FileReader(archivoMenu));
		String menu = arMenu.readLine();
		
		while(menu != null) {
			String[] partes = menu.split(";");
			String nombreProducto = partes[0];
			String valorProducto = partes[1];
			
			String elProducto = mMenu.get(nombreProducto);
			if(elProducto == null)
			{
				mMenu.put(nombreProducto, valorProducto);
			}
			
			
			menu = menu.replace(";", " / valor: ");
			System.out.println(menu);
			menu = arMenu.readLine();
		}
		
	}
	
	private static void cargarCombos(File archivoCombos) throws IOException {
		
		BufferedReader arCombos = new BufferedReader(new FileReader(archivoCombos));
		String combos = arCombos.readLine();
		
		
		while(combos != null) {
			System.out.println(combos);
			combos = arCombos.readLine();
		}
		
	}

}	

