package wonka;

import com.jfoenix.controls.JFXButton;
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
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
    private Pane pnlPack;

    @FXML
    private Pane pnlDevelops;

    @FXML
    private VBox fonsiBack;

    @FXML
    private VBox daniBack;

    @FXML
    private VBox diegoBack;

    @FXML
    private Pane pnlSignOut;

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
    private TextField sumCard;

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
    private TextField yugiTipo;

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
    private TextField magiColor;

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
    private TextField fogColor;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Arrancamos todas las listas de todas las pantallas
        ListCards();
        ListCardsOrders();
        ListCardsClientes();
        ListCardsLess();
        ListClientesLess();

        //Cargamos items en la comboBox de tipo de juego de carta
        nameGame.getItems().addAll(
                "Magic",
                "Yu Gi Oh",
                "FOW"
        );
      
         //Cargamos items en la comboBox de sexo de cliente
        sexoCliente.getItems().addAll(
                "Femenino",
                "Masculino"                
        );

        //Metodo para poder arrastrar la pantalla libremente
        this.MoverVentanas(this.home);
    }

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

    public void ListCards() {

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #00000B");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void ListCardsOrders() {

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemCarta.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #00000B");
                });
                pnItemsOrders.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void ListCardsClientes() {

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemCliente.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #00000B");
                });
                pnItemsClientes.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void ListCardsLess() {

        Node[] nodes = new Node[20];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemCartaLess.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #00000B");
                });

                pnItemsCartasLess.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void ListClientesLess() {

        Node[] nodes = new Node[4];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("ItemClienteLess.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #266D7F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #00000B");
                });
                pnItemsClientesLess.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

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
        if ("Yu Gi Oh".equals(p)) {
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
        if ("FOW".equals(p)) {
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

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(true);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(false);
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
            pnlDevelops.toFront();
        }
        if (actionEvent.getSource() == btnSignout) {
            System.exit(0);
        }
        if (actionEvent.getSource() == btnOrders) {
            pnlOrders.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(true);
            pnlDevelops.setVisible(false);
            pnlCompras.setVisible(false);
            ListCardsOrders();
            pnlOrders.toFront();
        }
    }
}
