package backend;

import Objetos.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import wonka.NewHibernateUtil;

/**
 *
 * @author mallo
 */
public class comprovacionesBBDD {

    public static CartaMAGIC comprobarCartaMagic(int cod) {

        Session sesion;
        CartaMAGIC mag = null;
        try {
            sesion = NewHibernateUtil.getSession();
            mag = (CartaMAGIC) sesion.get(CartaMAGIC.class, cod);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return mag;
    }

    public static CartaYUGI comprobarCartaYugi(int cod) {

        Session sesion;
        CartaYUGI yu = null;
        try {
            sesion = NewHibernateUtil.getSession();
            yu = (CartaYUGI) sesion.get(CartaYUGI.class, cod);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return yu;
    }

    public static CartaFOW comprobarCartaFOW(int cod) {

        Session sesion;
        CartaFOW fow = null;
        try {
            sesion = NewHibernateUtil.getSession();
            fow = (CartaFOW) sesion.get(CartaFOW.class, cod);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return fow;
    }
    
    public static Carta comprobarCarta(int cod) {

        Session sesion;
        Carta Card = null;
        try {
            sesion = NewHibernateUtil.getSession();
            Card = (Carta) sesion.get(Carta.class, cod);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return Card;
    }

    public static Cliente comprobarCliente(int cod) {
        Session sesion;
        Cliente temp = null;
        try {
            sesion = NewHibernateUtil.getSession();
            temp = (Cliente) sesion.get(Cliente.class, cod);
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    public static Reserva comprobarReserva(Carta cod, Cliente cod2) {
        Session sesion;
        Reserva temp = new Reserva();
        //Le damos los cods al temporal para que tenga las referencias
        temp.setIDCarta(cod);
        temp.setIDCliente(cod2);
        try {
            sesion = NewHibernateUtil.getSession();
            temp = (Reserva) sesion.get(Reserva.class, temp);
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }
}
