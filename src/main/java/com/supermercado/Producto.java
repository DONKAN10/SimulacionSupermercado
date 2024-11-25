package com.supermercado;

public class Producto {
    private String nombre;
    private double precio;
    private int tiempoProcesar; // Tiempo en segundos que tarda en procesarse

    public Producto(String nombre, double precio, int tiempoProcesar) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProcesar = tiempoProcesar;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getTiempoProcesar() {
        return tiempoProcesar;
    }

    @Override
    public String toString() {
        return nombre + " ($" + precio + ")";
    }
}
