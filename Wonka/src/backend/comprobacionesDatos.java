package backend;

import java.util.ArrayList;

/**
 *
 * @author a16alfonsofa
 */
public class comprobacionesDatos {

    public static int comprobarCliente(ArrayList<String> Cliente) {

        //COMPROBAMOS LA EDAD DEL CLIENTE, SI ES UN NÚMERO
        try {
            Integer.parseInt(Cliente.get(2));
        } catch (NumberFormatException e) {
            return 1;
        }

        //COMPROBAMOS EL TELÉFONO DEL CLIENTE, SI ES UN NÚMERO Y SI SU LONGITUD NO ES IGUAL A 9
        try {
            Integer.parseInt(Cliente.get(5));
            if (Cliente.get(5).length() >= 9) {
                return 0;
            } else {
                return 2;
            }
        } catch (NumberFormatException e) {
            return 2;
        }
    }
}
