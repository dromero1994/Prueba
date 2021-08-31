package com.utp.p46.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.Statement;

import com.utp.p46.modelo.dao.DaoLider;
import com.utp.p46.modelo.vo.Lider;
import com.utp.p46.vista.Vista;

public class Controlador{
    /************
     * Atributos
     ***********/
    private DaoLider daoLider;

     /************
     * Constructor
     ***********/
    public Controlador(){
        this.daoLider = new DaoLider();
    }


    public Lider buscar_lider(String documento_identidad){
        return daoLider.buscar_lider(documento_identidad);
    }


    public void insertar_lider(Lider objLider){
        daoLider.insertar_lider(objLider);
    }

    public Lider construir_lider(int id, String nombre, String primer_apellido, String segundo_apellido, int salario, String ciudad_residencia, String cargo, int clasificacion, String documento_identidad, String fecha_nacimiento){
        return new Lider(id, nombre, primer_apellido, segundo_apellido, salario, ciudad_residencia, cargo, clasificacion, documento_identidad, fecha_nacimiento);
    }

    public Lider construir_lider(){
        return new Lider();
    }

    public void actualizar_lider(Lider objLider, int id){
        daoLider.actualizar_lider(objLider, id);
    }

}
