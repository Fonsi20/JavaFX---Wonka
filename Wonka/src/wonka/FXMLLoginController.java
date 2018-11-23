package wonka;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author a16alfonsofa
 */
public class FXMLLoginController implements Initializable {

    private double x, y;

    @FXML
    private Label label;

    @FXML
    private AnchorPane login;

    @FXML
    private Button btnSingUp;

    @FXML
    private Button btnEnter;

    @FXML
    private PasswordField edPass;

    @FXML
    private TextField edUser;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        if (event.getSource() == btnEnter) {
            if (edUser.getText().equals("root") && edPass.getText().equals("root")) {

                Parent segunda = FXMLLoader.load(getClass().getResource("Home.fxml"));
                Stage HomeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                HomeStage.setScene(new Scene(segunda));
                HomeStage.toFront();
                //HomeStage.setFullScreen(true);
                //Wonka.moverPantalla(segunda);

                HomeStage.show();
            } else {
                edPass.setText("");
                edUser.setText("Usuario o Contraseña incorrecta");
            }
        }
        if (event.getSource() == btnSingUp) {
            System.exit(0);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.MoverVentanas(this.login);
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
        });
    }
}
