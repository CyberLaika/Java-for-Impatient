package n8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FIleLinesRead {
    public static Map<String,Set<Integer>> linesReader(String filename) throws FileNotFoundException {
        Map<String,Set<Integer>> wordsInLines = new HashMap<>();

        try (Scanner file = new Scanner(new File(filename))) {
            int countLine =1;
            while (file.hasNext()) {
                String[] words = file.nextLine().split(" ");
                for(String word : words)
                {
                   Set<Integer> lines = wordsInLines.getOrDefault(word, new TreeSet<>());
                   lines.add(countLine);
                    wordsInLines.put(word, lines);
                }
                countLine++;
            }
        }

        return wordsInLines;


        /*for (var entry : counts.entrySet()) {
            System.out.println("Word is: " + entry.getKey() + " with lines: " + "".join(",", entry.getValue()));
        }*/
    }
}
