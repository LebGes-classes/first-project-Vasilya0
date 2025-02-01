import java.util.Scanner;

public class Menu {
    private final Console console = new Console();
    private final Scanner scanner = new Scanner(System.in);
    private int level = 1;




    public void run() {
        boolean running = true;
        while (running) {
            console.clear();
            System.out.println(" Меню:");
            System.out.println("1. Старт");
            System.out.println("2. Правила");
            System.out.println("3. Стоп");
            System.out.println("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ваш уровень: " + level);
                    play();
                    break;
                case 2:
                    rules();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Попробуйте еще раз.\n");
            }
        }
        //scanner.close();
    }

    private void play() {
        Game game = new Game();
        game.start();
    }

    public void gameEnd() {
        level ++;
        boolean end = true;
        while (end) {
            console.clear();
            System.out.println("1. Следующий уровень");
            System.out.println("2. Стоп");
            System.out.println("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ваш уровень: " + level);
                    play();
                    break;
                case 2:
                    end = false;
                    break;
                default:
                    System.out.println("Попробуйте еще раз.\n");
            }
        }
        scanner.close();
        }


    private void rules() {
        console.clear();
        System.out.println("Правила:\n");
        System.out.println("1. Игрок (@) должен дойти до выхода (!).\n");
        System.out.println("2. Для передвижения используйте клавиши 'w', 'a', 's', 'd'.\n");
        System.out.println("3. Нажмите Enter, чтобы вернуться в меню.\n");
        scanner.nextLine();
    }
}