package dad.ahorcado.palabras;

public class PalabrasController {

    private final PalabrasView view;

    public PalabrasController() {
        this.view = new PalabrasView();
    }

    public PalabrasView getView() {
        return view;
    }
}
