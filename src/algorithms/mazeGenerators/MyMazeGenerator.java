package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int rows, int cols) {
        Maze MyMaze = new Maze(rows, cols);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                MyMaze.getMaze()[r][c] = 1;
            }
        }
        PickStartPosition(MyMaze);
        ArrayList<Position> wallList = new ArrayList<>();
        Position startpos = MyMaze.getStartPosition();
        wallList.add(startpos);
        Random random = new Random();
        Position currentpos;
        while (!wallList.isEmpty()) {
            currentpos = wallList.remove(random.nextInt(wallList.size()));
            if (oneVisitor(MyMaze, currentpos) < 2) {
                MyMaze.getMaze()[currentpos.getRowIndex()][currentpos.getColumnIndex()] = 0;
                getNeighbors(wallList, MyMaze, currentpos);
            }
        }
        PickExitPosition(MyMaze);
        return MyMaze;
    }

    private static int legal_Position(Maze maze, Position position) {
        if (position.getRowIndex() < 0 || position.getRowIndex() >= maze.getRows() ||
                position.getColumnIndex() < 0 || position.getColumnIndex() >= maze.getColumns()) {
            return 0;
        }
        return 1;
    }

    private static void getNeighbors(ArrayList<Position> wallList, Maze maze, Position pos) {
        Position[] neighbors = {
                new Position(pos.getRowIndex() + 1, pos.getColumnIndex()),
                new Position(pos.getRowIndex() - 1, pos.getColumnIndex()),
                new Position(pos.getRowIndex(), pos.getColumnIndex() - 1),
                new Position(pos.getRowIndex(), pos.getColumnIndex() + 1)
        };

        for (Position neighbor : neighbors) {
            if (legal_Position(maze, neighbor) == 1 && maze.getMaze()[neighbor.getRowIndex()][neighbor.getColumnIndex()] == 1) {
                wallList.add(neighbor);
            }
        }
    }

    private static int oneVisitor(Maze maze, Position pos) {
        Position[] neighbors = {
                new Position(pos.getRowIndex() + 1, pos.getColumnIndex()),
                new Position(pos.getRowIndex() - 1, pos.getColumnIndex()),
                new Position(pos.getRowIndex(), pos.getColumnIndex() - 1),
                new Position(pos.getRowIndex(), pos.getColumnIndex() + 1)
        };

        int numOfVisited = 0;
        for (Position neighbor : neighbors) {
            if (legal_Position(maze, neighbor) == 1 && maze.getMaze()[neighbor.getRowIndex()][neighbor.getColumnIndex()] == 0) {
                numOfVisited++;
            }
        }

        return numOfVisited;
    }
}
