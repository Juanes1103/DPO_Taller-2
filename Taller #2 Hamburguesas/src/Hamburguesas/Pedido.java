package Hamburguesas;

import java.io.File;

public class Pedido {
	
	//Atributos
	private static int numeroPedidos;
	private int idPedido;
	private String nombreCliente;
	private String direccionCliente;
	
	//Métodos
	public Pedido(String nombreCliente, String direccionCliente) {
		
	}
	
	public int getIdPedidos() {
		return 0;
	}
	
	public void agregarProducto(Producto nuevoItem) {
		
	}
	
	private int getPrecioNetoPedido() {
		return 0;
	}
	
	private int getPrecioTotalPedido() {
		return 0;
	}
	
	private int getPrecioIVAPedido() {
		return 0;
	}
	
	private String generTextoFactura() {
		return null;
	}
	
	public void guardarFactura(File archivo) {
		
	}
	
	//Setters y Getters
	public static int getNumeroPedidos() {
		return numeroPedidos;
	}
	public static void setNumeroPedidos(int numeroPedidos) {
		Pedido.numeroPedidos = numeroPedidos;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDireccionCliente() {
		return direccionCliente;
	}
	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}
	
	

}
