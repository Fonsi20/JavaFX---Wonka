package wonka;

import backend.createBBDD;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static wonka.Wonka.conect;
import static wonka.Wonka.sentencia;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ODBServer;

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
    private RadioButton rbHibernate;

    @FXML
    private PasswordField edPass;

    @FXML
    private TextField edUser;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, InterruptedException {

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

                            if (rbHibernate.isSelected()) {
                                String url = "jdbc:mysql://localhost:3307/?user=root&password=usbw";
                                try {
                                    conect = DriverManager.getConnection(url);
                                    sentencia = conect.createStatement();

                                } catch (SQLException e) {
                                    System.out.println("Error: " + e);
                                    System.exit(1);
                                }
                                try {
                                    if (!sentencia.executeQuery("show databases like 'TIENDACARTAS'").first()) {
                                        createBBDD.crearTablas(sentencia);
                                        System.out.println("--- Base de datos CREADA ---\n");
                                    } else {
                                        sentencia.execute("use TIENDACARTAS");
                                        System.out.println("--- Base de datos CREADA ---\n");
                                    }
                                    Wonka.basedatos = true;

                                } catch (SQLException e) {
                                    System.out.println("Error: " + e);
                                    System.exit(2);
                                }
                            } else {
                                //Inicio del servidor: 
                                System.out.println("Iniciando programa:");
                                ODBServer server = ODBFactory.openServer(8000);
                                server.addBase("neoWonka", "neoWonka.neo");
                                server.startServer(true);
                                //  Thread.sleep(100);
                                createBBDD.insertarNeodatis();
                                Wonka.basedatos = false;
                                arreglosDependencias();
                            }
                            Locale locale = new Locale("en", "US");
                            ResourceBundle bundle = ResourceBundle.getBundle("strings", locale);
                            Parent segunda = FXMLLoader.load(getClass().getResource("Home.fxml"), bundle);
                            Stage HomeStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            HomeStage.setScene(new Scene(segunda));
                            HomeStage.toFront();
                            HomeStage.show();

                        } else {
                            edPass.setText("");
                            edUser.setText("");
                            edUser.setPromptText("Wrong user/password");
                        }
                    }
                    if (event.getSource() == btnSingUp) {
                        System.exit(0);
                    }

                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            private void arreglosDependencias() {
                String url = "jdbc:mysql://localhost:3307/?user=root&password=usbw";
                try {
                    conect = DriverManager.getConnection(url);
                    sentencia = conect.createStatement();

                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                    System.exit(1);
                }
                try {
                    if (!sentencia.executeQuery("show databases like 'TIENDACARTAS'").first()) {
                        createBBDD.crearTablas(sentencia);
                        System.out.println("--- Base de datos NEODATIS CREADA ---\n");
                    } else {
                        sentencia.execute("use TIENDACARTAS");
                        System.out.println("--- Base de datos NEODATIS CREADA ---\n");
                    }
                    Wonka.basedatos = true;

                } catch (SQLException e) {
                    System.out.println("Error: " + e);
                    System.exit(2);
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
