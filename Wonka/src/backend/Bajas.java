package backend;

import Objetos.*;
import static backend.Inserciones.guardarModificar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        String nombre = nombreCarta;
        Statement S = Wonka.conect.createStatement();
        ResultSet Res = S.executeQuery("SELECT IDCarta AS id, NombreJuego as NJ FROM CARTAS WHERE NombreCarta='" + nombre + "';");
        Res.next();
        if ((Res.getString("NJ")).equals("Magic")) {
            cMAG = comprovacionesBBDD.comprobarCartaMagic(Res.getInt("id"));
            if (cMAG != null) {
                Inserciones.eliminar(cMAG);
            } else {
                System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
            }
        }

        if ((Res.getString("NJ")).equals("Yu-Gi-Oh")) {
            cYU = comprovacionesBBDD.comprobarCartaYugi(Res.getInt("id"));
            if (cYU != null) {
                Inserciones.eliminar(cYU);
            } else {
                System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
            }
        }

        if ((Res.getString("NJ")).equals("Force of Will")) {
            cFOW = comprovacionesBBDD.comprobarCartaFOW(Res.getInt("id"));
            if (cFOW != null) {
                Inserciones.eliminar(cFOW);
            } else {
                System.out.println("NO PODEMOS MODIFICAR UNA CARTA INEXISTENTE");
            }
        }
        Res.close();
    }

    public static void eliminarCliente(String nombre) throws SQLException {
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
    }

}
