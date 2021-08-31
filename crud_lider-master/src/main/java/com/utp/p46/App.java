package com.utp.p46;

import com.utp.p46.vista.Vista;
import com.utp.p46.vista.VistaFormulario;


public class App 
{
    public static void main( String[] args )
    {
        /*
        Vista vista = new Vista();
        Controlador objControlador = new Controlador(vista);

        objControlador.conectar_bd();
        objControlador.buscar_lider("98765");
        */
        //objControlador.insertar_lider();
        /*
        Vista objVista = new Vista();
        //objVista.actualizar_lider();
        //objVista.buscar_lider();
        //objVista.actualizar_lider();
        objVista.crear_menu();
        */
        VistaFormulario objVistaFormulario = new VistaFormulario();
        objVistaFormulario.setVisible(true);

    }
}
