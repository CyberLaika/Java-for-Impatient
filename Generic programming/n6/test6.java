package n6;

import java.util.ArrayList;

public class test6 {//Producer-extends. Consumer-super
    public static <E> void connector1(ArrayList<E> arr1, ArrayList<? extends E> arr2){
        arr1.addAll(arr2);
    }
    public static <E> void connector2(ArrayList<? super E> arr1, ArrayList< E> arr2){
        arr1.addAll(arr2);
    }

    public static void main(String[] args) {
     //   ArrayList<>
    }

}
