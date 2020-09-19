
package paquete;

    /*                                                                   facebook.com/barubdg - github.com/barubdg                                                               */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*PARA AGREGAR MÁS COMPONENTES DEL JFRAME (clase main) A ESTA CLASE, ES NECESARIO HACER LOS CAMBIOS
EN:
1. public class envio_jframe
        public envio_frame(con parametros - agregar el componente)
        {agregar el componente a los botones.addActionListener}
2. class BotonListener
    {     crear una variable del componente
          public BotonListener(con parametros - agregar componente)
           { this.variable del componente = variable del parametro del componente}
      }
*/
public class envio_jframe extends JFrame
{
    //METODO CONSTRUCTOR DE LA CLASE CON PARAMETROS
    public envio_jframe(JTextField JtfID, JTextField JtfNombre, JTextField JtfApellido, //ESTOS 
            JTextField JtfDni, JTextField JtfNumero, JButton btnAgregar, JButton btnGuardar, //SON
            JButton btnModificar, JButton btnEliminar, DefaultTableModel modelo, JTable tabla, JLabel mensaje,
            JButton btnmodif_select) // LOS PARAMETROS
     { 
       //ESTOS SON LAS ACCIONES A LOS BOTONES, SE ENCUENTRA DENTRO DEL METODO CONSTRUCTOR POR DEFECTO
       btnAgregar.addActionListener(new BotonListener(JtfID, JtfNombre, JtfApellido, JtfDni, JtfNumero, 
                                    btnAgregar, btnGuardar, btnModificar, btnEliminar, modelo, tabla, mensaje,
                                    btnmodif_select));
       
       btnModificar.addActionListener(new BotonListener(JtfID, JtfNombre, JtfApellido, JtfDni, JtfNumero, 
                                    btnAgregar, btnGuardar, btnModificar, btnEliminar, modelo, tabla, mensaje,
                                    btnmodif_select));
       
       btnGuardar.addActionListener(new BotonListener(JtfID, JtfNombre, JtfApellido, JtfDni, JtfNumero, 
                                    btnAgregar, btnGuardar, btnModificar, btnEliminar, modelo, tabla, mensaje,
                                    btnmodif_select));
       
       btnEliminar.addActionListener(new BotonListener(JtfID, JtfNombre, JtfApellido, JtfDni, JtfNumero, 
                                    btnAgregar, btnGuardar, btnModificar, btnEliminar, modelo, tabla, mensaje,
                                    btnmodif_select));
       btnmodif_select.addActionListener(new BotonListener(JtfID, JtfNombre, JtfApellido, JtfDni, JtfNumero,
                                    btnAgregar, btnGuardar, btnModificar, btnEliminar, modelo, tabla, mensaje,
                                    btnmodif_select));
      //ESTOS SON LAS ACCIONES A LOS BOTONES, SE ENCUENTRA DENTRO DEL METODO CONSTRUCTOR POR DEFECTO
     }                                
        
}

//ACTION LISTENER CLASE NUEVA
class BotonListener implements ActionListener
{
    
    persona_datos guardando = new persona_datos(); //CLASE PERSONA
    JButton btnAgregar,btnGuardar,btnModificar,btnEliminar; //BOTONES
    JButton btnmodif_select; //SUB BOTONES DE LOS BOTONES PRINCIPALES
    JTextField JtfID, JtfNombre, JtfApellido,JtfDni,JtfNumero; //CAJAS DE TEXTO
    DefaultTableModel modelo; // DEFAULT TABLA
    JTable tabla; //TABLA
    JLabel mensaje;
    
    private int acum=1; //ACUMULADOR
    private int guardar_Acum; //GUARDAR ACUMULADOR
    //METODO CONSTRUCTOR DE LA CLASE CON PARAMETROS
    public BotonListener
    (JTextField JtfID, JTextField JtfNombre, JTextField JtfApellido, 
    JTextField JtfDni, JTextField JtfNumero, JButton btnAgregar, JButton btnGuardar,
    JButton btnModificar, JButton btnEliminar, DefaultTableModel modelo, JTable tabla, JLabel mensaje,
    JButton btnmodif_select)
     {
          this.JtfID = JtfID;
          this.JtfNombre = JtfNombre;
          this.JtfApellido = JtfApellido;
          this.JtfDni = JtfDni;
          this.JtfNumero = JtfNumero;
          this.modelo = modelo;
          this.btnAgregar = btnAgregar;
          this.btnGuardar = btnGuardar;
          this.btnModificar = btnModificar;
          this.btnEliminar = btnEliminar;
          this.tabla = tabla;
          this.mensaje = mensaje;
          this.btnmodif_select = btnmodif_select;
           Idincrementar(); //INCREMENTAR ID        
     }
    
