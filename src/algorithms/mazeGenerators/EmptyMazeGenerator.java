package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator{
    @Override
    public Maze generate(int columns, int rows) {
        return new Maze(columns,rows);
    }
}
