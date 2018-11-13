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
import javafx.scene.control.ScrollPane;

public class Controller implements Initializable {

    //INICIALIZAMOS LAS PANTALLAS Y TODOS LOS DEMÁS COMPONENETES DE NUESTROS FXML
    @FXML
    private VBox pnItems = null;

    @FXML
    private VBox pnItemsOrders = null;

    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

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
    private Pane pnlMenus;

    @FXML
    private ScrollPane ListCards;

    @FXML
    private ScrollPane ListCardsOrders;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ListCards();
    }

    public void ListCards() {

        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void ListCardsOrders() {

        System.out.println(" ENTRO EN LA SEGUNDA LISTA");
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {

                final int j = i;
                nodes[i] = FXMLLoader.load(getClass().getResource("Item.fxml"));

                nodes[i].setOnMouseEntered(event -> {
                    nodes[j].setStyle("-fx-background-color : #0A0E3F");
                });
                nodes[i].setOnMouseExited(event -> {
                    nodes[j].setStyle("-fx-background-color : #02030A");
                });
                pnItemsOrders.getChildren().add(nodes[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(true);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlMenus.setVisible(false);
            pnlCustomer.toFront();
        }
        if (actionEvent.getSource() == btnMenus) {
            pnlMenus.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlMenus.setVisible(true);
            pnlMenus.toFront();
        }
        if (actionEvent.getSource() == btnOverview) {
            pnlOverview.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(true);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(false);
            pnlMenus.setVisible(false);
            ListCards();
            pnlOverview.toFront();
        }
        if (actionEvent.getSource() == btnSettings) {
            pnlDevelops.setStyle("-fx-background-color : #00222B");
            pnlOverview.setVisible(false);
            pnlCustomer.setVisible(false);
            pnlOrders.setVisible(false);
            pnlDevelops.setVisible(true);
            pnlMenus.setVisible(false);
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
            pnlMenus.setVisible(false);
            //ListCards.setVisible(false);
            ListCardsOrders();
            pnlOrders.toFront();
        }
    }
}
