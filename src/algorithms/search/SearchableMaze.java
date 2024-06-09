package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {
    private Maze maze;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        return new MazeState(maze.getStartPosition().getRowIndex(), maze.getStartPosition().getColumnIndex());
    }

    @Override
    public AState getGoalState() {
        return new MazeState(maze.getGoalPosition().getRowIndex(), maze.getGoalPosition().getColumnIndex());
    }

    @Override
    public ArrayList<AState> getAllPossibleStates(AState state) {
        ArrayList<AState> neighbors = new ArrayList<>();
        MazeState mazeState = (MazeState) state;
        int row = mazeState.getRow();
        int col = mazeState.getCol();

        addNeighborIfValid(neighbors, row - 1, col); // Up
        addNeighborIfValid(neighbors, row + 1, col); // Down
        addNeighborIfValid(neighbors, row, col - 1); // Left
        addNeighborIfValid(neighbors, row, col + 1); // Right
        addNeighborIfValid(neighbors, row - 1, col - 1); // Up-Left
        addNeighborIfValid(neighbors, row - 1, col + 1); // Up-Right
        addNeighborIfValid(neighbors, row + 1, col - 1); // Down-Left
        addNeighborIfValid(neighbors, row + 1, col + 1); // Down-Right

        return neighbors;
    }

    private void addNeighborIfValid(ArrayList<AState> neighbors, int row, int col) {
        if (row >= 0 && col >= 0 && row < maze.getRows() && col < maze.getColumns() && maze.getGrid()[row][col] == 0) {
            neighbors.add(new MazeState(row, col));
        }
    }
    public double getMoveCost(AState currentState, AState neighbor) {
        // Assuming each move has a constant cost of 1
        return 1.0;
    }

    @Override
    public double getCost(AState state) {
        return 0;
    }
}
