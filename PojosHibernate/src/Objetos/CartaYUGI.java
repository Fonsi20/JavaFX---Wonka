package Objetos;

import java.util.Date;

/**
 *
 * @author a16diegovs
 */
public class CartaYUGI extends Carta{
    private String IDCYugi,
            TipoCarta,
            Atributo,
            SubTipo;
    private int Nivel;

    public CartaYUGI(String IDCYugi, String TipoCarta, String Atributo, String SubTipo, int Nivel, int Stock, String NombreJuego, String NombreCarta, String Descripcion, String Coleccion, String Ano, float Precio,byte[] IMG) {
        super(Stock, NombreJuego, NombreCarta, Descripcion, Coleccion, Ano, Precio,IMG);
        this.IDCYugi = IDCYugi;
        this.TipoCarta = TipoCarta;
        this.Atributo = Atributo;
        this.SubTipo = SubTipo;
        this.Nivel = Nivel;
    }
    public CartaYUGI() {
    }

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getIDCYugi() {
        return IDCYugi;
    }

    public void setIDCYugi(String IDCYugi) {
        this.IDCYugi = IDCYugi;
    }

    public String getTipoCarta() {
        return TipoCarta;
    }

    public void setTipoCarta(String TipoCarta) {
        this.TipoCarta = TipoCarta;
    }

    public String getAtributo() {
        return Atributo;
    }

    public void setAtributo(String Atributo) {
        this.Atributo = Atributo;
    }

    public String getSubTipo() {
        return SubTipo;
    }

    public void setSubTipo(String SubTipo) {
        this.SubTipo = SubTipo;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }
    // </editor-fold>
    
}
