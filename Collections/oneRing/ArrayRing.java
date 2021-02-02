package oneRing;

import java.util.*;

public class ArrayRing<T>  extends ArrayList<T> implements Ring<T>{
    @Override
    public T get(int index) {
        index=index%size();
        return super.get(index);
    }

    @Override
    public T set(int index, T element) {
        return super.set(index%size(), element);
    }

    @Override
    public T getFirst() {
        return super.get(0);
    }

    @Override
    public T getLast() {
        return super.get(super.size()-1);
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new Iterator<>(){
            int current=ArrayRing.this.size();
            @Override
            public boolean hasNext() {
                return current>0;
            }

            @Override
            public T next() {
                current--;
                return ArrayRing.this.get(current);
            }
        };
    }
}
