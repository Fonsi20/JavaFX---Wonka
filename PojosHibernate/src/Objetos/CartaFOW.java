package Objetos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author a16diegovs
 */
public class CartaFOW extends Carta{

    private String IDCFoW,
            Elemento,
            Coste,
            Tipo,
            Raza;

    public CartaFOW(String Elemento,String IDCFoW, String Coste, String Tipo, String Raza, int Stock, String NombreJuego, String NombreCarta, String Descripcion, String Coleccion, String Ano, float Precio,byte[] IMG) {
        super(Stock, NombreJuego, NombreCarta, Descripcion, Coleccion, Ano, Precio, IMG);
        this.IDCFoW = IDCFoW;
        this.Coste = Coste;
        this.Tipo = Tipo;
        this.Raza = Raza;
        this.Elemento = Elemento;
    }

    public CartaFOW() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getIDCFoW() {
        return IDCFoW;
    }

    public void setIDCFoW(String IDCFoW) {
        this.IDCFoW = IDCFoW;
    }

    public String getCoste() {
        return Coste;
    }

    public void setCoste(String Coste) {
        this.Coste = Coste;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }
    public String getElemento() {
        return Elemento;
    }

    public void setElemento(String Elemento) {
        this.Elemento = Elemento;
    }
    // </editor-fold> 

    
    
}
