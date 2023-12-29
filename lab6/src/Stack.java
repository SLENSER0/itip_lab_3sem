public class Stack<T> {
    private T[] data;
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        data[size++] = element;
    }
    public T pop() {
        T poppedElement = data[--size];
        data[size] = null;
        return poppedElement;
    }
    public T peek() {
        return data[size - 1];
    }
}
