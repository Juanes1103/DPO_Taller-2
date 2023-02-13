package Hamburguesas;

import Hamburguesas.Producto;
import Hamburguesas.ProductoMenu;

public class Combo {
	
	//Atributos
	private double descuento;
	private String nombreCombo;
	
	//Métodos
	public Combo(String nombreCombo, double descuento) {
		this.nombreCombo = nombreCombo;
		this.descuento = descuento;
		
	}
	
	public void agregarItemACombo(Producto itemCombo) {
		
	}
	
	public int getPrecio() {
		return 0;
	}
	
	public String generarTextoFactura() {
		return null;
	}
	
	public String getNombre() {
		return null;
	}
	//Setters y Getters
	
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public String getNombreCombo() {
		return nombreCombo;
	}
	public void setNombreCombo(String nombreCombo) {
		this.nombreCombo = nombreCombo;
	}
	
}
