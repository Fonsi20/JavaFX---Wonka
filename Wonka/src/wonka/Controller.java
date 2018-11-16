package wonka;

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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller implements Initializable {

    //INICIALIZAMOS LAS PANTALLAS Y TODOS LOS DEMÁS COMPONENETES DE NUESTROS FXML
    @FXML
    private VBox pnItems = null;

    @FXML
    private VBox pnItemsOrders = null;

    @FXML
    private VBox pnItemsClientes = null;

    @FXML
    private VBox pnItemsCartasLess = null;

    @FXML
    private VBox pnItemsClientesLess = null;

    @FXML
    private VBox atributosYugi1;

    @FXML
    private VBox atributosYugi2;

    @FXML
    private VBox atributosMagi1;

    @FXML
    private VBox atributosMagi2;

    @FXML
    private VBox atributosFOG1;

    @FXML
    private VBox atributosFOG2;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnCompras;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlDevelops;

    @FXML
    private Pane pnlCompras;

    @FXML
    private AnchorPane home;

    @FXML
    private ComboBox nameGame;

    @FXML
    private ScrollPane ListCards;

    @FXML
    private ScrollPane ListCardsLess;

    @FXML
    private ScrollPane ListClientesLess;

    @FXML
    private ScrollPane ListCardsOrders;

    @FXML
    private ScrollPane ListCardsClientes;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Arrancamos todas las listas de todas las pantallas
        ListCards();
        ListCardsOrders();
        ListCardsClientes();
        ListCardsLess();
        ListClientesLess();

        //Cargamos items en la comboBox
        nameGame.getItems().addAll(
                "Magic",
                "Yu Gi Oh",
                "FOW"
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
            atributosYugi1.setDisable(true);
            atributosYugi2.setDisable(true);
            atributosFOG1.setDisable(true);
            atributosFOG2.setDisable(true);
            atributosMagi1.setDisable(false);
            atributosMagi2.setDisable(false);
        }
        if ("Yu Gi Oh".equals(p)) {
            atributosYugi1.setDisable(false);
            atributosYugi2.setDisable(false);
            atributosFOG1.setDisable(true);
            atributosFOG2.setDisable(true);
            atributosMagi1.setDisable(true);
            atributosMagi2.setDisable(true);
        }
        if ("FOW".equals(p)) {
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
