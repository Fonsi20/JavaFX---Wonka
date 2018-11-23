package wonka;

import Objetos.*;
import backend.Bajas;
import backend.Inserciones;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.hibernate.Session;

public class Controller implements Initializable {

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
    private Pane pnlSignOut;

    @FXML
    private Pane pnlDevelops;

    @FXML
    private VBox fonsiBack;

    @FXML
    private VBox daniBack;

    @FXML
    private VBox diegoBack;

    @FXML
    private Pane pnlHistorial;

    @FXML
    private ScrollPane ListHistorial;

    @FXML
    private VBox pnItemsHistorial;

    @FXML
    private JFXButton btnCancelarReserva;

    @FXML
    private JFXButton btnLimpiarHistorial;

    @FXML
    private JFXTextField busClienteHistorial;

    @FXML
    private JFXButton btnBuscarHistorial;

    @FXML
    private Pane pnlCompras;

    @FXML
    private ScrollPane ListClientesLess;

    @FXML
    private VBox pnItemsClientesLess;

    @FXML
    private ScrollPane ListCardsLess;

    @FXML
    private VBox pnItemsCartasLess;

    @FXML
    private JFXButton btnComprarCarta;

    @FXML
    private JFXButton btnLimpiarListas;

    @FXML
    private JFXTextField busComCliente;

    @FXML
    private JFXTextField busComCarta;

    @FXML
    private JFXButton btnBuscarCompras;

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
    private Button btnLimpiarCamposClientes;

    @FXML
    private Button btnModificarCamposClientes;

    @FXML
    private Button btnBorrarCamposClientes;

    @FXML
    private Button btnGuardarCamposClientes;

    @FXML
    private ScrollPane ListCardsClientes;

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
    private TextField idCard;

    @FXML
    private TextField priceCard;

    @FXML
    private TextField colecCard;

    @FXML
    private JFXTextArea sumCard;

    @FXML
    private Button btnLimpiarCarta;

    @FXML
    private Button btnModificarCarta;

    @FXML
    private Button btnBorrarCarta;

    @FXML
    private Button btnGuardarCarta;

    @FXML
    private HBox atributosJuegos;

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
    private ScrollPane ListCardsOrders;

    @FXML
    private VBox pnItemsOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private ScrollPane ListCards;

    @FXML
    private VBox pnItems;

    @FXML
    private TextField entradaBusquedaInicio;

    @FXML
    private TextField entradaBusquedaCartas;

    @FXML
    private Label lblTotalCartas;

    @FXML
    private Label lblTotalClientes;

    @FXML
    private Label lblPedidosPendientes;

    @FXML
    private Label lblCartasVendidas;

