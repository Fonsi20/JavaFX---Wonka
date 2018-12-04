package Objetos;

import java.util.Date;

/**
 *
 * @author a16diegovs
 */
public class CartaMAGIC extends Carta {
    private String IDCMagic,
            Color,
            Coste,
            Tipo;

    public CartaMAGIC(String IDCMagic, String Color, String Coste, String Tipo, int Stock, String NombreJuego, String NombreCarta, String Descripcion, String Coleccion, String Ano, float Precio,byte[] IMG) {
        super(Stock, NombreJuego, NombreCarta, Descripcion, Coleccion, Ano, Precio, IMG);
        this.IDCMagic = IDCMagic;
        this.Color = Color;
        this.Coste = Coste;
        this.Tipo = Tipo;
    }
    

    public CartaMAGIC() {
    }
    
    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">
    public String getIDCMagic() {
        return IDCMagic;
    }

    public void setIDCMagic(String IDCMagic) {
        this.IDCMagic = IDCMagic;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
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
    // </editor-fold>
    
    
    
}
