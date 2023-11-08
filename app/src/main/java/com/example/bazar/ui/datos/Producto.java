package com.example.bazar.ui.datos;

import java.util.ArrayList;
import java.util.Date;

public class Producto {
    private String nombre;
    private String marca;

    private String categoria;
    private String precio;
    private Usuario creador;

    private ArrayList<Usuario> usuariosIntegrantes;

    public static ArrayList<Producto> productos = new ArrayList<>();


    static {
        Usuario unsuario = new Usuario("Carlos ", "carosen@gmail.com", "0000", "0971258963");
        productos.add(new Producto("Zapato negro", "Nike", "Calzado", "100", unsuario));
        productos.add(new Producto("Camisa Polo azul", "Ralph Lauren", "Ropa", "120", unsuario));
        productos.add(new Producto("Collar de perlas", "Dior", "Accesrios", "500", unsuario));
        productos.add(new Producto("Gorro gris", "Adidas", "Accesorios", "80", unsuario));
        productos.add(new Producto("Pulsera con brillo", "Swasrozki", "Acesorio", "250", unsuario));


    }


    public Producto(String nombre, String marca, String categoria, String precio,
                    Usuario creador) {
        this.nombre = nombre;
        this.marca = marca;
        this.categoria = categoria;
        this.precio = precio;
        this.creador = creador;
        usuariosIntegrantes = new ArrayList<>();
        usuariosIntegrantes.add(creador);
    }
    public static void agregarProducto( Producto unProducto ) {
        productos.add( unProducto );
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    @Override
    public String toString() {
        return String.format("Producto {nombre: %s}", nombre);
    }

}
