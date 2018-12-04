package Objetos;
import java.io.Serializable;
import java.util.*;
/**
 *
 * @author a16diegovs
 */
public class Venta implements Serializable{
    private int     IDVenta,
            Cantidad;
    private Carta Carta;
    private Cliente Cliente;
    
    public Venta(Carta Carta, Cliente Cliente, int Cantidad) {
        this.Carta = Carta;
        this.Cliente = Cliente;
        this.Cantidad = Cantidad;
    }

    public Venta() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public int getIDVenta() {
        return IDVenta;
    }

    public void setIDVenta(int IDVenta) {
        this.IDVenta = IDVenta;
    }
    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    public Carta getCarta() {
        return Carta;
    }

    public void setCarta(Carta Carta) {
        this.Carta = Carta;
    }

    public Cliente getCliente() {
        return Cliente;
    }

    public void setCliente(Cliente Cliente) {
        this.Cliente = Cliente;
    }
    // </editor-fold>

    
    
}
