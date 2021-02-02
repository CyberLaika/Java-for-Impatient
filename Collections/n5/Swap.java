package n5;

import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class Swap {
    public static<E> void swap(List<E> list, int i, int j) {
        if (i >= list.size() || j >= list.size() || i>j) {
            throw new IllegalArgumentException("Incorrect i or j");
        }
        if (list instanceof RandomAccess) {
            list.set(i, list.set(j, list.get(i)));
        } else {
            ListIterator<E> iter = list.listIterator(i);
            E first = iter.next();
            for (int x = i + 1; x < j; x++) {
                iter.next();
            }
            E second = iter.next();
            iter.set(first);
            for (int x = j; x >= i; x--) {
                iter.previous();
            }
            iter.set(second);
        }
    }

}
