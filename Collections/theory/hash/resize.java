package theory.hash;

import java.util.*;

public class resize {
    public static void main(String[] args) {
        HashMap<Account,String> h=new HashMap<>();
        for(int i=0;i<1000;i++)
            h.put(new Account(i),"attack");
        h.put(new Account(1001),"attack");
        for(Map.Entry e:h.entrySet())
            System.out.print(e.getKey()+" ");
        int n=1;
        for(int i=0;i<34;i++)
            n=n*2;
        System.out.println(n);
        System.out.println("Aa".hashCode()== "BB".hashCode());
        //property called "Equivalent Substrings"
       List<String> dos= Arrays.asList("AaAaAaAa", "AaAaBBBB", "AaAaAaBB", "AaAaBBAa",
                "BBBBAaAa", "BBBBBBBB", "BBBBAaBB", "BBBBBBAa",
                "AaBBAaAa", "AaBBBBBB", "AaBBAaBB", "AaBBBBAa",
                "BBAaAaAa", "BBAaBBBB", "BBAaAaBB", "BBAaBBAa");

       //TreeMap<Account,String> tree=new TreeMap<>();
       //tree.put(new Account(10),"wtf");

    }

}
