package n7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FileFreqReader {
    public static Map<String, Integer> freqReader(List<String> words) {
        Map<String, Integer> freq = new TreeMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }

    public static List<String> readWords(String filename) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNext())
                list.add(file.nextLine());
        }
            List<String> result = new ArrayList<>();
            for (String str : list) {
                String[] words = str.split(" ");
                result.addAll(Arrays.asList(words));
            }

        return result;
    }
}
