package n3;

import java.util.HashSet;
import java.util.Set;

public class Dozen {
    public static <E> Set<E> union(Set<E> first, Set<E> second) {
        Set<E> result = new HashSet<>(first.size() + second.size());
        result.addAll(first);
        result.addAll(second);
        return result;
    }

    public static <E> Set<E> intersection(Set<E> first, Set<E> second) {
        HashSet<E> result = new HashSet<>(first.size());
        result.addAll(first);
        result.retainAll(second);
        return result;
    }

    public static <E> Set<E> difference(Set<E> first, Set<E> second) {
        Set<E> union = union(first,second);
        Set<E> intersection = intersection(first,second);
        union.removeAll(intersection);
        return union;
    }
}
