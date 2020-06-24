package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * "VIEW" IN MODEL-VIEW-CONTROLLER, wasn't able to format class name due to instructions
 */

public class GameOfLife extends JFrame {

    private final JToggleButton playToggleButton = new JToggleButton("Pause");
    private final JButton resetButton = new JButton("Reset");
    private final JLabel generationLabel = new JLabel("Generation #1");
    private final JLabel aliveLabel = new JLabel("Alive: 0");
    private final JPanel gridPanel = new JPanel();
    private CellGrid cellGrid;
    private boolean paused = false;

    public GameOfLife() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 405);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        playToggleButton.setName("PlayToggleButton");
        resetButton.setName("ResetButton");
        generationLabel.setName("GenerationLabel");
        aliveLabel.setName("AliveLabel");

        JPanel buttonPanel = new JPanel();
        JPanel textPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.X_AXIS));
        gridPanel.setLayout(new BoxLayout(gridPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(playToggleButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        buttonPanel.add(resetButton);

        textPanel.add(generationLabel);
        textPanel.add(Box.createRigidArea(new Dimension(30, 0)));
        textPanel.add(aliveLabel);

        add(Box.createRigidArea(new Dimension(0, 5)));
        add(textPanel);
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(gridPanel);
        add(buttonPanel);
        add(Box.createRigidArea(new Dimension(0, 5)));
    }

    public boolean isPaused() {
        return paused;
    }

    public CellGrid getCellGrid() {
        return cellGrid;
    }

    public JPanel getGridPanel() {
        return gridPanel;
    }

    public void setPaused(boolean paused) {
        playToggleButton.setText(paused ? "Resume" : "Pause");
        this.paused = paused;
    }

    public void setGenerationLabel(int generation) {
        generationLabel.setText("Generation #" + generation);
    }

    public void setAliveLabel(int aliveCount) {
        aliveLabel.setText("Alive: " + aliveCount);
    }

    public void setCellGrid(Universe universe) {
        cellGrid = new CellGrid(universe);
    }

    public void addPlayToggleListener(ActionListener actionListener) {
        playToggleButton.addActionListener(actionListener);
    }

    public void addResetListener(ActionListener actionListener) {
        resetButton.addActionListener(actionListener);
    }
}
