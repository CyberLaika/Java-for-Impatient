package n16;

import java.util.Collection;
import java.util.List;

public class test16 {

    public static <T extends Comparable<? super T>>  void sort1(List<T> list){}
    //Compiled into
    public static void sort2(List<Comparable> list){}
    //T=Comparable;


    public static <T extends Object & Comparable<? super T>> T max1(Collection<? extends T> coll){ return (T) new Object();}
    //Compiled into
    public static Object max2(Collection<Object> coll){return new Object();}
    //T=Object;

}
