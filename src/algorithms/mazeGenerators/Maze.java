package algorithms.mazeGenerators;

public class Maze {
    private int columns;
    private int rows;
    private int[][] grid;
    private Position startPosition;
    private Position goalPosition;

    // Constructor
    public Maze(int columns, int rows) {
        if (columns < 2 || rows < 2){
            this.rows = 3;
            this.columns = 3;
            this.grid = new int[3][3];

        }
        else {
            this.columns = columns;
            this.rows = rows;
            this.grid = new int[rows][columns];
        }

        this.startPosition = new Position(0, 0); // Default start position
        this.goalPosition = new Position(this.rows - 1, this.columns - 1); // Default goal position
    }

    // Getters
    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public int[][] getGrid() {
        return grid;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getGoalPosition() {
        return goalPosition;
    }

    public void setStart(Position start) {
        startPosition = start;
    }

    public void setExit(Position exit) {
        goalPosition = exit;
    }


    // Method to print the maze
    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == startPosition.getRowIndex() && j == startPosition.getColumnIndex()) {
                    System.out.print("S ");
                } else if (i == goalPosition.getRowIndex() && j == goalPosition.getColumnIndex()) {
                    System.out.print("E ");
                } else {
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public int[][] getMaze() {
        return grid;
    }

}
