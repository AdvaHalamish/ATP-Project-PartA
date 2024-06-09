package algorithms.search;

import java.util.Collections;
import java.util.Map;

public abstract class ASearchingAlgorithm implements ISearchingAlgorithm {
    protected int numberOfNodesEvaluated;

    public ASearchingAlgorithm() {
        this.numberOfNodesEvaluated = 0;
    }

    public int getNumberOfNodesEvaluated() {
        return numberOfNodesEvaluated;
    }

// Inside ASearchingAlgorithm class

    protected Solution backtracePath(Map<AState, AState> predecessors, AState startState, AState goalState) {
        Solution solution = new Solution();
        AState currentState = goalState;

        while (!currentState.equals(startState)) {
            solution.addState(currentState);
            currentState = predecessors.get(currentState);
        }
        solution.addState(startState);

        // Reverse the path before returning
        Collections.reverse(solution.getSolutionPath());

        return solution;
    }

}
