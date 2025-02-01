public class Labirint {
    private final int[][] MAZE;
    private final int HEIGHT;
    private final int WIDTH;

    public Labirint(int[][] maze) {
        this.MAZE = maze;
        this.HEIGHT = maze.length;
        this.WIDTH = maze[0].length;

    }

    public void print(Player player) {

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (i == player.getRow() && j == player.getColumn()) {
                    System.out.print("P "); // Игрок
                } else if (MAZE[i][j] == 1) {
                    System.out.print("# "); // Стена
                } else if (MAZE[i][j] == 2) {
                    System.out.print("E "); // Выход
                } else {
                    System.out.print("  "); // Пустое пространство
                }
            }
            System.out.println();
        }
    }

    public int getCell(int row, int col) {
        return MAZE[row][col];
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }
}
