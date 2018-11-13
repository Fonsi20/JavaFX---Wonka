/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wonka;

import backend.createBBDD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.hibernate.SessionFactory;

/**
 * @author a16alfonsofa
 */
public class Wonka extends Application {

    private double x, y;
    private Stage primaryStage;
    static Connection conect;
    static Statement sentencia;
    static ResultSet res;
    static int op;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

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

        } catch (SQLException e) {
            System.out.println("Error: " + e);
            System.exit(2);
        }

        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();

        mostrarVentanaPrincipal();

    }

    public void mostrarVentanaPrincipal() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));
            primaryStage.initStyle(StageStyle.TRANSPARENT);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            moverPantalla(root);
            primaryStage.show();
        } catch (IOException e) {
        }
    }

    public void moverPantalla(Parent root) {

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
