package wonka;

import backend.createBBDD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author a16alfonsofa
 */
public class Wonka extends Application {

    private double x, y;
    public Stage primaryStage;
    public static Connection conect;
    public static Statement sentencia;
    public static ResultSet res;
    public static int op;
    public static boolean basedatos;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        primaryStage.getIcons().add(new Image("images/Magic.png")); 
        mostrarVentanaPrincipal();

    }

    public void mostrarVentanaPrincipal() throws IOException {
        try {
            Locale locale = new Locale("en", "US");
            ResourceBundle bundle = ResourceBundle.getBundle("strings", locale);
            Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"), bundle);
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
