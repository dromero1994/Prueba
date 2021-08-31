package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Lider;

public class LiderDao {

    public ArrayList<Lider> query_requerimiento_4() throws SQLException {
        // Crea arreglo para almacenar objetos tipo Proyecto
        ArrayList<Lider> lideres = new ArrayList<Lider>();
        try{
            String query="SELECT  l.Nombre, l.Primer_Apellido ";
            query+="FROM Proyecto p ";
            query+="INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider ";
            query+="WHERE p.Constructora ='Pegaso'";
            Connection conexion = JDBCUtilities.getConnection();
            PreparedStatement pStatement=conexion.prepareStatement(query);
            ResultSet resultado=pStatement.executeQuery();
            while(resultado.next()){
                Lider liderReq4=new Lider(resultado.getString("Nombre"),resultado.getString("Primer_Apellido"));
                lideres.add(liderReq4);
            }
        }
        catch(Exception e){
            System.out.println("Error "+e.getMessage());
        }
        return lideres;
    }// Fin del método query_requerimiento_4

}