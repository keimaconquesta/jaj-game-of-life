package life;

import java.util.Random;

public class GameOfLifeModel {

    Universe currentUniverse = new Universe();
    Universe nextUniverse = new Universe();

    public void initUniverse() {
        currentUniverse.initGeneration();
        nextUniverse.initGeneration();
        Random random = new Random();

        for (int i = 0; i < Universe.SIZE; i++) {
            for (int j = 0; j < Universe.SIZE; j++) {
                CellState cellState = random.nextBoolean() ? CellState.ALIVE : CellState.DEAD;
                currentUniverse.setCell(i, j, cellState);
                nextUniverse.setCell(i ,j, cellState);
            }
        }
    }

    public void updateUniverse(Universe currentUniverse, Universe nextUniverse) {
        // changing next universe based on evolution rules
        for (int i = 0; i < Universe.SIZE; i++) {
            for (int j = 0; j < Universe.SIZE; j++) {
                int neighborCount = currentUniverse.getNeighborCount(i, j);
                CellState cellState = currentUniverse.getCell(i, j);

                if (cellState == CellState.DEAD && neighborCount == 3) {
                    nextUniverse.setCell(i, j, CellState.ALIVE);
                } else if (cellState == CellState.ALIVE &&
                        (neighborCount < 2 || neighborCount > 3)) {
                    nextUniverse.setCell(i, j, CellState.DEAD);
                }
            }
        }

        // changing current universe to next universe
        for (int i = 0; i < Universe.SIZE; i++) {
            for (int j = 0; j < Universe.SIZE; j++) {
                CellState newState = nextUniverse.getCell(i, j);
                currentUniverse.setCell(i, j, newState);
            }
        }
        this.nextUniverse = nextUniverse;
        this.currentUniverse = currentUniverse;
    }

    public Universe getCurrentUniverse() {
        return currentUniverse;
    }

    public Universe getNextUniverse() {
        return nextUniverse;
    }

    public void incrementGeneration() {
        currentUniverse.incrementGeneration();
        nextUniverse.incrementGeneration();
    }
}
