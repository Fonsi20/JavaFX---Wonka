package wonka;

import Objetos.*;
import backend.Bajas;
import backend.Inserciones;
import backend.comprobacionesDatos;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import java.io.ByteArrayInputStream;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Controller implements Initializable, MapComponentInitializedListener {

// <editor-fold defaultstate="collapsed" desc="Declaraciones de elementos de la interfaz">
    //INICIALIZAMOS LAS PANTALLAS Y TODOS LOS DEMÁS COMPONENETES DE NUESTROS FXML
    @FXML
    private AnchorPane home;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnCompras;

    @FXML
    private Button btnHistorial;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlDevelops;

    @FXML
    private Pane pnlHistorial;

    @FXML
    private VBox pnItemsHistorial;

    @FXML
    private Pane pnlCompras;

    @FXML
    private VBox pnItemsClientesLess;

    @FXML
    private VBox pnItemsCartasLess;

    @FXML
    private JFXTextField busComCliente;

    @FXML
    private JFXTextField busComCarta;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private TextField nombreCliente;

    @FXML
    private TextField edadCliente;

    @FXML
    private TextField apellidosCliente;

    @FXML
    private ComboBox sexoCliente;

    @FXML
    private TextField emailCliente;

    @FXML
    private TextField telefonoCliente;

    @FXML
    private Button btnModificarCamposClientes;

    @FXML
    private Button btnBorrarCamposClientes;

    @FXML
    private Button btnGuardarCamposClientes;

    @FXML
    private VBox pnItemsClientes;

    @FXML
    private TextField direccionCliente;

    @FXML
    private Pane pnlOrders;

    @FXML
    private ComboBox nameGame;

    @FXML
    private TextField yearCard;

    @FXML
    private TextField stockCard;

    @FXML
    private TextField nameCard;

    @FXML
    private TextField priceCard;

    @FXML
    private TextField colecCard;

    @FXML
    private JFXTextArea sumCard;

    @FXML
    private Button btnModificarCarta;

    @FXML
    private Button btnBorrarCarta;

    @FXML
    private Button btnGuardarCarta;

    @FXML
    private VBox atributosYugi1;

    @FXML
    private TextField yugiID;

    @FXML
    private TextField yugiAtributo;

    @FXML
    private VBox atributosYugi2;

    @FXML
    private JFXComboBox<String> yugiTipo;

    @FXML
    private TextField yugiNivel;

    @FXML
    private TextField yugiSubTIpo;

    @FXML
    private VBox atributosMagi1;

    @FXML
    private TextField magiID;

    @FXML
    private TextField magiCoste;

    @FXML
    private VBox atributosMagi2;

    @FXML
    private TextField magiTipo;

    @FXML
    private JFXComboBox<String> magiColor;

    @FXML
    private VBox atributosFOG1;

    @FXML
    private TextField fogID;

    @FXML
    private TextField fogCoste;

    @FXML
    private VBox atributosFOG2;

    @FXML
    private TextField fogTipo;

    @FXML
    private JFXComboBox<String> fogColor;

    @FXML
    private TextField fogRaza;

    @FXML
    private VBox pnItemsOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane MostrarCarta;

    @FXML
    private VBox pnItems;

    @FXML
    private TextField entradaBusquedaInicio;

    @FXML
    private TextField entradaBusquedaCartas;

    @FXML
    private TextField lblBuscarCliente;

    @FXML
    private Label lblTotalCartas;

    @FXML
    private Label lblTotalClientes;

    @FXML
    private Label lblPedidosPendientes;

    @FXML
    private Label lblCartasVendidas;

    @FXML
    private VBox MenuPrincipal;

    @FXML
    private StackPane PantallasHome;

    @FXML
    private TextField textAreaCantidadCompra;

    @FXML
    private ImageView MCImagenCarta;

    @FXML
    private Text MCNombreC;

    @FXML
    private Text MCColeccion;

    @FXML
    private TextArea MCDescripcion;

    @FXML
    private Text MCPrecio;

    @FXML
    private Text MCStock;

    @FXML
    private Text MCAno;

    @FXML
    private VBox MCBloqueYuGi;

    @FXML
    private TextField MCyuID;

    @FXML
    private TextField MCyuTIPOC;

    @FXML
    private TextField MCyuAtribu;

    @FXML
    private TextField MCyuLVL;

    @FXML
    private TextField MCyuSub;

    @FXML
    private VBox MCBloqueMagic;

    @FXML
    private TextField MCmagicID;

    @FXML
    private TextField MCmagicTIPOC;

    @FXML
    private TextField MCmagicCoste;

    @FXML
    private TextField MCmagicColor;

    @FXML
    private VBox MCBloqueFow;

    @FXML
    private TextField MCfowID;

    @FXML
    private TextField MCfowTIPOC;

    @FXML
    private TextField MCfowCoste;

    @FXML
    private TextField MCfowElemento;

    @FXML
    private TextField MCfowRaza;

    @FXML
    private Button btnSubirImagen;

    @FXML
    private GoogleMapView gmaps;
    private GoogleMap map;

    // </editor-fold>
    private Node[] nodes = new Node[0];
    private Node[] nodesCartas = new Node[0];
    private Node[] nodesClientes = new Node[0];
    private Node[] nodesCartasLess = new Node[0];
    private Node[] nodesClientesLess = new Node[0];
    private Node[] nodesHistorial = new Node[0];

    private String idClienteCompra;
    private String idCartaCompra;

    private File selectedFile;

    // ---------------------------------------- Métodos de control de la aplicación ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Método de inicialización">
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gmaps.addMapInializedListener(this);
        System.out.println("uno");
        try {
            try {
                //Arrancamos todas las listas de todas las pantallas
                ListCards();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("dos");
            ListCardsOrders();
            System.out.println("tres");
            try {
                ListCardsClientes();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("cuatro");

            ListCardsLess();
            System.out.println("cinco");
            ListClientesLess();
            System.out.println("seis");
            try {
                ListHistorial();
            } catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("siete");

        //Cargamos items en la comboBox de tipo de juego de carta
        nameGame.getItems().addAll(
                "Yu-Gi-Oh",
                "Magic",
                "Force of Will"
        );

        //Cargamos items en la comboBox de sexo de cliente
        sexoCliente.getItems().addAll(
                "Femenino",
                "Masculino"
        );

        magiColor.getItems().addAll(
                "Blanco", "Azul", "Negro", "Rojo", "Verde", "Incoloro", "Multicolor"
        );

        yugiTipo.getItems().addAll(
                "Monstruo", "Mágica", "Trampa"
        );

        fogColor.getItems().addAll(
                "Luz", "Oscuridad", "Agua", "Viento", "Fuego", "Neutro", "Multicolor"
        );

        //Metodo para poder arrastrar la pantalla libremente
        this.MoverVentanas(this.home);

        //Metodo Inizialización de informacion DASHBOARD
        CargarDatosDashboard();

    }
    // </editor-fold>

    @Override
    public void mapInitialized() {
        LatLong joeSmithLocation = new LatLong(42.2260838, -8.7604453);

        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();

        mapOptions.center(new LatLong(42.2260838, -8.7604453))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(13);

        map = gmaps.createMap(mapOptions);

        //Add markers to the map
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(joeSmithLocation);

        Marker joeSmithMarker = new Marker(markerOptions1);

        map.addMarker(joeSmithMarker);

    }

    // <editor-fold defaultstate="collapsed" desc="Método de control de campos editables para la ventana de Cartas">
    @FXML
    //Activar los distintos campos de inserción de una carta
    public void activarAtributo(ActionEvent actionEvent) {

        String p = (String) nameGame.getSelectionModel().getSelectedItem();

        if ("Magic".equals(p)) {

            atributosMagi1.setStyle("-fx-background-color :  #4FA2FF");
            atributosMagi2.setStyle("-fx-background-color :  #4FA2FF");
            atributosYugi1.setStyle("-fx-background-color :  #266D7F");
            atributosYugi2.setStyle("-fx-background-color :   #266D7F");
            atributosFOG1.setStyle("-fx-background-color :   #266D7F");
            atributosFOG2.setStyle("-fx-background-color :   #266D7F");

            atributosYugi1.setDisable(true);
            atributosYugi2.setDisable(true);
            atributosFOG1.setDisable(true);
            atributosFOG2.setDisable(true);
            atributosMagi1.setDisable(false);
            atributosMagi2.setDisable(false);
        }
        if ("Yu-Gi-Oh".equals(p)) {
            atributosYugi1.setStyle("-fx-background-color :  #4FA2FF");
            atributosYugi2.setStyle("-fx-background-color :  #4FA2FF");
            atributosMagi1.setStyle("-fx-background-color :  #266D7F");
            atributosMagi2.setStyle("-fx-background-color :   #266D7F");
            atributosFOG1.setStyle("-fx-background-color :   #266D7F");
            atributosFOG2.setStyle("-fx-background-color :   #266D7F");

            atributosYugi1.setDisable(false);
            atributosYugi2.setDisable(false);
            atributosFOG1.setDisable(true);
            atributosFOG2.setDisable(true);
            atributosMagi1.setDisable(true);
            atributosMagi2.setDisable(true);
        }
        if ("Force of Will".equals(p)) {
            atributosFOG1.setStyle("-fx-background-color :  #4FA2FF");
            atributosFOG2.setStyle("-fx-background-color :  #4FA2FF");
            atributosYugi1.setStyle("-fx-background-color :  #266D7F");
            atributosYugi2.setStyle("-fx-background-color :   #266D7F");
            atributosMagi1.setStyle("-fx-background-color :   #266D7F");
            atributosMagi2.setStyle("-fx-background-color :   #266D7F");

            atributosYugi1.setDisable(true);
            atributosYugi2.setDisable(true);
            atributosFOG1.setDisable(false);
            atributosFOG2.setDisable(false);
            atributosMagi1.setDisable(true);
            atributosMagi2.setDisable(true);
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Control de los botones del menú">
    @FXML
    //Acciones al pulsar sobre los botones del menú
    public void handleClicks(ActionEvent actionEvent) throws SQLException, IOException {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(true);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(false);
            pnlHistorial.setVisible(false);
            ListCardsClientes();
            accionLimpiarCamposClientes(actionEvent);
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnCompras) {
            pnlCompras.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(true);
            pnlHistorial.setVisible(false);
            ListCardsLess();
            ListClientesLess();
            pnlCompras.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(true);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(false);
            pnlHistorial.setVisible(false);
            ListCards();
            pnlOverview.toFront();
        }
        if (actionEvent.getSource() == btnSettings) {
            pnlDevelops.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(true);
            pnlCompras.setVisible(false);
            pnlHistorial.setVisible(false);
            pnlDevelops.toFront();
        }
        if (actionEvent.getSource() == btnHistorial) {
            pnlOrders.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(false);
            pnlHistorial.setVisible(true);
            ListHistorial();
            pnlHistorial.toFront();
        }
        if (actionEvent.getSource() == btnOrders) {
            pnlOrders.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(true);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(false);
            pnlHistorial.setVisible(false);
            ListCardsOrders();
            accionLimpiarCarta(actionEvent);
            pnlOrders.toFront();
        }
        if (actionEvent.getSource() == btnSignout) {
            System.exit(0);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de movimiento de ventanas">
    @FXML
    private void MoverVentanas(AnchorPane root) {

        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);

        root.setOnMousePressed(e -> {
            Stage stage = (Stage) root.getScene().getWindow();
            xOffset.set(stage.getX() - e.getScreenX());
            yOffset.set(stage.getY() - e.getScreenY());

        });

        root.setOnMouseDragged(e -> {
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setX(e.getScreenX() + xOffset.get());
            stage.setY(e.getScreenY() + yOffset.get());
        });
    }
    // </editor-fold>

    // ---------------------------------------- Cargas ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Método de carga de los nodos en la ventana de Inicio">
    @FXML
    //Carga de la lista de Cartas de la pantalla inicial
    public void ListCards() throws SQLException {
        if (Wonka.basedatos == true) {
            try {
                Statement S = Wonka.conect.createStatement();
                ResultSet Res = S.executeQuery("SELECT COUNT(*) AS Cont FROM CARTAS");
                Res.next();
                limpiarListas(pnItems);
                nodes = new Node[Res.getInt("Cont")];
                Res.close();
                Res = S.executeQuery("SELECT NombreJuego as NJ, NombreCarta as NC, Coleccion as C, Precio as P, Stock as S FROM CARTAS");
                try {
                    for (int i = 0; i < nodes.length; i++) {
                        Res.next();
                        final int j = i;
                        nodes[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                        //Establecimiento de labels
                        Label itemCartaJuego = (Label) nodes[i].lookup("#itemCartaJuego");
                        itemCartaJuego.setText(Res.getString("NJ"));

                        Label itemCartaNombre = (Label) nodes[i].lookup("#itemCartaNombre");
                        itemCartaNombre.setText(Res.getString("NC"));

                        Label itemCartaColeccion = (Label) nodes[i].lookup("#itemCartaColeccion");
                        itemCartaColeccion.setText(Res.getString("C"));

                        Label itemCartaPrecio = (Label) nodes[i].lookup("#itemCartaPrecio");
                        itemCartaPrecio.setText(Res.getString("P"));

                        Button itemCartaStock = (Button) nodes[i].lookup("#itemCartaStock");
                        itemCartaStock.setText(Res.getString("S"));

                        nodes[i].setOnMouseEntered(event -> {
                            nodes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });

                        nodes[i].setOnMouseExited(event -> {
                            nodes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });

                        nodes[i].setOnMouseClicked(event -> {

                            Session s;
                            s = NewHibernateUtil.getSession();
                            List<Object> CartaMAGIC = s.createCriteria(CartaMAGIC.class).list();
                            List<Object> CartaFOW = s.createCriteria(CartaFOW.class).list();
                            List<Object> CartaYUGI = s.createCriteria(CartaYUGI.class).list();
                            s.close();

                            MCNombreC.setText(itemCartaNombre.getText());
                            MCColeccion.setText("Coleccion: " + itemCartaColeccion.getText());
                            MCPrecio.setText("Precio: " + itemCartaPrecio.getText());
                            MCStock.setText("Stock: " + itemCartaStock.getText());

                            if (itemCartaJuego.getText().equals("Yu-Gi-Oh")) {
                                MCBloqueYuGi.setDisable(false);
                                MCBloqueFow.setDisable(true);
                                MCBloqueMagic.setDisable(true);
                                for (Object o : CartaYUGI) {
                                    if (itemCartaNombre.getText().equals(((CartaYUGI) o).getNombreCarta())) {

                                        if (((CartaYUGI) o).getIMG() != null) {

                                            Image img = new Image(new ByteArrayInputStream(((CartaYUGI) o).getIMG()));
                                            MCImagenCarta.setImage(img);
                                        } else {
                                            String url = "file:src/images/ReversoCard.jpg";
                                            MCImagenCarta.setImage(new Image(url));
                                        }

                                        MCDescripcion.setText(((CartaYUGI) o).getDescripcion());
                                        String[] parts = (((CartaYUGI) o).getAno()).split("-");
                                        String year = parts[0];
                                        MCAno.setText("Año: " + year);
                                        MCyuAtribu.setText(((CartaYUGI) o).getAtributo());
                                        MCyuID.setText(((CartaYUGI) o).getIDCYugi());
                                        MCyuLVL.setText(String.valueOf(((CartaYUGI) o).getNivel()));
                                        MCyuSub.setText(((CartaYUGI) o).getSubTipo());

                                        //"Monstruo", "Mágica", "Trampa"
                                        if (((CartaYUGI) o).getTipoCarta().equals("Monstruo")) {
                                            MCyuTIPOC.setText("Monstruo");
                                        }
                                        if (((CartaYUGI) o).getTipoCarta().equals("Mágica")) {
                                            MCyuTIPOC.setText("Mágica");
                                        }
                                        if (((CartaYUGI) o).getTipoCarta().equals("Trampa")) {
                                            MCyuTIPOC.setText("Trampa");
                                        }
                                        MostrarCarta.setVisible(true);
                                        MenuPrincipal.setDisable(true);
                                        PantallasHome.setDisable(true);
                                    }
                                }
                            } else if (itemCartaJuego.getText().equals("Magic")) {
                                MCBloqueYuGi.setDisable(true);
                                MCBloqueFow.setDisable(true);
                                MCBloqueMagic.setDisable(false);
                                for (Object o : CartaMAGIC) {
                                    if (itemCartaNombre.getText().equals(((CartaMAGIC) o).getNombreCarta())) {

                                        if (((CartaMAGIC) o).getIMG() != null) {

                                            Image img = new Image(new ByteArrayInputStream(((CartaMAGIC) o).getIMG()));
                                            MCImagenCarta.setImage(img);
                                        } else {
                                            String url = "file:src/images/ReversoCard.jpg";
                                            MCImagenCarta.setImage(new Image(url));
                                        }

                                        MCDescripcion.setText(((CartaMAGIC) o).getDescripcion());
                                        String[] parts = (((CartaMAGIC) o).getAno()).split("-");
                                        String year = parts[0];
                                        MCAno.setText("Año: " + year);
                                        MCmagicCoste.setText(((CartaMAGIC) o).getCoste());
                                        MCmagicID.setText(((CartaMAGIC) o).getIDCMagic());
                                        MCmagicTIPOC.setText(((CartaMAGIC) o).getTipo());

                                        //"Blanco", "Azul", "Negro", "Rojo", "Verde", "Incoloro", "Multicolor"
                                        if (((CartaMAGIC) o).getColor().equals("Blanco")) {
                                            MCmagicColor.setText("Blanco");
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Azul")) {
                                            MCmagicColor.setText("Azul");
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Negro")) {
                                            MCmagicColor.setText("Negro");
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Rojo")) {
                                            MCmagicColor.setText("Rojo");
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Verde")) {
                                            MCmagicColor.setText("Verde");
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Incoloro")) {
                                            MCmagicColor.setText("Incoloro");
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Multicolor")) {
                                            MCmagicColor.setText("Multicolor");
                                        }
                                        MostrarCarta.setVisible(true);
                                        MenuPrincipal.setDisable(true);
                                        PantallasHome.setDisable(true);

                                    }
                                }
                            } else if (itemCartaJuego.getText().equals("Force of Will")) {
                                MCBloqueYuGi.setDisable(true);
                                MCBloqueFow.setDisable(false);
                                MCBloqueMagic.setDisable(true);
                                for (Object o : CartaFOW) {
                                    if (itemCartaNombre.getText().equals(((CartaFOW) o).getNombreCarta())) {

                                        if (((CartaFOW) o).getIMG() != null) {

                                            Image img = new Image(new ByteArrayInputStream(((CartaFOW) o).getIMG()));
                                            MCImagenCarta.setImage(img);
                                        } else {
                                            String url = "file:src/images/ReversoCard.jpg";
                                            MCImagenCarta.setImage(new Image(url));
                                        }
                                        MCDescripcion.setText(((CartaFOW) o).getDescripcion());
                                        String[] parts = (((CartaFOW) o).getAno()).split("-");
                                        String year = parts[0];
                                        MCAno.setText("Año: " + year);
                                        MCfowCoste.setText(((CartaFOW) o).getCoste());
                                        MCfowID.setText(((CartaFOW) o).getIDCFoW());
                                        MCfowRaza.setText(((CartaFOW) o).getRaza());
                                        MCfowTIPOC.setText(((CartaFOW) o).getTipo());

                                        //"Luz", "Oscuridad", "Agua", "Viento", "Fuego", "Neutro", "Multicolor"
                                        if (((CartaFOW) o).getElemento().equals("Luz")) {
                                            MCfowElemento.setText("Luz");
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Oscuridad")) {
                                            MCfowElemento.setText("Oscuridad");
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Agua")) {
                                            MCfowElemento.setText("Agua");
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Viento")) {
                                            MCfowElemento.setText("Viento");
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Fuego")) {
                                            MCfowElemento.setText("Fuego");
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Neutro")) {
                                            MCfowElemento.setText("Neutro");
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Multicolor")) {
                                            MCfowElemento.setText("Multicolor");
                                        }
                                        MostrarCarta.setVisible(true);
                                        MenuPrincipal.setDisable(true);
                                        PantallasHome.setDisable(true);

                                    }
                                }
                            }
                        });
                        pnItems.getChildren().add(nodes[i]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Res.close();
            } catch (SQLException x) {
                System.out.println(x);
            }
        } else {

            //Aqui va cargar listas cartas desde neodatis
            ODB odb = ODBFactory.openClient("localhost", 8000, "neoWonka");
            Values val = odb.getValues(new ValuesCriteriaQuery(Carta.class).count("IDCarta"));
            ObjectValues ov = val.nextValues();
            int value = Integer.parseInt(String.valueOf(ov.getByAlias("IDCarta")));
            limpiarListas(pnItems);
            nodes = new Node[value];
            Values valCarta = odb.getValues(new ValuesCriteriaQuery(Carta.class)
                    .field("NombreJuego")
                    .field("NombreCarta")
                    .field("Coleccion")
                    .field("Precio")
                    .field("Stock"));
            try {
                for (int i = 0; i < nodes.length; i++) {
                    valCarta.next();
                    ObjectValues ovCarta = (ObjectValues) val.next();
                    final int j = i;
                    nodes[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                    //Establecimiento de labels
                    Label itemCartaJuego = (Label) nodes[i].lookup("#itemCartaJuego");
                    itemCartaJuego.setText((String) ovCarta.getByAlias("NombreJuego"));

                    Label itemCartaNombre = (Label) nodes[i].lookup("#itemCartaNombre");
                    itemCartaNombre.setText((String) ovCarta.getByAlias("NombreCarta"));

                    Label itemCartaColeccion = (Label) nodes[i].lookup("#itemCartaColeccion");
                    itemCartaColeccion.setText((String) ovCarta.getByAlias("Coleccion"));

                    Label itemCartaPrecio = (Label) nodes[i].lookup("#itemCartaPrecio");
                    itemCartaPrecio.setText((String) ovCarta.getByAlias("Precio"));

                    Button itemCartaStock = (Button) nodes[i].lookup("#itemCartaStock");
                    itemCartaStock.setText((String) ovCarta.getByAlias("Stock"));

                    nodes[i].setOnMouseEntered(event -> {
                        nodes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });

                    nodes[i].setOnMouseExited(event -> {
                        nodes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                    });

                    nodes[i].setOnMouseClicked(event -> {

                        /**
                         * Session s; s = NewHibernateUtil.getSession();
                         * List<Object> CartaMAGIC =
                         * s.createCriteria(CartaMAGIC.class).list();
                         * List<Object> CartaFOW =
                         * s.createCriteria(CartaFOW.class).list(); List<Object>
                         * CartaYUGI = s.createCriteria(CartaYUGI.class).list();
                         * s.close();*
                         */
                        Objects<CartaYUGI> valCartaYugi = odb.getObjects(new CriteriaQuery(CartaYUGI.class));
                        Objects<CartaMAGIC> valCartaMagic = odb.getObjects(new CriteriaQuery(CartaMAGIC.class));
                        Objects<CartaFOW> valCartaFow = odb.getObjects(new CriteriaQuery(CartaFOW.class));

                        MCNombreC.setText(itemCartaNombre.getText());
                        MCColeccion.setText("Coleccion: " + itemCartaColeccion.getText());
                        MCPrecio.setText("Precio: " + itemCartaPrecio.getText());
                        MCStock.setText("Stock: " + itemCartaStock.getText());

                        if (itemCartaJuego.getText().equals("Yu-Gi-Oh")) {
                            MCBloqueYuGi.setDisable(false);
                            MCBloqueFow.setDisable(true);
                            MCBloqueMagic.setDisable(true);
                            while (valCartaYugi.hasNext()) {
                                Object o = valCartaYugi.next();
                                if (itemCartaNombre.getText().equals(((CartaYUGI) o).getNombreCarta())) {

                                    if (((CartaYUGI) o).getIMG() != null) {

                                        Image img = new Image(new ByteArrayInputStream(((CartaYUGI) o).getIMG()));
                                        MCImagenCarta.setImage(img);
                                    } else {
                                        String url = "file:src/images/ReversoCard.jpg";
                                        MCImagenCarta.setImage(new Image(url));
                                    }

                                    MCDescripcion.setText(((CartaYUGI) o).getDescripcion());
                                    String[] parts = (((CartaYUGI) o).getAno()).split("-");
                                    String year = parts[0];
                                    MCAno.setText("Año: " + year);
                                    MCyuAtribu.setText(((CartaYUGI) o).getAtributo());
                                    MCyuID.setText(((CartaYUGI) o).getIDCYugi());
                                    MCyuLVL.setText(String.valueOf(((CartaYUGI) o).getNivel()));
                                    MCyuSub.setText(((CartaYUGI) o).getSubTipo());

                                    //"Monstruo", "Mágica", "Trampa"
                                    if (((CartaYUGI) o).getTipoCarta().equals("Monstruo")) {
                                        MCyuTIPOC.setText("Monstruo");
                                    }
                                    if (((CartaYUGI) o).getTipoCarta().equals("Mágica")) {
                                        MCyuTIPOC.setText("Mágica");
                                    }
                                    if (((CartaYUGI) o).getTipoCarta().equals("Trampa")) {
                                        MCyuTIPOC.setText("Trampa");
                                    }
                                    MostrarCarta.setVisible(true);
                                    MenuPrincipal.setDisable(true);
                                    PantallasHome.setDisable(true);
                                }
                            }
                        } else if (itemCartaJuego.getText().equals("Magic")) {
                            MCBloqueYuGi.setDisable(true);
                            MCBloqueFow.setDisable(true);
                            MCBloqueMagic.setDisable(false);
                            while (valCartaMagic.hasNext()) {
                                Object o = valCartaMagic.next();
                                if (itemCartaNombre.getText().equals(((CartaMAGIC) o).getNombreCarta())) {

                                    if (((CartaMAGIC) o).getIMG() != null) {

                                        Image img = new Image(new ByteArrayInputStream(((CartaMAGIC) o).getIMG()));
                                        MCImagenCarta.setImage(img);
                                    } else {
                                        String url = "file:src/images/ReversoCard.jpg";
                                        MCImagenCarta.setImage(new Image(url));
                                    }

                                    MCDescripcion.setText(((CartaMAGIC) o).getDescripcion());
                                    String[] parts = (((CartaMAGIC) o).getAno()).split("-");
                                    String year = parts[0];
                                    MCAno.setText("Año: " + year);
                                    MCmagicCoste.setText(((CartaMAGIC) o).getCoste());
                                    MCmagicID.setText(((CartaMAGIC) o).getIDCMagic());
                                    MCmagicTIPOC.setText(((CartaMAGIC) o).getTipo());

                                    //"Blanco", "Azul", "Negro", "Rojo", "Verde", "Incoloro", "Multicolor"
                                    if (((CartaMAGIC) o).getColor().equals("Blanco")) {
                                        MCmagicColor.setText("Blanco");
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Azul")) {
                                        MCmagicColor.setText("Azul");
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Negro")) {
                                        MCmagicColor.setText("Negro");
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Rojo")) {
                                        MCmagicColor.setText("Rojo");
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Verde")) {
                                        MCmagicColor.setText("Verde");
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Incoloro")) {
                                        MCmagicColor.setText("Incoloro");
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Multicolor")) {
                                        MCmagicColor.setText("Multicolor");
                                    }
                                    MostrarCarta.setVisible(true);
                                    MenuPrincipal.setDisable(true);
                                    PantallasHome.setDisable(true);

                                }
                            }
                        } else if (itemCartaJuego.getText().equals("Force of Will")) {
                            MCBloqueYuGi.setDisable(true);
                            MCBloqueFow.setDisable(false);
                            MCBloqueMagic.setDisable(true);
                            while (valCartaFow.hasNext()) {
                                Object o = valCartaFow.next();
                                if (itemCartaNombre.getText().equals(((CartaFOW) o).getNombreCarta())) {

                                    if (((CartaFOW) o).getIMG() != null) {

                                        Image img = new Image(new ByteArrayInputStream(((CartaFOW) o).getIMG()));
                                        MCImagenCarta.setImage(img);
                                    } else {
                                        String url = "file:src/images/ReversoCard.jpg";
                                        MCImagenCarta.setImage(new Image(url));
                                    }
                                    MCDescripcion.setText(((CartaFOW) o).getDescripcion());
                                    String[] parts = (((CartaFOW) o).getAno()).split("-");
                                    String year = parts[0];
                                    MCAno.setText("Año: " + year);
                                    MCfowCoste.setText(((CartaFOW) o).getCoste());
                                    MCfowID.setText(((CartaFOW) o).getIDCFoW());
                                    MCfowRaza.setText(((CartaFOW) o).getRaza());
                                    MCfowTIPOC.setText(((CartaFOW) o).getTipo());

                                    //"Luz", "Oscuridad", "Agua", "Viento", "Fuego", "Neutro", "Multicolor"
                                    if (((CartaFOW) o).getElemento().equals("Luz")) {
                                        MCfowElemento.setText("Luz");
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Oscuridad")) {
                                        MCfowElemento.setText("Oscuridad");
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Agua")) {
                                        MCfowElemento.setText("Agua");
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Viento")) {
                                        MCfowElemento.setText("Viento");
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Fuego")) {
                                        MCfowElemento.setText("Fuego");
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Neutro")) {
                                        MCfowElemento.setText("Neutro");
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Multicolor")) {
                                        MCfowElemento.setText("Multicolor");
                                    }
                                    MostrarCarta.setVisible(true);
                                    MenuPrincipal.setDisable(true);
                                    PantallasHome.setDisable(true);

                                }
                            }
                        }
                    });
                    pnItems.getChildren().add(nodes[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            odb.close();

        }
    }
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de carga de los nodos de cartas en la ventana de Cartas">
    @FXML
    //Carga de la lista de Cartas de la pantalla Cartas
    public void ListCardsOrders() {
        if (Wonka.basedatos == true) {
            try {
                //String año = null, descripcion = null;
                Statement S = Wonka.conect.createStatement();
                ResultSet Res = S.executeQuery("SELECT COUNT(*) AS Cont FROM CARTAS");
                Res.next();
                limpiarListas(pnItemsOrders);
                nodesCartas = new Node[Res.getInt("Cont")];
                Res.close();
                Res = S.executeQuery("SELECT NombreJuego as NJ, NombreCarta as NC, Coleccion as C, Precio as P, Stock as S FROM CARTAS");
                try {
                    for (int i = 0; i < nodesCartas.length; i++) {
                        Res.next();
                        final int j = i;
                        nodesCartas[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                        //Establecimiento de labels
                        Label itemCartaJuego = (Label) nodesCartas[i].lookup("#itemCartaJuego");
                        itemCartaJuego.setText(Res.getString("NJ"));

                        Label itemCartaNombre = (Label) nodesCartas[i].lookup("#itemCartaNombre");
                        itemCartaNombre.setText(Res.getString("NC"));

                        Label itemCartaColeccion = (Label) nodesCartas[i].lookup("#itemCartaColeccion");
                        itemCartaColeccion.setText(Res.getString("C"));

                        Label itemCartaPrecio = (Label) nodesCartas[i].lookup("#itemCartaPrecio");
                        itemCartaPrecio.setText(Res.getString("P"));

                        Button itemCartaStock = (Button) nodesCartas[i].lookup("#itemCartaStock");
                        itemCartaStock.setText(Res.getString("S"));

                        nodesCartas[i].setOnMouseEntered(event -> {
                            nodesCartas[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });
                        nodesCartas[i].setOnMouseExited(event -> {
                            nodesCartas[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });

                        nodesCartas[i].setOnMouseClicked(event -> {
                            nodesCartas[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesCartas[j].setOnMouseExited(null);
                            nodesCartas[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesCartas.length; x++) {
                                if (x != j) {
                                    nodesCartas[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesCartas[x].setOnMouseExited(event2 -> {
                                        nodesCartas[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesCartas[x].setOnMouseEntered(event2 -> {
                                        nodesCartas[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });

                        nodesCartas[i].setOnMousePressed(event -> {
                            //Bloqueamos el campo Nombre Carta para no poder editarlo, para poder volver a escribir pulsar Limpiar.
                            nameCard.setDisable(true);
                            btnGuardarCarta.setDisable(true);
                            btnModificarCarta.setDisable(false);
                            btnBorrarCarta.setDisable(false);
                            //Cargar informacion en los Edit Text
                            Session s;
                            s = NewHibernateUtil.getSession();
                            List<Object> CartaMAGIC = s.createCriteria(CartaMAGIC.class).list();
                            List<Object> CartaFOW = s.createCriteria(CartaFOW.class).list();
                            List<Object> CartaYUGI = s.createCriteria(CartaYUGI.class).list();
                            s.close();

                            nameCard.setText(itemCartaNombre.getText());
                            colecCard.setText(itemCartaColeccion.getText());
                            priceCard.setText(itemCartaPrecio.getText());
                            stockCard.setText(itemCartaStock.getText());

                            if (itemCartaJuego.getText().equals("Yu-Gi-Oh")) {
                                nameGame.getSelectionModel().select(0);
                                for (Object o : CartaYUGI) {
                                    if (itemCartaNombre.getText().equals(((CartaYUGI) o).getNombreCarta())) {

                                        if (((CartaYUGI) o).getIMG() == null) {
                                            btnSubirImagen.setText("Subir imagen");
                                        } else {
                                            btnSubirImagen.setText("Modificar imagen");
                                        }

                                        sumCard.setText(((CartaYUGI) o).getDescripcion());
                                        String[] parts = (((CartaYUGI) o).getAno()).split("-");
                                        String year = parts[0];
                                        yearCard.setText(year);
                                        yugiAtributo.setText(((CartaYUGI) o).getAtributo());
                                        yugiID.setText(((CartaYUGI) o).getIDCYugi());
                                        yugiNivel.setText(String.valueOf(((CartaYUGI) o).getNivel()));
                                        yugiSubTIpo.setText(((CartaYUGI) o).getSubTipo());

                                        //"Monstruo", "Mágica", "Trampa"
                                        if (((CartaYUGI) o).getTipoCarta().equals("Monstruo")) {
                                            yugiTipo.getSelectionModel().select(0);
                                        }
                                        if (((CartaYUGI) o).getTipoCarta().equals("Mágica")) {
                                            yugiTipo.getSelectionModel().select(1);
                                        }
                                        if (((CartaYUGI) o).getTipoCarta().equals("Trampa")) {
                                            yugiTipo.getSelectionModel().select(2);
                                        }
                                    }
                                }
                            } else if (itemCartaJuego.getText().equals("Magic")) {
                                nameGame.getSelectionModel().select(1);
                                for (Object o : CartaMAGIC) {
                                    if (itemCartaNombre.getText().equals(((CartaMAGIC) o).getNombreCarta())) {

                                        if (((CartaMAGIC) o).getIMG() == null) {
                                            btnSubirImagen.setText("Subir imagen");
                                        } else {
                                            btnSubirImagen.setText("Modificar imagen");
                                        }

                                        sumCard.setText(((CartaMAGIC) o).getDescripcion());
                                        String[] parts = (((CartaMAGIC) o).getAno()).split("-");
                                        String year = parts[0];
                                        yearCard.setText(year);
                                        magiCoste.setText(((CartaMAGIC) o).getCoste());
                                        magiID.setText(((CartaMAGIC) o).getIDCMagic());
                                        magiTipo.setText(((CartaMAGIC) o).getTipo());

                                        //"Blanco", "Azul", "Negro", "Rojo", "Verde", "Incoloro", "Multicolor"
                                        if (((CartaMAGIC) o).getColor().equals("Blanco")) {
                                            magiColor.getSelectionModel().select(0);
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Azul")) {
                                            magiColor.getSelectionModel().select(1);
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Negro")) {
                                            magiColor.getSelectionModel().select(2);
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Rojo")) {
                                            magiColor.getSelectionModel().select(3);
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Verde")) {
                                            magiColor.getSelectionModel().select(4);
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Incoloro")) {
                                            magiColor.getSelectionModel().select(5);
                                        }
                                        if (((CartaMAGIC) o).getColor().equals("Multicolor")) {
                                            magiColor.getSelectionModel().select(6);
                                        }

                                    }
                                }
                            } else if (itemCartaJuego.getText().equals("Force of Will")) {
                                nameGame.getSelectionModel().select(2);
                                for (Object o : CartaFOW) {
                                    if (itemCartaNombre.getText().equals(((CartaFOW) o).getNombreCarta())) {

                                        if (((CartaFOW) o).getIMG() == null) {
                                            btnSubirImagen.setText("Subir imagen");
                                        } else {
                                            btnSubirImagen.setText("Modificar imagen");
                                        }

                                        sumCard.setText(((CartaFOW) o).getDescripcion());
                                        String[] parts = (((CartaFOW) o).getAno()).split("-");
                                        String year = parts[0];
                                        yearCard.setText(year);
                                        fogCoste.setText(((CartaFOW) o).getCoste());
                                        fogID.setText(((CartaFOW) o).getIDCFoW());
                                        fogRaza.setText(((CartaFOW) o).getRaza());
                                        fogTipo.setText(((CartaFOW) o).getTipo());

                                        //"Luz", "Oscuridad", "Agua", "Viento", "Fuego", "Neutro", "Multicolor"
                                        if (((CartaFOW) o).getElemento().equals("Luz")) {
                                            fogColor.getSelectionModel().select(0);
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Oscuridad")) {
                                            fogColor.getSelectionModel().select(1);
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Agua")) {
                                            fogColor.getSelectionModel().select(2);
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Viento")) {
                                            fogColor.getSelectionModel().select(3);
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Fuego")) {
                                            fogColor.getSelectionModel().select(4);
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Neutro")) {
                                            fogColor.getSelectionModel().select(5);
                                        }
                                        if (((CartaFOW) o).getElemento().equals("Multicolor")) {
                                            fogColor.getSelectionModel().select(6);
                                        }

                                    }
                                }
                            }
                        });

                        pnItemsOrders.getChildren().add(nodesCartas[i]);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Res.close();
            } catch (SQLException x) {
                System.out.println(x);
            }
        } else {
            ODB odb = ODBFactory.openClient("localhost", 8000, "neoWonka");
            Values val = odb.getValues(new ValuesCriteriaQuery(Carta.class).count("IDCarta"));
            ObjectValues ov = val.nextValues();
            int value = Integer.parseInt(String.valueOf(ov.getByAlias("IDCarta")));
            limpiarListas(pnItemsOrders);
            nodesCartas = new Node[value];
            Values valCarta = odb.getValues(new ValuesCriteriaQuery(Carta.class)
                    .field("NombreJuego")
                    .field("NombreCarta")
                    .field("Coleccion")
                    .field("Precio")
                    .field("Stock"));
            try {
                for (int i = 0; i < nodesCartas.length; i++) {
                    valCarta.next();
                    final int j = i;
                    nodesCartas[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                    //Establecimiento de labels
                    Label itemCartaJuego = (Label) nodesCartas[i].lookup("#itemCartaJuego");
                    itemCartaJuego.setText((String) ov.getByAlias("NombreJuego"));

                    Label itemCartaNombre = (Label) nodesCartas[i].lookup("#itemCartaNombre");
                    itemCartaNombre.setText((String) ov.getByAlias("NombreCarta"));

                    Label itemCartaColeccion = (Label) nodesCartas[i].lookup("#itemCartaColeccion");
                    itemCartaColeccion.setText((String) ov.getByAlias("Coleccion"));

                    Label itemCartaPrecio = (Label) nodesCartas[i].lookup("#itemCartaPrecio");
                    itemCartaPrecio.setText((String) ov.getByAlias("Precio"));

                    Button itemCartaStock = (Button) nodesCartas[i].lookup("#itemCartaStock");
                    itemCartaStock.setText((String) ov.getByAlias("Stock"));

                    nodesCartas[i].setOnMouseEntered(event -> {
                        nodesCartas[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });
                    nodesCartas[i].setOnMouseExited(event -> {
                        nodesCartas[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                    });

                    nodesCartas[i].setOnMouseClicked(event -> {
                        nodesCartas[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                        nodesCartas[j].setOnMouseExited(null);
                        nodesCartas[j].setOnMouseEntered(null);
                        for (int x = 0; x < nodesCartas.length; x++) {
                            if (x != j) {
                                nodesCartas[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                final int x2 = x;
                                nodesCartas[x].setOnMouseExited(event2 -> {
                                    nodesCartas[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                });
                                nodesCartas[x].setOnMouseEntered(event2 -> {
                                    nodesCartas[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                });
                            }
                        }
                    });

                    nodesCartas[i].setOnMousePressed(event -> {
                        //Bloqueamos el campo Nombre Carta para no poder editarlo, para poder volver a escribir pulsar Limpiar.
                        nameCard.setDisable(true);
                        btnGuardarCarta.setDisable(true);
                        btnModificarCarta.setDisable(false);
                        btnBorrarCarta.setDisable(false);
                        //Cargar informacion en los Edit Text
                        /* Session s;
                        s = NewHibernateUtil.getSession();
                        List<Object> CartaMAGIC = s.createCriteria(CartaMAGIC.class).list();
                        List<Object> CartaFOW = s.createCriteria(CartaFOW.class).list();
                        List<Object> CartaYUGI = s.createCriteria(CartaYUGI.class).list();
                        s.close();*/

                        Objects<CartaYUGI> valCartaYugi = odb.getObjects(new CriteriaQuery(CartaYUGI.class));
                        Objects<CartaMAGIC> valCartaMagic = odb.getObjects(new CriteriaQuery(CartaMAGIC.class));
                        Objects<CartaFOW> valCartaFow = odb.getObjects(new CriteriaQuery(CartaFOW.class));
                        nameCard.setText(itemCartaNombre.getText());
                        colecCard.setText(itemCartaColeccion.getText());
                        priceCard.setText(itemCartaPrecio.getText());
                        stockCard.setText(itemCartaStock.getText());

                        if (itemCartaJuego.getText().equals("Yu-Gi-Oh")) {
                            nameGame.getSelectionModel().select(0);
                            while (valCartaYugi.hasNext()) {
                                Object o = valCartaYugi.next();
                                if (itemCartaNombre.getText().equals(((CartaYUGI) o).getNombreCarta())) {

                                    if (((CartaYUGI) o).getIMG() == null) {
                                        btnSubirImagen.setText("Subir imagen");
                                    } else {
                                        btnSubirImagen.setText("Modificar imagen");
                                    }

                                    sumCard.setText(((CartaYUGI) o).getDescripcion());
                                    String[] parts = (((CartaYUGI) o).getAno()).split("-");
                                    String year = parts[0];
                                    yearCard.setText(year);
                                    yugiAtributo.setText(((CartaYUGI) o).getAtributo());
                                    yugiID.setText(((CartaYUGI) o).getIDCYugi());
                                    yugiNivel.setText(String.valueOf(((CartaYUGI) o).getNivel()));
                                    yugiSubTIpo.setText(((CartaYUGI) o).getSubTipo());

                                    //"Monstruo", "Mágica", "Trampa"
                                    if (((CartaYUGI) o).getTipoCarta().equals("Monstruo")) {
                                        yugiTipo.getSelectionModel().select(0);
                                    }
                                    if (((CartaYUGI) o).getTipoCarta().equals("Mágica")) {
                                        yugiTipo.getSelectionModel().select(1);
                                    }
                                    if (((CartaYUGI) o).getTipoCarta().equals("Trampa")) {
                                        yugiTipo.getSelectionModel().select(2);
                                    }
                                }
                            }
                        } else if (itemCartaJuego.getText().equals("Magic")) {
                            nameGame.getSelectionModel().select(1);
                            while (valCartaMagic.hasNext()) {
                                Object o = valCartaMagic.next();
                                if (itemCartaNombre.getText().equals(((CartaMAGIC) o).getNombreCarta())) {

                                    if (((CartaMAGIC) o).getIMG() == null) {
                                        btnSubirImagen.setText("Subir imagen");
                                    } else {
                                        btnSubirImagen.setText("Modificar imagen");
                                    }

                                    sumCard.setText(((CartaMAGIC) o).getDescripcion());
                                    String[] parts = (((CartaMAGIC) o).getAno()).split("-");
                                    String year = parts[0];
                                    yearCard.setText(year);
                                    magiCoste.setText(((CartaMAGIC) o).getCoste());
                                    magiID.setText(((CartaMAGIC) o).getIDCMagic());
                                    magiTipo.setText(((CartaMAGIC) o).getTipo());

                                    //"Blanco", "Azul", "Negro", "Rojo", "Verde", "Incoloro", "Multicolor"
                                    if (((CartaMAGIC) o).getColor().equals("Blanco")) {
                                        magiColor.getSelectionModel().select(0);
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Azul")) {
                                        magiColor.getSelectionModel().select(1);
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Negro")) {
                                        magiColor.getSelectionModel().select(2);
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Rojo")) {
                                        magiColor.getSelectionModel().select(3);
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Verde")) {
                                        magiColor.getSelectionModel().select(4);
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Incoloro")) {
                                        magiColor.getSelectionModel().select(5);
                                    }
                                    if (((CartaMAGIC) o).getColor().equals("Multicolor")) {
                                        magiColor.getSelectionModel().select(6);
                                    }

                                }
                            }
                        } else if (itemCartaJuego.getText().equals("Force of Will")) {
                            nameGame.getSelectionModel().select(2);
                            while (valCartaFow.hasNext()) {
                                Object o = valCartaFow.next();
                                if (itemCartaNombre.getText().equals(((CartaFOW) o).getNombreCarta())) {

                                    if (((CartaFOW) o).getIMG() == null) {
                                        btnSubirImagen.setText("Subir imagen");
                                    } else {
                                        btnSubirImagen.setText("Modificar imagen");
                                    }

                                    sumCard.setText(((CartaFOW) o).getDescripcion());
                                    String[] parts = (((CartaFOW) o).getAno()).split("-");
                                    String year = parts[0];
                                    yearCard.setText(year);
                                    fogCoste.setText(((CartaFOW) o).getCoste());
                                    fogID.setText(((CartaFOW) o).getIDCFoW());
                                    fogRaza.setText(((CartaFOW) o).getRaza());
                                    fogTipo.setText(((CartaFOW) o).getTipo());

                                    //"Luz", "Oscuridad", "Agua", "Viento", "Fuego", "Neutro", "Multicolor"
                                    if (((CartaFOW) o).getElemento().equals("Luz")) {
                                        fogColor.getSelectionModel().select(0);
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Oscuridad")) {
                                        fogColor.getSelectionModel().select(1);
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Agua")) {
                                        fogColor.getSelectionModel().select(2);
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Viento")) {
                                        fogColor.getSelectionModel().select(3);
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Fuego")) {
                                        fogColor.getSelectionModel().select(4);
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Neutro")) {
                                        fogColor.getSelectionModel().select(5);
                                    }
                                    if (((CartaFOW) o).getElemento().equals("Multicolor")) {
                                        fogColor.getSelectionModel().select(6);
                                    }

                                }
                            }
                        }
                    });

                    pnItemsOrders.getChildren().add(nodesCartas[i]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            odb.close();
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de carga de los nodos en la ventana de clientes">
    @FXML
    //Carga de la lista de clientes de la pantalla Clientes
    public void ListCardsClientes() throws SQLException {
        if (Wonka.basedatos == true) {
            try {
                Statement S = Wonka.conect.createStatement();
                ResultSet Res = S.executeQuery("SELECT COUNT(*) AS Cont FROM clientes");
                Res.next();
                limpiarListas(pnItemsClientes);
                nodesClientes = new Node[Res.getInt("Cont")];
                Res.close();
                Res = S.executeQuery("SELECT Nombre as N, Apellidos as A, Edad as E, Mail as M, Telefono as T FROM clientes");

                try {
                    for (int i = 0; i < nodesClientes.length; i++) {
                        Res.next();
                        final int j = i;
                        nodesClientes[i] = FXMLLoader.load(getClass().getResource("ItemCliente.fxml"));

                        //Establecimiento de labels
                        Label itemClienteNombre = (Label) nodesClientes[i].lookup("#itemClienteNombre");
                        itemClienteNombre.setText(Res.getString("N"));

                        Label itemClienteApellido = (Label) nodesClientes[i].lookup("#itemClienteApellido");
                        itemClienteApellido.setText(Res.getString("A"));

                        Label itemClienteEdad = (Label) nodesClientes[i].lookup("#itemClienteEdad");
                        itemClienteEdad.setText(Res.getString("E"));

                        Label itemClienteEmail = (Label) nodesClientes[i].lookup("#itemClienteEmail");
                        itemClienteEmail.setText(Res.getString("M"));

                        Label itemClienteTlf = (Label) nodesClientes[i].lookup("#itemClienteTlf");
                        itemClienteTlf.setText(Res.getString("T"));

                        nodesClientes[i].setOnMouseEntered(event -> {
                            nodesClientes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });

                        nodesClientes[i].setOnMouseExited(event -> {
                            nodesClientes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });

                        nodesClientes[i].setOnMouseClicked(event -> {
                            nodesClientes[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesClientes[j].setOnMouseExited(null);
                            nodesClientes[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesClientes.length; x++) {
                                if (x != j) {
                                    nodesClientes[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesClientes[x].setOnMouseExited(event2 -> {
                                        nodesClientes[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesClientes[x].setOnMouseEntered(event2 -> {
                                        nodesClientes[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });

                        nodesClientes[i].setOnMousePressed(event -> {
                            btnModificarCamposClientes.setDisable(false);
                            btnBorrarCamposClientes.setDisable(false);
                            btnGuardarCamposClientes.setDisable(true);
                            Session s;
                            s = NewHibernateUtil.getSession();
                            List<Object> Clientes = s.createCriteria(Cliente.class).list();
                            s.close();

                            nombreCliente.setText(itemClienteNombre.getText());
                            apellidosCliente.setText(itemClienteApellido.getText());
                            edadCliente.setText(itemClienteEdad.getText());
                            emailCliente.setText(itemClienteEmail.getText());
                            telefonoCliente.setText(itemClienteTlf.getText());
                            for (Object C : Clientes) {
                                if (itemClienteNombre.getText().equals(((Cliente) C).getNombre())) {
                                    if (((Cliente) C).isSexo() == false) {
                                        sexoCliente.getSelectionModel().select(0);
                                    } else {
                                        sexoCliente.getSelectionModel().select(1);
                                    }
                                    direccionCliente.setText(((Cliente) C).getDireccion());
                                }
                            }
                        });

                        pnItemsClientes.getChildren().add(nodesClientes[i]);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Res.close();
            } catch (SQLException x) {
                System.out.println(x);
            }
        } else {

            ODB odb = ODBFactory.openClient("localhost", 8000, "neoWonka");
            Values val = odb.getValues(new ValuesCriteriaQuery(Cliente.class).count("IDCliente"));
            ObjectValues ov = val.nextValues();
            int value = Integer.parseInt(String.valueOf(ov.getByAlias("IDCliente")));
            limpiarListas(pnItemsClientes);
            nodesClientes = new Node[value];
            Values valCliente = odb.getValues(new ValuesCriteriaQuery(Cliente.class)
                    .field("Nombre")
                    .field("Apellidos")
                    .field("Edad")
                    .field("Mail")
                    .field("Telefono"));
            try {
                for (int i = 0; i < nodesClientes.length; i++) {
                    valCliente.next();
                    final int j = i;
                    nodesClientes[i] = FXMLLoader.load(getClass().getResource("ItemCliente.fxml"));

                    //Establecimiento de labels
                    Label itemClienteNombre = (Label) nodesClientes[i].lookup("#itemClienteNombre");
                    itemClienteNombre.setText((String) ov.getByAlias("Nombre"));

                    Label itemClienteApellido = (Label) nodesClientes[i].lookup("#itemClienteApellido");
                    itemClienteApellido.setText((String) ov.getByAlias("Apellidos"));

                    Label itemClienteEdad = (Label) nodesClientes[i].lookup("#itemClienteEdad");
                    itemClienteEdad.setText((String) ov.getByAlias("Edad"));

                    Label itemClienteEmail = (Label) nodesClientes[i].lookup("#itemClienteEmail");
                    itemClienteEmail.setText((String) ov.getByAlias("Mail"));

                    Label itemClienteTlf = (Label) nodesClientes[i].lookup("#itemClienteTlf");
                    itemClienteTlf.setText((String) ov.getByAlias("Telefono"));

                    nodesClientes[i].setOnMouseEntered(event -> {
                        nodesClientes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });

                    nodesClientes[i].setOnMouseExited(event -> {
                        nodesClientes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                    });

                    nodesClientes[i].setOnMouseClicked(event -> {
                        nodesClientes[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                        nodesClientes[j].setOnMouseExited(null);
                        nodesClientes[j].setOnMouseEntered(null);
                        for (int x = 0; x < nodesClientes.length; x++) {
                            if (x != j) {
                                nodesClientes[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                final int x2 = x;
                                nodesClientes[x].setOnMouseExited(event2 -> {
                                    nodesClientes[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                });
                                nodesClientes[x].setOnMouseEntered(event2 -> {
                                    nodesClientes[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                });
                            }
                        }
                    });

                    nodesClientes[i].setOnMousePressed(event -> {
                        btnModificarCamposClientes.setDisable(false);
                        btnBorrarCamposClientes.setDisable(false);
                        btnGuardarCamposClientes.setDisable(true);
                        Objects<Cliente> valcliente = odb.getObjects(new CriteriaQuery(Cliente.class));

                        nombreCliente.setText(itemClienteNombre.getText());
                        apellidosCliente.setText(itemClienteApellido.getText());
                        edadCliente.setText(itemClienteEdad.getText());
                        emailCliente.setText(itemClienteEmail.getText());
                        telefonoCliente.setText(itemClienteTlf.getText());
                        while (valcliente.hasNext()) {
                            Object C = valcliente.next();
                            if (itemClienteNombre.getText().equals(((Cliente) C).getNombre())) {
                                if (((Cliente) C).isSexo() == false) {
                                    sexoCliente.getSelectionModel().select(0);
                                } else {
                                    sexoCliente.getSelectionModel().select(1);
                                }
                                direccionCliente.setText(((Cliente) C).getDireccion());
                            }
                        }
                    });

                    pnItemsClientes.getChildren().add(nodesClientes[i]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            odb.close();
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de carga de los nodos simplificados de cartas en la ventana de Compras">
    @FXML
    //Carga de la lista de cartas de la pantalla Compra
    public void ListCardsLess() {
        if (Wonka.basedatos == true) {
            try {
                Statement S = Wonka.conect.createStatement();
                ResultSet Res = S.executeQuery("SELECT COUNT(*) AS Cont FROM Cartas");
                Res.next();
                limpiarListas(pnItemsCartasLess);
                nodesCartasLess = new Node[Res.getInt("Cont")];
                Res.close();
                Res = S.executeQuery("SELECT IDCarta as ID, NombreJuego as NJ, NombreCarta as NC, Precio as P FROM CARTAS");
                try {
                    for (int i = 0; i < nodesCartasLess.length; i++) {
                        Res.next();
                        final int j = i;
                        nodesCartasLess[i] = FXMLLoader.load(getClass().getResource("ItemCartaLess.fxml"));

                        //Establecimiento de labels
                        Label itemNombreJuegoLess = (Label) nodesCartasLess[i].lookup("#itemCartaLessJuego");
                        itemNombreJuegoLess.setText(Res.getString("NJ"));

                        Label itemNombreCartaLess = (Label) nodesCartasLess[i].lookup("#itemCartaLessNombreCarta");
                        itemNombreCartaLess.setText(Res.getString("NC"));

                        Label itemPrecioCartaLess = (Label) nodesCartasLess[i].lookup("#itemCartaLessPrecio");
                        itemPrecioCartaLess.setText(Res.getString("P"));

                        nodesCartasLess[i].setOnMouseEntered(event -> {
                            nodesCartasLess[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });

                        nodesCartasLess[i].setOnMouseExited(event -> {
                            nodesCartasLess[j].setStyle("-fx-background-color : #02030A; -fx-background-radius:5");
                        });

                        nodesCartasLess[i].setOnMouseClicked(event -> {
                            nodesCartasLess[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesCartasLess[j].setOnMouseExited(null);
                            nodesCartasLess[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesCartasLess.length; x++) {
                                if (x != j) {
                                    nodesCartasLess[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesCartasLess[x].setOnMouseExited(event2 -> {
                                        nodesCartasLess[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesCartasLess[x].setOnMouseEntered(event2 -> {
                                        nodesCartasLess[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });

                        nodesCartasLess[i].setOnMousePressed(event -> {
                            Session s;
                            s = NewHibernateUtil.getSession();
                            List<Object> Carta = s.createCriteria(Carta.class).list();
                            s.close();

                            for (Object C : Carta) {
                                if (itemNombreCartaLess.getText().equals(((Carta) C).getNombreCarta())) {
                                    idCartaCompra = Integer.toString(((Carta) C).getIDCarta());
                                    busComCarta.setText(((Carta) C).getNombreCarta());
                                }
                            }
                        });

                        pnItemsCartasLess.getChildren().add(nodesCartasLess[i]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {

            ODB odb = ODBFactory.openClient("localhost", 8000, "neoWonka");
            Values val = odb.getValues(new ValuesCriteriaQuery(Carta.class).count("IDCarta"));
            ObjectValues ov = val.nextValues();
            int value = Integer.parseInt(String.valueOf(ov.getByAlias("IDCarta")));
            limpiarListas(pnItemsCartasLess);
            nodesCartasLess = new Node[value];
            Values valCartaless = odb.getValues(new ValuesCriteriaQuery(Carta.class)
                    .field("IDCarta")
                    .field("NombreJuego")
                    .field("NombreCarta")
                    .field("Precio"));
            try {
                for (int i = 0; i < nodesCartasLess.length; i++) {
                    valCartaless.next();
                    final int j = i;
                    nodesCartasLess[i] = FXMLLoader.load(getClass().getResource("ItemCartaLess.fxml"));

                    //Establecimiento de labels
                    Label itemNombreJuegoLess = (Label) nodesCartasLess[i].lookup("#itemCartaLessJuego");
                    itemNombreJuegoLess.setText((String) ov.getByAlias("NombreJuego"));

                    Label itemNombreCartaLess = (Label) nodesCartasLess[i].lookup("#itemCartaLessNombreCarta");
                    itemNombreCartaLess.setText((String) ov.getByAlias("NombreCarta"));

                    Label itemPrecioCartaLess = (Label) nodesCartasLess[i].lookup("#itemCartaLessPrecio");
                    itemPrecioCartaLess.setText((String) ov.getByAlias("Precio"));

                    nodesCartasLess[i].setOnMouseEntered(event -> {
                        nodesCartasLess[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });

                    nodesCartasLess[i].setOnMouseExited(event -> {
                        nodesCartasLess[j].setStyle("-fx-background-color : #02030A; -fx-background-radius:5");
                    });

                    nodesCartasLess[i].setOnMouseClicked(event -> {
                        nodesCartasLess[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                        nodesCartasLess[j].setOnMouseExited(null);
                        nodesCartasLess[j].setOnMouseEntered(null);
                        for (int x = 0; x < nodesCartasLess.length; x++) {
                            if (x != j) {
                                nodesCartasLess[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                final int x2 = x;
                                nodesCartasLess[x].setOnMouseExited(event2 -> {
                                    nodesCartasLess[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                });
                                nodesCartasLess[x].setOnMouseEntered(event2 -> {
                                    nodesCartasLess[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                });
                            }
                        }
                    });

                    nodesCartasLess[i].setOnMousePressed(event -> {

                        Objects<Carta> valcartaless = odb.getObjects(new CriteriaQuery(Carta.class));

                        while (valcartaless.hasNext()) {
                            Object C = valcartaless.next();
                            if (itemNombreCartaLess.getText().equals(((Carta) C).getNombreCarta())) {
                                idCartaCompra = Integer.toString(((Carta) C).getIDCarta());
                                busComCarta.setText(((Carta) C).getNombreCarta());
                            }
                        }
                    });

                    pnItemsCartasLess.getChildren().add(nodesCartasLess[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            odb.close();
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de carga de los nodos simplificados de clientes en la ventana de Compras">
    @FXML
    //Carga de la lista de clientes de la pantalla Compra
    public void ListClientesLess() {
        if (Wonka.basedatos == true) {
            try {
                Statement S = Wonka.conect.createStatement();
                ResultSet Res = S.executeQuery("SELECT COUNT(*) AS Cont FROM clientes");
                Res.next();
                limpiarListas(pnItemsClientesLess);
                nodesClientesLess = new Node[Res.getInt("Cont")];
                Res.close();
                Res = S.executeQuery("SELECT Nombre as N, Apellidos as A, Edad as E, Mail as M, Telefono as T FROM clientes");

                try {
                    for (int i = 0; i < nodesClientesLess.length; i++) {
                        Res.next();
                        final int j = i;
                        nodesClientesLess[i] = FXMLLoader.load(getClass().getResource("ItemClienteLess.fxml"));

                        //Establecimiento de labels
                        Label itemClienteNombre = (Label) nodesClientesLess[i].lookup("#itemClienteLessNombre");
                        itemClienteNombre.setText(Res.getString("N"));

                        Label itemClienteApellido = (Label) nodesClientesLess[i].lookup("#itemClienteLessApellidos");
                        itemClienteApellido.setText(Res.getString("A"));

                        nodesClientesLess[i].setOnMouseEntered(event -> {
                            nodesClientesLess[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });

                        nodesClientesLess[i].setOnMouseExited(event -> {
                            nodesClientesLess[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });

                        nodesClientesLess[i].setOnMouseClicked(event -> {
                            nodesClientesLess[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesClientesLess[j].setOnMouseExited(null);
                            nodesClientesLess[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesClientesLess.length; x++) {
                                if (x != j) {
                                    nodesClientesLess[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesClientesLess[x].setOnMouseExited(event2 -> {
                                        nodesClientesLess[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesClientesLess[x].setOnMouseEntered(event2 -> {
                                        nodesClientesLess[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });

                        nodesClientesLess[i].setOnMousePressed(event -> {
                            Session s;
                            s = NewHibernateUtil.getSession();
                            List<Object> Clientes = s.createCriteria(Cliente.class).list();
                            s.close();

                            for (Object C : Clientes) {
                                if ((itemClienteNombre.getText() + itemClienteApellido.getText()).equals((((Cliente) C).getNombre() + ((Cliente) C).getApellidos()))) {

                                    idClienteCompra = Integer.toString(((Cliente) C).getIDCliente());
                                    busComCliente.setText(((Cliente) C).getNombre() + " " + ((Cliente) C).getApellidos());
                                }
                            }
                        });
                        pnItemsClientesLess.getChildren().add(nodesClientesLess[i]);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Res.close();
            } catch (SQLException x) {
                System.out.println(x);
            }
        } else {

            ODB odb = ODBFactory.openClient("localhost", 8000, "neoWonka");
            Values val = odb.getValues(new ValuesCriteriaQuery(Cliente.class).count("IDCliente"));
            ObjectValues ov = val.nextValues();
            int value = Integer.parseInt(String.valueOf(ov.getByAlias("IDCliente")));
            limpiarListas(pnItemsClientesLess);
            nodesClientesLess = new Node[value];
            Values valclieteLess = odb.getValues(new ValuesCriteriaQuery(Cliente.class)
                    .field("Nombre")
                    .field("Apellidos")
                    .field("Edad")
                    .field("Mail")
                    .field("Telefono"));
            try {
                for (int i = 0; i < nodesClientesLess.length; i++) {
                    valclieteLess.hasNext();
                    final int j = i;
                    nodesClientesLess[i] = FXMLLoader.load(getClass().getResource("ItemClienteLess.fxml"));

                    //Establecimiento de labels
                    Label itemClienteNombre = (Label) nodesClientesLess[i].lookup("#itemClienteLessNombre");
                    itemClienteNombre.setText((String) ov.getByAlias("Nombre"));

                    Label itemClienteApellido = (Label) nodesClientesLess[i].lookup("#itemClienteLessApellidos");
                    itemClienteApellido.setText((String) ov.getByAlias("Apellidos"));

                    nodesClientesLess[i].setOnMouseEntered(event -> {
                        nodesClientesLess[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });

                    nodesClientesLess[i].setOnMouseExited(event -> {
                        nodesClientesLess[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                    });

                    nodesClientesLess[i].setOnMouseClicked(event -> {
                        nodesClientesLess[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                        nodesClientesLess[j].setOnMouseExited(null);
                        nodesClientesLess[j].setOnMouseEntered(null);
                        for (int x = 0; x < nodesClientesLess.length; x++) {
                            if (x != j) {
                                nodesClientesLess[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                final int x2 = x;
                                nodesClientesLess[x].setOnMouseExited(event2 -> {
                                    nodesClientesLess[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                });
                                nodesClientesLess[x].setOnMouseEntered(event2 -> {
                                    nodesClientesLess[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                });
                            }
                        }
                    });

                    nodesClientesLess[i].setOnMousePressed(event -> {
                        Objects<Cliente> valClienteLess = odb.getObjects(new CriteriaQuery(Cliente.class));

                        while (valClienteLess.hasNext()) {
                            Object C = valClienteLess.next();
                            if ((itemClienteNombre.getText() + itemClienteApellido.getText()).equals((((Cliente) C).getNombre() + ((Cliente) C).getApellidos()))) {

                                idClienteCompra = Integer.toString(((Cliente) C).getIDCliente());
                                busComCliente.setText(((Cliente) C).getNombre() + " " + ((Cliente) C).getApellidos());
                            }
                        }
                    });
                    pnItemsClientesLess.getChildren().add(nodesClientesLess[i]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            odb.close();

        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de carga de los nodos de reservas y ventas en la ventana de Historial">
    @FXML
    //Carga de la lista de clientes con pedidos de la pantalla Historial
    public void ListHistorial() throws SQLException, IOException {

        if (Wonka.basedatos == true) {
            Statement S = Wonka.conect.createStatement();
            ResultSet ResVentas = S.executeQuery("SELECT COUNT(*) AS ContV FROM Ventas;");
            ResVentas.next();
            int VCont = ResVentas.getInt("ContV");
            ResVentas.close();
            ResultSet ResReservas = S.executeQuery("SELECT COUNT(*) AS ContR FROM Reservas;");
            ResReservas.next();
            int RCont = ResReservas.getInt("ContR");
            ResReservas.close();
            limpiarListas(pnItemsHistorial);
            ResVentas = S.executeQuery("SELECT"
                    + " C.Nombre as N, C.Apellidos as A, C.Telefono as T, CAR.NombreCarta as NC, CAR.Precio as P, V.Cantidad AS Cant FROM Ventas as V"
                    + " LEFT JOIN CLIENTES as C ON C.IDCliente = V.IDCliente"
                    + " 	INNER JOIN cartas as CAR on CAR.IDCarta = V.IDCarta ORDER BY N ASC;");
            nodesHistorial = new Node[VCont + RCont];
            int i = 0;
            for (i = 0; i < VCont; i++) {
                System.out.println("Venta " + i);
                try {
                    ResVentas.next();
                    nodesHistorial[i] = FXMLLoader.load(getClass().getResource("ItemHistorial.fxml"));

                    //Establecimiento de labels
                    Label itemHistoriaNomCliente = (Label) nodesHistorial[i].lookup("#itemHistorialNombre");
                    itemHistoriaNomCliente.setText(ResVentas.getString("N") + " " + ResVentas.getString("A"));

                    Label itemHistoriaNomCarta = (Label) nodesHistorial[i].lookup("#itemHistorialNombreCarta");
                    itemHistoriaNomCarta.setText(ResVentas.getString("NC"));

                    Label itemHistoriaCantidad = (Label) nodesHistorial[i].lookup("#itemHistoriaCantidad");
                    itemHistoriaCantidad.setText(ResVentas.getString("Cant"));

                    Label itemHistoriaTlf = (Label) nodesHistorial[i].lookup("#itemHistorialTlf");
                    itemHistoriaTlf.setText(ResVentas.getString("T"));

                    Label itemHistoriaPrecio = (Label) nodesHistorial[i].lookup("#itemHistorialPrecio");
                    itemHistoriaPrecio.setText(ResVentas.getString("P"));

                    Button itemHistoriaEstado = (Button) nodesHistorial[i].lookup("#itemHistorialEstado");
                    itemHistoriaEstado.setText("Vendida");
                    pnItemsHistorial.getChildren().add(nodesHistorial[i]);

                    final int j = i;
                    nodesHistorial[i].setOnMouseEntered(event -> {
                        nodesHistorial[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });
                    nodesHistorial[i].setOnMouseExited(event -> {
                        nodesHistorial[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ResVentas.close();
            ResReservas = S.executeQuery("SELECT"
                    + " C.Nombre as N, C.Apellidos as A, C.Telefono as T, CAR.NombreCarta as NC, CAR.Precio as P ,R.Cantidad AS Cant FROM Reservas as R"
                    + " LEFT JOIN CLIENTES as C ON C.IDCliente = R.IDCliente"
                    + " 	INNER JOIN cartas as CAR on CAR.IDCarta = R.IDCarta ORDER BY N ASC;");
            for (i = i; i < nodesHistorial.length; i++) {
                try {
                    ResReservas.next();

                    nodesHistorial[i] = FXMLLoader.load(getClass().getResource("ItemHistorial.fxml"));

                    //Establecimiento de labels
                    Label itemHistoriaNomCliente = (Label) nodesHistorial[i].lookup("#itemHistorialNombre");
                    itemHistoriaNomCliente.setText(ResReservas.getString("N") + " " + ResReservas.getString("A"));

                    Label itemHistoriaNomCarta = (Label) nodesHistorial[i].lookup("#itemHistorialNombreCarta");
                    itemHistoriaNomCarta.setText(ResReservas.getString("NC"));

                    Label itemHistoriaCantidad = (Label) nodesHistorial[i].lookup("#itemHistoriaCantidad");
                    itemHistoriaCantidad.setText(ResReservas.getString("Cant"));

                    Label itemHistoriaTlf = (Label) nodesHistorial[i].lookup("#itemHistorialTlf");
                    itemHistoriaTlf.setText(ResReservas.getString("T"));

                    Label itemHistoriaPrecio = (Label) nodesHistorial[i].lookup("#itemHistorialPrecio");
                    itemHistoriaPrecio.setText(ResReservas.getString("P"));

                    Button itemHistoriaEstado = (Button) nodesHistorial[i].lookup("#itemHistorialEstado");
                    itemHistoriaEstado.setText("Reservada");

                    pnItemsHistorial.getChildren().add(nodesHistorial[i]);

                    final int j = i;
                    nodesHistorial[i].setOnMouseEntered(event -> {
                        nodesHistorial[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });
                    nodesHistorial[i].setOnMouseExited(event -> {
                        nodesHistorial[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                    });
                    nodesHistorial[i].setOnMouseClicked(event -> {
                        nodesHistorial[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                        nodesHistorial[j].setOnMouseExited(null);
                        nodesHistorial[j].setOnMouseEntered(null);
                        for (int x = 0; x < nodesHistorial.length; x++) {
                            if (x != j) {
                                nodesHistorial[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                final int x2 = x;
                                nodesHistorial[x].setOnMouseExited(event2 -> {
                                    nodesHistorial[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                });
                                nodesHistorial[x].setOnMouseEntered(event2 -> {
                                    nodesHistorial[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                });
                            }
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            ResReservas.close();
        } else {
            int cont = 0;
            ODB odb = ODBFactory.openClient("localhost", 8000, "neoWonka");
            Values val = odb.getValues(new ValuesCriteriaQuery(Venta.class).count("IDVenta"));
            ObjectValues ov = val.nextValues();
            int valueV = Integer.parseInt(String.valueOf(ov.getByAlias("IDVenta")));
            Values valr = odb.getValues(new ValuesCriteriaQuery(Reserva.class).count("IDCarta"));
            ObjectValues ovr = valr.nextValues();
            int valueR = Integer.parseInt(String.valueOf(ov.getByAlias("IDVenta")));

            limpiarListas(pnItemsHistorial);
            nodesHistorial = new Node[valueV + valueR];

            Objects<Venta> idVenta = odb.getObjects(new CriteriaQuery(Venta.class));
            while (idVenta.hasNext()) {

                Venta venta = (Venta) idVenta.next();
                nodesHistorial[cont] = FXMLLoader.load(getClass().getResource("ItemHistorial.fxml"));

                //Establecimiento de labels
                Label itemHistoriaNomCliente = (Label) nodesHistorial[cont].lookup("#itemHistorialNombre");
                itemHistoriaNomCliente.setText(venta.getCliente().getNombre() + " " + venta.getCliente().getApellidos());

                Label itemHistoriaNomCarta = (Label) nodesHistorial[cont].lookup("#itemHistorialNombreCarta");
                itemHistoriaNomCarta.setText(venta.getCarta().getNombreCarta());

                Label itemHistoriaCantidad = (Label) nodesHistorial[cont].lookup("#itemHistoriaCantidad");
                itemHistoriaCantidad.setText(String.valueOf(venta.getCantidad()));

                Label itemHistoriaTlf = (Label) nodesHistorial[cont].lookup("#itemHistorialTlf");
                itemHistoriaTlf.setText(venta.getCliente().getTelefono());

                Label itemHistoriaPrecio = (Label) nodesHistorial[cont].lookup("#itemHistorialPrecio");
                itemHistoriaPrecio.setText(String.valueOf(venta.getCarta().getPrecio()));

                Button itemHistoriaEstado = (Button) nodesHistorial[cont].lookup("#itemHistorialEstado");
                itemHistoriaEstado.setText("Vendida");
                pnItemsHistorial.getChildren().add(nodesHistorial[cont]);

                final int j = cont;
                nodesHistorial[cont].setOnMouseEntered(event -> {
                    nodesHistorial[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                });
                nodesHistorial[cont].setOnMouseExited(event -> {
                    nodesHistorial[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                });

                cont++;

            }

            /**
             * ResReservas = S.executeQuery("SELECT" + " C.Nombre as N,
             * C.Apellidos as A, C.Telefono as T, CAR.NombreCarta as NC,
             * CAR.Precio as P ,R.Cantidad AS Cant FROM Reservas as R" + " LEFT
             * JOIN CLIENTES as C ON C.IDCliente = R.IDCliente" + " INNER JOIN
             * cartas as CAR on CAR.IDCarta = R.IDCarta ORDER BY N ASC;");*
             */
            Objects<Reserva> idReserva = odb.getObjects(new CriteriaQuery(Reserva.class));
            while (idReserva.hasNext()) {

                Reserva reserva = (Reserva) idReserva.next();
                nodesHistorial[cont] = FXMLLoader.load(getClass().getResource("ItemHistorial.fxml"));

                //Establecimiento de labels
                Label itemHistoriaNomCliente = (Label) nodesHistorial[cont].lookup("#itemHistorialNombre");
                itemHistoriaNomCliente.setText(reserva.getIDCliente().getNombre() + " " + reserva.getIDCliente().getApellidos());

                Label itemHistoriaNomCarta = (Label) nodesHistorial[cont].lookup("#itemHistorialNombreCarta");
                itemHistoriaNomCarta.setText(reserva.getIDCarta().getNombreCarta());

                Label itemHistoriaCantidad = (Label) nodesHistorial[cont].lookup("#itemHistoriaCantidad");
                itemHistoriaCantidad.setText(String.valueOf(reserva.getCantidad()));

                Label itemHistoriaTlf = (Label) nodesHistorial[cont].lookup("#itemHistorialTlf");
                itemHistoriaTlf.setText(reserva.getIDCliente().getTelefono());

                Label itemHistoriaPrecio = (Label) nodesHistorial[cont].lookup("#itemHistorialPrecio");
                itemHistoriaPrecio.setText(String.valueOf(reserva.getIDCarta().getPrecio()));

                Button itemHistoriaEstado = (Button) nodesHistorial[cont].lookup("#itemHistorialEstado");
                itemHistoriaEstado.setText("Reservada");

                pnItemsHistorial.getChildren().add(nodesHistorial[cont]);

                final int j = cont;
                nodesHistorial[cont].setOnMouseEntered(event -> {
                    nodesHistorial[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                });
                nodesHistorial[cont].setOnMouseExited(event -> {
                    nodesHistorial[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                });
                nodesHistorial[cont].setOnMouseClicked(event -> {
                    nodesHistorial[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                    nodesHistorial[j].setOnMouseExited(null);
                    nodesHistorial[j].setOnMouseEntered(null);
                    for (int x = 0; x < nodesHistorial.length; x++) {
                        if (x != j) {
                            nodesHistorial[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                            final int x2 = x;
                            nodesHistorial[x].setOnMouseExited(event2 -> {
                                nodesHistorial[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                            });
                            nodesHistorial[x].setOnMouseEntered(event2 -> {
                                nodesHistorial[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                            });
                        }
                    }
                });

            }
            odb.close();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de carga de los contadores de ventas,cartas,clientes,etc">
    private void CargarDatosDashboard() {

        if (Wonka.basedatos == true) {
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> Carta = s.createCriteria(Carta.class).list();
            List<Object> Cliente = s.createCriteria(Cliente.class).list();
            List<Object> Reservas = s.createCriteria(Reserva.class).list();
            List<Object> Ventas = s.createCriteria(Venta.class).list();

            lblTotalCartas.setText(Integer.toString(Carta.size()));
            lblTotalClientes.setText(Integer.toString(Cliente.size()));
            lblCartasVendidas.setText(Integer.toString(Reservas.size()));
            lblPedidosPendientes.setText(Integer.toString(Ventas.size()));
            s.close();
        } else {
            ODB odb = ODBFactory.openClient("localhost", 8000, "neoWonka");

            Objects<Carta> Carta = odb.getObjects(new CriteriaQuery(Carta.class));
            Objects<Cliente> Cliente = odb.getObjects(new CriteriaQuery(Cliente.class));
            Objects<Reserva> Reservas = odb.getObjects(new CriteriaQuery(Reserva.class));
            Objects<Venta> Ventas = odb.getObjects(new CriteriaQuery(Venta.class));

            lblTotalCartas.setText(Integer.toString(Carta.size()));
            lblTotalClientes.setText(Integer.toString(Cliente.size()));
            lblCartasVendidas.setText(Integer.toString(Reservas.size()));
            lblPedidosPendientes.setText(Integer.toString(Ventas.size()));
        }

    }
    // </editor-fold>

    // ---------------------------------------- Inserciones ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Método de inserción de un cliente">
    @FXML
    //Guardamos al cliente introducido en la BBDD
    void accionGuardarCamposClientes(ActionEvent event) throws SQLException {

        edadCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        telefonoCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        nombreCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        apellidosCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        emailCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        direccionCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        sexoCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        int correcto = 0;
        ArrayList<String> Cliente = new ArrayList<String>();
        Cliente.add(nombreCliente.getText());
        Cliente.add(apellidosCliente.getText());
        Cliente.add(edadCliente.getText());
        Cliente.add("" + sexoCliente.getSelectionModel().getSelectedIndex());
        Cliente.add(direccionCliente.getText());
        Cliente.add(telefonoCliente.getText());
        Cliente.add(emailCliente.getText());

        correcto = comprobacionesDatos.comprobarCliente(Cliente);

        if (correcto == 0) {
            Inserciones.insertarCliente(Cliente);
        }
        if (correcto == 1) {
            edadCliente.setText("");
            edadCliente.setPromptText("Introduce un número");
            edadCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        if (correcto == 2) {
            telefonoCliente.setText("");
            telefonoCliente.setPromptText("Introduce un número de 9 digitos");
            telefonoCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        if (correcto == 3) {
            nombreCliente.setText("");
            nombreCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");

            apellidosCliente.setText("");
            apellidosCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");

            emailCliente.setText("");
            emailCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");

            direccionCliente.setText("");
            direccionCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        if (correcto == 4) {
            sexoCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        //accionLimpiarCamposClientes(event);
        ListCardsClientes();
        ListClientesLess();
        ListCardsOrders();
        CargarDatosDashboard();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de inserción de cartas">
    @FXML
    //Guardamos la carta introducida en la BBDD
    void accionGuardarCarta(ActionEvent event) throws SQLException, IOException {

        //Genericas
        stockCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        sumCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        nameCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        colecCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        yearCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        priceCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //Magic
        magiCoste.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        magiID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        magiTipo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //FOW
        fogCoste.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogRaza.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogTipo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //Yu gi oh
        yugiAtributo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiNivel.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiSubTIpo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        ArrayList<String> Carta = new ArrayList<String>();

        int correcto = 0;
        Carta.add(stockCard.getText());
        Carta.add((String) nameGame.getSelectionModel().getSelectedItem());
        Carta.add(nameCard.getText());
        Carta.add(sumCard.getText());
        Carta.add(colecCard.getText());
        Carta.add(yearCard.getText());
        Carta.add(priceCard.getText());
        System.out.println(selectedFile.getAbsolutePath());
        byte[] IMG = Files.readAllBytes(selectedFile.toPath());

        if (((String) nameGame.getSelectionModel().getSelectedItem()) == null) {
            nameGame.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        } else {
            switch ((String) nameGame.getSelectionModel().getSelectedItem()) {

                case "Magic":

                    Carta.add((String) magiColor.getSelectionModel().getSelectedItem());
                    Carta.add(magiCoste.getText());
                    Carta.add(magiID.getText());
                    Carta.add(magiTipo.getText());
                    break;
                case "Yu-Gi-Oh":
                    Carta.add(yugiID.getText());
                    Carta.add(yugiAtributo.getText());
                    Carta.add(yugiNivel.getText());
                    Carta.add(yugiSubTIpo.getText());
                    Carta.add((String) yugiTipo.getSelectionModel().getSelectedItem());
                    break;
                case "Force of Will":
                    Carta.add((String) fogColor.getSelectionModel().getSelectedItem());
                    Carta.add(fogCoste.getText());
                    Carta.add(fogID.getText());
                    Carta.add(fogRaza.getText());
                    Carta.add(fogTipo.getText());
                    break;
            }

            correcto = comprobacionesDatos.comprobarCarta(Carta);

            if (correcto == 1) {
                stockCard.setText("");
                stockCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");
            }

            if (correcto == 3) {
                sumCard.setText("");
                sumCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");

                nameCard.setText("");
                nameCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");

                colecCard.setText("");
                colecCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");

            }

            if (correcto == 2) {
                yearCard.setText("");
                yearCard.setPromptText("Introduce un número de 4 digitos");
                yearCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");
            }

            if (correcto == 4) {
                priceCard.setText("");
                priceCard.setPromptText("Introduce un número");
                priceCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");
            }

            switch ((String) nameGame.getSelectionModel().getSelectedItem()) {
                case "Magic":
                    if (correcto == 5) {
                        magiCoste.setText("");
                        magiCoste.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        magiID.setText("");
                        magiID.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        magiTipo.setText("");
                        magiTipo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 9) {
                        magiColor.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 0) {
                        Inserciones.insertarCartasMagic(Carta, IMG);
                        accionLimpiarCarta(event);
                        break;
                    } else {
                        break;
                    }

                case "Yu-Gi-Oh":
                    if (correcto == 6) {
                        yugiAtributo.setText("");
                        yugiAtributo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        yugiID.setText("");
                        yugiID.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        yugiSubTIpo.setText("");
                        yugiSubTIpo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 8) {
                        yugiNivel.setText("");
                        yugiNivel.setPromptText("Un Número");
                        yugiNivel.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 10) {
                        yugiTipo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 0) {
                        Inserciones.insertarCartasYuGi(Carta, IMG);
                        accionLimpiarCarta(event);
                        break;
                    } else {
                        break;
                    }

                case "Force of Will":
                    if (correcto == 7) {
                        fogCoste.setText("");
                        fogCoste.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        fogID.setText("");
                        fogID.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        fogRaza.setText("");
                        fogRaza.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        fogTipo.setText("");
                        fogTipo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 11) {
                        fogColor.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 0) {
                        Inserciones.insertarCartasFOW(Carta, IMG);
                        accionLimpiarCarta(event);
                        break;
                    } else {
                        break;
                    }
            }
            ListCards();
            ListCardsOrders();
            ListCardsLess();
            CargarDatosDashboard();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de inserción de una reserva o venta">
    @FXML
    void accionComprarCarta(ActionEvent event) throws SQLException, IOException {

        int cantidadV = 0, cantidadR = 0, cantidadStock = 0;
        textAreaCantidadCompra.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        Session s;
        s = NewHibernateUtil.getSession();
        List<Object> Carta = s.createCriteria(Carta.class).list();
        List<Object> Cliente = s.createCriteria(Cliente.class).list();
        s.close();
        Carta CartaCompra = null;
        Cliente ClienteCompra = null;
        try {
            Integer.parseInt(textAreaCantidadCompra.getText());
            int cantidad = Integer.parseInt(textAreaCantidadCompra.getText());
            for (Object c : Cliente) {
                if (Integer.parseInt(idClienteCompra) == ((Cliente) c).getIDCliente()) {
                    ClienteCompra = (Cliente) c;
                }
            }
            for (Object o : Carta) {
                if (Integer.parseInt(idCartaCompra) == ((Carta) o).getIDCarta()) {
                    cantidadStock = ((Carta) o).getStock();

                    if (cantidad <= cantidadStock) {
                        ((Carta) o).setStock(((Carta) o).getStock() - cantidad);
                        String[] parts = (((Carta) o).getAno()).split("-");
                        String year = parts[0];
                        ((Carta) o).setAno(year);
                        CartaCompra = (Carta) o;
                        Inserciones.InsertarCompra(CartaCompra, ClienteCompra, cantidad);
                        Inserciones.guardarModificar(CartaCompra);
                    } else {
                        cantidadR = cantidad - cantidadStock;
                        cantidadV = cantidad - cantidadR;
                        System.out.println(cantidadR + " : " + cantidadV + " : " + cantidadStock + " : " + cantidad);
                        if (cantidadV > 0) {
                            ((Carta) o).setStock(((Carta) o).getStock() - cantidadV);
                            String[] parts = (((Carta) o).getAno()).split("-");
                            String year = parts[0];
                            ((Carta) o).setAno(year);
                            CartaCompra = (Carta) o;
                            Inserciones.InsertarCompra(CartaCompra, ClienteCompra, cantidadV);
                            Inserciones.guardarModificar(CartaCompra);
                        }
                        if (cantidadR > 0) {
                            CartaCompra = (Carta) o;
                            Inserciones.InsertarReserva(CartaCompra, ClienteCompra, cantidadR);
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            textAreaCantidadCompra.setStyle("-fx - border - color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");

        }
        Inserciones.automatizacionStock();
        try {
            ListHistorial();
        } catch (IOException e) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, e);
        }
        ListCards();
        ListCardsOrders();
        ListCardsLess();
        CargarDatosDashboard();
    }
    // </editor-fold>

    // ---------------------------------------- Modificaciones ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Método de modificación de un cliente">
    @FXML
    //Modificamos los campos de un cliente seleccionado en la lista y lo subimos de nuevo a la BBDD
    void accionModificarCamposClientes(ActionEvent event) throws SQLException {

        edadCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        telefonoCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        nombreCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        apellidosCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        emailCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        direccionCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        sexoCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        ArrayList<String> Cliente = new ArrayList<String>();
        int correcto = 0;
        Cliente.add(nombreCliente.getText());
        Cliente.add(apellidosCliente.getText());
        Cliente.add(edadCliente.getText());
        Cliente.add("" + sexoCliente.getSelectionModel().getSelectedIndex());
        Cliente.add(direccionCliente.getText());
        Cliente.add(telefonoCliente.getText());
        Cliente.add(emailCliente.getText());

        correcto = comprobacionesDatos.comprobarCliente(Cliente);

        if (correcto == 0) {
            Inserciones.actualizarCliente(Cliente);
        }
        if (correcto == 1) {
            edadCliente.setText("");
            edadCliente.setPromptText("Introduce un número");
            edadCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        if (correcto == 2) {
            telefonoCliente.setText("");
            telefonoCliente.setPromptText("Introduce un número de 9 digitos");
            telefonoCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        if (correcto == 3) {
            nombreCliente.setText("");
            nombreCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");

            apellidosCliente.setText("");
            apellidosCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");

            emailCliente.setText("");
            emailCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");

            direccionCliente.setText("");
            direccionCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        if (correcto == 4) {
            sexoCliente.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        }

        //accionLimpiarCamposClientes(event);
        ListCardsClientes();
        ListClientesLess();
        ListCardsOrders();
        CargarDatosDashboard();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de modificación de una carta">
    @FXML
    //Modificamos los campos de una carta seleccionada en la lista y la subimos de nuevo a la BBDD
    void accionModificarCarta(ActionEvent event) throws SQLException, IOException {

        //Genericas
        stockCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        sumCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        nameCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        colecCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        yearCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        priceCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //Magic
        magiCoste.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        magiID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        magiTipo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //FOW
        fogCoste.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogRaza.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogTipo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //Yu gi oh
        yugiAtributo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiNivel.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiSubTIpo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        ArrayList<String> Carta = new ArrayList<String>();
        int correcto = 0;
        Carta.add(stockCard.getText());
        Carta.add((String) nameGame.getSelectionModel().getSelectedItem());
        Carta.add(nameCard.getText());
        Carta.add(sumCard.getText());
        Carta.add(colecCard.getText());
        Carta.add(yearCard.getText());
        Carta.add(priceCard.getText());
        System.out.println(selectedFile.getAbsolutePath());
        byte[] IMG = Files.readAllBytes(selectedFile.toPath());

        if (((String) nameGame.getSelectionModel().getSelectedItem()) == null) {
            nameGame.setStyle("  -fx-border-color:#f45454;"
                    + "    -fx-border-radius:0.15em;"
                    + "    -fx-background-color:#00000b;"
                    + "    -fx-border-size:0.15em;"
                    + "    -fx-prompt-text-fill:#f45454;"
                    + "    -fx-text-fill:#fff;");
        } else {
            switch ((String) nameGame.getSelectionModel().getSelectedItem()) {

                case "Magic":

                    Carta.add((String) magiColor.getSelectionModel().getSelectedItem());
                    Carta.add(magiCoste.getText());
                    Carta.add(magiID.getText());
                    Carta.add(magiTipo.getText());
                    break;
                case "Yu-Gi-Oh":
                    Carta.add(yugiID.getText());
                    Carta.add(yugiAtributo.getText());
                    Carta.add(yugiNivel.getText());
                    Carta.add(yugiSubTIpo.getText());
                    Carta.add((String) yugiTipo.getSelectionModel().getSelectedItem());
                    break;
                case "Force of Will":
                    Carta.add((String) fogColor.getSelectionModel().getSelectedItem());
                    Carta.add(fogCoste.getText());
                    Carta.add(fogID.getText());
                    Carta.add(fogRaza.getText());
                    Carta.add(fogTipo.getText());
                    break;
            }

            correcto = comprobacionesDatos.comprobarCarta(Carta);

            if (correcto == 1) {
                stockCard.setText("");
                stockCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");
            }

            if (correcto == 3) {
                sumCard.setText("");
                sumCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");

                nameCard.setText("");
                nameCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");

                colecCard.setText("");
                colecCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");

            }

            if (correcto == 2) {
                yearCard.setText("");
                yearCard.setPromptText("Introduce un número de 4 digitos");
                yearCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");
            }

            if (correcto == 4) {
                priceCard.setText("");
                priceCard.setPromptText("Introduce un número");
                priceCard.setStyle("  -fx-border-color:#f45454;"
                        + "    -fx-border-radius:0.15em;"
                        + "    -fx-background-color:#00000b;"
                        + "    -fx-border-size:0.15em;"
                        + "    -fx-prompt-text-fill:#f45454;"
                        + "    -fx-text-fill:#fff;");
            }

            switch ((String) nameGame.getSelectionModel().getSelectedItem()) {
                case "Magic":
                    if (correcto == 5) {
                        magiCoste.setText("");
                        magiCoste.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        magiID.setText("");
                        magiID.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        magiTipo.setText("");
                        magiTipo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 9) {
                        magiColor.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 0) {
                        Inserciones.actualizarCartaMagic(Carta, IMG);
                        accionLimpiarCarta(event);
                        break;
                    } else {
                        break;
                    }

                case "Yu-Gi-Oh":
                    if (correcto == 6) {
                        yugiAtributo.setText("");
                        yugiAtributo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        yugiID.setText("");
                        yugiID.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        yugiSubTIpo.setText("");
                        yugiSubTIpo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 8) {
                        yugiNivel.setText("");
                        yugiNivel.setPromptText("Un Número");
                        yugiNivel.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 10) {
                        yugiTipo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 0) {
                        Inserciones.actualizarCartaYuGi(Carta, IMG);
                        accionLimpiarCarta(event);
                        break;
                    } else {
                        break;
                    }

                case "Force of Will":
                    if (correcto == 7) {
                        fogCoste.setText("");
                        fogCoste.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        fogID.setText("");
                        fogID.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        fogRaza.setText("");
                        fogRaza.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");

                        fogTipo.setText("");
                        fogTipo.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 11) {
                        fogColor.setStyle("  -fx-border-color:#f45454;"
                                + "    -fx-border-radius:0.15em;"
                                + "    -fx-background-color:#00000b;"
                                + "    -fx-border-size:0.15em;"
                                + "    -fx-prompt-text-fill:#f45454;"
                                + "    -fx-text-fill:#fff;");
                    }

                    if (correcto == 0) {
                        Inserciones.actualizarCartaFOW(Carta, IMG);
                        accionLimpiarCarta(event);
                        break;
                    } else {
                        break;
                    }
            }

            ListCards();
            ListCardsOrders();
            ListCardsLess();
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de modificación de una carta que se ha buscado">
    @FXML
    void accionBuscarAñadirCarta(KeyEvent evento) throws SQLException, IOException {
        if (evento.getCode().equals(KeyCode.ENTER)) {
            String nombrecarta, nombreClienteTrasTamaño;
            int contador = 0, i = 0;
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> Carta = s.createCriteria(Carta.class).list();

            int longitudNombre = 0;
            longitudNombre = entradaBusquedaCartas.getText().length();

            for (Object o : Carta) {
                nombrecarta = ((Carta) o).getNombreCarta();
                if (longitudNombre < nombrecarta.length()) {
                    nombreClienteTrasTamaño = nombrecarta.substring(0, longitudNombre);
                } else {
                    nombreClienteTrasTamaño = nombrecarta;
                }
                if (nombreClienteTrasTamaño.toLowerCase().equals(entradaBusquedaCartas.getText().toLowerCase())) {
                    contador++;
                }
            }
            if ("".equals(entradaBusquedaCartas.getText()) || contador == 0) {
                System.out.println("NINGUNO");
                ListCardsOrders();
            } else {
                limpiarListas(pnItemsOrders);
                nodesCartas = new Node[contador];
                for (Object o : Carta) {
                    nombrecarta = ((Carta) o).getNombreCarta();
                    if (longitudNombre < nombrecarta.length()) {
                        nombreClienteTrasTamaño = nombrecarta.substring(0, longitudNombre);
                    } else {
                        nombreClienteTrasTamaño = nombrecarta;
                    }
                    if (nombreClienteTrasTamaño.toLowerCase().equals(entradaBusquedaCartas.getText().toLowerCase())) {

                        final int j = i;
                        nodesCartas[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                        //Establecimiento de labels
                        Label itemCartaJuego = (Label) nodesCartas[i].lookup("#itemCartaJuego");
                        itemCartaJuego.setText(((Carta) o).getNombreJuego());

                        Label itemCartaNombre = (Label) nodesCartas[i].lookup("#itemCartaNombre");
                        itemCartaNombre.setText(((Carta) o).getNombreCarta());

                        Label itemCartaColeccion = (Label) nodesCartas[i].lookup("#itemCartaColeccion");
                        itemCartaColeccion.setText(((Carta) o).getColeccion());

                        Label itemCartaPrecio = (Label) nodesCartas[i].lookup("#itemCartaPrecio");
                        itemCartaPrecio.setText(Float.toString(((Carta) o).getPrecio()));

                        Button itemCartaStock = (Button) nodesCartas[i].lookup("#itemCartaStock");
                        itemCartaStock.setText(Integer.toString(((Carta) o).getStock()));

                        nodesCartas[i].setOnMouseEntered(event -> {
                            nodesCartas[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });
                        nodesCartas[i].setOnMouseExited(event -> {
                            nodesCartas[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });

                        nodesCartas[i].setOnMouseClicked(event -> {
                            nodesCartas[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesCartas[j].setOnMouseExited(null);
                            nodesCartas[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesCartas.length; x++) {
                                if (x != j) {
                                    nodesCartas[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesCartas[x].setOnMouseExited(event2 -> {
                                        nodesCartas[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesCartas[x].setOnMouseEntered(event2 -> {
                                        nodesCartas[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });

                        nodesCartas[i].setOnMousePressed(event -> {
                            //Bloqueamos el campo Nombre Carta para no poder editarlo, para poder volver a escribir pulsar Limpiar.
                            nameCard.setDisable(true);
                            btnGuardarCarta.setDisable(true);
                            //Cargar informacion en los Edit Text
                            Session a;
                            a = NewHibernateUtil.getSession();
                            List<Object> CartaMAGIC = a.createCriteria(CartaMAGIC.class).list();
                            List<Object> CartaFOW = a.createCriteria(CartaFOW.class).list();
                            List<Object> CartaYUGI = a.createCriteria(CartaYUGI.class).list();

                            nameCard.setText(itemCartaNombre.getText());
                            colecCard.setText(itemCartaColeccion.getText());
                            priceCard.setText(itemCartaPrecio.getText());
                            stockCard.setText(itemCartaStock.getText());

                            if (itemCartaJuego.getText().equals("Yu-Gi-Oh")) {
                                nameGame.getSelectionModel().select(0);
                                for (Object y : CartaYUGI) {
                                    if (itemCartaNombre.getText().equals(((CartaYUGI) y).getNombreCarta())) {

                                        sumCard.setText(((CartaYUGI) y).getDescripcion());
                                        String[] parts = (((CartaYUGI) y).getAno()).split("-");
                                        String year = parts[0];
                                        yearCard.setText(year);
                                        yugiAtributo.setText(((CartaYUGI) y).getAtributo());
                                        yugiID.setText(((CartaYUGI) y).getIDCYugi());
                                        yugiNivel.setText(String.valueOf(((CartaYUGI) y).getNivel()));
                                        yugiSubTIpo.setText(((CartaYUGI) y).getSubTipo());

                                        //"Monstruo", "Mágica", "Trampa"
                                        if (((CartaYUGI) y).getTipoCarta().equals("Monstruo")) {
                                            yugiTipo.getSelectionModel().select(0);
                                        }
                                        if (((CartaYUGI) y).getTipoCarta().equals("Mágica")) {
                                            yugiTipo.getSelectionModel().select(1);
                                        }
                                        if (((CartaYUGI) y).getTipoCarta().equals("Trampa")) {
                                            yugiTipo.getSelectionModel().select(2);
                                        }
                                    }
                                }
                            } else if (itemCartaJuego.getText().equals("Magic")) {
                                nameGame.getSelectionModel().select(1);
                                for (Object m : CartaMAGIC) {
                                    if (itemCartaNombre.getText().equals(((CartaMAGIC) m).getNombreCarta())) {

                                        sumCard.setText(((CartaMAGIC) m).getDescripcion());
                                        String[] parts = (((CartaMAGIC) m).getAno()).split("-");
                                        String year = parts[0];
                                        yearCard.setText(year);
                                        magiCoste.setText(((CartaMAGIC) m).getCoste());
                                        magiID.setText(((CartaMAGIC) m).getIDCMagic());
                                        magiTipo.setText(((CartaMAGIC) m).getTipo());

                                        //"Blanco", "Azul", "Negro", "Rojo", "Verde", "Incoloro", "Multicolor"
                                        if (((CartaMAGIC) m).getColor().equals("Blanco")) {
                                            magiColor.getSelectionModel().select(0);
                                        }
                                        if (((CartaMAGIC) m).getColor().equals("Azul")) {
                                            magiColor.getSelectionModel().select(1);
                                        }
                                        if (((CartaMAGIC) m).getColor().equals("Negro")) {
                                            magiColor.getSelectionModel().select(2);
                                        }
                                        if (((CartaMAGIC) m).getColor().equals("Rojo")) {
                                            magiColor.getSelectionModel().select(3);
                                        }
                                        if (((CartaMAGIC) m).getColor().equals("Verde")) {
                                            magiColor.getSelectionModel().select(4);
                                        }
                                        if (((CartaMAGIC) m).getColor().equals("Incoloro")) {
                                            magiColor.getSelectionModel().select(5);
                                        }
                                        if (((CartaMAGIC) m).getColor().equals("Multicolor")) {
                                            magiColor.getSelectionModel().select(6);
                                        }

                                    }
                                }
                            } else if (itemCartaJuego.getText().equals("Force of Will")) {
                                nameGame.getSelectionModel().select(2);
                                for (Object f : CartaFOW) {
                                    if (itemCartaNombre.getText().equals(((CartaFOW) f).getNombreCarta())) {

                                        sumCard.setText(((CartaFOW) f).getDescripcion());
                                        String[] parts = (((CartaFOW) f).getAno()).split("-");
                                        String year = parts[0];
                                        yearCard.setText(year);
                                        fogCoste.setText(((CartaFOW) f).getCoste());
                                        fogID.setText(((CartaFOW) f).getIDCFoW());
                                        fogRaza.setText(((CartaFOW) f).getRaza());
                                        fogTipo.setText(((CartaFOW) f).getTipo());

                                        //"Luz", "Oscuridad", "Agua", "Viento", "Fuego", "Neutro", "Multicolor"
                                        if (((CartaFOW) f).getElemento().equals("Luz")) {
                                            fogColor.getSelectionModel().select(0);
                                        }
                                        if (((CartaFOW) f).getElemento().equals("Oscuridad")) {
                                            fogColor.getSelectionModel().select(1);
                                        }
                                        if (((CartaFOW) f).getElemento().equals("Agua")) {
                                            fogColor.getSelectionModel().select(2);
                                        }
                                        if (((CartaFOW) f).getElemento().equals("Viento")) {
                                            fogColor.getSelectionModel().select(3);
                                        }
                                        if (((CartaFOW) f).getElemento().equals("Fuego")) {
                                            fogColor.getSelectionModel().select(4);
                                        }
                                        if (((CartaFOW) f).getElemento().equals("Neutro")) {
                                            fogColor.getSelectionModel().select(5);
                                        }
                                        if (((CartaFOW) f).getElemento().equals("Multicolor")) {
                                            fogColor.getSelectionModel().select(6);
                                        }

                                    }
                                }
                            }
                        });
                        pnItemsOrders.getChildren().add(nodesCartas[i]);
                        i++;
                    }
                }
                s.close();
                entradaBusquedaCartas.setText("");
            }
        }
    }
    // </editor-fold>

    // ---------------------------------------- Borrados ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Método de borrado de un cliente">
    @FXML
    //Borramos al cliente seleccionado en la lista de la BBDD
    void accionBorrarCamposClientes(ActionEvent event) throws SQLException {
        String nombre = nombreCliente.getText();
        Bajas.eliminarCliente(nombre);
        accionLimpiarCamposClientes(event);
        ListCardsClientes();
        ListClientesLess();
        ListCardsOrders();
        CargarDatosDashboard();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de borrado de una carta">
    @FXML
    //Borramos la carta seleccionada en la lista
    void accionbtnBorrarCarta(ActionEvent event) throws SQLException {

        String nombreCarta = nameCard.getText();
        Bajas.eliminarCarta(nombreCarta);
        accionLimpiarCarta(event);
        ListCards();
        ListCardsOrders();
        ListCardsLess();
        CargarDatosDashboard();

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de borrado de una venta">
    @FXML
    //Reseteamos los campos de busqueda
    void accionBorrarCompras(ActionEvent event) {

        busComCarta.setText("");
        busComCliente.setText("");
        textAreaCantidadCompra.setText("");

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de borrado de una reserva">
    @FXML
    void CancelarReservaHistorial(ActionEvent event) {
        for (int i = 0; i < nodesHistorial.length; i++) {
            if (nodesHistorial[i].getStyle().equals("-fx-background-color : #17414C; -fx-background-radius:5")) {
                String NCliente = ((Label) nodesHistorial[i].lookup("#itemHistorialNombre")).getText();
                String NCarta = ((Label) nodesHistorial[i].lookup("#itemHistorialNombreCarta")).getText();
                try {
                    Bajas.eliminarReserva(NCliente, NCarta);
                    try {
                        ListHistorial();
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    CargarDatosDashboard();
                } catch (SQLException x) {
                    System.out.println(x.getMessage());
                }

            }
        }
    }
    // </editor-fold>

    // ---------------------------------------- Limpieza de campos ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Limpieza de los campos de clientes">
    @FXML
    //Reseteamos los campos de inserción de un cliente
    void accionLimpiarCamposClientes(ActionEvent event) {

        nombreCliente.setText("");
        edadCliente.setText("");
        direccionCliente.setText("");
        apellidosCliente.setText("");
        emailCliente.setText("");
        telefonoCliente.setText("");
        btnModificarCamposClientes.setDisable(true);
        btnBorrarCamposClientes.setDisable(true);
        btnGuardarCamposClientes.setDisable(false);

        edadCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        telefonoCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        nombreCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        apellidosCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        emailCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        direccionCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        sexoCliente.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Limpieza de los campos de la ventana Cartas">
    @FXML
    //Limpiamos los campos de la pantalla carta
    void accionLimpiarCarta(ActionEvent event) {
        //Activamos campo nombre carta para poder añadir una
        nameCard.setDisable(false);
        btnGuardarCarta.setDisable(false);
        btnModificarCarta.setDisable(true);
        btnBorrarCarta.setDisable(true);

        //Genericas
        nameCard.setText("");
        colecCard.setText("");
        yearCard.setText("");
        stockCard.setText("");
        priceCard.setText("");
        sumCard.setText("");
        btnSubirImagen.setText("Subir imagen");
        stockCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        sumCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        nameCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        colecCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        yearCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        priceCard.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        nameGame.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //Magic
        magiCoste.setText("");
        magiID.setText("");
        magiTipo.setText("");
        magiCoste.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        magiID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        magiTipo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //FOW
        fogCoste.setText("");
        fogID.setText("");
        fogRaza.setText("");
        fogTipo.setText("");
        fogCoste.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogRaza.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        fogTipo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

        //Yu gi oh
        yugiID.setText("");
        yugiAtributo.setText("");
        yugiNivel.setText("");
        yugiSubTIpo.setText("");

        yugiAtributo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiID.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiNivel.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");
        yugiSubTIpo.setStyle(" -fx-background-color:#00000b;"
                + "    -fx-text-fill:#fff;");

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Limpieza de campos de la ventana de detalles de carta">
    public void limpiarCamposMostrar() {

        InputStream inStream = getClass().getResourceAsStream("/images/ReversoCard.jpg");
        Image imageObject = new Image(inStream);

        MCBloqueFow.setDisable(true);
        MCBloqueMagic.setDisable(true);
        MCBloqueYuGi.setDisable(true);

        MCAno.setText("");
        MCColeccion.setText("");
        MCDescripcion.setText("");
        MCImagenCarta.setImage(imageObject);
        MCNombreC.setText("");
        MCPrecio.setText("");
        MCStock.setText("");

        MCfowCoste.setText("");
        MCfowElemento.setText("");
        MCfowID.setText("");
        MCfowRaza.setText("");
        MCfowTIPOC.setText("");

        MCmagicColor.setText("");
        MCmagicCoste.setText("");
        MCmagicID.setText("");
        MCmagicTIPOC.setText("");

        MCyuAtribu.setText("");
        MCyuID.setText("");
        MCyuLVL.setText("");
        MCyuSub.setText("");
        MCyuTIPOC.setText("");

    }
    // </editor-fold>

    public void limpiarListas(VBox items) {
        items.getChildren().clear();
    }

    // ---------------------------------------- Busquedas ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Método de búsqueda de la ventana Clientes">
    @FXML
    void accionBuscarCliente(KeyEvent evento) throws IOException, SQLException {

        if (evento.getCode().equals(KeyCode.ENTER)) {

            String nombrecliente, nombreClienteTrasTamaño;
            int contador = 0, i = 0;
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> Cliente = s.createCriteria(Cliente.class).list();
            s.close();
            int longitudNombre = 0;
            longitudNombre = lblBuscarCliente.getText().length();
            for (Object o : Cliente) {
                nombrecliente = ((Cliente) o).getNombre();
                if (longitudNombre < nombrecliente.length()) {
                    nombreClienteTrasTamaño = nombrecliente.substring(0, longitudNombre);
                } else {
                    nombreClienteTrasTamaño = nombrecliente;
                }
                if (nombreClienteTrasTamaño.toLowerCase().equals(lblBuscarCliente.getText().toLowerCase())) {
                    contador++;
                }
            }
            if ("".equals(lblBuscarCliente.getText()) || contador == 0) {
                System.out.println("NINGUNO");
                ListCardsClientes();
            } else {
                limpiarListas(pnItemsClientes);
                nodesClientes = new Node[contador];
                for (Object o : Cliente) {
                    nombrecliente = ((Cliente) o).getNombre();
                    if (longitudNombre < nombrecliente.length()) {
                        nombreClienteTrasTamaño = nombrecliente.substring(0, longitudNombre);
                    } else {
                        nombreClienteTrasTamaño = nombrecliente;
                    }

                    if (nombreClienteTrasTamaño.toLowerCase().equals(lblBuscarCliente.getText().toLowerCase())) {

                        final int j = i;
                        nodesClientes[i] = FXMLLoader.load(getClass().getResource("ItemCliente.fxml"));

                        //Establecimiento de labels
                        Label itemNombreCliente = (Label) nodesClientes[i].lookup("#itemClienteNombre");
                        itemNombreCliente.setText(((Cliente) o).getNombre());

                        Label itemApellidoCliente = (Label) nodesClientes[i].lookup("#itemClienteApellido");
                        itemApellidoCliente.setText(((Cliente) o).getApellidos());

                        Label itemEdadCliente = (Label) nodesClientes[i].lookup("#itemClienteEdad");
                        itemEdadCliente.setText(Integer.toString(((Cliente) o).getEdad()));

                        Label itemEmailCliente = (Label) nodesClientes[i].lookup("#itemClienteEmail");
                        itemEmailCliente.setText(((Cliente) o).getMail());

                        Label itemTlfCliente = (Label) nodesClientes[i].lookup("#itemClienteTlf");
                        itemTlfCliente.setText(((Cliente) o).getTelefono());

                        nodesClientes[i].setOnMouseEntered(event -> {
                            nodesClientes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });
                        nodesClientes[i].setOnMouseExited(event -> {
                            nodesClientes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });
                        nodesClientes[i].setOnMouseClicked(event -> {
                            nodesClientes[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesClientes[j].setOnMouseExited(null);
                            nodesClientes[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesClientes.length; x++) {
                                if (x != j) {
                                    nodesClientes[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesClientes[x].setOnMouseExited(event2 -> {
                                        nodesClientes[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesClientes[x].setOnMouseEntered(event2 -> {
                                        nodesClientes[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });

                        pnItemsClientes.getChildren().add(nodesClientes[i]);

                        i++;
                    }
                }

            }
            lblBuscarCliente.setText("");
        }

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Código de búsqueda en la ventana de Cartas">
    @FXML
    void accionBuscarCarta(KeyEvent evento) throws SQLException, IOException {
        if (evento.getCode().equals(KeyCode.ENTER)) {

            String nombrecarta, nombreClienteTrasTamaño;
            int contador = 0, i = 0;
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> Carta = s.createCriteria(Carta.class).list();
            s.close();
            int longitudNombre = 0;
            longitudNombre = entradaBusquedaInicio.getText().length();
            for (Object o : Carta) {
                nombrecarta = ((Carta) o).getNombreCarta();
                if (longitudNombre < nombrecarta.length()) {
                    nombreClienteTrasTamaño = nombrecarta.substring(0, longitudNombre);
                } else {
                    nombreClienteTrasTamaño = nombrecarta;
                }
                if (nombreClienteTrasTamaño.toLowerCase().equals(entradaBusquedaInicio.getText().toLowerCase())) {
                    contador++;
                }
            }
            if ("".equals(entradaBusquedaInicio.getText()) || contador == 0) {
                System.out.println("NINGUNO");
                ListCards();
            } else {
                limpiarListas(pnItems);
                nodes = new Node[contador];
                for (Object o : Carta) {
                    nombrecarta = ((Carta) o).getNombreCarta();
                    if (longitudNombre < nombrecarta.length()) {
                        nombreClienteTrasTamaño = nombrecarta.substring(0, longitudNombre);
                    } else {
                        nombreClienteTrasTamaño = nombrecarta;
                    }
                    if (nombreClienteTrasTamaño.toLowerCase().equals(entradaBusquedaInicio.getText().toLowerCase())) {

                        final int j = i;
                        nodes[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                        //Establecimiento de labels
                        Label itemCartaJuego = (Label) nodes[i].lookup("#itemCartaJuego");
                        itemCartaJuego.setText(((Carta) o).getNombreJuego());

                        Label itemCartaNombre = (Label) nodes[i].lookup("#itemCartaNombre");
                        itemCartaNombre.setText(((Carta) o).getNombreCarta());

                        Label itemCartaColeccion = (Label) nodes[i].lookup("#itemCartaColeccion");
                        itemCartaColeccion.setText(((Carta) o).getColeccion());

                        Label itemCartaPrecio = (Label) nodes[i].lookup("#itemCartaPrecio");
                        itemCartaPrecio.setText(Float.toString(((Carta) o).getPrecio()));

                        Button itemCartaStock = (Button) nodes[i].lookup("#itemCartaStock");
                        itemCartaStock.setText(Integer.toString(((Carta) o).getStock()));

                        nodes[i].setOnMouseEntered(event -> {
                            nodes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });
                        nodes[i].setOnMouseExited(event -> {
                            nodes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });
                        nodes[i].setOnMouseClicked(event -> {
                            nodes[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodes[j].setOnMouseExited(null);
                            nodes[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodes.length; x++) {
                                if (x != j) {
                                    nodes[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodes[x].setOnMouseExited(event2 -> {
                                        nodes[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodes[x].setOnMouseEntered(event2 -> {
                                        nodes[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });

                        pnItems.getChildren().add(nodes[i]);

                        i++;
                    }
                }

            }
            entradaBusquedaInicio.setText("");
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de búsqueda de clientes en la ventana de compras">
    @FXML
    void accionBuscarComprasCliente(KeyEvent evento) throws IOException {

        if (evento.getCode().equals(KeyCode.ENTER)) {
            String nombreCliente;
            String nombreClienteTrasTamaño;
            int contador = 0, i = 0;
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> Cliente = s.createCriteria(Cliente.class).list();
            s.close();
            int longitudNombre = 0;
            longitudNombre = busComCliente.getText().length();
            for (Object o : Cliente) {
                nombreCliente = ((Cliente) o).getNombre();
                if (longitudNombre < nombreCliente.length()) {
                    nombreClienteTrasTamaño = nombreCliente.substring(0, longitudNombre);
                } else {
                    nombreClienteTrasTamaño = nombreCliente;
                }
                if (nombreClienteTrasTamaño.toLowerCase().equals(busComCliente.getText().toLowerCase())) {
                    contador++;
                }
            }

            System.out.println(contador);

            if ("".equals(busComCliente.getText()) || contador == 0) {
                System.out.println("NINGUNO");
                ListClientesLess();
            } else {
                limpiarListas(pnItemsClientesLess);
                nodesClientesLess = new Node[contador];
                for (Object o : Cliente) {
                    nombreCliente = ((Cliente) o).getNombre();
                    if (longitudNombre < nombreCliente.length()) {
                        nombreClienteTrasTamaño = nombreCliente.substring(0, longitudNombre);
                    } else {
                        nombreClienteTrasTamaño = nombreCliente;
                    }
                    if (nombreClienteTrasTamaño.toLowerCase().equals(busComCliente.getText().toLowerCase())) {
                        final int j = i;
                        nodesClientesLess[i] = FXMLLoader.load(getClass().getResource("ItemClienteLess.fxml"));

                        //Establecimiento de labels
                        Label itemNombreCliente = (Label) nodesClientesLess[i].lookup("#itemClienteLessNombre");
                        itemNombreCliente.setText(((Cliente) o).getNombre());

                        Label itemApellidoCliente = (Label) nodesClientesLess[i].lookup("#itemClienteLessApellidos");
                        itemApellidoCliente.setText(((Cliente) o).getApellidos());

                        nodesClientesLess[i].setOnMouseEntered(event -> {
                            nodesClientesLess[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });
                        nodesClientesLess[i].setOnMouseExited(event -> {
                            nodesClientesLess[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });
                        nodesClientesLess[i].setOnMouseClicked(event -> {
                            nodesClientesLess[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesClientesLess[j].setOnMouseExited(null);
                            nodesClientesLess[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesClientesLess.length; x++) {
                                if (x != j) {
                                    nodesClientesLess[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesClientesLess[x].setOnMouseExited(event2 -> {
                                        nodesClientesLess[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesClientesLess[x].setOnMouseEntered(event2 -> {
                                        nodesClientesLess[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });
                        nodesClientesLess[i].setOnMousePressed(event -> {
                            for (Object C : Cliente) {
                                if (itemNombreCliente.getText().equals(((Cliente) C).getNombre())) {
                                    idClienteCompra = Integer.toString(((Cliente) C).getIDCliente());
                                    busComCliente.setText(((Cliente) C).getNombre() + " " + ((Cliente) C).getApellidos());
                                }
                            }
                        });
                        pnItemsClientesLess.getChildren().add(nodesClientesLess[i]);
                        i++;
                    }
                }
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de búsqueda de cartas en la ventana de compras">
    @FXML
    void accionBuscarComprasCarta(KeyEvent evento) throws IOException {

        if (evento.getCode().equals(KeyCode.ENTER)) {
            String nombreCarta;
            String nombreCartaTrasTamaño;
            int contador = 0, i = 0;
            Session s;
            s = NewHibernateUtil.getSession();
            List<Object> Carta = s.createCriteria(Carta.class).list();
            s.close();
            int longitudNombre = 0;
            longitudNombre = busComCarta.getText().length();
            for (Object o : Carta) {
                nombreCarta = ((Carta) o).getNombreCarta();
                if (longitudNombre < nombreCarta.length()) {
                    nombreCartaTrasTamaño = nombreCarta.substring(0, longitudNombre);
                } else {
                    nombreCartaTrasTamaño = nombreCarta;
                }
                if (nombreCartaTrasTamaño.toLowerCase().equals(busComCarta.getText().toLowerCase())) {
                    contador++;
                }
            }

            System.out.println(contador);

            if ("".equals(busComCarta.getText()) || contador == 0) {
                System.out.println("NINGUNO");
                ListCardsLess();
            } else {
                limpiarListas(pnItemsCartasLess);
                nodesCartasLess = new Node[contador];
                for (Object o : Carta) {
                    nombreCarta = ((Carta) o).getNombreCarta();
                    if (longitudNombre < nombreCarta.length()) {
                        nombreCartaTrasTamaño = nombreCarta.substring(0, longitudNombre);
                    } else {
                        nombreCartaTrasTamaño = nombreCarta;
                    }
                    if (nombreCartaTrasTamaño.toLowerCase().equals(busComCarta.getText().toLowerCase())) {
                        final int j = i;
                        nodesCartasLess[i] = FXMLLoader.load(getClass().getResource("ItemCartaLess.fxml"));

                        //Establecimiento de labels
                        Label itemNombreJuegoCarta = (Label) nodesCartasLess[i].lookup("#itemCartaLessJuego");
                        itemNombreJuegoCarta.setText(((Carta) o).getNombreJuego());

                        Label itemNombreCartaCarta = (Label) nodesCartasLess[i].lookup("#itemCartaLessNombreCarta");
                        itemNombreCartaCarta.setText(((Carta) o).getNombreCarta());

                        Label itemPrecioCartaCarta = (Label) nodesCartasLess[i].lookup("#itemCartaLessPrecio");
                        itemPrecioCartaCarta.setText(Float.toString(((Carta) o).getPrecio()));

                        nodesCartasLess[i].setOnMouseEntered(event -> {
                            nodesCartasLess[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                        });
                        nodesCartasLess[i].setOnMouseExited(event -> {
                            nodesCartasLess[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                        });
                        nodesCartasLess[i].setOnMouseClicked(event -> {
                            nodesCartasLess[j].setStyle("-fx-background-color : #17414C; -fx-background-radius:5");
                            nodesCartasLess[j].setOnMouseExited(null);
                            nodesCartasLess[j].setOnMouseEntered(null);
                            for (int x = 0; x < nodesCartasLess.length; x++) {
                                if (x != j) {
                                    nodesCartasLess[x].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    final int x2 = x;
                                    nodesCartasLess[x].setOnMouseExited(event2 -> {
                                        nodesCartasLess[x2].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                                    });
                                    nodesCartasLess[x].setOnMouseEntered(event2 -> {
                                        nodesCartasLess[x2].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                                    });
                                }
                            }
                        });
                        nodesCartasLess[i].setOnMousePressed(event -> {
                            for (Object C : Carta) {
                                if (itemNombreCartaCarta.getText().equals(((Carta) C).getNombreCarta())) {
                                    idCartaCompra = Integer.toString(((Carta) C).getIDCarta());
                                    busComCarta.setText(((Carta) C).getNombreCarta());
                                }
                            }
                        });
                        pnItemsCartasLess.getChildren().add(nodesCartasLess[i]);
                        i++;
                    }
                }
            }
        }

    }
    // </editor-fold>

    // ---------------------------------------- Otros ---------------------------------------------------//
    // <editor-fold defaultstate="collapsed" desc="Método salida de la venta de detalles de carta">
    @FXML
    void accionSalirMostrarCarta(MouseEvent event) {
        limpiarCamposMostrar();
        MostrarCarta.setVisible(false);
        PantallasHome.setDisable(false);
        MenuPrincipal.setDisable(false);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Método de carga de imágenes">
    @FXML
    void selectImg(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imagenes", "*.jpg", "*.png")
        );
        try {
            selectedFile = fileChooser.showOpenDialog(stage);
            btnSubirImagen.setText("Imagen Lista");
        } catch (Exception e) {

        }
    }
    // </editor-fold>

}
