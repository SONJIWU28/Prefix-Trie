/**
 * Класс с константами для всего проекта
 */
public class Constants {
    // Константы для алфавита
    public static final int ALPHABET_SIZE = 26;
    public static final char MIN_CHAR = 'a';
    public static final char MAX_CHAR = 'z';
    public static final int OFFSET = 'a';

    // Константы для MyList
    public static final int INITIAL_CAPACITY = 10;

    // Ошибки валидации слов
    public static final String ERROR_NULL_WORD = "Слово не может быть null";
    public static final String ERROR_EMPTY_WORD = "Слово не может быть пустым";
    public static final String ERROR_INVALID_CHARS = "Слово должно содержать только буквы английского алфавита (a-z)";
    public static final String ERROR_INDEX_OUT_OF_BOUNDS = "Индекс выходит за границы";
    public static final String ERROR_INVALID_LENGTH = "Длина должна быть положительным числом";
    public static final String ERROR_INVALID_INPUT = "Ошибка ввода: введите корректное число";

    // Ошибки файлов
    public static final String ERROR_FILE_NULL_PATH = "Путь к файлу не может быть null";
    public static final String ERROR_FILE_EXTENSION = "Файл должен иметь расширение .txt";
    public static final String ERROR_FILE_NOT_FOUND = "Файл не найден";
    public static final String ERROR_FILE_EMPTY = "Файл пустой";
    public static final String ERROR_FILE_HEADER = "Файл не является файлом дерева (отсутствует заголовок)";
    public static final String ERROR_FILE_WRITE = "Ошибка при записи в файл: ";
    public static final String ERROR_FILE_READ = "Ошибка при чтении файла: ";

    // Файлы
    public static final String FILE_HEADER = "# Trie Dictionary";
    public static final String FILE_EXTENSION = ".txt";
    public static final String FILE_SAVE_SUCCESS = "Сохранено %d слов в файл: %s";
    public static final String FILE_LOAD_SUCCESS = "Загружено слов: %d";

    // Интерфейс
    public static final String APP_TITLE = "=== TRIE (Префиксное дерево) ===\n";
    public static final String EXIT_MESSAGE = "Выход из программы.";

    // Меню
    public static final String MENU_HEADER = "\n--- МЕНЮ ---";
    public static final String MENU_INSERT = "1 - insert (вставить слово)";
    public static final String MENU_CONTAINS = "2 - contains (проверить наличие слова)";
    public static final String MENU_STARTS_WITH = "3 - startsWith (проверить префикс)";
    public static final String MENU_GET_BY_PREFIX = "4 - getByPrefix (получить все слова по префиксу)";
    public static final String MENU_GET_BY_LENGTH = "5 - getByLength (получить слова определенной длины)";
    public static final String MENU_REMOVE = "6 - remove (удалить слово)";
    public static final String MENU_SAVE = "7 - saveToFile (сохранить слова в файл)";
    public static final String MENU_LOAD = "8 - loadFromFile (загрузить слова из файла)";
    public static final String MENU_SIZE = "9 - size (количество слов в дереве)";
    public static final String MENU_EXIT = "0 - Выход";
    public static final String CHOICE_PROMPT = "Ваш выбор: ";

    // Ввод
    public static final String ENTER_WORD = "Введите слово: ";
    public static final String ENTER_PREFIX = "Введите префикс: ";
    public static final String ENTER_WORD_TO_REMOVE = "Введите слово для удаления: ";
    public static final String ENTER_FILE_PATH = "Введите путь к файлу (.txt): ";
    public static final String ENTER_LENGTH = "Введите длину слова: ";

    // Результаты
    public static final String WORD_ADDED = "Слово \"%s\" успешно добавлено";
    public static final String WORD_ALREADY_EXISTS = "Слово \"%s\" уже существует в дереве";
    public static final String WORD_FOUND = "Слово найдено";
    public static final String WORD_NOT_FOUND = "Слово не найдено";
    public static final String WORD_REMOVED = "Слово \"%s\" успешно удалено";
    public static final String WORD_NOT_REMOVED = "Слово \"%s\" не найдено, удаление невозможно";
    public static final String PREFIX_EXISTS = "Префикс существует";
    public static final String PREFIX_NOT_EXISTS = "Префикс не существует";
    public static final String INVALID_CHOICE = "Неверный выбор.";
    public static final String ERROR_PREFIX = "Ошибка: ";
    public static final String WORDS_FOUND = "\nНайдено слов: ";
    public static final String TREE_SIZE = "Количество слов в дереве: ";
}