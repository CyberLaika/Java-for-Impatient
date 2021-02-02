package n2;

import java.util.ArrayList;
import java.util.ListIterator;

public class ToUpperCase {
    public static ArrayList<String> toUpperCaseIter(ArrayList<String> listStr) {
        ListIterator<String> iter = listStr.listIterator();
        while (iter.hasNext()) {
            iter.set(iter.next().toUpperCase());
        }
        return listStr;
    }

    public static ArrayList<String> toUpperCaseFor(ArrayList<String> listStr) {
        for (String element : listStr) {
           listStr.set(listStr.indexOf(element),element.toUpperCase());
        }
        return listStr;
    }

    public static ArrayList<String> toUpperCaseAll(ArrayList<String> listStr) {
        listStr.replaceAll(String::toUpperCase);
        return listStr;
    }
}
