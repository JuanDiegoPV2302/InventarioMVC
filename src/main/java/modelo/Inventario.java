/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juandiegopena
 */
public class Inventario {

    private List<Producto> productos = new ArrayList<>();

    public void agregar(String nombre, int cantidad, double precio) {
        if (nombre == null || nombre.trim().isEmpty() || cantidad < 0 || precio <= 0) {
            throw new IllegalArgumentException("Datos invalidos");
        }
        productos.add(new Producto(nombre, cantidad, precio));
    }

    public Producto buscar(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public int vender(String nombre, int cantidad) {
        Producto p = buscar(nombre);
        if (p == null) {
            throw new IllegalArgumentException("No existe");
        }
        if (cantidad > p.getCantidad()) {
            throw new StockInsuficienteException("Stock insuficiente");
        }
        p.setCantidad(p.getCantidad() - cantidad);
        return p.getCantidad();
    }

    public List<Producto> obtenerProductos() {
        return new ArrayList<>(productos);
    }

    public double obtenerValorTotal() {
        double total = 0;
        for (Producto p : productos) {
            total += p.getCantidad() * p.getPrecio();
        }
        return total;
    }
}
