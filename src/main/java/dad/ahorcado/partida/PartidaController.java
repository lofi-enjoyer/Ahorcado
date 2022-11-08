package dad.ahorcado.partida;

import dad.ahorcado.Ahorcado;
import dad.ahorcado.RootController;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class PartidaController {

    private static final int MAX_ERRORS = 8;

    private RootController rootController;

    private PartidaView view;
    private PartidaModel model;

    private List<Character> letters;
    private List<Character> remainingLetters;

    private String currentWord;
    private int currentPoints;
    private int errors;

    public PartidaController(RootController rootController) {
        this.rootController = rootController;
        this.view = new PartidaView();
        this.model = new PartidaModel();

        this.letters = new ArrayList<>();
        this.remainingLetters = new ArrayList<>();
        currentWord = "prueba";

        view.getLetterButton().setOnAction(this::addLetter);
        view.getPointsLabel().textProperty().bind(model.pointsProperty());
        view.getWordTextField().textProperty().bindBidirectional(model.wordTextProperty());
        view.getLettersLabel().textProperty().bind(model.lettersProperty());
        view.getCurrentWordLabel().textProperty().bind(model.wordProperty());
        view.getResolveButton().setOnAction(this::resolve);

        loadWord("mondongo");
        model.setPoints(String.valueOf(0));

        view.getImageView().setImage(new Image(Ahorcado.class.getResourceAsStream((errors + 1) + ".png")));
    }

    private void loadWord(String word) {
        currentWord = word.toLowerCase();
        letters.clear();
        remainingLetters.clear();
        String placeholder = "";
        for (int i = 0; i < word.length(); i++) {
            placeholder += "_";
            if (!remainingLetters.contains(word.charAt(i)))
                remainingLetters.add(word.charAt(i));
        }
        model.setWord(placeholder);

        model.setLetters("");
    }

    private void addLetter(ActionEvent event) {
        if (remainingLetters.size() == 0) {
            loadWord("prueba");
            return;
        }

        String fieldWord = model.getWordText();
        if (fieldWord == null) {
            model.setWordText("");
            fieldWord = model.getWordText();
        }

        model.setWordText("");
        model.setLetters("");

        fieldWord = fieldWord.toLowerCase();
        if (fieldWord.length() == 1) {
            char newChar = fieldWord.charAt(0);
            if (!letters.contains(newChar))
                letters.add(newChar);

            if (remainingLetters.contains(fieldWord.charAt(0))) {
                currentPoints++;
                model.setPoints(String.valueOf(currentPoints));
                remainingLetters.remove((Character) fieldWord.charAt(0));
            } else {
                errors++;
            }
        }

        updateWordDisplay();

        letters.forEach(letter -> {
            model.setLetters(model.getLetters() + letter);
        });
    }

    private void resolve(ActionEvent event) {

    }

    private void updateWordDisplay() {
        String wordDisplay = "";
        for (int i = 0; i < currentWord.length(); i++) {
            if (letters.contains(currentWord.charAt(i))) {
                wordDisplay += currentWord.charAt(i);
            } else {
                wordDisplay += "_";
            }
        }

        model.setWord(wordDisplay);

        if (errors <= MAX_ERRORS) {
            view.getImageView().setImage(new Image(Ahorcado.class.getResourceAsStream((errors + 1) + ".png")));
        } else {
            errors = 0;
            currentPoints = 0;
            loadWord(rootController.getRandomWord());
        }
    }

    public PartidaView getView() {
        return view;
    }

}
