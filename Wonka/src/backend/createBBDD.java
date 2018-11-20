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
                    + "	Descripcion VARCHAR(900) NOT NULL,"
                    + "	Coleccion VARCHAR(100) NOT NULL,"
                    + "	PRIMARY KEY (IDCarta)"
                    + ")ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS CARTAS_MAGIC("
                    + "	IDCarta INT(3) ZEROFILL NOT NULL,"
                    + "	IDCMagic VARCHAR(10) NOT NULL,"
                    + "	Color ENUM('Blanco','Azul','Negro','Rojo','Verde','Incoloro','Multicolor') NOT NULL,"
                    + "	Coste VARCHAR(2) NOT NULL,"
                    + "	Tipo VARCHAR(100) NOT NULL,"
                    + "	PRIMARY KEY (IDCarta),"
                    + "    FOREIGN KEY (IDCarta) REFERENCES CARTAS (IDCarta) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "    UNIQUE INDEX FK_CMAGIC (IDCarta)"
                    + ")ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS CARTAS_YUGI("
                    + "	IDCarta INT(3) ZEROFILL NOT NULL,"
                    + "	IDCYugi VARCHAR(10) NOT NULL,"
                    + "	TipoCarta ENUM('Monstruo','Mágica','Trampa') NOT NULL,"
                    + "	Atributo VARCHAR(10) NOT NULL,"
                    + "	Nivel INT(2) NOT NULL,"
                    + "	SubTipo VARCHAR(50) NOT NULL,"
                    + "	PRIMARY KEY (IDCarta),"
                    + "	FOREIGN KEY (IDCarta) REFERENCES CARTAS (IDCarta) ON DELETE CASCADE ON UPDATE CASCADE,"
                    + "    UNIQUE INDEX FK_CMAGIC (IDCarta)"
                    + ")ENGINE INNODB;");

            sentencia.execute("CREATE TABLE IF NOT EXISTS CARTAS_FOW("
                    + "	IDCarta INT(3) ZEROFILL NOT NULL,"
                    + "	IDCFoW VARCHAR(10) NOT NULL,"
                    + "	Elemento ENUM ('Luz','Oscuridad','Agua','Viento','Fuego','Neutro','Multicolor') NOT NULL,"
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
            
            //Cartas Magi
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES ('Magic','2018','0.50','5','Agente filoscuro','Mientras hayas escrutado este turno, la Agente filoscuro tiene la habilidad de toque mortal y `Siempre que esta criatura haga daño de combate a un jugador, tú robas una carta´. Dimir','Gremios de Ravnica');");
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES ('Magic','2016','2.49','0','Árbol de la perdición','Defensor. Intercambia el total de vidas del oponente objetivo con la resistencia del Árbol de la perdición.','Luna de horrores');");
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES ('Magic','2016','0.49','2','Trampa opresiva','La Trampa opresiva entra al campo de batalla girada. Cuando la Trampa opresiva entre al campo de batalla, obtienes dos contadores de energía. Al girar, pagar energía : Gira la criatura o el planeswalker objetivo. No pueden activarse sus habilidades activadas este turno.','Kaladesh');");
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES ('Magic','2006','1.49','1','Categoría alfa','La criatura encantada obtiene +2/+2 por cada una de las demas criaturas en juego que compartan un tipo de criatura con ella.','Salvat');");
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES ('Magic','2018','0.15','4','Eviscerar','Destruye la criatura objetivo.','Dominaria');");
            sentencia.execute("INSERT INTO cartas_magic (IDCarta,IDCMagic, Color, Coste, Tipo) VALUES ('001','164/259 C','Multicolor','3','Criatura - Humano Asesino');");
            sentencia.execute("INSERT INTO cartas_magic (IDCarta,IDCMagic, Color, Coste, Tipo) VALUES ('002','109/205 H','Negro','4','Criatura - Planta');");
            sentencia.execute("INSERT INTO cartas_magic (IDCarta,IDCMagic, Color, Coste, Tipo) VALUES ('003','204/264 R','Incoloro','3','Artefacto');");
            sentencia.execute("INSERT INTO cartas_magic (IDCarta,IDCMagic, Color, Coste, Tipo) VALUES ('004','204/254 R','Verde','3','Encantamiento - Aura');");
            sentencia.execute("INSERT INTO cartas_magic (IDCarta,IDCMagic, Color, Coste, Tipo) VALUES ('005','091/269 C','Negro','4','Conjuro');");
            
            //Cartas Yu-gi-oh
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES ('Yu-Gi-Oh','2002','4.99','5','Dragón blanco de ojos azules','Este legendario dragón es una poderosa máquina de destrucción. Virtualmente invencible, muy pocos se han enfrentado a esta impresionante criatura y han vivido para contarlo. ','Leyenda del dragón blanco de ojos azules');");
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES ('Yu-Gi-Oh','2010','0.99','3','Alanegra - Gust el Viento de Cola ','Si no controlas cartas, puedes Invocar esta carta de Modo Especial (desde tu mano). Si un monstruo de tu adversario ataca a un monstruo Alanegra que controles, el monstruo atacante pierde 300 ATK, sólo durante el Damage Step. ','Oscuridad brillante');");
            sentencia.execute("INSERT INTO cartas_yugi (IDCarta, IDCYugi, TipoCarta, Atributo, Nivel, SubTipo) VALUES ('006','BIK-S001','Monstruo','Luz','8','Dragón')");
            sentencia.execute("INSERT INTO cartas_yugi (IDCarta, IDCYugi, TipoCarta, Atributo, Nivel, SubTipo) VALUES ('007','LC5D-SP121','Monstruo','Oscuridad','2','Bestia Alada')");
            
            
            

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
