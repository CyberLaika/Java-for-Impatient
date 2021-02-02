package n12;

import n4.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class test12 {
    public static <T> void minmax (List<T> el, Comparator<? super T> comp, List<? super T> result){
        if(el.isEmpty())
            throw new IllegalArgumentException("el is empty");
        T min=el.get(0);
        T max=el.get(0);
        for (T t : el) {
            if (comp.compare(t, max) > 0) {
                max = t;
            } else if (comp.compare(t, min) < 0)
                min = t;
        }
        result.add(min);
        result.add(max);
    }

    public static void main(String[] args) {
        List<Person> personList= new ArrayList<>();
        personList.add(new Person(3,"Stirlitz","SpyMaster"));
        personList.add(new Person(2,"Kate","Radioman"));
        personList.add(new Person(4,"Schlag","Pastor"));
        personList.add(new Person(1,"Pleischner","Professor"));
        List<Person> heroes= new ArrayList<>();
        minmax(personList, Comparator.comparingInt(Person::getId),heroes);
        for(Person person:heroes)
            System.out.println(person.toString());
    }
}
