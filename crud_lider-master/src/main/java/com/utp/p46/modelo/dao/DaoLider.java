package com.utp.p46.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utp.p46.controlador.DatabaseController;
import com.utp.p46.modelo.vo.Lider;

public class DaoLider {

    public Lider buscar_lider(String documento_identidad){
        //Crear el objeto
        Lider objLider = new Lider();
        try {
            //Consulta sql
            /*
            String query = "SELECT * FROM Lider WHERE Documento_Identidad = \""+documento_identidad+"\"";
            System.out.println(query);
            Statement statement = this.conn.createStatement();
            //Ejecutamos el query
            ResultSet resultado = statement.executeQuery(query);
            */
            //query
            String query = "SELECT * FROM Lider WHERE Documento_Identidad = ?";
            Connection conn = DatabaseController.conectar_bd();
            //Preparar el query para su ejecución
            PreparedStatement pStatement = conn.prepareStatement(query);
            //añadimos valores al query
            pStatement.setString(1, documento_identidad);
            
            //ejecutar y obtener los resultados de la consulta
            ResultSet resultado = pStatement.executeQuery();
            //Verificamos que halla almenos un registro como respuesta
            if(resultado.next()){           
                    
                //Pasar datos de la BD al objeto
                objLider.setId( resultado.getInt("ID_Lider") );
                objLider.setNombre( resultado.getString("Nombre") );
                objLider.setPrimer_apellido( resultado.getString("Primer_Apellido") );
                objLider.setSegundo_apellido( resultado.getString("Segundo_Apellido") );
                objLider.setSalario( resultado.getInt("Salario") );
                objLider.setCiudad_residencia( resultado.getString("Ciudad_Residencia") );
                objLider.setCargo( resultado.getString("Cargo") );
                objLider.setClasificacion( resultado.getInt("Clasificacion") );
                objLider.setDocumento_identidad( resultado.getString("Documento_Identidad") );
                objLider.setFecha_nacimiento( resultado.getString("Fecha_Nacimiento") );
                
            }
            
            //Cerrar la conexión
            conn.close();
            pStatement.close();

        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            System.out.println("Error");
        }
        return objLider;
    }


    public void insertar_lider(Lider objLider){
        //Consulta SQL
        String query = "INSERT INTO Lider VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = DatabaseController.conectar_bd();
            PreparedStatement pStatement = conn.prepareStatement(query);
            //Insertar los valores en el query
            pStatement.setInt(1, objLider.getId());
            pStatement.setString(2, objLider.getNombre());
            pStatement.setString(3, objLider.getPrimer_apellido());
            pStatement.setString(4, objLider.getSegundo_apellido());
            pStatement.setInt(5, objLider.getSalario());
            pStatement.setString(6, objLider.getCiudad_residencia());
            pStatement.setString(7, objLider.getCargo());
            pStatement.setInt(8, objLider.getClasificacion());
            pStatement.setString(9, objLider.getDocumento_identidad());
            pStatement.setString(10, objLider.getFecha_nacimiento());

            //Ejecutar query
            if(pStatement.executeUpdate() == 1){
                System.out.println("Lider registrado con éxito!");
            }
            //cerrar conexión
            conn.close();
            pStatement.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e);
        }
    }


    public void actualizar_lider(Lider objLider, int id){
        //Armar la estructura del query
        String query = "UPDATE Lider SET ID_Lider = ?, Nombre = ?, Primer_Apellido = ?, Segundo_Apellido = ?, Salario = ?, Ciudad_Residencia = ?, Cargo = ?, Clasificacion  = ?, Documento_Identidad  = ?, Fecha_Nacimiento = ? WHERE ID_Lider = ?";
        
        try {
            Connection conn = DatabaseController.conectar_bd();
            PreparedStatement pStatement = conn.prepareStatement(query);
            //Pasar los parámetros al query
            pStatement.setInt(1, objLider.getId());
            pStatement.setString(2, objLider.getNombre());
            pStatement.setString(3, objLider.getPrimer_apellido());
            pStatement.setString(4, objLider.getSegundo_apellido());
            pStatement.setInt(5, objLider.getSalario());
            pStatement.setString(6, objLider.getCiudad_residencia());
            pStatement.setString(7, objLider.getCargo());
            pStatement.setInt(8, objLider.getClasificacion());
            pStatement.setString(9, objLider.getDocumento_identidad());
            pStatement.setString(10, objLider.getFecha_nacimiento());
            pStatement.setInt(11, id);

            /**
             * pStatement.executeUpdate() -> Ejecuta el query
             * Se obtiene como respuesta: 
             * 1 -> Ejecución satisfactoria
             * 2 -> No se afectó ningún registro
             */
            if(pStatement.executeUpdate() == 1){
                System.out.println("Actualización satisfacotira");
            }else{
                System.out.println("Error al actualizar");
            }
            //cerrar conexión
            conn.close();
            pStatement.close();
        } catch (Exception e) {
            //TODO: handle exception
            System.err.println(e);
        }
    }

    
}
