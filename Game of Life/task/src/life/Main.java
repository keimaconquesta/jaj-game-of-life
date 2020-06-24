package life;

public class Main {
    public static void main(String[] args) {
        GameOfLifeModel model = new GameOfLifeModel();
        GameOfLife view = new GameOfLife();
        new GameOfLifeController(model, view);
        view.setVisible(true);
    }
}
