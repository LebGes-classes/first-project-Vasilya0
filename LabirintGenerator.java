public class LabirintGenerator {
    private int height;
    private int width;
    private int[][] labirint;

    public LabirintGenerator(int height, int width) {
        this.height = height;
        this.width = width;
        this.labirint = new int[height][width];
    }

    public int[][] generate() {
        // Инициализируем лабиринт стенами
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                labirint[i][j] = 1; // 1 - стена
            }
        }
        // Генерируем лабиринт рекурсивным обходом
        generateRecursive(1, 1);
        // Делаем вход и выход
        makeEntranceAndExit();
        return labirint;
    }

    private void makeEntranceAndExit() {
        labirint[0][1] = 0;
        labirint[height - 1][width - 2] = 2;
    }

    private void generateRecursive(int row, int col) {
        labirint[row][col] = 0; // 0 - проход

        int[][] directions = {{-2, 0}, {2, 0}, {0, -2}, {0, 2}};
        shuffleArray(directions);

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow > 0 && newRow < height - 1 && newCol > 0 && newCol < width - 1 && labirint[newRow][newCol] == 1) {
                labirint[row + dir[0] / 2][col + dir[1] / 2] = 0;
                generateRecursive(newRow, newCol);
            }
        }
    }

    private void shuffleArray(int[][] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int[] temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
