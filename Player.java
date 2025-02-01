public class Player {
    private int row; // строка
    private int column; // столбец

    public Player(int startRow, int startCol) {
        this.row = startRow;
        this.column = startCol;

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void movePlayer(int newRow, int newCol) {
        this.row = newRow;
        this.column = newCol;
    }
}