    private Node[] nodes = new Node[0];
    private Node[] nodesCartas = new Node[0];
    private Node[] nodesClientes = new Node[0];

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            //Arrancamos todas las listas de todas las pantallas
            ListCards();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListCardsOrders();
        try {
            ListCardsClientes();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        ListCardsLess();
        ListClientesLess();
        ListHistorial();

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
            //root.setStyle("-fx-cursor: CLOSED_HAND;");
        });

        //root.setOnMouseReleased(e -> root.setStyle("-fx-cursor: DEFAULT;"));
    }

    @FXML
    //Carga de la lista de Cartas de la pantalla inicial
    public void ListCards() throws SQLException {
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

                    pnItems.getChildren().add(nodes[i]);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Res.close();
        } catch (SQLException x) {
            System.out.println(x);
        }
    }

    @FXML
    //Carga de la lista de Cartas de la pantalla Cartas
    public void ListCardsOrders() {
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

                    //descripcion.setText(Res.getString("D"));
                    nodesCartas[i].setOnMouseEntered(event -> {
                        nodesCartas[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                    });
                    nodesCartas[i].setOnMouseExited(event -> {
                        nodesCartas[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                    });

                    nodesCartas[i].setOnMousePressed(event -> {
                        //Bloqueamos el campo Nombre Carta para no poder editarlo, para poder volver a escribir pulsar Limpiar.
                        nameCard.setDisable(true);
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

    }

    @FXML
    //Carga de la lista de clientes de la pantalla Clientes
    public void ListCardsClientes() throws SQLException {
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
                    nodesClientes[i].setOnMousePressed(event -> {
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

    }

    @FXML
    //Carga de la lista de cartas de la pantalla Compra
    public void ListCardsLess() {

        limpiarListas(pnItemsCartasLess);
        Node[] nodes = new Node[20];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemCartaLess.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A; -fx-background-radius:5");
                });

                pnItemsCartasLess.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    //Carga de la lista de clientes de la pantalla Compra
    public void ListClientesLess() {

        limpiarListas(pnItemsClientesLess);
        Node[] nodes = new Node[4];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemClienteLess.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                });
                pnItemsClientesLess.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    //Carga de la lista de clientes con pedidos de la pantalla Historial
    public void ListHistorial() {

        limpiarListas(pnItemsHistorial);
        Node[] nodes = new Node[24];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemHistorial.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                });
                pnItemsHistorial.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void limpiarListas(VBox items) {
        items.getChildren().clear();
    }

    @FXML
    //Activar los distintos campos de inserción de una carta
    public void activarAtributo(ActionEvent actionEvent
    ) {

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

    @FXML
    //Acciones al pulsar sobre los botones del menú
    public void handleClicks(ActionEvent actionEvent) throws SQLException {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(true);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(false);
            pnlHistorial.setVisible(false);
            ListCardsClientes();
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
            pnlOrders.toFront();
        }
        if (actionEvent.getSource() == btnSignout) {
            System.exit(0);
        }
    }

    @FXML
    void accionBuscarCarta(KeyEvent evento) throws SQLException {
        if (evento.getCode().equals(KeyCode.ENTER)) {
            Statement S = Wonka.conect.createStatement();
            ResultSet Res = S.executeQuery("SELECT COUNT(*) AS Cont FROM CARTAS Where NombreCarta = '" + entradaBusquedaInicio.getText() + "';");
            Res.next();
            if ("".equals(entradaBusquedaInicio.getText()) || Res.getInt("Cont") == 0) {
                ListCards();
            } else {
                try {
                    limpiarListas(pnItems);
                    nodes = new Node[Res.getInt("Cont")];
                    Res.close();
                    Res = S.executeQuery("SELECT NombreJuego as NJ, NombreCarta as NC, Coleccion as C, Precio as P, Stock as S FROM CARTAS Where NombreCarta = '" + entradaBusquedaInicio.getText() + "';");
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

                            pnItems.getChildren().add(nodes[i]);

                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Res.close();
                } catch (SQLException x) {
                    System.out.println(x);
                }
            }
            entradaBusquedaInicio.setText("");
        }
    }

    @FXML
    void accionBuscarAñadirCarta(KeyEvent evento) throws SQLException {
        if (evento.getCode().equals(KeyCode.ENTER)) {
            Statement S = Wonka.conect.createStatement();
            ResultSet Res = S.executeQuery("SELECT COUNT(*) AS Cont FROM CARTAS Where NombreCarta = '" + entradaBusquedaCartas.getText() + "';");
            Res.next();
            if ("".equals(entradaBusquedaCartas.getText()) || Res.getInt("Cont") == 0) {
                ListCardsOrders();
            } else {

                try {
                    //String año = null, descripcion = null;
                    limpiarListas(pnItemsOrders);
                    nodesCartas = new Node[Res.getInt("Cont")];
                    Res.close();
                    Res = S.executeQuery("SELECT NombreJuego as NJ, NombreCarta as NC, Coleccion as C, Precio as P, Stock as S FROM CARTAS Where NombreCarta = '" + entradaBusquedaCartas.getText() + "';");
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

                            //descripcion.setText(Res.getString("D"));
                            nodesCartas[i].setOnMouseEntered(event -> {
                                nodesCartas[j].setStyle("-fx-background-color : #266D7F; -fx-background-radius:5");
                            });
                            nodesCartas[i].setOnMouseExited(event -> {
                                nodesCartas[j].setStyle("-fx-background-color :  #02030A; -fx-background-radius:5");
                            });

                            nodesCartas[i].setOnMousePressed(event -> {
                                //Bloqueamos el campo Nombre Carta para no poder editarlo, para poder volver a escribir pulsar Limpiar.
                                nameCard.setDisable(true);
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

            }
            entradaBusquedaCartas.setText("");
        }
    }

    @FXML
    //Borramos al cliente seleccionado en la lista de la BBDD
    void accionBorrarCamposClientes(ActionEvent event) {

    }

    @FXML
    //Guardamos al cliente introducido en la BBDD
    void accionGuardarCamposClientes(ActionEvent event) {

    }

    @FXML
    //Reseteamos los campos de inserción de un cliente
    void accionLimpiarCamposClientes(ActionEvent event) {

        nombreCliente.setText("");
        edadCliente.setText("");
        direccionCliente.setText("");
        apellidosCliente.setText("");
        emailCliente.setText("");
        telefonoCliente.setText("");

    }

    @FXML
    //Modificamos los campos de un cliente seleccionado en la lista y lo subimos de nuevo a la BBDD
    void accionModificarCamposClientes(ActionEvent event) {

    }

    @FXML
    //Reseteamos los campos de busqueda
    void accionBorrarCompras(ActionEvent event) {

        busComCarta.setText("");
        busComCliente.setText("");

    }

    @FXML
    void accionBuscarCompras(ActionEvent event) {

    }

    @FXML
    //Modificamos los campos de una carta seleccionada en la lista y la subimos de nuevo a la BBDD
    void accionModificarCarta(ActionEvent event) throws SQLException {

        ArrayList<String> Carta = new ArrayList<String>();

        Carta.add(stockCard.getText());
        Carta.add((String) nameGame.getSelectionModel().getSelectedItem());
        Carta.add(nameCard.getText());
        Carta.add(sumCard.getText());
        Carta.add(colecCard.getText());
        Carta.add(yearCard.getText());
        Carta.add(priceCard.getText());

        if (((String) nameGame.getSelectionModel().getSelectedItem()) == null) {
            sumCard.setText("SELECIONA UN JUEGO!!");
        } else {
            switch ((String) nameGame.getSelectionModel().getSelectedItem()) {

                case "Magic":

                    Carta.add((String) magiColor.getSelectionModel().getSelectedItem());
                    Carta.add(magiCoste.getText());
                    Carta.add(magiID.getText());
                    Carta.add(magiTipo.getText());
                    Inserciones.actualizarCartaMagic(Carta);
                    accionLimpiarCarta(event);
                    break;
                case "Yu-Gi-Oh":
                    Carta.add(yugiID.getText());
                    Carta.add((String) yugiTipo.getSelectionModel().getSelectedItem());
                    Carta.add(yugiAtributo.getText());
                    Carta.add(yugiSubTIpo.getText());
                    Carta.add(yugiNivel.getText());
                    Inserciones.actualizarCartaYuGi(Carta);
                    accionLimpiarCarta(event);
                    break;
                case "Force of Will":
                    Carta.add((String) fogColor.getSelectionModel().getSelectedItem());
                    Carta.add(fogID.getText());
                    Carta.add(fogCoste.getText());
                    Carta.add(fogTipo.getText());
                    Carta.add(fogRaza.getText());
                    Inserciones.actualizarCartaFOW(Carta);
                    accionLimpiarCarta(event);
                    break;
            }
            ListCards();
            ListCardsOrders();
            ListCardsLess();
        }
    }

    @FXML
    //Borramos la carta seleccionada en la lista
    void accionbtnBorrarCarta(ActionEvent event) throws SQLException {

        String nombreCarta = nameCard.getText();
        Bajas.eliminarCarta(nombreCarta);
        accionLimpiarCarta(event);
        ListCards();
        ListCardsOrders();
        ListCardsLess();

    }

    @FXML
    //Limpiamos los campos de la pantalla carta
    void accionLimpiarCarta(ActionEvent event) {
        //Activamos campo nombre carta para poder añadir una
        nameCard.setDisable(false);

        nameCard.setText("");
        colecCard.setText("");
        yearCard.setText("");
        stockCard.setText("");
        priceCard.setText("");
        sumCard.setText("");

        yugiID.setText("");
        yugiAtributo.setText("");
        yugiNivel.setText("");
        yugiSubTIpo.setText("");

        magiCoste.setText("");
        magiID.setText("");
        magiTipo.setText("");

        fogCoste.setText("");
        fogID.setText("");
        fogRaza.setText("");
        fogTipo.setText("");

    }

    @FXML
    //Guardamos la carta introducida en la BBDD
    void accionGuardarCarta(ActionEvent event) throws SQLException {

        ArrayList<String> Carta = new ArrayList<String>();

        Carta.add(stockCard.getText());
        Carta.add((String) nameGame.getSelectionModel().getSelectedItem());
        Carta.add(nameCard.getText());
        Carta.add(sumCard.getText());
        Carta.add(colecCard.getText());
        Carta.add(yearCard.getText());
        Carta.add(priceCard.getText());

        if (((String) nameGame.getSelectionModel().getSelectedItem()) == null) {
            sumCard.setText("SELECIONA UN JUEGO!!");
        } else {
            switch ((String) nameGame.getSelectionModel().getSelectedItem()) {

                case "Magic":

                    Carta.add((String) magiColor.getSelectionModel().getSelectedItem());
                    Carta.add(magiCoste.getText());
                    Carta.add(magiID.getText());
                    Carta.add(magiTipo.getText());
                    Inserciones.insertarCartasMagic(Carta);
                    accionLimpiarCarta(event);
                    break;
                case "Yu-Gi-Oh":
                    Carta.add(yugiID.getText());
                    Carta.add(yugiAtributo.getText());
                    Carta.add(yugiNivel.getText());
                    Carta.add(yugiSubTIpo.getText());
                    Carta.add((String) yugiTipo.getSelectionModel().getSelectedItem());
                    Inserciones.insertarCartasYuGi(Carta);
                    accionLimpiarCarta(event);
                    break;
                case "Force of Will":
                    Carta.add((String) fogColor.getSelectionModel().getSelectedItem());
                    Carta.add(fogCoste.getText());
                    Carta.add(fogID.getText());
                    Carta.add(fogRaza.getText());
                    Carta.add(fogTipo.getText());
                    Inserciones.insertarCartasFOW(Carta);
                    accionLimpiarCarta(event);
                    break;
            }
            ListCards();
            ListCardsOrders();
            ListCardsLess();
        }
    }

    @FXML
    void CancelarReservaHistorial(ActionEvent event) {

    }

    @FXML
    void accionBorrarHistorial(ActionEvent event) {
        busClienteHistorial.setText("");
    }

    @FXML
    void accionBuscarHistorial(ActionEvent event) {

    }

    private void CargarDatosDashboard() {
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
    }

}
