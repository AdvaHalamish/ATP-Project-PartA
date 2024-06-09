package algorithms.mazeGenerators;

public class Position {
    private int rowIndex;
    private int columnIndex;

    // Constructor
    public Position(int rowIndex, int columnIndex) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
    }

    // Getters
    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    // Overriding toString() method to return position in {column,row} format
    @Override
    public String toString() {
        return "{" + columnIndex + "," + rowIndex + "}";
    }

    public void setColIndex(int colInd) {
        columnIndex=colInd;
    }

    public void setRowIndex(int rowInd) {
        rowIndex=rowInd;
    }

    public int Compare(Position other){
        if (this.getColumnIndex() == other.getColumnIndex() && this.getRowIndex() == other.getRowIndex()){
            return 0;
        }
        return 1;
    }

}
