package n5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        List<Integer> arrayList= new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        List<Integer> linkedList = new LinkedList<>(arrayList);
        Swap.swap(arrayList,0,2);
        Swap.swap(linkedList,0,2);
        System.out.println(arrayList.toString());
        System.out.println(linkedList.toString());
    }
}
