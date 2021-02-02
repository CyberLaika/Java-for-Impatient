package n18;

import java.util.*;

public class Main18 {
    public static void main(String[] args) {


        List<String> s = Collections.emptyList();
        Set<Long> l = Collections.emptySet();
        Map<Integer, String> d = Collections.emptyMap();

        List<String> list = Collections.EMPTY_LIST;//without generics
        Set<Long> set = Collections.EMPTY_SET;
        Map<Integer, String> map = Collections.EMPTY_MAP;

        //public static final List EMPTY_LIST = new EmptyList<>();

        /*
         @SuppressWarnings("unchecked")
            public static final <T> List<T> emptyList() {
            return (List<T>) EMPTY_LIST;
        }*/
    }


}
