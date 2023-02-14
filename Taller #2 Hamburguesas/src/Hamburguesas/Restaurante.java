package Hamburguesas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
	private ArrayList<Pedido> pedidos;
	private Pedido pedidoEnCurso;
	private String nombre;
	private String direccion;
	private static ArrayList<String> arregloIngredientes = new ArrayList<String>();
	private static ArrayList<String> arregloMenu = new ArrayList<String>();
	private static ArrayList<String> arregloCombos = new ArrayList<String>();
	private static ArrayList<String> arregloOrden = new ArrayList<String>();
	
	//Métodos
	public Restaurante() {
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente) {
		
		System.out.println("\nNombre registrado: " + nombreCliente);
		System.out.println("Direcion registrada: " + direccionCliente + "\n");
		
		nombre = nombreCliente;
		direccion = direccionCliente;
		
		boolean continuar = true;
		
		while(continuar == true) {
		
		System.out.println("\n-----------PRODUCTOS-----------\n");
		
		int k = 0;
		
		while (k<arregloMenu.size()){
			int p = k+1;
			String imp = p+"";
			
			System.out.println(imp + "." + arregloMenu.get(k));
			k++;
			
		}
		
		System.out.println("\n------------COMBOS------------\n");
		int j = arregloMenu.size();
		int i = 0;
		
		while (i<arregloCombos.size()){
			int p = j+1;
			String imp = p+"";
			
			
			System.out.println(imp + "." + arregloCombos.get(i));
			i++;
			j++;
			
		}
		
		System.out.println("\nSeleccione lo que desea añadir a su orden: ");
		Scanner op = new Scanner(System.in);
		int opcion = op.nextInt();
		
		if(opcion < 23) {
			
			String elemento = arregloMenu.get(opcion-1);
			arregloOrden.add(elemento);
			
			System.out.println("Se ha agregado " + elemento + " a la orden!\n");
			
		}else {
			String elemento = arregloCombos.get((opcion-arregloMenu.size())-1);
			arregloOrden.add(elemento);
			
			System.out.println("Se ha agregado " + elemento + " a la orden!\n");
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
			continuar = false;
		}
				
		
		}
		
		
	}
	
	private int parseInt(String opcion) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void cerrarYGuardarPedido() {
		
		
		System.out.println("\nSe ha guardao el pedido!\n");
	}
	
	public Pedido getPedidoEnCurso(String idPedido) {
		
		System.out.println("\nBuscando la información del pedido " + idPedido);
		System.out.println("\nSe ha encontrado la siguiente información");
		
		System.out.println("---------------");
		System.out.println("Id: " + idPedido);
		System.out.println("\nNombre: " + nombre);
		System.out.println("\nDirección: " + direccion);
		System.out.println("---------------");
		System.out.println("Descripción: ");
		System.out.println("\nEstado: ");
		System.out.println("---------------");
	
		
		return null;
	}
	
	public ArrayList<Producto> getMenuBase(){
		
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
		
		ArrayList<Ingrediente> aIngredientes = getIngredientes();
		
		Map<String, String> mIngredientes = new HashMap<>();
		
		BufferedReader arIngredientes = new BufferedReader(new FileReader(archivoIngredientes));
		String ingredientes = arIngredientes.readLine();
		while(ingredientes != null) {
			String[] partes = ingredientes.split(";");
			String nombreIngrediente = partes[0];
			String valorIngrediente = partes[1];
			
			//int costoAdicional = (int)valorIngrediente;
			
			String elIngrediente = mIngredientes.get(nombreIngrediente);
			if(elIngrediente == null)
			{
				mIngredientes.put(nombreIngrediente, valorIngrediente);
			//	Ingrediente nIngrediente = Ingrediente.Ingrediente(nombreIngrediente, );
				arregloIngredientes.add(nombreIngrediente);
			}
			
			ingredientes = ingredientes.replace(";", " / valor: ");
			System.out.println(ingredientes);
			ingredientes = arIngredientes.readLine();
		}
		System.out.println("\n" + mIngredientes);
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
				arregloMenu.add(nombreProducto);
			}
			
			
			menu = menu.replace(";", " / valor: ");
			System.out.println(menu);
			menu = arMenu.readLine();
		}
		System.out.println("\n" + mMenu);
	}
	
	private static void cargarCombos(File archivoCombos) throws IOException {
		
		Map<String, String> mCombos = new HashMap<>();
		
		BufferedReader arCombos = new BufferedReader(new FileReader(archivoCombos));
		String combos = arCombos.readLine();
		
		while(combos != null) {
			String[] partes = combos.split(";");
			String nombreCombo = partes[0];
			String descuentoCombo = partes[1];
			String productoCombo = partes[2];
			String tamañoPapasCombo = partes[3];
			String tamañoBebidaCombo = partes[4];
			
			String elCombo = mCombos.get(nombreCombo);
			if(elCombo == null)
			{
				mCombos.put(nombreCombo, descuentoCombo);
				arregloCombos.add(nombreCombo);
			}
			
			
			System.out.println(nombreCombo + " / descuento: " + descuentoCombo + " / producto: " + productoCombo + " / tamaño papas: " + tamañoPapasCombo + " / tamaño bebida: " + tamañoBebidaCombo);
			combos = arCombos.readLine();
			
		}
		System.out.println("\n" + mCombos);
	}

}	

