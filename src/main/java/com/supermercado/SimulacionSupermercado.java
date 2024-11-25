package com.supermercado;

import java.util.ArrayList;
import java.util.List;

public class SimulacionSupermercado {
    public static void main(String[] args) {
        // Crear cajeras
        Cajera cajera1 = new Cajera("Luisa");
        Cajera cajera2 = new Cajera("David");
        List<Cajera> cajeras = new ArrayList<>();
        cajeras.add(cajera1);
        cajeras.add(cajera2);

        // Crear productos
        Producto leche = new Producto("Leche", 2.500, 2);
        Producto pan = new Producto("Pan", 2.000, 1);
        Producto arroz = new Producto("Arroz", 2.200, 3);
        Producto manzanas = new Producto("Manzanas", 1.000, 2);
        Producto jugo = new Producto("Gaseosa", 4.000, 1);

        // Crear clientes
        Cliente cliente1 = new Cliente("Cliente 1", cajeras.get(0), new Producto[]{leche, pan});
        Cliente cliente2 = new Cliente("Cliente 2", cajeras.get(1), new Producto[]{arroz, manzanas});
        Cliente cliente3 = new Cliente("Cliente 3", cajeras.get(0), new Producto[]{jugo, pan});

        // Crear hilos para cada cliente
        Thread hiloCliente1 = new Thread(cliente1);
        Thread hiloCliente2 = new Thread(cliente2);
        Thread hiloCliente3 = new Thread(cliente3);

        // Iniciar los hilos
        hiloCliente1.start();
        hiloCliente2.start();
        hiloCliente3.start();

        try {
            hiloCliente1.join();
            hiloCliente2.join();
            hiloCliente3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar tiempos totales de las cajeras
        for (Cajera cajera : cajeras) {
            System.out.println(cajera.getNombre() + " ha procesado un total de " + cajera.getTiempoTotalProcesado() + " segundos.");
        }
    }
}