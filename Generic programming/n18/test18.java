package n18;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;



public class test18 {
    public static <T> int[] repeat(int n, T obj, ToIntFunction<T> constr){
        int[] result= new int[n];
        //int[] result = constr.applyAsInt(obj);
        for(int i=0; i<n;i++)
            result[i]=constr.applyAsInt(obj);
        return result;

    }

    public static void main(String[] args) {
        ToIntFunction<Integer> toInt = a -> (int)a;
        int[] str= repeat(10,56,toInt);
        System.out.println(Arrays.toString(str));
    }
}
