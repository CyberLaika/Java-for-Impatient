package n2;

import java.util.Arrays;
import java.util.function.IntFunction;

public class StackO<E> {
    private Object[] data;
    private int cur=0;

    public StackO(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.data = new Object[size];
    }

    public void push(E item) {
        if (cur == data.length) {
            this.data = Arrays.copyOf(this.data, this.data.length + 5);
        }
        this.data[cur++] = item;
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (this.cur == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return (E) this.data[--cur];
    }
    public boolean isEmpty() {
        return this.cur == 0;
    }
}
