package backend;

import Objetos.*;
import static backend.Inserciones.guardarModificar;
import static backend.Inserciones.odb;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import wonka.Wonka;

/**
 *
 * @author a16alfonsofa
 */
public class Bajas {

    public static void eliminarCarta(String nombreCarta) throws SQLException {
        CartaYUGI cYU = null;
        CartaMAGIC cMAG = null;
        CartaFOW cFOW = null;
        Carta CGEN = null;
        String nombre = nombreCarta;
        String tipoCarta = "";
        int IDCarta = 0;
        if (Wonka.basedatos == true) {
            Statement S = Wonka.conect.createStatement();
            ResultSet Res = S.executeQuery("SELECT IDCarta AS id, NombreJuego as NJ FROM CARTAS WHERE NombreCarta='" + nombre + "';");
            Res.next();
            tipoCarta = Res.getString("NJ");
            IDCarta = Res.getInt("id");
            Res.close();
        } else {
            ICriterion crit = Where.equal("NombreCarta", nombre);
            CriteriaQuery query = new CriteriaQuery(Carta.class, crit);
            CGEN = (Carta) odb.getObjectFromId(query.getOidOfObjectToQuery());
            tipoCarta = CGEN.getNombreJuego();
        }

        if (tipoCarta.equals("Magic")) {
            if (Wonka.basedatos == true) {
                cMAG = comprovacionesBBDD.comprobarCartaMagic(IDCarta);
                if (cMAG != null) {
                    Inserciones.eliminar(cMAG);

                } else {
                    System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
                }
            } else {
                odb.delete(CGEN);
                odb.close();
            }
        }

        if (tipoCarta.equals("Yu-Gi-Oh")) {
            if (Wonka.basedatos == true) {
                cYU = comprovacionesBBDD.comprobarCartaYugi(IDCarta);
                if (cYU != null) {
                    Inserciones.eliminar(cYU);
                } else {
                    System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
                }
            } else {
                odb.delete(CGEN);
                odb.close();
            }
        }

        if (tipoCarta.equals("Force of Will")) {
            if (Wonka.basedatos == true) {
                cFOW = comprovacionesBBDD.comprobarCartaFOW(IDCarta);
                if (cFOW != null) {
                    Inserciones.eliminar(cFOW);
                } else {
                    System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
                }
            } else {
                odb.delete(CGEN);
                odb.close();
            }
        }
    }

    public static void eliminarCliente(String nombre) throws SQLException {
        if (Wonka.basedatos == true) {
            Statement S = Wonka.conect.createStatement();
            ResultSet Res = S.executeQuery("SELECT IDCliente AS ID FROM Clientes WHERE Nombre='" + nombre + "';");
            Res.next();
            Cliente temp = comprovacionesBBDD.comprobarCliente(Res.getInt("ID"));
            if (temp != null) {
                Inserciones.eliminar(temp);

            } else {
                System.out.println("NO EXISTE ESE CLIENTE");
            }
            Res.close();
        } else {
            ICriterion crit = Where.equal("Nombre", nombre);
            CriteriaQuery query = new CriteriaQuery(Cliente.class, crit);
            Cliente Clie = (Cliente) odb.getObjectFromId(query.getOidOfObjectToQuery());
            odb.delete(Clie);
            odb.close();
        }

    }

    public static void eliminarReserva(String NCliente, String NCarta) throws SQLException {
        int IDCliente = 0;
        int IDCarta = 0;
        Cliente OCliente;
        Carta OCarta;
        if (Wonka.basedatos == true) {
            Statement S = Wonka.conect.createStatement();
            ResultSet Res = S.executeQuery("SELECT IDCliente AS ID,Nombre AS N,Apellidos AS A FROM Clientes;");
            while (Res.isLast() != true) {
                Res.next();
                if (NCliente.equals(Res.getString("N") + " " + Res.getString("A"))) {
                    IDCliente = Res.getInt("ID");
                    Res.close();
                    break;
                }
            }
            Res = S.executeQuery("SELECT IDCarta AS ID FROM CARTAS WHERE NombreCarta='" + NCarta + "';");
            Res.next();
            IDCarta = Res.getInt("ID");
            Res.close();

            OCliente = comprovacionesBBDD.comprobarCliente(IDCliente);
            OCarta = comprovacionesBBDD.comprobarCarta(IDCarta);

            Reserva temp = comprovacionesBBDD.comprobarReserva(OCarta, OCliente);

            if (temp != null) {
                Inserciones.eliminar(temp);
            } else {
                System.out.println("NO EXISTE ESA RESERVA");
            }
        } else {
            ICriterion crit = Where.equal("Nombre", NCliente);
            CriteriaQuery query = new CriteriaQuery(Cliente.class, crit);
            Cliente Clie = (Cliente) odb.getObjectFromId(query.getOidOfObjectToQuery());

            crit = Where.equal("NombreCarta", NCarta);
            query = new CriteriaQuery(Carta.class, crit);
            Carta Card = (Carta) odb.getObjectFromId(query.getOidOfObjectToQuery());

            crit = new And().add(Where.equal("IDCliente", Clie.getIDCliente())).add(Where.equal("IDCarta", Card.getIDCarta()));
            query = new CriteriaQuery(Reserva.class, crit);
            Reserva Res = (Reserva) odb.getObjectFromId(query.getOidOfObjectToQuery());
            odb.delete(Res);
            odb.close();
        }
    }

}
