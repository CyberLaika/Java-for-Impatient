package oneRing;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiPredicate;

public class LinkedRing<T> implements Ring<T> {
    private int size = 0;
    private Node head = null;





    class Node {

        T value;
        Node nextNode;
        Node prevNode;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

        Node(Node next){
            nextNode=next;
             prevNode=next;
        }

    }

    @Override
    public T getFirst() {
        if(head!=null)
            return head.value;
        else
            return null;
    }

    @Override
    public T getLast() {
        if(head!=null)
            return head.prevNode.value;
        else
            return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object o) {
        Node currentNode = head;

        if (!this.isEmpty()) {
            do {

                if (( currentNode.value==null && o==null) ||(currentNode.value!=null &&  currentNode.value.equals(o))) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            final Node startNode =new Node(head);
            Node currentNode= startNode;

             @Override
            public boolean hasNext(){
                 if(startNode.nextNode==null)
                     return false;
                 if(currentNode==startNode)
                     return true;
                 return currentNode.nextNode != head;
            }

            @Override
            public T next() {
                currentNode=currentNode.nextNode;
                return currentNode.value;
            }

            @Override
            public void remove() {
                if(currentNode==startNode)
                    throw new IllegalStateException();
                LinkedRing.this.removeCur(currentNode);
            }
        };
    }

    @Override
    public Iterator<T> reverseIterator() {
        return new Iterator<>() {
            final Node startNode =new Node(head);
            Node currentNode= startNode;

            /*
            @Override
            public boolean hasNext() {
                return head != null;//сработает только в случае если коллекция пустая
            }*/

            @Override
            public boolean hasNext(){
                if(startNode.nextNode==null)
                    return false;
                if(currentNode==startNode)
                    return true;
                return currentNode.prevNode != head.prevNode;
            }

            @Override
            public T next() {
                if(currentNode==startNode)
                    currentNode=currentNode.prevNode.prevNode;
                else
                currentNode=currentNode.prevNode;
                return currentNode.value;
            }

            @Override
            public void remove() {
                if(currentNode==startNode)
                    throw new IllegalStateException();
                LinkedRing.this.remove(currentNode.value);
            }
        };
    }


    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        if(this.isEmpty())
            return result;
        int i = 0;
        Node currentNode = head;
        do{
            result[i++] = currentNode.value;
             currentNode = currentNode.nextNode;
         } while (currentNode.nextNode != head);

        return result;
    }

    @Override
    public boolean add(T o) {
        Node newNode = new Node(o);

        if (this.isEmpty()) {
            head = newNode;
        } else {
            head.prevNode.nextNode=newNode;
            newNode.prevNode=head.prevNode;
        }
        newNode.nextNode=head;
        head.prevNode=newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node cur = this.head;

        if (!this.isEmpty()) {
            //https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html
            //For any non-null reference value x, x.equals(null) should return false.
                if (cur.value.equals(o)) {
                   removeHead();
                    return true;
                } else {
                    do {
                        cur = cur.nextNode;
                        if ( Objects.equals(cur.value,o)) {
                            removeCur(cur);
                            return true;
                        }
                    } while (cur.nextNode != head);
                }
        }
        return false;

        /* старая версия
        Node cur = this.head;

        if (this.head != null) {
            if (o == null) {
                if (cur.value == null) {
                    removeHead();
                    return true;
                } else {
                    do {
                        cur = cur.nextNode;
                        if (cur.value == null) {
                           removeCur(cur);
                           return true;
                        }
                    } while (cur.nextNode != head);
                }
            } else {
                if (cur.value.equals(o)) {
                   removeHead();
                    return true;
                } else {
                    do {
                        cur = cur.nextNode;
                        if (cur.value.equals(o)) {
                            removeCur(cur);
                            return true;
                        }
                    } while (cur.nextNode != head);
                }
            }
        }*/
    }

    private void removeHead(){
        head.nextNode.prevNode=head.prevNode;
        head.prevNode.nextNode=head.nextNode;
        size--;
    }

    private void removeCur(Node cur){
        cur.nextNode.prevNode=cur.prevNode;
        cur.prevNode.nextNode=cur.nextNode;
        size--;
    }


    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (collection != null && !collection.isEmpty()) {
            Object[] c = collection.toArray();
            for (Object o : c) this.add((T) o);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        while (this.head != null)
            remove(head.value);
    }


    @Override
    public boolean retainAll(Collection<?> c) {//O(n*m)
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<T> it = this.iterator();

        while (it.hasNext()) {
            if (!c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }

        return modified;
           /* старая версия
        Objects.requireNonNull(c);
        boolean modified = false;

        for (Object cur : this) {//O(n)
            if (!c.contains(cur)) {//O(n*m)
                remove(cur);//O((n^2)*m)
                modified = true;
            }
        }

        return modified;*/
    }

    public boolean retainAll2(Collection<?> c) {//O(n)+O(m)
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<T> it = this.iterator();
        Set<Object> hash = new HashSet<>(c);//O(m)


        while (it.hasNext()) {//O(n)
            if (!hash.contains(it.next())) {//O(1)
                it.remove();
                modified = true;
            }
        }

        return modified;
    }


    @Override
    public boolean removeAll(Collection<?> c) {// AbstractCollections
        Objects.requireNonNull(c);
        boolean modified = false;
        Iterator<T> it = this.iterator();

        while(it.hasNext()) {
            if (c.contains(it.next())) {
                it.remove();
                modified = true;
            }
        }
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {// AbstractCollections
        Iterator<?> var2 = c.iterator();
        Object e;
        do {
            if (!var2.hasNext()) {
                return true;
            }

            e = var2.next();
        } while(this.contains(e));

        return false;
    }
    @SuppressWarnings("unchecked")
    @Override
    public <K> K[] toArray(K[] a) {
        if (a.length < this.size) {
            a = (K[]) Array.newInstance(a.getClass().getComponentType(), this.size);
        }
        int i = 0;
        Object[] result = a;
        Node cur=head;
        do {
            result[i++] = cur.value;
            cur=cur.nextNode;
        }while(cur != head);

        if (a.length > this.size) {
            a[this.size] = null;
        }
        return a;
    }
}