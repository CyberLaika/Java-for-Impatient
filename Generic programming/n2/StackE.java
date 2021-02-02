package n2;

import java.util.Arrays;
import java.util.function.IntFunction;

public class StackE<E> {
    private E[] data;
    private int cur=0;

    public StackE(int size, IntFunction<E[]> constr) {
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        this.data = constr.apply(size);
    }

    public void push(E item) {
        if (cur == data.length) {
            this.data = Arrays.copyOf(this.data, this.data.length + 5);
        }
        this.data[cur++] = item;
    }

    public E pop() {
        if (this.cur == 0) {
            throw new IllegalStateException("stack is empty");
        }
        return this.data[--cur];
    }
    public boolean isEmpty() {
        return this.cur == 0;
    }


}
