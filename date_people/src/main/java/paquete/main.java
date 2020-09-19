
package paquete;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

    /*                                                                   facebook.com/barubdg - github.com/barubdg                                                               */
public class main extends JFrame
{
    public main()
    {
        super("DATOS DE PERSONAS");
        
        //LABELs
        JLabel txtID = new JLabel();
        JLabel txtNombre = new JLabel();
        JLabel txtApellido = new JLabel();
        JLabel txtDni = new JLabel();
        JLabel txtNumero = new JLabel();
        
        //AGREGANDO NOMBRES A LOS JLABEL
        txtID.setText("ID");
        txtNombre.setText("NOMBRE");
        txtApellido.setText("APELLIDO");
        txtDni.setText("DNI");
        txtNumero.setText("NUMERO");
        //AGREGANDO MEDIDAS A LOS JLABEL
        txtID.setBounds(30, 30, 50, 20);
        txtNombre.setBounds(90, 30, 50, 20);
        txtApellido.setBounds(180, 30, 70, 20);
        txtDni.setBounds(280, 30, 70, 20);
        txtNumero.setBounds(360,30,70,20);
        
        //CAJAS DE TEXTO
        JTextField JtfID  = new JTextField();
        JtfID.setEnabled(false);
        
        JTextField JtfNombre  = new JTextField();
        JTextField JtfApellido  = new JTextField();
        JTextField JtfDni  = new JTextField();
        JTextField JtfNumero  = new JTextField();
        //AGREGANDO MEDIDAS A LAS CAJAS DE TEXTO
        JtfID.setBounds(10, 50, 50, 20);
        JtfNombre.setBounds(75,50,80,20);
        JtfApellido.setBounds(170, 50, 80, 20);
        JtfDni.setBounds(260, 50, 80, 20);
        JtfNumero.setBounds(350, 50, 80, 20);
        
                    //AGREGANDO BOTONES
        //BOTON AGREGAR
        JButton btnAgregar = new JButton("AGREGAR");
        btnAgregar.setBounds(510, 100, 100, 20);
        btnAgregar.setMnemonic('A');
        //BOTON GUARDAR
        JButton btnGuardar = new JButton("GUARDAR");
        btnGuardar.setEnabled(false); //DESHABILITAR BOTON
        btnGuardar.setBounds(510, 150, 100, 20);
        btnGuardar.setMnemonic('G');
        //BOTON MODIFICAR
        JButton btnModificar = new JButton("MODIFICAR");
        btnModificar.setEnabled(false); //DESHABILITAR BOTON
        btnModificar.setBounds(510, 200, 100, 20);
        btnModificar.setMnemonic('M');
        //BOTON ELIMINAR
        JButton btnEliminar = new JButton("ELIMINAR");
        btnEliminar.setEnabled(false); //DESHABILITAR BOTON
        btnEliminar.setBounds(510, 250, 100, 20);
        btnEliminar.setMnemonic('E');
       
        
        //TABLA POR DEFECTO
        DefaultTableModel modelo = new DefaultTableModel(); //CREANDO LA TABLA POR DEFECTO - CUANDO EL PROGRAMADOR NO DEFINE
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("DNI");
        modelo.addColumn("NUMERO");
        
        //CREANDO LA TABLA
        JTable tabla = new JTable(modelo);
        tabla.setEnabled(false);
        
        JScrollPane scroll = new JScrollPane(tabla); //AGREGAMOS EL COMPONENTE A LA TABLA
        scroll.setBounds(10, 80, 500, 200);
        
        /* APERTURA - COMPONENTES ESPECIALES PARA EL BTNMODIFICAR DE LA CLASE  envio_jframe*/
            //MENSAJE QUE APARECE CUANDO SE PRESIONA EL BOTON MODIFICAR
            JLabel mensaje = new JLabel("seleccione una fila y presione el boton seleccionar");
            mensaje.setBounds(170, 280, 300, 20);
            mensaje.setVisible(false);
            add(mensaje);
            //BOTON QUE APARECE CUANDO SE PRESIONA EL BOTON MODIFICAR
            JButton btnmodif_select = new JButton("Seleccionar");
            btnmodif_select.setBounds(10, 280, 120, 20);
            btnmodif_select.setVisible(false);
            add(btnmodif_select);
        /*CIERRE - COMPONENTES ESPECIALES PARA EL BTNMODIFICAR DE LA CALSE envio_jframe*/
        
        //CREANDO UN OBJETO DE LA CLASE ENVIO_FRAME
        envio_jframe enJF = new envio_jframe(JtfID, JtfNombre, JtfApellido, JtfDni, JtfNumero,
                btnAgregar, btnGuardar, btnModificar, btnEliminar, modelo, tabla, mensaje, btnmodif_select);
        
        //AGREGAR TABLA AL FRAME
        add(scroll);
        //AGREGAR BOTONES AL FRAME
        add(btnAgregar);
        add(btnGuardar);
        add(btnModificar);
        add(btnEliminar);
       
        //AGREGANDO AL FRAME - LABEL
        add(txtID);
        add(txtNombre);
        add(txtApellido);
        add(txtDni);
        add(txtNumero);
        //AGREGANDO AL FRAME - CAJAS DE TEXTO
        add(JtfID);
        add(JtfNombre);
        add(JtfApellido);
        add(JtfDni);
        add(JtfNumero);
        
        setSize(650,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null); //SIRVE PARA NO PERDER LAS COORDENADAS DE LOS COMPONENTES
        setVisible(true);
    }
    
    public static void main(String[] args) { main iniciar_jframe = new main();} //CORRER LA VENTANA

    /*                                                               www.facebook.com/barubdg  - github.com/barubdg       
           NOTA: SOLO PARA PRACTICAR Y ESTUDIARLO, SI ESTAS CONCIENTE QUE NO SABES PROGRAMAR Y LO QUIERES
           TENER FACIL PARA TU TAREA, TE ESTAS  EDUCANDO MAL, PRACTICA MUCHO, PORQUE EL CAMPO LABORAL ES COMPETITIVO.
           QUE DIOS TE BENDIGA
                                                                           facebook.com/barubdg - github.com/barubdg                                                               */
}
