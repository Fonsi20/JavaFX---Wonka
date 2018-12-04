package Objetos;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author a16diegovs
 */
public class Cliente implements Serializable{

    private int IDCliente,
            Edad;
    private String Nombre,
            Apellidos,
            Direccion,
            Telefono,
            Mail;
    private boolean Sexo;
    private Set <Reserva> Reservas;
    private Set <Venta> Ventas;

    public Cliente(int Edad, String Nombre, String Apellidos, String Direccion, String Telefono, String Mail, boolean Sexo) {
        this.Edad = Edad;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Mail = Mail;
        this.Sexo = Sexo;
    }

    public Cliente() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">  
    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public boolean isSexo() {
        return Sexo;
    }

    public void setSexo(boolean Sexo) {
        this.Sexo = Sexo;
    }

    public Set<Reserva> getReservas() {
        return Reservas;
    }

    public void setReservas(Set<Reserva> Reservas) {
        this.Reservas = Reservas;
    }

    public Set <Venta> getVentas() {
        return Ventas;
    }

    public void setVentas(Set <Venta> Ventas) {
        this.Ventas = Ventas;
    }
    // </editor-fold> 

}
