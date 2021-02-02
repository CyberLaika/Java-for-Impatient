package n4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorConcurrent {
    public static <T> List<T> deleteDuplicateWithException(List<T> list){
        if(list.size()<2)
            return list;
        ListIterator<?> first=list.listIterator(1);//second идет позади второго и удаляет, если элементы коллекции совпали
        ListIterator<?> second=list.listIterator();

        // foreach
        while(first.hasNext())
        {
            if(first.next()==second.next())// throws ConcurrentModificationException
                second.remove();//
        }
        return list;
    }





    public static void deleteMoreThanFiveWrong(ArrayList<Integer> intList) {
        for (Integer s : intList) {
            if(s>5)
            intList.remove(s);
        }
    }

    public static void deleteMoreThanFiveEx1(ArrayList<Integer> intList) {
       for (Iterator<Integer> iterator = intList.iterator(); iterator.hasNext();){
           Integer integer = iterator.next();
            if(integer >5) {
                iterator.remove();
            }
        }
    }

    public static void deleteMoreThanFiveEx2(ArrayList<Integer> intList) {
        List<Integer> toRemove = new ArrayList<>();
        for (Integer integer : intList) {
            if(integer > 5) {
                toRemove.add(integer);
            }
        }
        intList.removeAll(toRemove);
    }

    public static void deleteMoreThanFiveEx3(ArrayList<Integer> intList) {
        intList.removeIf(i->i>5);
    }

    // package concurrent

}
