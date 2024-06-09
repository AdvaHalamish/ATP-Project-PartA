package algorithms.search;

import java.util.ArrayList;

public interface ISearchable {
    AState getStartState();
    AState getGoalState();
    ArrayList<AState> getAllPossibleStates(AState state);
    double getMoveCost(AState currentState, AState neighbor);
    double getCost(AState state);
}
