/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainCRUD;

import Controlador.ClienteController;
import Modelo.Clientes;
import Modelo.ConsultasClientes;
import Vista.frmClientes;

/**
 *
 * @author USUARIO
 */
public class clienteMain {

    public static void main(String[] args) {
        Clientes modelo = new Clientes();
        ConsultasClientes consulta = new ConsultasClientes();
        frmClientes vista = new frmClientes();
        
        ClienteController ctrl = new ClienteController(modelo, vista, consulta);
        ctrl.iniciar();
        vista.setVisible(true);
        
                           
    }

}
