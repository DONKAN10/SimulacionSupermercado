package com.supermercado;

public class Cliente implements Runnable {
    private String nombre;
    private Cajera cajera;
    private Producto[] productos;

    public Cliente(String nombre, Cajera cajera, Producto[] productos) {
        this.nombre = nombre;
        this.cajera = cajera;
        this.productos = productos;
    }

    @Override
    public void run() {
        double total = 0;
        int tiempoTotal = 0;

        System.out.println(nombre + " empieza a comprar.");

        for (Producto producto : productos) {
            total += producto.getPrecio();
            tiempoTotal += producto.getTiempoProcesar();
            System.out.println("Procesando: " + producto);
            try {
                Thread.sleep(producto.getTiempoProcesar() * 1000); // Simula el tiempo de cobro
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(nombre + " ha completado su compra. Total: $" + total);
        cajera.procesarCompra(tiempoTotal);
        System.out.println(nombre + " se demoró " + tiempoTotal + " segundos.");
    }
}
