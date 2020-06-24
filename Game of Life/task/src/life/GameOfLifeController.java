package life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOfLifeController {
    private final GameOfLifeModel model;
    private final GameOfLife view;
    private boolean reset = false;

    public GameOfLifeController(GameOfLifeModel model, GameOfLife view) {
        this.model = model;
        this.view = view;
        this.view.addPlayToggleListener(new PlayToggleListener());
        this.view.addResetListener(new ResetListener());
        init();
        update();
    }

    public void init() {
        model.initUniverse();
        view.setGenerationLabel(model.getCurrentUniverse().getGeneration());
        view.setAliveLabel(model.getCurrentUniverse().getAliveCount());
        view.setCellGrid(model.getCurrentUniverse());
        view.getGridPanel().add(view.getCellGrid());
        view.setVisible(true);
    }

    public void update() {
        while (!reset) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!view.isPaused() && !reset) {
                model.incrementGeneration();
                model.updateUniverse(model.getCurrentUniverse(), model.getNextUniverse());
                view.setGenerationLabel(model.getCurrentUniverse().getGeneration());
                view.setAliveLabel(model.getCurrentUniverse().getAliveCount());
                view.repaint();
                view.revalidate();
            }
        }
    }

    class PlayToggleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean paused = view.isPaused();
            view.setPaused(!paused);
        }
    }

    class ResetListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            reset = true;
            model.initUniverse();
            view.setGenerationLabel(model.getCurrentUniverse().getGeneration());
            view.setAliveLabel(model.getCurrentUniverse().getAliveCount());
            view.setCellGrid(model.getCurrentUniverse());
            view.repaint();
            view.revalidate();
            reset = false;
        }
    }
}

