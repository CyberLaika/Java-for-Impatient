package oneRing;

import java.util.Collection;
import java.util.Iterator;

public interface Ring<T> extends Collection<T> {
    public T getFirst();
    public T getLast();
    public Iterator<T> reverseIterator();

}
