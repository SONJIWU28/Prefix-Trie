/**
 * Префиксное дерево (Trie)
 * Структура данных для эффективного хранения и поиска строк
 */
public class Trie {
    private final Node root;

    /**
     * Конструктор префиксного дерева
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Вставка слова в дерево
     */
    public boolean insert(String word) {
        Validator.validateWord(word);
        word = Validator.normalize(word);

        // Проверка на дубликат через contains
        if (contains(word)) {
            return false;
        }

        Node current = root;
        for (int i = 0; i < word.length(); ++i) {
            int ind = word.charAt(i) - Constants.OFFSET;
            if (current.getChild(ind) == null) {
                current.setChild(ind, new Node());
            }
            current = current.getChild(ind);
        }
        current.setEnd(true);
        return true;
    }

    /**
     * Проверка наличия слова в дереве
     */
    public boolean contains(String word) {
        if (!Validator.isValidPrefix(word)) {
            return false;
        }
        word = Validator.normalize(word);

        Node current = root;
        for (int i = 0; i < word.length(); ++i) {
            int ind = word.charAt(i) - Constants.OFFSET;
            current = current.getChild(ind);
            if (current == null) {
                return false;
            }
        }
        return current.isEnd();
    }

    /**
     * Проверка существования слов с данным префиксом
     */
    public boolean startsWith(String prefix) {
        if (!Validator.isValidPrefix(prefix)) {
            return false;
        }
        prefix = Validator.normalize(prefix);

        Node current = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int ind = prefix.charAt(i) - Constants.OFFSET;
            current = current.getChild(ind);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Получение всех слов с данным префиксом
     */
    public MyList<String> getByPrefix(String prefix) {
        if (!Validator.isValidPrefix(prefix)) {
            return new MyList<>();
        }
        prefix = Validator.normalize(prefix);

        Node current = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int ind = prefix.charAt(i) - Constants.OFFSET;
            current = current.getChild(ind);
            if (current == null) {
                return new MyList<>();
            }
        }

        MyList<String> results = new MyList<>();
        findWords(current, new StringBuilder(prefix), results);
        return results;
    }

    /**
     * Получение всех слов заданной длины
     */
    public MyList<String> getByLength(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_LENGTH);
        }

        MyList<String> results = new MyList<>();
        findWordsByLength(root, new StringBuilder(), results, length);
        return results;
    }

    /**
     * Удаление слова из дерева
     */
    public boolean remove(String word) {
        if (!Validator.isValidPrefix(word)) {
            return false;
        }
        word = Validator.normalize(word);

        // Строим путь до слова
        Node[] path = new Node[word.length() + 1];
        path[0] = root;

        for (int i = 0; i < word.length(); ++i) {
            int ind = word.charAt(i) - Constants.OFFSET;
            Node next = path[i].getChild(ind);
            if (next == null) {
                return false;
            }
            path[i + 1] = next;
        }

        // Проверяем существование слова
        Node target = path[word.length()];
        if (!target.isEnd()) {
            return false;
        }
        target.setEnd(false);

        // Удаляем ненужные узлы снизу вверх
        for (int i = word.length(); i > 0; --i) {
            Node node = path[i];
            if (node.isEnd() || node.hasChildren()) {
                break;
            }
            int ind = word.charAt(i - 1) - Constants.OFFSET;
            path[i - 1].setChild(ind, null);
        }

        return true;
    }

    /**
     * Получение количества слов в дереве
     */
    public int size() {
        return countWords(root);
    }

    /**
     * Проверка пустоты дерева
     */
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Подсчет количества слов начиная с узла
     */
    private int countWords(Node node) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.isEnd()) {
            count = 1;
        }

        for (int i = 0; i < Constants.ALPHABET_SIZE; ++i) {
            Node child = node.getChild(i);
            if (child != null) {
                count += countWords(child);
            }
        }

        return count;
    }

    /**
     * Рекурсивный сбор всех слов начиная с узла
     */
    private void findWords(Node node, StringBuilder sb, MyList<String> results) {
        if (node == null) {
            return;
        }
        if (node.isEnd()) {
            results.add(sb.toString());
        }

        for (int i = 0; i < Constants.ALPHABET_SIZE; ++i) {
            Node child = node.getChild(i);
            if (child != null) {
                sb.append((char)(i + Constants.OFFSET));
                findWords(child, sb, results);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    /**
     * Рекурсивный сбор слов заданной длины
     */
    private void findWordsByLength(Node node, StringBuilder sb, MyList<String> results, int targetLength) {
        if (node == null) {
            return;
        }

        // Если достигли нужной длины
        if (sb.length() == targetLength) {
            if (node.isEnd()) {
                results.add(sb.toString());
            }
            return;
        }

        // Продолжаем обход
        for (int i = 0; i < Constants.ALPHABET_SIZE; ++i) {
            Node child = node.getChild(i);
            if (child != null) {
                sb.append((char)(i + Constants.OFFSET));
                findWordsByLength(child, sb, results, targetLength);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}