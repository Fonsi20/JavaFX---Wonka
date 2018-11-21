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
                    + "	Apellidos VARCHAR(60) NOT NULL,"
                    + "	Edad INT(2) NOT NULL,"
                    + "	Sexo BOOLEAN NOT NULL,"
                    + "	Dirección VARCHAR(200) NOT NULL,"
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
                    + "	Tipo VARCHAR(50) NOT NULL,"
                    + "	Raza VARCHAR(50) NOT NULL,"
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
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES "
                    + "('Magic','2018','0.49','5','Agente filoscuro','Mientras hayas escrutado este turno, la Agente filoscuro tiene la habilidad de toque mortal y `Siempre que esta criatura haga daño de combate a un jugador, tú robas una carta´. Dimir','Gremios de Ravnica'),"
                    + "('Magic','2016','2.49','0','Árbol de la perdición','Defensor. Intercambia el total de vidas del oponente objetivo con la resistencia del Árbol de la perdición.','Luna de horrores'),"
                    + "('Magic','2016','0.49','2','Trampa opresiva','La Trampa opresiva entra al campo de batalla girada. Cuando la Trampa opresiva entre al campo de batalla, obtienes dos contadores de energía. Al girar, pagar energía : Gira la criatura o el planeswalker objetivo. No pueden activarse sus habilidades activadas este turno.','Kaladesh'),"
                    + "('Magic','2006','1.49','1','Categoría alfa','La criatura encantada obtiene +2/+2 por cada una de las demas criaturas en juego que compartan un tipo de criatura con ella.','Salvat'),"
                    + "('Magic','2018','0.15','4','Eviscerar','Destruye la criatura objetivo.','Dominaria');");
            sentencia.execute("INSERT INTO cartas_magic (IDCarta,IDCMagic, Color, Coste, Tipo) VALUES "
                    + "('001','164/259 C','Multicolor','3','Criatura - Humano Asesino'),"
                    + "('002','109/205 H','Negro','4','Criatura - Planta'),"
                    + "('003','204/264 R','Incoloro','3','Artefacto'),"
                    + "('004','204/254 R','Verde','3','Encantamiento - Aura'),"
                    + "('005','091/269 C','Negro','4','Destruye la criatura objetivo.')");

            //Cartas Yu-gi-oh
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES "
                    + "('Yu-Gi-Oh','2002','4.99','5','Dragón blanco de ojos azules','Este legendario dragón es una poderosa máquina de destrucción. Virtualmente invencible, muy pocos se han enfrentado a esta impresionante criatura y han vivido para contarlo.','Leyenda del dragón blanco de ojos azules'),"
                    + "('Yu-Gi-Oh','2010','0.99','3','Alanegra - Gust el Viento de Cola ','Si no controlas cartas, puedes Invocar esta carta de Modo Especial (desde tu mano). Si un monstruo de tu adversario ataca a un monstruo Alanegra que controles, el monstruo atacante pierde 300 ATK, sólo durante el Damage Step.','Oscuridad brillante'),"
                    + "('Yu-Gi-Oh','2009','1.49','2','Baya de la supremacía','Si tus Life Points eran menos que los de tu adversario cuando se activó esta carta, gana 2000 Life Points. Si tus Life Points eran más, recibe 1000 puntos de daño.','Batalla furiosa'),"
                    + "('Yu-Gi-Oh','2005','1.99','5','Armadura Sakuretsu','Cuando un monstruo de tu adversario declara un ataque: selecciona al monstruo atacante; destruye ese objetivo.','Revelación oscura volumen 1'),"
                    + "('Yu-Gi-Oh','2015','9.99','0','Esfera kuriboh','Cuando un monstruo de tu adversario declara un ataque: puedes mandar al Cementerio esta carta en tu mano; cambia al monstruo atacante a Posición de Defensa. Cuando Invocas un monstruo por Ritual, puedes desterrar esta carta en tu Cementerio como 1 de los monstruos requeridos para la Invocación por Ritual.','Dimensión del caos');");
            sentencia.execute("INSERT INTO cartas_yugi (IDCarta, IDCYugi, TipoCarta, Atributo, Nivel, SubTipo) VALUES "
                    + "('006','BIK-S001','Monstruo','Luz','8','Dragón'),"
                    + "('007','LC5D-SP121','Monstruo','Oscuridad','2','Bestia Alada'),"
                    + "('008','RGBT-SP060','Mágica','Mágica','0','Mágica normal'),"
                    + "('009','LCYW-SP238','Trampa','Trampa','0','Trampa normal'),"
                    + "('010','DOSC-SP020','Monstruo','Oscuridad','1','Demonio');");
            
            //Cartas Force of will
            sentencia.execute("INSERT INTO cartas ( NombreJuego, Año, Precio, Stock, NombreCarta, Descripcion, Coleccion) VALUES "
                    + "('Force of Will','2016','3.49','1','La manticora','Cuando esta carta entre en tu campo; Elige uno - Mira la mano de tu oponente y elige una carta. Tu oponente y elige una carta. Tu oponente descarta esa carta; o destruye el añadido o insignia objetivo que controle tu oponente','Legacy Lost'),"
                    + "('Force of Will','2014','2.49','4','Alicia, avatar de las siete tierras','Si te fueran a infligir daño, en vez de eso se lo infligen a esta carta.','The Moonlit Savior'),"
                    + "('Force of Will','2013','1.49','0','Caza de almas','Cada jugador entierra un resonador, luego cada jugador descarta una carta','PR Card'),"
                    + "('Force of Will','2016','1.99','1','Gwiner, el dragón blanco','Puedes pagar 2 menos para jugar esta carta por cada resonador que contrates que haya sido puesto en tu campo este turno','PR Card');");
                    
            
            sentencia.execute("INSERT INTO cartas_fow (IDCarta, IDCFoW, Elemento, Coste, Tipo, Raza) VALUES "
                    + "('011','LEL-090 R','Multicolor','5','Resonador','Quimera'),"
                    + "('012','RL 1701-2','Agua','6','Resonador','Avatar'),"
                    + "('013','RL1611-1','Viento','1','Canto','Ninguna'),"
                    + "('014','RL1611-2','Oscuridad','5','Resonador','Dragón');");
                   
            //Clientes
            sentencia.execute("INSERT INTO clientes (Nombre,Apellidos,Edad,Sexo,Dirección,Telefono,Mail) values"
                    + "('Alfonso','Fernández Alvarez','27',true,'Baixada ao Reiro Nº19 - Ponteareas - Spain','555555520','fonsi20@gmail.com' ),"
                    + "('David','da Silva Simón','23',true,'Camiño Arieiro nº1 - Vigo - Spain','568975345','daviddasilva@gmail.com' ),"
                    + "('Ana','Pérez Sánchez','31',false,'Calle Coruña nº13 - Vigo - Spain','484574656','anaperez@gmail.com' ),"
                    + "('Nuria','Muñoz Carrera','25',false,'Avenida Gran Via nº33 - Vigo - Spain','411203040','nuriamuñoz@gmail.com' ),"
                    + "('Bonifacio','Rodríguez Álvarez','55',true,'Camino del rio nº19 - Mos - Spain','232124578','bonifaciorodriguez@gmail.com' ),"
                    + "('Leonardo','Costas Zapatero','42',true,'Calle Miramar nº23 - Cangas - Spain','787878788','leonardocostas@gmail.com' );");

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

}
