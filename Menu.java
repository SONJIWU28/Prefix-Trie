import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Класс для работы с меню программы
 */
public class Menu {
    private final Trie trie;
    private final Scanner scanner;

    public Menu(Trie trie, Scanner scanner) {
        this.trie = trie;
        this.scanner = scanner;
    }

    /**
     * Вывод меню на экран
     */
    public void printMenu() {
        System.out.println(Constants.MENU_HEADER);
        System.out.println(Constants.MENU_INSERT);
        System.out.println(Constants.MENU_CONTAINS);
        System.out.println(Constants.MENU_STARTS_WITH);
        System.out.println(Constants.MENU_GET_BY_PREFIX);
        System.out.println(Constants.MENU_GET_BY_LENGTH);
        System.out.println(Constants.MENU_REMOVE);
        System.out.println(Constants.MENU_SAVE);
        System.out.println(Constants.MENU_LOAD);
        System.out.println(Constants.MENU_SIZE);
        System.out.println(Constants.MENU_EXIT);
    }

    /**
     * Обработка вставки слова
     */
    public void handleInsert() {
        System.out.print(Constants.ENTER_WORD);
        String word = scanner.nextLine();
        try {
            boolean inserted = trie.insert(word);
            if (inserted) {
                System.out.printf(Constants.WORD_ADDED + "%n", word);
            } else {
                System.out.printf(Constants.WORD_ALREADY_EXISTS + "%n", word);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_PREFIX + e.getMessage());
        }
    }

    /**
     * Обработка проверки наличия слова
     */
    public void handleContains() {
        System.out.print(Constants.ENTER_WORD);
        String word = scanner.nextLine();
        boolean exists = trie.contains(word);
        if (exists) {
            System.out.println(Constants.WORD_FOUND);
        } else {
            System.out.println(Constants.WORD_NOT_FOUND);
        }
    }

    /**
     * Обработка проверки префикса
     */
    public void handleStartsWith() {
        System.out.print(Constants.ENTER_PREFIX);
        String prefix = scanner.nextLine();
        boolean hasPrefix = trie.startsWith(prefix);
        if (hasPrefix) {
            System.out.println(Constants.PREFIX_EXISTS);
        } else {
            System.out.println(Constants.PREFIX_NOT_EXISTS);
        }
    }

    /**
     * Обработка получения слов по префиксу
     */
    public void handleGetByPrefix() {
        System.out.print(Constants.ENTER_PREFIX);
        String prefix = scanner.nextLine();
        MyList<String> words = trie.getByPrefix(prefix);
        printWords(words);
    }

    /**
     * Обработка получения слов определенной длины
     */
    public void handleGetByLength() {
        System.out.print(Constants.ENTER_LENGTH);
        try {
            int length = scanner.nextInt();
            scanner.nextLine();
            MyList<String> words = trie.getByLength(length);
            printWords(words);
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println(Constants.ERROR_PREFIX + Constants.ERROR_INVALID_INPUT);
        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_PREFIX + e.getMessage());
        }
    }

    /**
     * Обработка удаления слова с проверкой существования
     */
    public void handleRemove() {
        System.out.print(Constants.ENTER_WORD_TO_REMOVE);
        String word = scanner.nextLine();
        boolean removed = trie.remove(word);
        if (removed) {
            System.out.printf(Constants.WORD_REMOVED + "%n", word);
        } else {
            System.out.printf(Constants.WORD_NOT_REMOVED + "%n", word);
        }
    }

    /**
     * Обработка сохранения в файл
     */
    public void handleSaveToFile() {
        System.out.print(Constants.ENTER_FILE_PATH);
        String path = scanner.nextLine();
        FileManager manager = new FileManager(trie);
        manager.saveToFile(path);
    }

    /**
     * Обработка загрузки из файла
     */
    public void handleLoadFromFile() {
        System.out.print(Constants.ENTER_FILE_PATH);
        String path = scanner.nextLine();
        FileManager manager = new FileManager(trie);
        manager.loadFromFile(path);
    }

    /**
     * Обработка вывода размера дерева
     */
    public void handleSize() {
        System.out.println(Constants.TREE_SIZE + trie.size());
    }

    /**
     * Вывод списка слов на экран
     */
    private void printWords(MyList<String> words) {
        System.out.println(Constants.WORDS_FOUND + words.size());
        for (int i = 0; i < words.size(); ++i) {
            System.out.println("  " + (i + 1) + ". " + words.get(i));
        }
    }
}