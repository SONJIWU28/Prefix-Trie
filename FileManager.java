import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Менеджер для работы с файлами
 * Сохранение и загрузка словаря
 */
public class FileManager {
    private final Trie trie;

    public FileManager(Trie trie) {
        this.trie = trie;
    }

    /**
     * Сохранение всех слов из дерева в файл
     */
    public void saveToFile(String path) {
        try {
            Validator.validateFilePath(path);

            PrintWriter writer = new PrintWriter(path, StandardCharsets.UTF_8);
            MyList<String> words = trie.getByPrefix("");

            // Заголовок
            writer.println(Constants.FILE_HEADER);

            // Список слов
            for (int i = 0; i < words.size(); ++i) {
                writer.println(words.get(i));
            }

            writer.close();
            System.out.printf(Constants.FILE_SAVE_SUCCESS + "%n", words.size(), path);

        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_FILE_WRITE + e.getMessage());
        } catch (Exception e) {
            System.out.println(Constants.ERROR_FILE_WRITE + e.getMessage());
        }
    }



    /**
     * Загрузка слов из файла в дерево
     */
    public void loadFromFile(String path) {
        try {
            Validator.validateFilePath(path);

            File file = new File(path);
            Validator.validateFileExists(file);

            Scanner scanner = new Scanner(file);

            if (!scanner.hasNextLine()) {
                scanner.close();
                throw new IllegalArgumentException(Constants.ERROR_FILE_READ + Constants.ERROR_FILE_EMPTY);
            }

            // Проверяем заголовок
            String header = scanner.nextLine().trim();
            Validator.validateFileHeader(header);

            int loaded = 0;

            // Читаем слова построчно
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim().toLowerCase();

                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                trie.insert(line);
                ++loaded;
            }

            scanner.close();
            System.out.printf(Constants.FILE_LOAD_SUCCESS + "%n", loaded);

        } catch (IllegalArgumentException e) {
            System.out.println(Constants.ERROR_FILE_READ + e.getMessage());
        } catch (Exception e) {
            System.out.println(Constants.ERROR_FILE_READ + e.getMessage());
        }
    }
}