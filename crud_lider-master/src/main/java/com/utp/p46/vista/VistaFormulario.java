package com.utp.p46.vista;
//javax.swing -> interfaz gráfica
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.utp.p46.controlador.Controlador;
import com.utp.p46.modelo.vo.Lider;

//java.awt -> caracteristicas adicionales para la UI
import java.awt.*;
//java.awt.event -> eventos de la UI
import java.awt.event.*;

public class VistaFormulario extends JFrame{
    /****************
     * Atributos
     ****************/
    //Etiquetas para mostrar texto
    private JLabel lblNombre;
    private JLabel lblPrimerApellido;
    private JLabel lblSegundoApellido;
    private JLabel lblSalario;
    private JLabel lblBuscar;
    //Campos e texto
    private JTextField txtNombre;
    private JTextField txtPrimerApellido;
    private JTextField txtSegundoApellido;
    private JTextField txtSalario;
    private JTextField txtBuscar;
    //Botones
    private JButton btnBuscar;
    private JButton btnGuardar;
    //Controlador
    private Controlador controlador;

    //Constructor
    public VistaFormulario(){
        this.controlador = new Controlador();
        //Configuración de la ventana
        //titulo de la ventana
        this.setTitle("Formulario lider");
        //coordenadas y tamaño de la ventana
        this.setBounds(0, 0, 500, 350);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Agregar esquema tipo borderlayout a la ventana
        this.getContentPane().setLayout( new BorderLayout(5, 5) );

        /***************************
         * 
         * CONTENEDOR SUPERIOR
         * 
         ***************************/
        //Construir layout
        GridLayout northLayout = new GridLayout(1, 3, 5, 5);
        //Construir contenedor superior
        Container northContainer = new Container();
        northContainer.setLayout(northLayout);
        //Columna 1
        this.lblBuscar = new JLabel("Buscar por documento: ");
        northContainer.add(this.lblBuscar);
        //Columna 2
        this.txtBuscar = new JTextField();
        northContainer.add(this.txtBuscar);
        //Columna 3
        this.btnBuscar = new JButton("Buscar");
        northContainer.add(this.btnBuscar);


         /***************************
         * 
         * CONTENEDOR CENTRAL
         * 
         ***************************/
        GridLayout centerLayout = new GridLayout(5, 2, 5, 5);
        Container centerContainer = new Container();
        centerContainer.setLayout(centerLayout);
        //Inicializar y añadir los elementos al container
        //FILA 1
        //columna 1
        this.lblNombre = new JLabel("Nombre: ");
        centerContainer.add(this.lblNombre);
        //columna 2
        this.txtNombre = new JTextField();
        centerContainer.add(this.txtNombre);

        //FILA 2
        //columna 1
        this.lblPrimerApellido = new JLabel("Primer apellido: ");
        centerContainer.add(this.lblPrimerApellido);
        //columna 2
        this.txtPrimerApellido = new JTextField();
        centerContainer.add(this.txtPrimerApellido);

        //FILA 3
        //columna 1
        this.lblSegundoApellido = new JLabel("Segundo apellido: ");
        centerContainer.add(this.lblSegundoApellido);
        //columna 2
        this.txtSegundoApellido = new JTextField();
        centerContainer.add(this.txtSegundoApellido);

        //FILA 4
        //columna 1
        this.lblSalario = new JLabel("Salario: ");
        centerContainer.add(this.lblSalario);
        //columna 2
        this.txtSalario = new JTextField();
        centerContainer.add(this.txtSalario);

        //FILA 5
        //columna 1
        centerContainer.add( new JLabel() );
        //columna 2
        this.btnGuardar = new JButton("Guardar");
        centerContainer.add(this.btnGuardar);

        /***********************
         * 
         * Manejador de eventos
         * 
         ***********************/
        this.btnBuscar.addActionListener( new ActionListener(){

            public void actionPerformed(ActionEvent evt){
                String documento = txtBuscar.getText();
                Lider objLider = controlador.buscar_lider(documento);
                txtNombre.setText( objLider.getNombre() );
                txtPrimerApellido.setText( objLider.getPrimer_apellido() );
                txtSegundoApellido.setText( objLider.getSegundo_apellido());
                txtSalario.setText( ""+objLider.getSalario() );
                //Cambiar texto del botón guardar y limpiar el campo de busqueda
                btnGuardar.setText("Actualizar");
                txtBuscar.setText("");
            }
        } );

        /***************************
         * 
         * AÑADIR ELEMENTOS A 
         * LA VENTANA PRINCIPAL
         * 
         ***************************/
        this.add(northContainer, BorderLayout.NORTH);
        /*
        this.add(new Button("SOUTH"), BorderLayout.SOUTH);
        this.add(new Button("WEST"), BorderLayout.WEST);
        this.add(new Button("EAST"), BorderLayout.EAST);
        */
        /*
        JTextArea area = new JTextArea(5, 50);
        String cadena = "Nombre: Juan - Apellido: Perez\n";
        cadena += "Nombre: Pedro - Apellido: Hernan";
        area.setText(cadena);
        */
        this.add(centerContainer, BorderLayout.CENTER);


    }
    
}
