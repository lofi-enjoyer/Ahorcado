package dad.ahorcado;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ahorcado extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new RootController().getRootPane(), 640, 480);
        stage.setTitle("Ahorcado");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}