package oneRing;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Ring<Integer> ring=new LinkedRing<>();
        ring.add(1);
        ring.add(2);
        ring.add(3);
        ring.add(4);
        ring.add(5);
        ring.add(null);
        ring.remove(null);
        ring.add(null);
        ring.add(8);
        System.out.println(ring.contains(8));
        System.out.println(Arrays.toString(ring.toArray()));
        System.out.println(ring.contains(null));
        System.out.println(ring.contains(1));
        ArrayList<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(7);
        list.add(null);
        list.add(1);
       // LinkedRing<Integer> LR= (LinkedRing<Integer>) ring;
      //  LR.retainAll2(list);
        ring.retainAll(list);
        System.out.println(Arrays.toString(ring.toArray()));
        System.out.println();
        

        Iterator<Integer> iter= ring.iterator();
        while(iter.hasNext())
           System.out.print(iter.next()+" ");
        System.out.println();
        Iterator<Integer> iterRev= ring.reverseIterator();
        while(iterRev.hasNext())
            System.out.print(iterRev.next()+" ");







    }
}
