
import controlador.ControladorInventario;
import modelo.Inventario;
import vista.VistaConsola;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juandiegopena
 */
public class App {
    public static void main(String[] args) {
        Inventario modelo = new Inventario();
        VistaConsola vista = new VistaConsola();
        ControladorInventario controlador = new ControladorInventario(modelo, vista);
        controlador.iniciar();
    }
}
