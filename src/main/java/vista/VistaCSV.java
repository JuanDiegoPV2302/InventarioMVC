/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author juandiegopena
 */
public class VistaCSV {
    public void exportarInventario(List<Producto> productos, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            writer.write("Nombre,Cantidad,Precio\n"); 
            for (Producto p : productos) {
                writer.write(p.getNombre() + "," + p.getCantidad() + "," + p.getPrecio() + "\n");
            }
            System.out.println("El inventario ha sido exportado exitosamente a: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error en la exportación del archivo: " + e.getMessage());
        }
    }
}
