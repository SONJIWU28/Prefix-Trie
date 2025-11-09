import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Главный класс программы для работы с префиксным деревом (Trie)
 */
public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(trie, scanner);

        System.out.println(Constants.APP_TITLE);

        // Основной цикл программы
        while (true) {
            menu.printMenu();
            System.out.print(Constants.CHOICE_PROMPT);

            int choice = -1;

            // Обработка исключения при вводе не числа
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(Constants.INVALID_CHOICE);
                continue;
            }

            // Выход из программы
            if (choice == 0) {
                System.out.println(Constants.EXIT_MESSAGE);
                break;
            }

            // Обработка выбора пользователя
            switch (choice) {
                case 1:
                    menu.handleInsert();
                    break;
                case 2:
                    menu.handleContains();
                    break;
                case 3:
                    menu.handleStartsWith();
                    break;
                case 4:
                    menu.handleGetByPrefix();
                    break;
                case 5:
                    menu.handleGetByLength();
                    break;
                case 6:
                    menu.handleRemove();
                    break;
                case 7:
                    menu.handleSaveToFile();
                    break;
                case 8:
                    menu.handleLoadFromFile();
                    break;
                case 9:
                    menu.handleSize();
                    break;
                default:
                    System.out.println(Constants.INVALID_CHOICE);
            }
        }

        scanner.close();
    }
}