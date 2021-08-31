package com.utp.p46.modelo.vo;


public class Lider{
    /*************
     * Atributos
     *************/
    private int id;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private int salario;
    private String ciudad_residencia;
    private String cargo;
    private int clasificacion;
    private String documento_identidad;
    private String fecha_nacimiento;

     /***************
     * Constructores
     ***************/
    public Lider(){

    }

    public Lider(int id, String nombre, String primer_apellido, String segundo_apellido, int salario, String ciudad_residencia, String cargo, int clasificacion, String documento_identidad, String fecha_nacimiento){
        this.id = id;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.salario = salario;
        this.ciudad_residencia = ciudad_residencia;
        this.cargo = cargo;
        this.clasificacion = clasificacion;
        this.documento_identidad = documento_identidad;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    /*************
     * Getters 
     * and
     * Setters
     *************/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCiudad_residencia() {
        return ciudad_residencia;
    }

    public void setCiudad_residencia(String ciudad_residencia) {
        this.ciudad_residencia = ciudad_residencia;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDocumento_identidad() {
        return documento_identidad;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

}