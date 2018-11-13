package backend;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author a16alfonsofa
 */
public class createBBDD {

    public static void crearTablas(Statement sentencia) {

        try {
            sentencia.execute("CREATE DATABASE IF NOT EXISTS TIENDACARTAS;");
            sentencia.execute("use TIENDACARTAS;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS CLIENTES("
                    + "	IDCliente INT(5) ZEROFILL NOT NULL AUTO_INCREMENT,"
                    + "	Nombre VARCHAR(30) NOT NULL,"
                    + "	Apellidos VARCHAR(30) NOT NULL,"
                    + "	Edad INT(2) NOT NULL,"
                    + "	Sexo BOOLEAN NOT NULL,"
                    + "	Dirección VARCHAR(30) NOT NULL,"
                    + "	Telefono VARCHAR(9) NOT NULL,"
                    + "	Mail VARCHAR(30) NOT NULL,"
                    + "	PRIMARY KEY (IDCliente),"
                    + "    INDEX FK_NombreAP (Nombre,Apellidos)"
                    + ");");

            sentencia.execute("CREATE TABLE IF NOT EXISTS CARTAS("
                    + "	IDCarta INT(3) ZEROFILL NOT NULL AUTO_INCREMENT,"
                    + "	NombreJuego ENUM('Magic','Yu-Gi-Oh','Force of Will') NOT NULL,"
                    + "	Año YEAR NOT NULL,"
                    + "	Precio FLOAT(5) NOT NULL,"
                    + "	Stock INT(3) NOT NULL,"
                    + "	NombreCarta VARCHAR(40) NOT NULL,"
                    + "	Descripcion VARCHAR(200) NOT NULL,"
                    + "	Coleccion VARCHAR(30) NOT NULL,"
                    + "	PRIMARY KEY (IDCarta)"
                    + ")ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS CARTAS_YUGI("
                    + "	IDCarta INT(3) ZEROFILL NOT NULL,"
                    + "	IDCYugi VARCHAR(10) NOT NULL,"
                    + "	TipoCarta ENUM('Monstruo','Mágica','Trampa') NOT NULL,"
                    + "	Atributo VARCHAR(10) NOT NULL,"
                    + "	Nivel INT(2) NOT NULL,"
                    + "	SubTipo VARCHAR(10) NOT NULL,"
                    + "	PRIMARY KEY (IDCarta),"
                    + "	FOREIGN KEY (IDCarta) REFERENCES CARTAS (IDCarta) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "    UNIQUE INDEX FK_CMAGIC (IDCarta)"
                    + ")ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS CARTAS_FOW("
                    + "	IDCarta INT(3) ZEROFILL NOT NULL,"
                    + "	IDCFoW VARCHAR(10) NOT NULL,"
                    + "	Elemento ENUM ('Luz','Oscuridad','Agua','Viento','Fuego','Neutro') NOT NULL,"
                    + "	Coste VARCHAR(2) NOT NULL,"
                    + "	Tipo VARCHAR(10) NOT NULL,"
                    + "	Raza VARCHAR(15) NOT NULL,"
                    + "	PRIMARY KEY (IDCarta),"
                    + "	FOREIGN KEY (IDCarta) REFERENCES CARTAS (IDCarta) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "    UNIQUE INDEX FK_CMAGIC (IDCarta)"
                    + ")ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS VENTAS("
                    + "	IDVenta INT(5) ZEROFILL NOT NULL AUTO_INCREMENT,"
                    + "	IDCliente INT(5) ZEROFILL NOT NULL,"
                    + "	IDCarta INT(5) ZEROFILL NOT NULL,"
                    + "	Cantidad INT(2) NOT NULL,"
                    + "	PRIMARY KEY (IDVenta),"
                    + "	FOREIGN KEY (IDCliente) REFERENCES CLIENTES(IDCliente) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "	FOREIGN KEY (IDCarta) REFERENCES CARTAS (IDCarta) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "	UNIQUE INDEX FK_VCliente (IDCliente),"
                    + "	UNIQUE INDEX FK_VCarta (IDCarta)"
                    + ")ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS RESERVAS("
                    + "	IDCarta INT(5) ZEROFILL NOT NULL,"
                    + "	IDCliente INT(5) ZEROFILL NOT NULL,"
                    + "	Cantidad INT(2) NOT NULL,"
                    + "	PRIMARY KEY (IDCarta,IDCliente),"
                    + "	FOREIGN KEY (IDCliente) REFERENCES CLIENTES(IDCliente) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "	FOREIGN KEY (IDCarta) REFERENCES CARTAS (IDCarta) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "	UNIQUE INDEX FK_RCliente (IDCliente),"
                    + "	UNIQUE INDEX FK_RCarta (IDCarta)"
                    + ")ENGINE INNODB;");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
