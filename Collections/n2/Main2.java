package n2;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list.add("somebody ");
        list.add("once ");
        list.add("told ");
        list.add("me ");
        System.out.println(ToUpperCase.toUpperCaseIter(new ArrayList<>(list)).toString());
        System.out.println(ToUpperCase.toUpperCaseFor(new ArrayList<>(list)).toString());
        System.out.println(ToUpperCase.toUpperCaseAll(new ArrayList<>(list)).toString());
    }
}
