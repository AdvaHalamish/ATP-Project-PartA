package algorithms.search;

import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm {
    private int numberOfNodesEvaluated = 0;

    @Override
    public Solution solve(ISearchable domain) {
        numberOfNodesEvaluated = 0;
        Solution solution = new Solution();
        if (domain == null) return solution;

        PriorityQueue<AState> openList = new PriorityQueue<>(Comparator.comparingDouble(AState::getCost));
        Set<AState> closedList = new HashSet<>();

        AState startState = domain.getStartState();
        AState goalState = domain.getGoalState();
        startState.setCost(0);
        openList.add(startState);

        Map<AState, AState> predecessors = new HashMap<>();

        while (!openList.isEmpty()) {
            AState currentState = openList.poll();
            numberOfNodesEvaluated++;

            if (currentState.equals(goalState)) {
                return backtracePath(predecessors, startState, goalState);
            }

            closedList.add(currentState);

            for (AState neighbor : domain.getAllPossibleStates(currentState)) {
                if (!closedList.contains(neighbor) && !openList.contains(neighbor)) {
                    neighbor.setCost(currentState.getCost() + domain.getMoveCost(currentState, neighbor));
                    openList.add(neighbor);
                    predecessors.put(neighbor, currentState);
                } else if (openList.contains(neighbor)) {
                    double newCost = currentState.getCost() + domain.getMoveCost(currentState, neighbor);
                    if (newCost < neighbor.getCost()) {
                        neighbor.setCost(newCost);
                        predecessors.put(neighbor, currentState);
                    }
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
        return "Best First Search";
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

