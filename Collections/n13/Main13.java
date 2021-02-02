package n13;

import java.util.LinkedHashMap;

public class Main13 {
    public static void main(String[] args) {
        Cache<Integer,String> cache=new Cache<>(3);
        cache.put(1,"1");
        cache.put(2,"2");
        cache.put(3,"3");
        cache.put(4,"4");
        cache.put(5,"5");
        System.out.println(cache.toString());
    }




}
