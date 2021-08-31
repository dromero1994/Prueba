package model.dao;

//Estructura de datos
import java.util.ArrayList;

import model.vo.Lider;
import model.vo.Proyecto;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

public class ProyectoDao {

    public ArrayList<Proyecto> query_requerimiento_1() throws SQLException {
        ArrayList<Proyecto> objProyecto = new ArrayList<Proyecto>();
        
        try {
            String query = "SELECT  Fecha_Inicio,Numero_Habitaciones,Numero_Banos FROM Proyecto WHERE Constructora = 'Pegaso'";
            Connection conn = JDBCUtilities.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(query);
            ResultSet resultado = pStatement.executeQuery();
            while (resultado.next()) {
                Proyecto objProyectoReq1 = new Proyecto();
                objProyectoReq1.setFecha_inicio(resultado.getString("Fecha_Inicio"));
                objProyectoReq1.setNum_habitaciones(resultado.getInt("Numero_Habitaciones"));
                objProyectoReq1.setNum_banios(resultado.getInt("Numero_Banos"));
                objProyecto.add(objProyectoReq1);

            }
            conn.close();
            pStatement.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        return objProyecto;

    }
    public ArrayList<Proyecto> query_requerimiento_2() throws SQLException {
        ArrayList<Proyecto> objProyecto = new ArrayList<Proyecto>();
        
        try {
            String query = "SELECT P.Fecha_Inicio,P.Numero_Habitaciones,P.Numero_Banos,l.Nombre ,l.Primer_Apellido,t.Estrato ";
            query+="FROM Proyecto p ";
            query+="INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider ";
            query+="INNER JOIN Tipo t ON  t.ID_Tipo =  p.ID_Tipo ";
            query+="WHERE p.Constructora ='Pegaso' ";
            query+="LIMIT 50";
            Connection conn = JDBCUtilities.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(query);
            ResultSet resultado = pStatement.executeQuery();
            while (resultado.next()) {
                Proyecto objProyectoReq2 = new Proyecto();
                Lider objLiderReq2=new Lider(resultado.getString("Nombre"),resultado.getString("Primer_Apellido"));
                objProyectoReq2.setFecha_inicio(resultado.getString("Fecha_Inicio"));
                objProyectoReq2.setNum_habitaciones(resultado.getInt("Numero_Habitaciones"));
                objProyectoReq2.setNum_banios(resultado.getInt("Numero_Banos"));
                objProyectoReq2.setLider(objLiderReq2);
                objProyectoReq2.setEstrato_proyecto(resultado.getInt("Estrato"));
                objProyecto.add(objProyectoReq2);

            }
            conn.close();
            pStatement.close();
        } catch (Exception e) {
            System.out.println("Error "+e.getMessage());
        }
        return objProyecto;
    
    }// Fin del método query_requerimiento_2

    public ArrayList<Proyecto> query_requerimiento_3() throws SQLException {
        ArrayList<Proyecto> objProyecto = new ArrayList<Proyecto>();
        try {
            String query = "SELECT SUM(Numero_Habitaciones) AS Total_Habitaciones, Constructora ";
            query += "FROM Proyecto ";
            query += "GROUP BY Constructora ";
            Connection conn = JDBCUtilities.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(query);
            ResultSet resultado = pStatement.executeQuery();
            while (resultado.next()) {
                Proyecto objProyectoReq3 = new Proyecto();
                objProyectoReq3.setNum_habitaciones(resultado.getInt("Total_Habitaciones"));
                objProyectoReq3.setNombre_constructora(resultado.getString("Constructora"));
                objProyecto.add(objProyectoReq3);

            }
            conn.close();
            pStatement.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return objProyecto;
    }// Fin del método query_requerimiento_3

    public ArrayList<Proyecto> query_requerimiento_5() throws SQLException {
        ArrayList<Proyecto> objProyecto = new ArrayList<Proyecto>();
        try {
            String query = "SELECT SUM(Numero_Habitaciones) AS Total_Habitaciones, Constructora ";
            query += "FROM Proyecto ";
            query += "GROUP BY Constructora ";
            query += "HAVING Total_Habitaciones > 200 ";
            query += "ORDER BY Total_Habitaciones ASC";
            Connection conn = JDBCUtilities.getConnection();
            PreparedStatement pStatement = conn.prepareStatement(query);
            ResultSet resultado = pStatement.executeQuery();
            while (resultado.next()) {
                Proyecto objProyectoReq5 = new Proyecto();
                objProyectoReq5.setNum_habitaciones(resultado.getInt("Total_Habitaciones"));
                objProyectoReq5.setNombre_constructora(resultado.getString("Constructora"));
                objProyecto.add(objProyectoReq5);

            }
            conn.close();
            pStatement.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return objProyecto;
    }// Fin del método query_requerimiento_5

}