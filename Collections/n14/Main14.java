package n14;

import java.util.*;

public class Main14 {
    public static void main(String[] args) {

        List<Integer> ilv = ImmutableView.getImmutableListView(10);
        System.out.println(ilv.contains(11));
        System.out.println(ilv.contains(10));

        List<Integer> ilv2= ilv.subList(5,11);
        ListIterator<Integer> iter2=ilv2.listIterator();
        System.out.print("for my collection ");
        while(iter2.hasNext())
            System.out.print(iter2.next()+" ");
        System.out.println();

        List<Integer> aL=new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9,10));
        List<Integer> aL2= aL.subList(5,11);
        ListIterator<Integer> aLIter2=aL2.listIterator();
        System.out.print("for ArrayList     ");
        while(aLIter2.hasNext())
            System.out.print(aLIter2.next()+" ");

        System.out.println();
        List<Integer> ilv3 = ilv2.subList(0,4);
        ListIterator<Integer> iter3=ilv3.listIterator();


        System.out.println("for my collection "+ iter3.hasPrevious()+" "+iter3.next()+" "+iter3.next()+" "+iter3.previousIndex()+" "+iter3.nextIndex()+" "+iter3.previous());

        List<Integer> aL3 = aL2.subList(0,4);
        ListIterator<Integer> aLIter3=aL3.listIterator();


        System.out.print("for ArrayList     "+ aLIter3.hasPrevious()+" "+aLIter3.next()+" "+aLIter3.next()+" "+aLIter3.previousIndex()+" "+aLIter3.nextIndex()+" "+aLIter3.previous());



    }

}
