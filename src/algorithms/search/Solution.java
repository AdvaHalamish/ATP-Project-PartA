package algorithms.search;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private ArrayList<AState> path;

    public Solution() {
        this.path = new ArrayList<>();
    }

    public void addState(AState state) {
        path.add(state);
    }

    public ArrayList<AState> getSolutionPath() {
        return path;
    }

}
