package home;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private double x, y;

    @Override
    public void start(Stage primaryStage) throws Exception {

        //CARGAMOS EL XML DE NUESTRA VENTANA PRINCIPAL
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        primaryStage.setScene(new Scene(root));
        //PARA QUE NUESTRA VENTANA NO TENGA BORDES!
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //CON ESO HACEMOS QUE PODAMOS MOVER LA PANTALLA CLIKCANDO CON EL RATÓN SOBRE ELLA
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        primaryStage.show();
    }


    //LANZAMOS EL MÉTODO START
    public static void main(String[] args) {
        launch(args);
    }
}
