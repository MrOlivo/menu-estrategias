package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Main extends Application {

    @Override
    public void start(@NotNull Stage primaryStage) throws Exception {
        FXMLLoader fxmlloader = new FXMLLoader();
        Parent root = fxmlloader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Menú de estrategias");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}