package algorithms.search;

import algorithms.mazeGenerators.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {
    private BestFirstSearch bestbfs = new BestFirstSearch();
    private EmptyMazeGenerator emptyMazeGenerator = new EmptyMazeGenerator();
    private MyMazeGenerator myMazeGenerator = new MyMazeGenerator();
    private SimpleMazeGenerator simpleMazeGenerator = new SimpleMazeGenerator();

    @Test
    void getName() {
        assertEquals("Best First Search", bestbfs.getName());
    }

    @Test
    void solveEmptyMaze() {
        assertEquals(1, checkRoads(emptyMazeGenerator, 5, 5));
        assertEquals(1, checkRoads(emptyMazeGenerator, -5, 5));
        assertEquals(1, checkRoads(emptyMazeGenerator, 5, -5));
        assertEquals(1, checkRoads(emptyMazeGenerator, 555, 900));
        assertEquals(1, checkRoads(emptyMazeGenerator, 1, 1));
    }

    @Test
    void solveMyMaze() {
        assertEquals(1, checkRoads(myMazeGenerator, 0, 0));
        assertEquals(1, checkRoads(myMazeGenerator, -5, 5));
        assertEquals(1, checkRoads(myMazeGenerator, 5, -5));
   //     assertEquals(1, checkRoads(myMazeGenerator, 23, 20));
   //     assertEquals(1, checkRoads(myMazeGenerator, 555, 900));
    }

    @Test
    void solveSimpleMaze() {
        assertEquals(1, checkRoads(simpleMazeGenerator, 1, 1));
        assertEquals(1, checkRoads(simpleMazeGenerator, 5, -5));
        assertEquals(1, checkRoads(simpleMazeGenerator, -5, 5));
        assertEquals(1, checkRoads(simpleMazeGenerator, 55, 25));
        assertEquals(1, checkRoads(simpleMazeGenerator, 600, 900));
    }

    // Helper method to check the solution path
    private int checkRoads(AMazeGenerator mazeGenerator, int rows, int columns) {
        Maze maze = mazeGenerator.generate(rows, columns);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        Solution solution = bestbfs.solve(searchableMaze);

        ArrayList<AState> solutionPath = solution.getSolutionPath();

        // Check start and goal states
        if (solutionPath.isEmpty() || !(solutionPath.get(0).equals(searchableMaze.getStartState()))||
                !(solutionPath.get(solutionPath.size() - 1).equals(searchableMaze.getGoalState()))) {
            return 0;
        }

        // Check if solution path contains valid states
        for (AState state : solutionPath) {
            MazeState mazeState = (MazeState) state;
            if (maze.getMaze()[mazeState.getRow()][mazeState.getCol()] == 1) {
                return 0;
            }
        }

        return 1;
    }
}