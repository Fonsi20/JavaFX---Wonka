package backend;

import Objetos.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import wonka.NewHibernateUtil;
import wonka.Wonka;

/**
 *
 * @author a16alfonsofa
 */
public class Inserciones {

    public SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();

    public static void insertarCartasMagic(ArrayList<String> Carta) {
        System.out.println("en MAGIC " + Carta);
        int stock = Integer.parseInt(Carta.get(0));
        float price = Float.parseFloat(Carta.get(6));
        CartaMAGIC aux;
        aux = new CartaMAGIC(Carta.get(9), Carta.get(7), Carta.get(8), Carta.get(10), stock, Carta.get(1), Carta.get(2), Carta.get(3), Carta.get(4), Carta.get(5), price);
        guardarModificar(aux);
    }

    public static void insertarCartasYuGi(ArrayList<String> Carta) {
        System.out.println("en YUGI " + Carta);
        int stock = Integer.parseInt(Carta.get(0));
        float price = Float.parseFloat(Carta.get(6));
        int nivel = Integer.parseInt(Carta.get(9));
        CartaYUGI aux;
        aux = new CartaYUGI(Carta.get(7), Carta.get(11), Carta.get(8), Carta.get(10), nivel, stock, Carta.get(1), Carta.get(2), Carta.get(3), Carta.get(4), Carta.get(5), price);
        guardarModificar(aux);
    }

    public static void insertarCartasFOW(ArrayList<String> Carta) {
        System.out.println("en FOW " + Carta);
        int stock = Integer.parseInt(Carta.get(0));
        float price = Float.parseFloat(Carta.get(6));
        CartaFOW aux;
        aux = new CartaFOW(Carta.get(7), Carta.get(9), Carta.get(8), Carta.get(11), Carta.get(10), stock, Carta.get(1), Carta.get(2), Carta.get(3), Carta.get(4), Carta.get(5), price);
        guardarModificar(aux);
    }

    public static void actualizarCartaMagic(ArrayList<String> Carta) throws SQLException {
        CartaMAGIC mag = null;
        String nombre = Carta.get(2);
        Statement S = Wonka.conect.createStatement();
        ResultSet Res = S.executeQuery("SELECT IDCarta AS id FROM CARTAS WHERE NombreCarta='" + nombre + "';");
        Res.next();
        mag = comprovacionesBBDD.comprobarCartaMagic(Res.getInt("id"));
        Res.close();
        if (mag != null) {

            //String IDCMagic, String Color, String Coste, String Tipo, int Stock, String NombreJuego, String NombreCarta, String Descripcion, String Coleccion, String Ano, float Precio
            mag.setIDCMagic(Carta.get(9));
            mag.setColor(Carta.get(7));
            mag.setCoste(Carta.get(8));
            mag.setTipo(Carta.get(10));
            mag.setStock(Integer.parseInt(Carta.get(0)));
            mag.setNombreJuego(Carta.get(1));
            //mag.setNombreCarta(Carta.get(2));
            mag.setDescripcion(Carta.get(3));
            mag.setColeccion(Carta.get(4));
            mag.setPrecio(Float.parseFloat(Carta.get(6)));
            mag.setAno(Carta.get(5));

            guardarModificar(mag);

        } else {
            System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
        }
    }

    public static void actualizarCartaYuGi(ArrayList<String> Carta) throws SQLException {
        CartaYUGI yu = null;
        String nombre = Carta.get(2);
        Statement S = Wonka.conect.createStatement();
        ResultSet Res = S.executeQuery("SELECT IDCarta AS id FROM CARTAS WHERE NombreCarta='" + nombre + "';");
        Res.next();
        yu = comprovacionesBBDD.comprobarCartaYugi(Res.getInt("id"));
        Res.close();
        if (yu != null) {

            System.out.println(Carta.get(9));
            //String IDCYugi, String TipoCarta, String Atributo, String SubTipo, int Nivel, int Stock, String NombreJuego, String NombreCarta, String Descripcion, String Coleccion, String Ano, float Precio
            yu.setIDCYugi(Carta.get(7));
            yu.setTipoCarta(Carta.get(8));
            yu.setAtributo(Carta.get(9));
            yu.setSubTipo(Carta.get(10));
            yu.setNivel(Integer.parseInt(Carta.get(11)));
            yu.setStock(Integer.parseInt(Carta.get(0)));
            yu.setNombreJuego(Carta.get(1));
            //yu.setNombreCarta(Carta.get(2));
            yu.setDescripcion(Carta.get(3));
            yu.setColeccion(Carta.get(4));
            yu.setPrecio(Float.parseFloat(Carta.get(6)));
            yu.setAno(Carta.get(5));

            guardarModificar(yu);

        } else {
            System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
        }
    }

