package myUtil;

import java.util.Arrays;

public class testAL {
    public static void main(String[] args) {
        ArrayList<Integer> list1=  new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
        ArrayList<Integer> list2=  new ArrayList<>(Arrays.asList(2,5,6,7,10,123));
        list1.removeAll(list2);
        System.out.println(list1);


        /*
    }*/
    }
}


