package dad.ahorcado;

import dad.ahorcado.palabras.PalabrasController;
import dad.ahorcado.partida.PartidaController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class RootController implements Initializable {

    @FXML
    private Tab partidaTab;

    @FXML
    private Tab palabrasTab;

    @FXML
    private Tab puntuacionesTab;

    @FXML
    private TabPane rootPane;

    private PartidaController partidaController;
    private PalabrasController palabrasController;

    private List<String> wordList;
    private Properties records;

    private Random random;

    public RootController() {
        this.wordList = new ArrayList<>();
        wordList.add("EL BICHO SIUUU");
        wordList.add("prueBa");
        wordList.add("Test");
        loadRecords();
        records.put("pl1", "4");
        records.put("pl2", "43");
        records.put("pl3", "35");
        saveRecords();
        this.random = new Random();

        partidaController = new PartidaController(this);
        palabrasController = new PalabrasController();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Ahorcado.class.getResource("Ahorcado.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadRecords() {
        this.records = new Properties();
        try {
            records.load(new FileInputStream("records.properties"));
        } catch (IOException e) {
        }
    }

    private void saveRecords() {
        try {
            records.store(new FileWriter("records.properties"), "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        partidaTab.setContent(partidaController.getView().getPane());
        palabrasTab.setContent(palabrasController.getView().getRoot());
    }

    public String getRandomWord() {
        return wordList.get(random.nextInt(wordList.size()));
    }

    public TabPane getRootPane() {
        return rootPane;
    }

}