    public static void actualizarCartaFOW(ArrayList<String> Carta) throws SQLException {
        CartaFOW fow = null;
        String nombre = Carta.get(2);
        Statement S = Wonka.conect.createStatement();
        ResultSet Res = S.executeQuery("SELECT IDCarta AS id FROM CARTAS WHERE NombreCarta='" + nombre + "';");
        Res.next();
        fow = comprovacionesBBDD.comprobarCartaFOW(Res.getInt("id"));
        Res.close();
        if (fow != null) {

            //String Elemento, String IDCFoW, String Coste, String Tipo, String Raza, int Stock, String NombreJuego, String NombreCarta, String Descripcion, String Coleccion, String Ano, float Precio
            fow.setElemento(Carta.get(7));
            fow.setIDCFoW(Carta.get(8));
            fow.setCoste(Carta.get(9));
            fow.setTipo(Carta.get(11));
            fow.setRaza(Carta.get(10));
            fow.setStock(Integer.parseInt(Carta.get(0)));
            fow.setNombreJuego(Carta.get(1));
            //fow.setNombreCarta(Carta.get(2));
            fow.setDescripcion(Carta.get(3));
            fow.setColeccion(Carta.get(4));
            fow.setPrecio(Float.parseFloat(Carta.get(6)));
            fow.setAno(Carta.get(5));

            guardarModificar(fow);

        } else {
            System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
        }
    }

    public static void insertarCliente(ArrayList<String> Cliente) throws SQLException {
        System.out.println("en Clientes " + Cliente);
        boolean sexo;
        if (Cliente.get(3).equals("0")) {
            sexo = false;
        } else {
            sexo = true;
        }
        Cliente aux = new Cliente(Integer.parseInt(Cliente.get(2)), Cliente.get(0), Cliente.get(1), Cliente.get(4), Cliente.get(5), Cliente.get(6), sexo);
        guardarModificar(aux);
    }

    public static void actualizarCliente(ArrayList<String> Cliente) throws SQLException {
        Cliente temp = null;
        Statement S = Wonka.conect.createStatement();
        ResultSet Res = S.executeQuery("SELECT IDCliente AS ID FROM Clientes WHERE Nombre='" + Cliente.get(0) + "';");
        Res.next();
        temp = comprovacionesBBDD.comprobarCliente(Res.getInt("ID"));
        Res.close();

        if (temp != null) {
            temp.setNombre(Cliente.get(0));
            temp.setApellidos(Cliente.get(1));
            temp.setEdad(Integer.parseInt(Cliente.get(2)));
            boolean sexo;
            if (Cliente.get(3).equals("0")) {
                sexo = true;
            } else {
                sexo = false;
            }
            temp.setSexo(sexo);
            temp.setDireccion(Cliente.get(4));
            temp.setTelefono(Cliente.get(5));
            temp.setMail(Cliente.get(6));

            guardarModificar(temp);
        } else {
            System.out.println("NO EXISTE ESE CLIENTE");
        }
    }

    public static void InsertarCompra(Carta CarCompra, Cliente CliCompra, int cantidad) {
        Venta aux;
        aux = new Venta(CarCompra, CliCompra, cantidad);
        guardarModificar(aux);
    }

    public static void InsertarReserva(Carta CarCompra, Cliente CliCompra, int cantidad) {

        Session s;
        s = NewHibernateUtil.getSession();
        List<Object> Reservas = s.createCriteria(Reserva.class).list();
        Reserva aux;
        Carta carAux = null;
        Cliente cliAux = null;
        boolean existe = false;
        int cantidadObjeto = 0;
        try {
            for (Object o : Reservas) {

                carAux = ((Reserva) o).getIDCarta();
                cliAux = ((Reserva) o).getIDCliente();

                if (carAux.getIDCarta() == CarCompra.getIDCarta() && cliAux.getIDCliente() == CliCompra.getIDCliente()) {
                    ((Reserva) o).setCantidad(cantidad + ((Reserva) o).getCantidad());
                    cantidadObjeto = ((Reserva) o).getCantidad();
                    existe = true;
                }

            }
            if (existe == true) {
                System.out.println(cantidadObjeto);
                aux = new Reserva(CarCompra, CliCompra, cantidadObjeto);
                s.beginTransaction();
                s.update(carAux);
                s.getTransaction().commit();
                guardarModificar(aux);
            }

            if (existe == false) {
                System.out.println(cantidadObjeto);
                aux = new Reserva(CarCompra, CliCompra, cantidad);
                s.beginTransaction();
                s.update(carAux);
                s.getTransaction().commit();
                guardarModificar(aux);
            }

        } catch (NumberFormatException e) {
        }
        s.close();

    }

    public static void automatizacionStock() throws SQLException {

        Statement S = Wonka.conect.createStatement();
        ResultSet Res = S.executeQuery("SELECT count(*) as count FROM Reservas;");
        Res.next();
        if (Res.getInt("count") == 5) {
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> Reservas = s.createCriteria(Reserva.class).list();
            Reserva auxReservas = null;
            try {
                for (Object o : Reservas) {
                    InsertarCompra(((Reserva) o).getIDCarta(), ((Reserva) o).getIDCliente(), ((Reserva) o).getCantidad());
                    auxReservas = (Reserva) o;
                    Carta carAux = ((Reserva) o).getIDCarta();
                    carAux.setStock(5);
                    String[] parts = carAux.getAno().split("-");
                    String year = parts[0];
                    carAux.setAno(year);
                    s.beginTransaction();
                    s.update(carAux);
                    s.getTransaction().commit();
                    eliminar(auxReservas);
                }
            } catch (NumberFormatException e) {
            }
            s.close();
        }
    }

    public static void guardarModificar(Object objeto) {
        Session sesion;
        try {
            System.out.println("entra Grabar");
            sesion = NewHibernateUtil.getSession();
            sesion.beginTransaction();
            sesion.saveOrUpdate(objeto);
            sesion.getTransaction().commit();
            sesion.close();
        } catch (HibernateException e) {
            System.out.println("entra NO GRABAR");
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
