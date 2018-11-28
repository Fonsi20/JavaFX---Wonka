package backend;

import java.util.ArrayList;

/**
 *
 * @author a16alfonsofa
 */
public class comprobacionesDatos {

    public static int comprobarCliente(ArrayList<String> Cliente) {

        // COMPRUEBA QUE NINGUN CAMPO DE TEXTO ESTÉ VACIO
        if (Cliente.get(0).equals("") || Cliente.get(1).equals("") || Cliente.get(4).equals("") || Cliente.get(6).equals("")) {
            return 3;
        }

        //COMPROBAMOS LA EDAD DEL CLIENTE, SI ES UN NÚMERO
        try {
            Integer.parseInt(Cliente.get(2));
        } catch (NumberFormatException e) {
            return 1;
        }

        //COMPROBAMOS EL TELÉFONO DEL CLIENTE, SI ES UN NÚMERO Y SI SU LONGITUD NO ES IGUAL A 9
        try {
            Integer.parseInt(Cliente.get(5));
            if (Cliente.get(5).length() != 9) {
                return 2;
            }
        } catch (NumberFormatException e) {
            return 2;
        }

        //COMPROBAMOS SEXO
        try {
            if (Cliente.get(3) == null) {
                return 4;
            }
        } catch (NumberFormatException e) {
            return 2;
        }

        return 0;
    }

    public static int comprobarCarta(ArrayList<String> Carta) {

        // COMPRUEBA QUE NINGUN CAMPO DE TEXTO ESTÉ VACIO
        if (Carta.get(2).equals("") || Carta.get(3).equals("") || Carta.get(4).equals("")) {
            return 3;
        }

        //COMPRUEBA QUE ES UN ENTERO EL STOCK
        try {
            Integer.parseInt(Carta.get(0));
        } catch (NumberFormatException e) {
            return 1;
        }

        //COMPROBAMOS QUE EL AÑO ES DE 4 DIGITOS Y ENTERO
        try {
            Integer.parseInt(Carta.get(5));
            if (Carta.get(5).length() != 4) {
                return 2;
            }
        } catch (NumberFormatException e) {
            return 2;
        }

        //COMPRUEBA QUE EL PRECIO ES UN FLOAT
        try {
            Float.parseFloat(Carta.get(6));
        } catch (NumberFormatException e) {
            return 4;
        }

        //COMPROBAMOS CARTAS
        switch (Carta.get(1)) {
            case "Magic":
                if (Carta.get(8).equals("") || Carta.get(9).equals("") || Carta.get(10).equals("")) {
                    return 5;
                }
                if ((Carta.get(7)) == null) {
                    return 9;
                }
                break;

            case "Yu-Gi-Oh":
                if (Carta.get(7).equals("") || Carta.get(8).equals("") || Carta.get(10).equals("")) {
                    return 6;
                }
                //COMPRUEBA QUE ES UN ENTERO
                try {
                    Integer.parseInt(Carta.get(9));
                } catch (NumberFormatException e) {
                    return 8;
                }
                if ((Carta.get(11)) == null) {
                    return 10;
                }
                break;
            case "Force of Will":
                if (Carta.get(11).equals("") || Carta.get(8).equals("") || Carta.get(9).equals("") || Carta.get(10).equals("")) {
                    return 7;
                }
                if ((Carta.get(7)) == null) {
                    return 11;
                }
                break;
        }

        return 0;
    }
}
