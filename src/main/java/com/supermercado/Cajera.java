package com.supermercado;

public class Cajera {
    private String nombre;
    private int tiempoTotalProcesado;

    public Cajera(String nombre) {
        this.nombre = nombre;
        this.tiempoTotalProcesado = 0;
    }

    public synchronized void procesarCompra(int tiempo) {
        tiempoTotalProcesado += tiempo;
    }

    public int getTiempoTotalProcesado() {
        return tiempoTotalProcesado;
    }

    public String getNombre() {
        return nombre;
    }
}
