/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wonka;

import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.stage.StageStyle;

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

            System.out.println("Entró en el onClick");
            System.out.println(edPass.getText());
            System.out.println(edUser.getText());

            if (edUser.getText().equals("root") && edPass.getText().equals("root")) {

                System.out.println("Logeado!!!");
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
        // TODO
    }

}
