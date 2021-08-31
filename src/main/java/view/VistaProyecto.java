package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controller.Controlador;

public class VistaProyecto extends JFrame{
    
    private JButton btnReq1;
    private JButton btnReq2;
    private JButton btnReq3;
    private JButton btnReq4;
    private JButton btnReq5;
    
    private Controlador controlador;

    public VistaProyecto(){
        this.controlador=new  Controlador();
        this.setTitle("Consultas Reto 5");
        this.setBounds(0, 0, 500, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.getContentPane().setLayout(new BorderLayout(5, 5));

        GridLayout northLayout = new GridLayout(1, 3, 5, 5);
        //Construir contenedor superior
        Container northContainer = new Container();
        northContainer.setLayout(northLayout);
        //Columna 1
        this.btnReq1 = new JButton("Requerimiento 1");
        northContainer.add(this.btnReq1);
    }

}
