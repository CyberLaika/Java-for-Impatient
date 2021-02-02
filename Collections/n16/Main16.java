package n16;

import n15.ImmutableViewIntFunction;

import java.util.*;

public class Main16 {
    public static void main(String[] args) {


        ImmutableViewIntFunctionCache.ImmutableListView ilv = ImmutableViewIntFunctionCache.getImmutableListView(10, i -> i=i*2);
        System.out.println(ilv.contains(11));
        System.out.println(ilv.contains(20));

        List<Integer> ilv2= ilv.subList(5,11);
        ListIterator<Integer> iter2=ilv2.listIterator();
        System.out.print("for my collection ");
        while(iter2.hasNext())
            System.out.print(iter2.next()+" ");
        System.out.println();

        List<Integer> aL=new ArrayList<>(Arrays.asList(0,2,4,6,8,10,12,14,16,18,20));
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
