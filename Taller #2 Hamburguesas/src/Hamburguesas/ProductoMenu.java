package Hamburguesas;

import Hamburguesas.Producto;

public class ProductoMenu {
	
	//Atributos
	private String nombre;
	private int precioBase;
	
	//Métodos
	public ProductoMenu(String nombre, int precioBase) {
		
		this.nombre = nombre;
		this.precioBase = precioBase;
		
		
	}
	
	public String getNombres() {
		return null;
	}
	
	public int getPrecios() {
		return 0;
	}
	
	public String generarTextoFactura() {
		return null;
	}
	
	//Setters y Getters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}
	
	
	
}
