package n17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main17 {
    public static void main(String[] args) {
        List stringsChecked = Collections.checkedList(new ArrayList<>(), String.class);
        List strings = new ArrayList<>();
        System.out.println("trying without check");
        strings.add(new Integer(1));
        System.out.println("trying with check");
        stringsChecked.add(new Integer(1));
    }
}
