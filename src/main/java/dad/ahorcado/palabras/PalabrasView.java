package dad.ahorcado.palabras;

import dad.ahorcado.Ahorcado;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class PalabrasView {

    private HBox root;

    public PalabrasView() {
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(Ahorcado.class.getResource("PalabrasTab.fxml"));
            loader.setController(this);
            this.root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public HBox getRoot() {
        return root;
    }
}
