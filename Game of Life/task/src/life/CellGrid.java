package life;

import javax.swing.*;
import java.awt.*;

public class CellGrid extends JPanel {
    Universe universe;
    private static final int CELL_DIMEN = 15;

    CellGrid() {
        setSize(300, 300);
        setVisible(true);
    }

    CellGrid(Universe universe) {
        this.universe = universe;
        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < Universe.SIZE; i++) {
            for (int j = 0; j < Universe.SIZE; j++) {
                if (universe.getCell(i, j) == CellState.ALIVE) {
                    g.fillRect(i * CELL_DIMEN, j * CELL_DIMEN, CELL_DIMEN, CELL_DIMEN);
                } else {
                    g.drawRect(i * CELL_DIMEN, j * CELL_DIMEN, CELL_DIMEN, CELL_DIMEN);
                }
            }
        }
    }
}