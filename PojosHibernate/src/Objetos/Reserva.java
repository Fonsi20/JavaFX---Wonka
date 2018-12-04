package Objetos;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author a16diegovs
 */
public class Reserva implements Serializable{
    private Carta IDCarta;
    private Cliente IDCliente;
    private int Cantidad;
    
    public Reserva(Carta IDCarta, Cliente IDCliente, int Cantidad) {
        this.IDCarta = IDCarta;
        this.IDCliente = IDCliente;
        this.Cantidad = Cantidad;
    }

    public Reserva() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public Carta getIDCarta() {
        return IDCarta;
    }

    public void setIDCarta(Carta IDCarta) {
        this.IDCarta = IDCarta;
    }

    public Cliente getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(Cliente IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    // </editor-fold> 

    
    
    
}
