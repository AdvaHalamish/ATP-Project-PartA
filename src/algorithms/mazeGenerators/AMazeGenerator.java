package algorithms.mazeGenerators;

import java.util.Random;

public abstract class AMazeGenerator implements IMazeGenerator {
    @Override
    public abstract Maze generate(int columns, int rows);

    public long measureAlgorithmTimeMillis(int columns, int rows) {
        long startTime = System.currentTimeMillis();
        generate(columns, rows);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
    public void PickStartPosition(Maze maze){
        Random rand = new Random();
        int RowInd = rand.nextInt(maze.getRows());
        int ColInd = rand.nextInt(maze.getColumns());
        while (RowInd != 0 && ColInd != 0){
            RowInd = rand.nextInt(maze.getRows());
            ColInd = rand.nextInt(maze.getColumns());
        }
        Position startPos = new Position(RowInd,ColInd);
        maze.setStart(startPos);
    }
    public void PickExitPosition(Maze maze){
        Random rand = new Random();
        int RowInd = rand.nextInt(maze.getRows());
        int ColInd = rand.nextInt(maze.getColumns());
        Position EndPos = new Position(RowInd,ColInd);
        while ((RowInd != 0 && ColInd != 0 && RowInd != maze.getRows() -1 && ColInd != maze.getColumns() - 1) || (maze.getStartPosition().Compare(EndPos) == 0) || maze.getMaze()[EndPos.getRowIndex()][EndPos.getColumnIndex()] == 1)
        {
            RowInd = rand.nextInt(maze.getRows());
            ColInd = rand.nextInt(maze.getColumns());
            EndPos.setColIndex(ColInd) ;
            EndPos.setRowIndex(RowInd);
        }
        maze.setExit(EndPos);

    }
}
