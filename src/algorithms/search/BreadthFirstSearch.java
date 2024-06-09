package algorithms.search;

import java.util.*;

public class BreadthFirstSearch extends ASearchingAlgorithm {
    private int numberOfNodesEvaluated = 0;

    @Override
    public Solution solve(ISearchable domain) {
        numberOfNodesEvaluated = 0;
        Solution solution = new Solution();
        if (domain == null) return solution;

        Queue<AState> queue = new LinkedList<>();
        Set<AState> visited = new HashSet<>();

        AState startState = domain.getStartState();
        AState goalState = domain.getGoalState();
        queue.add(startState);
        visited.add(startState);

        Map<AState, AState> predecessors = new HashMap<>();

        while (!queue.isEmpty()) {
            AState currentState = queue.poll();
            numberOfNodesEvaluated++;
            if (currentState.equals(goalState)) {
                return backtracePath(predecessors, startState, goalState);
            }

            for (AState neighbor : domain.getAllPossibleStates(currentState)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                    predecessors.put(neighbor, currentState);
                }
            }
        }

        return solution;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numberOfNodesEvaluated;
    }

    @Override
    public String getName() {
        return "Breadth First Search";
    }

    protected Solution backtracePath(Map<AState, AState> predecessors, AState startState, AState goalState) {
        Solution solution = new Solution();
        AState currentState = goalState;

        while (!currentState.equals(startState)) {
            solution.addState(currentState);
            currentState = predecessors.get(currentState);
        }
        solution.addState(startState);
        Collections.reverse(solution.getSolutionPath());
        return solution;
    }
}
