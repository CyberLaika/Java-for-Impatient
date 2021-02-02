package n24;

import java.lang.reflect.Array;

public class test24 {
    public static void main(String[] args) {
        int[] a={1,2,3};
        myMethod(a.getClass());
    }
    public static void myMethod(Class<?> obj){
        System.out.println(obj.isArray());
       // obj.getEnumConstants();
    }

}
