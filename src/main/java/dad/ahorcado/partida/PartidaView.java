package dad.ahorcado.partida;

import dad.ahorcado.Ahorcado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class PartidaView {

    private GridPane rootPane;

    @FXML
    private Label pointsLabel;

    @FXML
    private TextField wordTextField;

    @FXML
    private Button letterButton;

    @FXML
    private Button resolveButton;

    @FXML
    private Label currentWordLabel;

    @FXML
    private Label lettersLabel;

    @FXML
    private ImageView imageView;

    public PartidaView() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Ahorcado.class.getResource("PartidaTab.fxml"));
            fxmlLoader.setController(this);
            rootPane = fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GridPane getPane() {
        return rootPane;
    }

    public Button getLetterButton() {
        return letterButton;
    }

    public Button getResolveButton() {
        return resolveButton;
    }

    public Label getPointsLabel() {
        return pointsLabel;
    }

    public TextField getWordTextField() {
        return wordTextField;
    }

    public Label getLettersLabel() {
        return lettersLabel;
    }

    public Label getCurrentWordLabel() {
        return currentWordLabel;
    }

    public ImageView getImageView() {
        return imageView;
    }

}
