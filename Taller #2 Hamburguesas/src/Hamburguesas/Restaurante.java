package Hamburguesas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Hamburguesas.Ingrediente;
import Hamburguesas.ProductoMenu;
import Hamburguesas.Pedido;
import Hamburguesas.Combo;

public class Restaurante {
	
	//Atributos
	private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	private Pedido pedidoEnCurso;
	private static ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
	private static ArrayList<ProductoMenu> menuBase = new ArrayList<ProductoMenu>();
	private static ArrayList<Combo> combos = new ArrayList<Combo>();
	
	private static ArrayList<String> arregloOrden = new ArrayList<String>();
	
	//Métodos
	public Restaurante() {
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		
		System.out.println("\nNombre registrado: " + nombreCliente);
		System.out.println("Direcion registrada: " + direccionCliente + "\n");
		Pedido pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
		pedidos.add(pedidoEnCurso);
		
	
		
		boolean continuar = true;
		
		while(continuar == true) {
		
		System.out.println("-----------PRODUCTOS-----------\n");
		
		int k = 0;
		
		while (k<menuBase.size()){
			int p = k+1;
			String imp = p+"";
			
			System.out.println(imp + "." + menuBase.get(k).getNombre());
			k++;
			
		}
		
		System.out.println("\n------------COMBOS------------\n");
		int j = menuBase.size();
		int i = 0;
		
		while (i<combos.size()){
			int p = j+1;
			String imp = p+"";
			
			
			System.out.println(imp + "." + combos.get(i).getNombre());
			i++;
			j++;
			
		}
		
		System.out.println("\nSeleccione lo que desea añadir a su orden: ");
		Scanner op = new Scanner(System.in);
		int opcion = op.nextInt();
		
		if(opcion < 23) {
			
			ProductoMenu elemento = menuBase.get(opcion-1);
			arregloOrden.add(elemento.getNombre());
			
			System.out.println("Se ha agregado " + elemento.getNombre() + " a la orden!\n");
			
		}else {
			Combo elemento = combos.get((opcion-menuBase.size())-1);
			arregloOrden.add(elemento.getNombre());
			
			System.out.println("Se ha agregado " + elemento.getNombre() + " a la orden!\n");
		}
		
		
		System.out.println("Elementos en el pedido: \n");
		int x = 0;
		
		while (x<arregloOrden.size()){
			int imp = x+1;
			
			System.out.println(imp + ". " + arregloOrden.get(x));
			
			x++;
		}
		
		System.out.println("\n¿Desea agregar algo más a su pedido?");
		System.out.println("1. Sí");
		System.out.println("0. No");
		Scanner decision = new Scanner(System.in);
		int num = decision.nextInt();
		
		if (num == 1) {
			continuar = true;
		} else {
			if (arregloOrden.size() == 0) {
				System.out.println("\nDebe agregar por lo menos un producto a su orden!");
				continuar = true;
			}else {
				continuar = false;
			}
			
		}	
		
		}
		
		System.out.println("\n--------RESUMEN DEL PEDIDO--------\n");
		
		int y = 0;
		
		while (y<arregloOrden.size()) {
			System.out.println("+" + arregloOrden.get(y));
			
			y++;
		}
		
		System.out.println("\n--------------------------------------");
		
	}
	
	private static int parseInt(String opcion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cerrarYGuardarPedido() {
		
		
		System.out.println("\nSe ha guardado el pedido!\n");
	}
	
	public Pedido getPedidoEnCurso(String idPedido) {
		
		System.out.println("\nBuscando la información del pedido " + idPedido);
		System.out.println("\nSe ha encontrado la siguiente información");
		
		Pedido orden = pedidos.get(0);
		
		
		System.out.println("---------------");
		System.out.println("Id: " + idPedido);
		System.out.println("\nNombre: " + orden.getNombreCliente());
		System.out.println("\nDirección: " + orden.getDireccionCliente());
		System.out.println("---------------");
		System.out.println("Descripción: ");
		System.out.println("\nEstado: ");
		System.out.println("---------------");
	
		
		return null;
	}
	
	public static ArrayList<Producto> getMenuBase(){
		
		ArrayList<Producto> aMenu = new ArrayList<Producto>();
		
		return aMenu;
	}
	
	public static ArrayList<Ingrediente> getIngredientes(){
		
		ArrayList<Ingrediente> aIngredientes = new ArrayList<Ingrediente>();
		
		return aIngredientes;
		
	}
	
	public static Restaurante cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) throws IOException {
			
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
		
		return restaurante;
		
		
		
	}
	
	private static void cargarIngredientes(File archivoIngredientes) throws IOException {
		
		BufferedReader arIngredientes;
		arIngredientes = new BufferedReader(new FileReader(archivoIngredientes));
		String ingrediente = arIngredientes.readLine();
		while(ingrediente != null) {
			String[] partes = ingrediente.split(";");
			String nombreIngrediente = partes[0];
			String valorIngrediente = partes[1];
			int valor = parseInt(valorIngrediente);
			Ingrediente nuevo = new Ingrediente(nombreIngrediente, valor);
			
			ingredientes.add(nuevo);
				
			//int costoAdicional = (int)valorIngrediente;
				
			ingrediente = ingrediente.replace(";", " / valor: ");
			System.out.println(ingrediente);
			ingrediente = arIngredientes.readLine();
		}
		arIngredientes.close();

	}
	
	private static void cargarMenu(File archivoMenu) throws IOException {
		
		BufferedReader arMenu = new BufferedReader(new FileReader(archivoMenu));
		String menu = arMenu.readLine();
		
		while(menu != null) {
			String[] partes = menu.split(";");
			String nombreProducto = partes[0];
			String valorProducto = partes[1];
			int valor = parseInt(valorProducto);
			ProductoMenu nuevo = new ProductoMenu(nombreProducto, valor);
			
			menuBase.add(nuevo);
			
			menu = menu.replace(";", " / valor: ");
			System.out.println(menu);
			menu = arMenu.readLine();
		}
		arMenu.close();
	}
	
	private static void cargarCombos(File archivoCombos) throws IOException {
		
		BufferedReader arCombos = new BufferedReader(new FileReader(archivoCombos));
		String combo = arCombos.readLine();
		
		while(combo != null) {
			String[] partes = combo.split(";");
			String nombreCombo = partes[0];
			String descuentoCombo = partes[1];
			String productoCombo = partes[2];
			String tamañoPapasCombo = partes[3];
			String tamañoBebidaCombo = partes[4];
			
			int descuento = parseInt(descuentoCombo);
			
			Combo nuevo = new Combo(nombreCombo, descuento);
			combos.add(nuevo);
			
			System.out.println(nombreCombo + " / descuento: " + descuentoCombo + " / producto: " + productoCombo + " / tamaño papas: " + tamañoPapasCombo + " / tamaño bebida: " + tamañoBebidaCombo);
			combo = arCombos.readLine();
			
		}
		arCombos.close();
	}

}	

