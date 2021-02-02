package n1;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class SieveOfEratosthenes {

    public static Set<Integer> sieveOfEratosthenes(int n) {

        if(n<2)
            throw  new IllegalArgumentException("n must be bigger then 2");

        Set<Integer> numbers= new HashSet<>();
        for(int i=2;i<=n;i++)
            numbers.add(i);

        for (int i = 2; i*i <= n; i++) {
            if (numbers.contains(i)) {
                for (int j = i; i*j <= n; j ++) {
                    numbers.remove(i*j);
                }
            }
        }
        return numbers;
    }

    public static Set<Integer> sieveOfEratosthenesBitSet(int n) {

        if(n<2)
            throw  new IllegalArgumentException("n must be bigger then 2");

        BitSet numbers= new BitSet(n);
        numbers.set(2,n-1);


        for (int i = 2; i*i <= n; i++) {
            if (numbers.get(i)) {
                for (int j = i; i*j <= n; j ++) {
                    numbers.clear(i*j);
                }
            }
        }

        Set<Integer> result= new HashSet<>();
        int i = numbers.nextSetBit(0);//i=2
        while (i > 0) {
            result.add(i);
            i = numbers.nextSetBit(i + 1);
        }

        return result;
    }


}
