package n8;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

public class Main8 {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Set<Integer>> linesAndWords= FIleLinesRead.linesReader("test.txt");

        for (Map.Entry<String, Set<Integer>> entry : linesAndWords.entrySet()) {
            System.out.println("word " + entry.getKey() + " in lines " + entry.getValue());
        }
    }


}
