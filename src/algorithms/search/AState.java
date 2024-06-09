package algorithms.search;

public abstract class AState {
    private String state;
    private double cost;

    public AState(String state) {
        this.state = state;
        this.cost = 0;
    }

    public String getState() {
        return state;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AState aState = (AState) obj;
        return state.equals(aState.state);
    }

    @Override
    public int hashCode() {
        return state.hashCode();
    }

    @Override
    public String toString() {
        return state;
    }
}
