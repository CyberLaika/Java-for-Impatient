package n4;

import java.util.ArrayList;
import java.util.Arrays;


public class Main4 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers= new ArrayList<>(Arrays.asList(1,2,2,3,4,5,5));


        //List<Integer> list=IteratorConcurrent.deleteMoreThanFive(numbers);

        //IteratorConcurrent.deleteMoreThanFiveWrong(numbers);

        numbers.addAll(Arrays.asList(6,7,8));
        IteratorConcurrent.deleteMoreThanFiveEx1(numbers);
        System.out.println(numbers);

        numbers.addAll(Arrays.asList(6,7,8));
        IteratorConcurrent.deleteMoreThanFiveEx2(numbers);
        System.out.println(numbers);

        numbers.addAll(Arrays.asList(6,7,8));
        IteratorConcurrent.deleteMoreThanFiveEx3(numbers);
        System.out.println(numbers);

        System.out.println(numbers);



    }
}
