package life;

public class Universe {
    CellState[][] grid;
    public static final int SIZE = 20;
    private int generation;

    Universe() {
        grid = new CellState[SIZE][SIZE];
        generation = 1;
    }

    public CellState getCell(int row, int column) {
        return grid[row][column];
    }

    public void setCell(int row, int column, CellState state) {
        grid[row][column] = state;
    }

    public int getNeighborCount(int row, int column) {
        int leftColumn = (SIZE + column - 1) % SIZE;
        int rightColumn = (column + 1) % SIZE;
        int upperRow = (SIZE + row - 1) % SIZE;
        int lowerRow = (row + 1) % SIZE;

        int northNeighborCount = grid[upperRow][column] == CellState.ALIVE ? 1 : 0;
        int eastNeighborCount = grid[row][rightColumn] == CellState.ALIVE ? 1 : 0;
        int westNeighborCount = grid[row][leftColumn] == CellState.ALIVE ? 1 : 0;
        int southNeighborCount = grid[lowerRow][column] == CellState.ALIVE ? 1 : 0;
        int northwestNeighborCount = grid[upperRow][leftColumn] == CellState.ALIVE ? 1 : 0;
        int northeastNeighborCount = grid[upperRow][rightColumn] == CellState.ALIVE ? 1 : 0;
        int southwestNeighborCount = grid[lowerRow][leftColumn] == CellState.ALIVE ? 1 : 0;
        int southeastNeighborCount = grid[lowerRow][rightColumn] == CellState.ALIVE ? 1 : 0;

        return northNeighborCount + eastNeighborCount + westNeighborCount + southNeighborCount +
                northwestNeighborCount + northeastNeighborCount + southwestNeighborCount + southeastNeighborCount;
    }

    public int getAliveCount() {
        int aliveCount = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == CellState.ALIVE) {
                    aliveCount++;
                }
            }
        }

        return aliveCount;
    }

    public int getGeneration() {
        return generation;
    }

    public void incrementGeneration() {
        generation++;
    }

    public void initGeneration() {
        generation = 1;
    }
}