package view;


import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controlador;
import model.vo.Lider;
import model.vo.Proyecto;

public class Vista {

    public static final Controlador controlador = new Controlador();

    public static void vista_requerimiento_1() {

        try {

            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_1();
            for (int i = 0; i < proyectos.size(); i++) {
                System.out.println("Fecha_Inicio: "+proyectos.get(i).getFecha_inicio()+" - Numero_Habitaciones: "+proyectos.get(i).getNum_habitaciones()+ " - Numero_Banos: "+proyectos.get(i).getNum_banios());
           }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }

    public static void vista_requerimiento_2() {
        try {
            String cadena;
            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_2();
            for (int i = 0; i < proyectos.size(); i++) {
                cadena="Fecha_Inicio: "+proyectos.get(i).getFecha_inicio();
                cadena+=" - Numero_Habitaciones: "+proyectos.get(i).getNum_habitaciones();
                cadena+=" - Numero_Banos: "+proyectos.get(i).getNum_banios();
                cadena+=" - Nombre_Lider: "+proyectos.get(i).getLider().getNombre();
                cadena+=" - Apellido_Lider: "+proyectos.get(i).getLider().getApellido();
                cadena+=" - Estrato_Proyecto: "+proyectos.get(i).getEstrato_proyecto();
                System.out.println(cadena);
           }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
    }

    public static void vista_requerimiento_3() {
        try{
            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_3();
            for(int i=0;i<proyectos.size();i++){
                System.out.println("Total_Habitaciones: "+proyectos.get(i).getNum_habitaciones()+" - Constructora: "+proyectos.get(i).getNombre_constructora());
            }
        }
        catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+ e.getMessage());
        }
    }

    public static void vista_requerimiento_4() {
        try{
            ArrayList<Lider> lider = controlador.Solucionar_requerimiento_4();
            String cadena;
            for(int i=0;i<lider.size();i++){
                cadena="Nombre_Lider: "+lider.get(i).getNombre();
                cadena+=" - Apellido_Lider: "+lider.get(i).getApellido();
                System.out.println(cadena);
            }
        }
        catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+ e.getMessage());
        }
    }

    public static void vista_requerimiento_5() {
        try{
            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_5();
            for(int i=0;i<proyectos.size();i++){
                System.out.println("Total_Habitaciones: "+proyectos.get(i).getNum_habitaciones()+" - Constructora: "+proyectos.get(i).getNombre_constructora());
            }
        }
        catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+ e.getMessage());
        }
    }

}
