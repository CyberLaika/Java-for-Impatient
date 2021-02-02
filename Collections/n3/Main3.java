package n3;

import java.util.HashSet;
import java.util.Set;

public class Main3 {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        Set<Integer> set2=new HashSet<>();

        for(int i=1;i<7;i++)
            set1.add(i);
        for(int i=4;i<11;i++)
            set2.add(i);

        System.out.println(Dozen.union(set1,set2).toString());
        System.out.println(Dozen.intersection(set1,set2).toString());
        System.out.println(Dozen.difference(set1,set2).toString());
    }
}
