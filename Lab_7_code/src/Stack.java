public class Stack<T> {
    private T[] data;
    private int cursor;
    
    Stack(int size) {
        data = (T[])new Object[size];
        cursor = 0;
    }

    public int size() {
        return cursor;
    }

    public T pop() {
        cursor--;
        return data[cursor];
        
    }

    public T peek() {
        return data[cursor - 1];
    }

    public void push(T val) {
        data[cursor] = val;
        cursor++;
    }
}