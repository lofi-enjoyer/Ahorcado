package dad.ahorcado.partida;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PartidaModel {

    private StringProperty currentWord = new SimpleStringProperty();
    private StringProperty points = new SimpleStringProperty();
    private StringProperty wordText = new SimpleStringProperty();
    private StringProperty letters = new SimpleStringProperty();
    private StringProperty word = new SimpleStringProperty();

    public String getCurrentWord() {
        return currentWord.get();
    }

    public StringProperty currentWordProperty() {
        return currentWord;
    }

    public void setCurrentWord(String currentWord) {
        this.currentWord.set(currentWord);
    }

    public String getPoints() {
        return points.get();
    }

    public StringProperty pointsProperty() {
        return points;
    }

    public void setPoints(String points) {
        this.points.set(points);
    }

    public String getWordText() {
        return wordText.get();
    }

    public StringProperty wordTextProperty() {
        return wordText;
    }

    public void setWordText(String wordText) {
        this.wordText.set(wordText);
    }

    public String getLetters() {
        return letters.get();
    }

    public StringProperty lettersProperty() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters.set(letters);
    }

    public String getWord() {
        return word.get();
    }

    public StringProperty wordProperty() {
        return word;
    }

    public void setWord(String word) {
        this.word.set(word);
    }

}
