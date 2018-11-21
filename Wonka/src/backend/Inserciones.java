package backend;

import Objetos.CartaMAGIC;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import wonka.NewHibernateUtil;

/**
 *
 * @author a16alfonsofa
 */
public class Inserciones {

    public SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();

    public static void insertarCartasMagic(ArrayList<String> Carta) {
        System.out.println("en MAGIC " + Carta);
        int stock = Integer.parseInt(Carta.get(0));
        float price = Integer.parseInt(Carta.get(6));
        CartaMAGIC aux;
        aux = new CartaMAGIC(Carta.get(9), Carta.get(7), Carta.get(8), Carta.get(10), stock, Carta.get(1), Carta.get(2), Carta.get(3), Carta.get(4), Carta.get(5), price);
        guardarModificar(aux);
    }

    public static void insertarCartasYuGi(ArrayList<String> Carta) {
        System.out.println("en YUGI " + Carta);
        //Carta aux = new Carta();
        //guardarModificar(aux);
    }

    public static void insertarCartasFOW(ArrayList<String> Carta) {
        System.out.println("en FOW " + Carta);
        //Carta aux = new Carta();
        //guardarModificar(aux);
    }

    public static void guardarModificar(Object objeto) {
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminar(Object objeto) {
        Session sesion;
        try {
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.delete(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
    }

}
