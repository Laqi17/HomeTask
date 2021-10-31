package hw8;

public class MyArrayList<T> {
    private final int DEFAULT_CAPACITY = 10;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private int pointer = 0;

    public boolean add(T item) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = item;
        return true;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void remove(int index) {
        for (int i = index; i<pointer; i++) {
            array[i] = array[i + 1];
        }
        array[pointer] = null;
        pointer--;
        if (array.length > DEFAULT_CAPACITY && pointer < array.length / CUT_RATE)
            resize(array.length/2);
    }

    public int size() {
        return pointer;
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}