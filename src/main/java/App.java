import view.Vista;
import view.VistaProyecto;

/**
 * Persistencia Proyectos Construcción
 *
 */
public class App {
    public static void main(String[] args) {

        // Casos de prueba

        // Requerimiento 1 - Reto3
       /* Vista.vista_requerimiento_1();//ok// 
        Vista.vista_requerimiento_2();//ok//
        Vista.vista_requerimiento_3(); //ok//
        Vista.vista_requerimiento_4();
        Vista.vista_requerimiento_5();//ok//*/
        VistaProyecto objVistaProyecto=new VistaProyecto();
        objVistaProyecto.setVisible(true);

    }
}
