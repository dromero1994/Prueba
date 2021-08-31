package com.utp.p46.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseController {

    //Método que retorna una conexión a la BD
    public static Connection conectar_bd() throws SQLException {
            return DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");        
    }

}
