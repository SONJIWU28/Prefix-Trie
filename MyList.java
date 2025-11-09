/**
 * Самописная реализация ArrayList
 * Параметризованный класс с generics
 */
public class MyList<E> {
    private Object[] data;
    private int size;

    /**
     * Конструктор с начальной емкостью
     */
    public MyList() {
        data = new Object[Constants.INITIAL_CAPACITY];
        size = 0;
    }

    /**
     * Добавление элемента в конец списка
     */
    public void add(E element) {
        if (size == data.length) {
            resize();
        }
        data[size] = element;
        ++size;
    }

    /**
     * Получение элемента по индексу
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Constants.ERROR_INDEX_OUT_OF_BOUNDS);
        }
        return (E) data[index];
    }

    /**
     * Получение размера списка
     */
    public int size() {
        return size;
    }
    /**
     * Увеличение емкости массива
     */
    private void resize() {
        Object[] newData = new Object[data.length * 2];
        for (int i = 0; i < size; ++i) {
            newData[i] = data[i];
        }
        data = newData;
    }
}