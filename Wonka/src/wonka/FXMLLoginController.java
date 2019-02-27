package wonka;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import wonka.I18N;

/**
 *
 * @author a16alfonsofa
 */
public class FXMLLoginController implements Initializable {

    private static ResourceBundle strings = ResourceBundle.getBundle("wonka/resources/strings_en_EN");

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

        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event2) {

                try {
                    if (event.getSource() == btnEnter) {
                        if (edUser.getText().toLowerCase().equals("root") && edPass.getText().toLowerCase().equals("root")) {
                            Parent segunda = FXMLLoader.load(getClass().getResource("Home.fxml"));
                            Stage HomeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            HomeStage.setScene(new Scene(segunda));
                            HomeStage.toFront();
                            HomeStage.show();
                        } else {
                            edPass.setText("");
                            edUser.setText("");
                            edUser.setPromptText(strings.getString("WRONG_USER_PSW"));
                        }
                    }
                    if (event.getSource() == btnSingUp) {
                        System.exit(0);
                    }

                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        });
        new Thread(sleeper).start();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
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
