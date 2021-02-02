package n16;

import n13.Cache;
import n15.ImmutableViewIntFunction;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class ImmutableViewIntFunctionCache {
    public static ImmutableViewIntFunctionCache.ImmutableListView getImmutableListView(int i, IntFunction<Integer> intFunction) {
        return new ImmutableViewIntFunctionCache.ImmutableListView(i, intFunction);
    }
    static class ImmutableListView implements List<Integer> {
        private final int up;
        private final int down;
        private final IntFunction<Integer> intFunction;
        private Cache<Integer, Integer> cache = new Cache<>(100);



        public ImmutableListView(int up,IntFunction<Integer> intFunction) {
            if (up < 0) {
                throw new IllegalArgumentException("Value < 0");
            }
            this.up = up;
            this.down = 0;
            this.intFunction = intFunction;
        }

        public ImmutableListView(int down, int up, IntFunction<Integer> intFunction) {
            if (up < 0 || down < 0) {
                throw new IllegalArgumentException("Value < 0");
            }
            this.up = up;
            this.down = down;
            this.intFunction = intFunction;
        }

        public Map<Integer,Integer> getcache(){
            return cache;
        }

        private int checkInCache(int key) {

            if (cache.containsKey(key)) {
                return cache.get(key);
            } else {
                int result = intFunction.apply(key);
                cache.put(key, result);
                return result;
            }
        }

        @Override
        public int size() {
            return up - down + 1;
        }

        @Override
        public boolean isEmpty() {
            return up - down + 1 == 0;
        }

        @Override
        public boolean contains(Object o) {
            if (o instanceof Integer) {
                for (int i = down; i <= up; i++) {
                    if (checkInCache(i) == (int) o) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public Iterator<Integer> iterator() {
            return listIterator();
        }

        @Override
        public void forEach(Consumer<? super Integer> action) {
            for (int i = down; i <= up; i++)
                action.accept(checkInCache(i));
        }

        @Override
        public boolean add(Integer integer) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean remove(Object o) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            for (Object o : collection) {
                if (!contains(o)) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean addAll(int i, Collection<? extends Integer> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public void clear() {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public Integer get(int i) {
            if (i + down <= up && i >= 0) {
                return intFunction.apply(i + down);
            }
            throw new IndexOutOfBoundsException("Out of bounds");
        }

        @Override
        public Integer set(int i, Integer integer) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public void add(int i, Integer integer) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public Integer remove(int i) {
            throw new UnsupportedOperationException("Cant change view");
        }

        @Override
        public int indexOf(Object o) {
            if (o instanceof Integer)
                for (int i = down; i <= up; i++) {
                    if (checkInCache(i) == (int)o) {
                        return i-down;
                    }
                }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            int index = -1;
            if (o instanceof Integer) {
                for (int i = down; i <= up; i++) {
                    if (checkInCache(i) == (int) o) {
                        index = i-down;
                    }
                }
            }
            return index;
        }

        @Override
        public ListIterator<Integer> listIterator() {
            return listIterator(0);
        }

        @Override
        public ListIterator<Integer> listIterator(int i) {
            if (i < 0 || i > size()) {
                throw new IndexOutOfBoundsException("Out of bound");
            }

            return new ListIterator<Integer>() {
                private int curValue = down + i-1;

                @Override
                public boolean hasNext() {
                    return curValue < up;
                }

                @Override
                public Integer next() {
                    if (curValue < up) {
                        return checkInCache(++this.curValue);
                    }
                    throw new IndexOutOfBoundsException("Out of bound");
                }

                @Override
                public boolean hasPrevious() {
                    return curValue > down + i;
                }

                @Override
                public Integer previous() {
                    if (hasPrevious()) {
                        return checkInCache(curValue--);
                    }
                    throw new IndexOutOfBoundsException("Out of bound");
                }

                @Override
                public int nextIndex() {
                    if (hasNext())
                        return curValue - (down + i) + 1;
                    else
                        return up;
                }

                @Override
                public int previousIndex() {
                    if(hasPrevious())
                        return  curValue - (down + i);
                    else
                        return curValue - (down + i) - 1;
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void set(Integer integer) {
                    throw new UnsupportedOperationException("Cant change view");
                }

                @Override
                public void add(Integer integer) {
                    throw new UnsupportedOperationException("Cant change view");
                }
            };

        }

        @Override
        public List<Integer> subList(int idxDown, int idxUp) {
            if (idxUp < idxDown || idxUp > this.size() || idxDown < 0)
                throw new IndexOutOfBoundsException("Out of bound");
            return new ImmutableViewIntFunctionCache.ImmutableListView(down + idxDown, down + idxUp - 1,intFunction);
        }

        @Override
        public Object[] toArray() {
            Integer[] array = new Integer[this.size()];
            int j = 0;
            for (int i = down; i <= up; i++) {
                array[j++] =checkInCache(i);
            }
            return array;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            Object[] array;
            int j = 0;
            if (a.length <= this.size()) {
                array = (Object[]) Array.newInstance(a.getClass().getComponentType(), this.size());
                for (int i = down; i <= up; i++)
                    array[j++] = checkInCache(i);

            } else {
                array = (Object[]) Array.newInstance(a.getClass().getComponentType(), a.length);
                for (int i = down; i <= up; i++)
                    array[j++] = checkInCache(i);
                for (; j < a.length; j++)
                    array[j] = null;

            }
            return (T[]) array;
        }
    }

}
