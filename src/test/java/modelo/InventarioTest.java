/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author juandiegopena
 */
public class InventarioTest {

    @Test
    void noSePuedeVenderMasDelStockDisponible() {
        Inventario inv = new Inventario();
        inv.agregar("Teclado", 5, 350.0);

        assertThrows(StockInsuficienteException.class, () -> {
            inv.vender("Teclado", 8);
        });

        assertEquals(5, inv.buscar("Teclado").getCantidad());
    }

    @Test
    void venderCantidadValidaDescuentaStock() {
        Inventario inv = new Inventario();
        inv.agregar("Mouse", 10, 150.0);

        int stockRestante = inv.vender("Mouse", 3);

        assertEquals(7, stockRestante);
        assertEquals(7, inv.buscar("Mouse").getCantidad());
    }

    @Test
    void noSePuedeAgregarProductoConPrecioInvalido() {
        Inventario inv = new Inventario();

        assertThrows(IllegalArgumentException.class, () -> {
            inv.agregar("Monitor", 2, 0.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            inv.agregar("Monitor", 2, -50.0);
        });
    }

    @Test
    void calcularValorTotalInventario() {
        Inventario inv = new Inventario();
        inv.agregar("Laptop", 2, 10000.0);
        inv.agregar("Funda", 5, 200.0);    

        double total = inv.obtenerValorTotal();

        assertEquals(21000.0, total);
    }

    @Test
    void buscarProductoInexistenteDevuelveNull() {
        Inventario inv = new Inventario();
        inv.agregar("Cable USB", 20, 50.0);

        Producto resultado = inv.buscar("Adaptador");

        assertNull(resultado);
    }
}