    //INCREMENTAR EL ID
    public void Idincrementar()
    {
     
     setGuardar_Acum(acum);
     JtfID.setText(String.valueOf(getGuardar_Acum()));}
     
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {        
            String obtener_num = String.valueOf(tabla.getSelectedRow()); //OBTENEMOS EL NUMERO DE LA FILA
            
            if (e.getSource()==btnAgregar) //BOTON PARA AGREGAR LOS DATOS A LA TABLA
               {
                    //NECESITA EL METODO
                    
                    OpcionEspecialTabla(); //SIRVE PARA HABILITAR  LA TABLA Y NO SE MUESTRE LA CELDA SELECCIONADA
                    HabilitarBotones(true,false,false); //LOS PARAMETROS FALSE SE CONVIERTEN EN TRUE EN EL METODO HABILITARBOTONES
                    guardando.setId(Integer.valueOf(JtfID.getText())); //ID
                    guardando.setNombre(JtfNombre.getText().toString()); //NOMBRE
                    guardando.setApellido(JtfApellido.getText().toString()); //APELLIDO
                    guardando.setDni(JtfDni.getText().toString()); //DNI
                    guardando.setNumero(JtfNumero.getText().toString()); //NUMERO
                    guardando.Enviar(); //GUARDANDO EL ARRAY
                    modelo.addRow(guardando.getPersona()); //SUBIENDO A LA TABLA
                    Limpiar(JtfNombre, JtfApellido, JtfDni, JtfNumero); //LLAMANDO AL METODO LIMPIAR
                    //APERTURA - PARTE DEL ID
                    acum = tabla.getRowCount()+1;
                    JtfID.setText(String.valueOf(acum));
                    //CIERRE - PARTE DEL ID
                    
               }
            
        else if(e.getSource()==btnModificar) //BOTON PARA MODIFICAR LOS DATOS DE LA TABLA
               {
                   JOptionPane.showMessageDialog(null,"LA TABLA ESTA DESBLOQUEADA, PUEDES MODIFICAR ");
                   btnAgregar.setEnabled(false); //DESHABILITAR EL BOTON GUARDAR
                   HabilitarBotones(false, false, true);
                   OpcionEspecialTabla(); //SIRVE PARA HABILITAR  LA TABLA Y NO SE MUESTRE LA CELDA SELECCIONADA
                   OpcionEspecialTabla2();
                   mensaje.setVisible(true); //EL MENSAJE ES VISIBLE
                   btnmodif_select.setVisible(true); //HABILITANDO VISIBILIDAD EN  EL BOTON SELECCIONAR
                 
               }
            
        else if(e.getSource()==btnGuardar) //BOTON PARA GUARDAR LOS CAMBIOS  EN LA TABLA
                {   JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS, PRESIONA MODIFICAR DE NUEVO");
                    
                    //FORMA MAS DETALLADA PARA NO CONFUNDIRNOS
                         //GUARDANDO LOS DATOS DE LAS CAJAS DE TEXTO EN VARIABLES TIPO STRING
                    String devolver_nombre = JtfNombre.getText();
                    String devolver_apellido = JtfApellido.getText();
                    String devolver_dni = JtfDni.getText();
                    String devolver_numero = JtfNumero.getText();
                    
                         //AGREGAMOS A LA TABLA LAS MODIFICACIONES.  
                           //setValueAt("EL TEXTO", "EL NUMERO DE LA FILA", "EL NUMERO DE LA COLUMNA")
                    modelo.setValueAt(devolver_nombre, Integer.parseInt(obtener_num),1);
                    modelo.setValueAt(devolver_apellido,Integer.parseInt(obtener_num),2);
                    modelo.setValueAt(devolver_dni, Integer.parseInt(obtener_num),3);
                    modelo.setValueAt(devolver_numero, Integer.parseInt(obtener_num),4);
                    OpcionEspecialTabla2(); 
                    OpcionEspecialTabla(); //SIRVE PARA HABILITAR  LA TABLA Y NO SE MUESTRE LA CELDA SELECCIONADA
                    Limpiar(JtfNombre, JtfApellido, JtfDni, JtfNumero); //LIMPIANDO LAS CAJAS DE TEXTO
                    btnAgregar.setEnabled(true); //HABILITANDO EL BOTON AGREGAR
                    HabilitarBotones(true, false, false);
                    btnmodif_select.setVisible(false); //EL BOTON SELECCIONAR
                    /*AUN FALTA AGREGAR MAS COMPONENTES */
                }
        else if(e.getSource()==btnmodif_select)
                {
                     //FORMA MAS DETALLADA PARA NO CONFUNDIRNOS
                         //GUARDANDO EN UN VARIABLE DEL TIPO STRING
                     String obtener_nombre = String.valueOf(modelo.getValueAt(Integer.parseInt(obtener_num), 1));
                     String obtener_apellido = String.valueOf(modelo.getValueAt(Integer.parseInt(obtener_num), 2));
                     String obtener_dni = String.valueOf(modelo.getValueAt(Integer.parseInt(obtener_num), 3));
                     String obtener_numero = String.valueOf(modelo.getValueAt(Integer.parseInt(obtener_num), 4));
                         //ENVIANDO LOS DATOS OBTENIDOS A LAS CAJAS DE TEXTO CORRESPONDIENTES
                     JtfNombre.setText(obtener_nombre);
                     JtfApellido.setText(obtener_apellido);
                     JtfDni.setText(obtener_dni);
                     JtfNumero.setText(obtener_numero);
                     
                         /*System.out.println(obtener_num);
                                                      System.out.println(obtener_nombre);
                                                      System.out.println(obtener_apellido);
                                                      System.out.println(obtener_dni);
                                                      System.out.println(obtener_numero);*/
                     mensaje.setVisible(false); //EL MENSAJE NO ES VISIBLE
                }
            else/*LA OPCION DEL BOTON ELIMINAR, SE PUEDE CAMBIAR POR UN ELSE IF PARA AGREGAR 
                                   MAS BOTONES PRINCIPALES O SUB-BOTONES*/            
                {
                    try 
                      {
                        int confirmar = JOptionPane.showConfirmDialog(null, "Seguro que quieres eliminar la fila");
                        //System.out.println(confirmar);
                         if (confirmar==0 && modelo.getRowCount()>0) // 0=SI 1=NO 2=CANCELAR
                        {
                        OpcionEspecialEliminar(false);
                        
                        //APERTURA - PARTE DEL ID
                        setGuardar_Acum(Integer.parseInt(JtfID.getText())-1); //PARA REDUCIR EL ID
                        JtfID.setText(String.valueOf(getGuardar_Acum())); // PARA REDUCIR EL ID
                        for (int i = 1; i < getGuardar_Acum(); i++) {modelo.setValueAt(String.valueOf(i), i-1, 0);}//MODIFICAR ID DE LA TABLA
                        //EN CASO ELIMINAMOS UNA FILA QUE NO SEA LA ULTIMA, PARA QUE EL ID SE MODIFIQUE
                        //CIERRE - PARTE DEL ID
                        
                        
                        if (modelo.getRowCount()==0)
                        {OpcionEspecialEliminar(true);}
                         
                         
                         }
                         /*AUN FALTA AGREGAR MAS COMPONENTES*/
                      } catch (ArrayIndexOutOfBoundsException exc) 
                        {JOptionPane.showMessageDialog(null, "Agrega mas datos si deseas...");}
                    
                }
     }
    

    
    //METODO PARA LIMPIAR LAS CAJAS DE TEXTO
    public void Limpiar 
    (JTextField JtfNombre, JTextField JtfApellido, JTextField JtfDni, JTextField JtfNumero) //PARAMETROS CON LOS JTextField
     {JTextField [] limpiar = { JtfNombre, JtfApellido, JtfDni,  JtfNumero}; //CREANDO ARRAY DE JTextField
      for (JTextField e : limpiar) {e.setText("");} //BORRANDO LOS TEXTOS DEL JTextField
     }
     public void OpcionEspecialEliminar(boolean boolbtnModificar) //SIRVE PARA HABILITAR O DESHABILITAR EL BOTON MODIFICAR
     {HabilitarBotones(true, boolbtnModificar, false);
      OpcionEspecialTabla();
      modelo.removeRow(tabla.getSelectedRow());
      // REDUCIR ID
      JOptionPane.showMessageDialog(null,"SE ELIMINO SATISFACTORIAMENTE");}
     
