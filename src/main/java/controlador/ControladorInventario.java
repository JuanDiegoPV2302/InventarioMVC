/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Inventario;
import modelo.StockInsuficienteException;
import vista.VistaCSV;
import vista.VistaConsola;

/**
 *
 * @author juandiegopena
 */
public class ControladorInventario {

    private Inventario inventario;
    private VistaConsola vista;
    private VistaCSV vistaCSV;

    public ControladorInventario(Inventario inventario, VistaConsola vista) {
        this.inventario = inventario;
        this.vista = vista;
        this.vistaCSV = new VistaCSV();
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenu();
            if (op == 1) {
                agregarProducto();
            } else if (op == 2) {
                venderProducto();
            } else if (op == 3) {
                vista.mostrarListado(inventario.obtenerProductos());
            } else if (op == 4) {
                double total = inventario.obtenerValorTotal();
                vista.mostrarMensaje("Valor del inventario: $" + total);
            } else if (op == 5) {
                vistaCSV.exportarInventario(inventario.obtenerProductos(), "inventario.csv");
            }
        } while (op != 0);
    }

    private void agregarProducto() {
        String n = vista.pedirTexto("Nombre: ");
        int c = vista.pedirEntero("Cantidad: ");
        double pr = vista.pedirDoble("Precio: ");

        try {
            inventario.agregar(n, c, pr);
            vista.mostrarMensaje("Agregado.");
        } catch (IllegalArgumentException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }

    private void venderProducto() {
        String n = vista.pedirTexto("Producto: ");

        if (inventario.buscar(n) == null) {
            vista.mostrarMensaje("No existe");
            return;
        }

        int c = vista.pedirEntero("Cantidad a vender: ");
        try {
            int restantes = inventario.vender(n, c);
            vista.mostrarMensaje("Venta ok. Quedan " + restantes);
        } catch (StockInsuficienteException e) {
            vista.mostrarMensaje(e.getMessage());
        }
    }
}
