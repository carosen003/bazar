package com.example.bazar.ui.utils;

public enum RequestCode {
	ITEM_EDITAR_TARJETA(1, "Editar tarjeta del menu de MostrarTarjetaActivity"),
	ACT_LANZADA_CREAR_PRODUCTO(2, "Actividad lanzada Crear producto"),
	PETICION_EDITAR_PRODUCTO(3, "Peticion editar producto");
	
	private int codigo;	
	private String descripcion;
	
	RequestCode(int codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
