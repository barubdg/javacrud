
package paquete;

    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
public class persona_datos 
{   //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
    protected int id;
    protected String nombre;
    protected String apellido;
    protected String dni;
    protected String numero;
    protected String [] persona;
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
    public String getDni() {return dni;}
    public void setDni(String dni) {this.dni = dni;}
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
    public String getNumero() {return numero;}
    public void setNumero(String numero) {this.numero = numero;}
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO
    public String[] getPersona() {return persona;}
    public void setPersona(String[] persona) {this.persona = persona;}
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO    
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO    
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO    
    public void Enviar()
        {String [] persona = {String.valueOf(getId()),getNombre(),getApellido(),getDni(),getNumero()};
        setPersona(persona);}
    //MODIFICAR ESTA PARTE DEL CODIGO SI ESTAS CLARO ACERCA DE SU FUNCIONAMIENTO    
    
     /*                                                               www.facebook.com/barubdg  - github.com/barubdg
           NOTA: SOLO PARA PRACTICAR Y ESTUDIARLO, SI ESTAS CONCIENTE QUE NO SABES PROGRAMAR Y LO QUIERES
           TENER FACIL PARA TU TAREA, TE ESTAS  EDUCANDO MAL, PRACTICA MUCHO, PORQUE EL CAMPO LABORAL ES COMPETITIVO.
           QUE DIOS TE BENDIGA
                                                                            www.facebook.com/barubdg - github.com/barubdg                                                               */
}
