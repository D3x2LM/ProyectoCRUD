/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainCRUD;

import Controlador.ControlProducto;
import Modelo.ConsultasProductos;
import Modelo.Productos;
import Vista.frmProductos;

public class Main {

    public static void main(String[] args) {
        Productos modelo = new Productos();
        ConsultasProductos consulta = new ConsultasProductos();
        frmProductos vista = new frmProductos();

        ControlProducto ctrl = new ControlProducto(modelo, consulta, vista);
        ctrl.iniciar();
        vista.setVisible(true);
    }

}


