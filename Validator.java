import java.io.File;

public class Validator {

    /**
     * Валидация слова для вставки
     */
    public static void validateWord(String word) {
        if (word == null) {
            throw new IllegalArgumentException(Constants.ERROR_NULL_WORD);
        }
        if (word.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_EMPTY_WORD);
        }
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!isValidChar(ch)) {
                throw new IllegalArgumentException(Constants.ERROR_INVALID_CHARS);
            }
        }
    }

    /**
     * Проверка валидности префикса
     */
    public static boolean isValidPrefix(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return true;
        }

        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (!isValidChar(ch)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Нормализация строки
     */
    public static String normalize(String text) {
        if (text == null) {
            return "";
        }
        return text.toLowerCase();
    }

    /**
     * Проверка символа
     */
    public static boolean isValidChar(char ch) {
        char lower = Character.toLowerCase(ch);
        if (lower >= Constants.MIN_CHAR && lower <= Constants.MAX_CHAR) {
            return true;
        }
        return false;
    }

    /**
     * Валидация пути к файлу
     */
    public static void validateFilePath(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_FILE_NULL_PATH);
        }
        if (!path.endsWith(Constants.FILE_EXTENSION)) {
            throw new IllegalArgumentException(Constants.ERROR_FILE_EXTENSION);
        }
    }

    /**
     * Валидация заголовка файла
     */
    public static void validateFileHeader(String header) {
        if (header == null || !Constants.FILE_HEADER.equals(header)) {
            throw new IllegalArgumentException(Constants.ERROR_FILE_HEADER);
        }
    }

    /**
     * Валидация существования файла
     */
    public static void validateFileExists(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(Constants.ERROR_FILE_NOT_FOUND);
        }
        if (file.length() == 0) {
            throw new IllegalArgumentException(Constants.ERROR_FILE_EMPTY);
        }
    }
}