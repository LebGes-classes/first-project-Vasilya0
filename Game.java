
import java.util.Scanner;

public class Game {
    private Console console = new Console();
    private Labirint labirint;
    private Player player;
    private Scanner sc = new Scanner(System.in);
    private Menu endLab = new Menu();
    private Menu menu = new Menu();


    public void start() {
        int labHeight = 11;
        int labWidth = 15;
        LabirintGenerator generator = new LabirintGenerator(labHeight, labWidth);
        int[][] generatedLab = generator.generate();
        labirint = new Labirint(generatedLab);
        player = new Player(0, 1); // Начальная позиция игрока

        boolean gameRunning = true;
        while (gameRunning) {
            console.clear();
            labirint.print(player);
            if (isAtExit()) {
                System.out.println("Ура! Вы победили!");

                endLab.gameEnd();
                gameRunning = false;
            } else {
                System.out.println("Используйте w/a/s/d для перемещения: ");
                System.out.println("Используйте q для выхода из игры");
                char move = sc.next().charAt(0);
                movePlayer(move);
            }
        }
        sc.nextLine();

    }


    private void movePlayer(char move) {
        int currentRow = player.getRow();
        int currentCol = player.getColumn();
        int newRow = currentRow;
        int newCol = currentCol;

        switch (move) {
            case 'w':
                newRow--;
                break;
            case 's':
                newRow++;
                break;
            case 'a':
                newCol--;
                break;
            case 'd':
                newCol++;
                break;
            case 'q':

                menu.run();
                break;
        }
        if (isValidMove(newRow, newCol)) {
            player.movePlayer(newRow, newCol);
        } else {
            System.out.println("Сюда нельзя!\n");
        }
    }

    private boolean isValidMove(int row, int col) {
        if (row < 0 || row >= labirint.getHEIGHT() || col < 0 || col >= labirint.getWIDTH()) {
            return false;
        }
        return labirint.getCell(row, col) != 1;
    }

    private boolean isAtExit() {
        return labirint.getCell(player.getRow(), player.getColumn()) == 2;
    }
}

