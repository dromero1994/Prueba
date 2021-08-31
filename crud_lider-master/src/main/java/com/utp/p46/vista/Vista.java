package com.utp.p46.vista;

import java.sql.SQLException;
import java.util.Scanner;

import com.utp.p46.controlador.Controlador;
import com.utp.p46.modelo.vo.Lider;

public class Vista {
    // Atributo
    private Controlador objControlador;

    // Constructor
    public Vista() {
        this.objControlador = new Controlador();
    }

    public void crear_menu() {

        System.out.println("-----------CRUD LIDER--------");
        System.out.println("1 -> Buscar lider");
        System.out.println("2 -> Actualizar lider");
        System.out.println("3 -> Registrar lider");
        System.out.println("0 -> Salir");
        System.out.println("Por favor ingrese una opción:");
        try (Scanner entrada = new Scanner(System.in)){
            int opcion = entrada.nextInt();

            switch(opcion){
                case 1:
                    this.buscar_lider();
                    break;
                case 2:
                    this.actualizar_lider();
                    break;
                case 3:
                    this.crear_lider();
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    crear_menu();
                    break;
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e);
        }

    }

    public void buscar_lider() {
        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("por favor ingrese el documento del lider que desea consultar: ");
            String documento = entrada.next();

            this.mostrar_lider(this.objControlador.buscar_lider(documento));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public void mostrar_lider(Lider lider) {
        System.out.println("------------------LIDER-------------------");
        System.out.println("");
        System.out.println("Id: " + lider.getId());
        System.out.println("Nombre: " + lider.getNombre());
        System.out.println("Primer apellido: " + lider.getPrimer_apellido());
        System.out.println("Segundo apellido: " + lider.getSegundo_apellido());
        System.out.println("Salario: $" + lider.getSalario());
        System.out.println("Ciudad residencia: " + lider.getCiudad_residencia());
        System.out.println("Cargo: " + lider.getCargo());
        System.out.println("Clasificación: " + lider.getClasificacion());
        System.out.println("Documento de identidad: " + lider.getDocumento_identidad());
        System.out.println("Fecha nacimiento: " + lider.getFecha_nacimiento());
        System.out.println("");
        System.out.println("-------------------------------------------");
    }

    public Lider crear_formulario() {

        Lider objLider = this.objControlador.construir_lider();

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.println("Por favor ingrese el id: ");
            int id = entrada.nextInt();

            System.out.println("por favor ingrese el nombre: ");
            String nombre = entrada.next();

            System.out.println("Por favor ingrese el primer apellido: ");
            String pApellido = entrada.next();

            System.out.println("Por favor ingrese el segundo apellido: ");
            String sApellido = entrada.next();

            System.out.println("Por favor ingrese el salario: ");
            int salario = entrada.nextInt();

            System.out.println("Por favor ingrese la ciudad de residencia: ");
            String ciudad = entrada.next();

            System.out.println("Por favor ingrese el cargo: ");
            String cargo = entrada.next();

            System.out.println("Por favor ingrese la clasificación: ");
            int clasificacion = entrada.nextInt();

            System.out.println("Por favor ingrese el documento de identidad: ");
            String documento = entrada.next();

            System.out.println("Por favor ingrese la fecha de nacimiento (yyyy-mm-dd) :");
            String fecha_nacimiento = entrada.next();

            objLider = this.objControlador.construir_lider(id, nombre, pApellido, sApellido,
                salario, ciudad, cargo, clasificacion, documento, fecha_nacimiento);

        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

        return objLider;
    }

    public void crear_lider(){
        Lider objLider = this.crear_formulario();
        this.objControlador.insertar_lider(objLider);
        System.out.println("Lider registrado con éxito");
    }

    public void actualizar_lider() {

        try (Scanner entrada = new Scanner(System.in)) {

            System.out.println("Por favor ingrese la cedula del lider a actualizar: ");
            String documento_identidad = entrada.next();
            Lider objLider = this.objControlador.buscar_lider(documento_identidad);
            //Validar que el lider exista
            if(objLider.getNombre() == null){
                System.out.println("El lider con el documento ingresado no existe");
            }else{
                System.out.println("----------DATOS DEL LIDER A ACTUALIZAR-----------");
                this.mostrar_lider(objLider);
                System.out.println("--------------------------------------------------");
                System.out.println("");
                System.out.println("FORMULARIO DE ACTUALIZACIÓN:");
                Lider update_lider = this.crear_formulario();
                this.objControlador.actualizar_lider(update_lider, objLider.getId());
            }
            

        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            System.out.println(e.getMessage());
        }

    }

}
