/**
 * Узел префиксного дерева (Trie)
 * Содержит массив дочерних узлов и флаг конца слова
 */
public class Node {
    private final Node[] children;
    private boolean isEnd;

    /**
     * Конструктор узла
     */
    public Node() {
        children = new Node[Constants.ALPHABET_SIZE];
        isEnd = false;
    }

    /**
     * Получение дочернего узла по индексу
     */
    public Node getChild(int ind) {
        if (ind < 0 || ind >= Constants.ALPHABET_SIZE) {
            return null;
        }
        return children[ind];
    }

    /**
     * Установка дочернего узла по индексу
     */
    public void setChild(int ind, Node node) {
        if (ind >= 0 && ind < Constants.ALPHABET_SIZE) {
            children[ind] = node;
        }
    }

    /**
     * Проверка, является ли узел концом слова
     */
    public boolean isEnd() {
        return isEnd;
    }

    /**
     * Установка флага конца слова
     */
    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    /**
     * Проверка наличия дочерних узлов
     */
    public boolean hasChildren() {
        for (int i = 0; i < Constants.ALPHABET_SIZE; ++i) {
            if (children[i] != null) {
                return true;
            }
        }
        return false;
    }
}