    //METODO PARA HABILITAR LOS BOTONES
     public void HabilitarBotones(boolean boolbtnguardar, boolean boolbtnModificar, boolean boolbtnEliminar)
     {btnGuardar.setEnabled(!boolbtnguardar); //BOTON GUARDAR PUEDE SER USADO
      btnModificar.setEnabled(!boolbtnModificar); //BOTON MODIFICAR PUEDE SER USADO
      btnEliminar.setEnabled(!boolbtnEliminar);} //BOTON ELIMINAR PUEDE SER USADO


     public void OpcionEspecialTabla()
     {tabla.setEnabled(true);
      tabla.setFocusable(false);
      //SIRVE PARA HABILITAR LA TABLA  Y NO SE MUESTRE LA CELDA DE SELECCION
     }
     public void OpcionEspecialTabla2()
     {tabla.setRowSelectionAllowed(true); //PARA VER LA SELECCION DE TODA LA FILA
      tabla.setSelectionMode(0); //PARA QUE NO APAREZCA NINGUNA SELECCION POR DEFECTO
     }
     
     
     
    public DefaultTableModel getModelo() {return modelo;} // USALO COMO QUIERAS JAJA

    //PARA GUARDAR EL ACUMULADOR DEL ID
    public int getGuardar_Acum() {return guardar_Acum;}
    public void setGuardar_Acum(int guardar_Acum) {this.guardar_Acum = guardar_Acum;}
    
    
     /*                                                               www.facebook.com/barubdg  - github.com/barubdg
           NOTA: SOLO PARA PRACTICAR Y ESTUDIARLO, SI ESTAS CONCIENTE QUE NO SABES PROGRAMAR Y LO QUIERES
           TENER FACIL PARA TU TAREA, TE ESTAS  EDUCANDO MAL, PRACTICA MUCHO, PORQUE EL CAMPO LABORAL ES COMPETITIVO.
           QUE DIOS TE BENDIGA
                                                                            www.facebook.com/barubdg - github.com/barubdg                                                               */
    
}
