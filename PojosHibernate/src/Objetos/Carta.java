package Objetos;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * @author a16diegovs
 */
public class Carta implements Serializable{
    //Atributos
    private int     IDCarta,
            Stock;
    private String  NombreJuego,
            NombreCarta,
            Descripcion,
            Coleccion,
            Ano;
    private float   Precio;
    private byte IMG[] = new byte[1024];
    
    //Objeto de relación con el hijo
    private Carta Carta;
    
    //Sets de relaciones
    private Set <Reserva> Reservas;
    private Set <Venta> Ventas;
    
    
    public Carta(int Stock, String NombreJuego, String NombreCarta, String Descripcion, String Coleccion, String Año, float Precio,byte[] IMG) {
        this.Stock = Stock;
        this.NombreJuego = NombreJuego;
        this.NombreCarta = NombreCarta;
        this.Descripcion = Descripcion;
        this.Coleccion = Coleccion;
        this.Ano = Año;
        this.Precio = Precio;
        this.IMG = IMG;
    }
    public Carta() {
    }

    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public int getIDCarta() {
        return IDCarta;
    }

    public void setIDCarta(int IDCarta) {
        this.IDCarta = IDCarta;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getNombreJuego() {
        return NombreJuego;
    }

    public void setNombreJuego(String NombreJuego) {
        this.NombreJuego = NombreJuego;
    }

    public String getNombreCarta() {
        return NombreCarta;
    }

    public void setNombreCarta(String NombreCarta) {
        this.NombreCarta = NombreCarta;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getColeccion() {
        return Coleccion;
    }

    public void setColeccion(String Coleccion) {
        this.Coleccion = Coleccion;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        this.Ano = Ano;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    
    
    public Set <Reserva> getReservas() {
        return Reservas;
    }

    public void setReservas(Set <Reserva> Reserva) {
        this.Reservas = Reserva;
    }

    public Set <Venta> getVentas() {
        return Ventas;
    }

    public void setVentas(Set <Venta> Venta) {
        this.Ventas = Venta;
    }

    public Carta getCartas() {
        return Carta;
    }

    public void setCartas(Carta Carta) {
        this.Carta = Carta;
    }
    public byte[] getIMG() {
        return IMG;
    }

    public void setIMG(byte[] IMG) {
        this.IMG = IMG;
    }
    // </editor-fold> 

    
	
}
