package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int columns, int rows) {
        Maze Simple = new Maze(columns,rows);

        // creating Empty Maze
        EmptyMazeGenerator empty = new EmptyMazeGenerator();
        Maze EmptyMaze = empty.generate(columns,rows);
        // picking random Start and Exit Positions.
        PickExitPosition(EmptyMaze);
        PickStartPosition(EmptyMaze);
        Position Start = EmptyMaze.getStartPosition();
        Position Exit = EmptyMaze.getGoalPosition();

        // setting a random walls
        for (int r =0 ; r<rows;r++) {
            for (int c = 0; c < columns; c++) {

                Simple.getMaze()[r][c] = 1;
            }
        }

        //creating a path from start to exit position

        if (Start.getRowIndex() < Exit.getRowIndex()){
            for (int i = Start.getRowIndex();i<=Exit.getRowIndex();i++){
                Simple.getMaze()[i][Start.getColumnIndex()] = 0;
            }
        }
        if (Start.getRowIndex() > Exit.getRowIndex()){
            for (int i = Start.getRowIndex();i>=Exit.getRowIndex();i--){
                Simple.getMaze()[i][Start.getColumnIndex()] = 0;
            }
        }
        if (Start.getColumnIndex() < Exit.getColumnIndex()){
            for (int i = Start.getColumnIndex() ; i <= Exit.getColumnIndex();i++){
                Simple.getMaze()[Exit.getRowIndex()][i] = 0;
            }
        }
        if (Start.getColumnIndex() > Exit.getColumnIndex()){
            for (int i = Start.getColumnIndex() ; i >= Exit.getColumnIndex();i--){
                Simple.getMaze()[Exit.getRowIndex()][i] = 0;
            }
        }
        // setting a random walls
        for (int r =0 ; r<rows;r++){
            for (int c = 0; c< columns;c++){
                if (Simple.getMaze()[r][c] != 0 ) {
                    if (Math.random() > 0.5) {
                        Simple.getMaze()[r][c] = 1;
                    } else {
                        Simple.getMaze()[r][c] = 0;
                    }
                }
            }
        }


        Simple.setStart(Start);
        Simple.setExit(Exit);
        return Simple;

    }
}
