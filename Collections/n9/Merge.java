package n9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Merge {

    public static Map<String, Integer> mergeMerge(List<String> words) {
        Map<String, Integer> freq = new TreeMap<>();
        for (String word : words) {
            freq.merge(word, 1, Integer::sum);
        }
        return freq;
    }

    public static Map<String, Integer> mergeContaints(List<String> words) {
        Map<String, Integer> freq = new TreeMap<>();
        for (String word : words) {
            if(freq.containsKey(word))
                freq.put(word,freq.get(word)+1);
            else
                freq.put(word,1);
        }
        return freq;
    }

    public static Map<String, Integer> mergeGet(List<String> words) {
        Map<String, Integer> freq = new TreeMap<>();
        for (String word : words) {
            if(freq.get(word)!=null)
                freq.put(word,freq.get(word)+1);
            else
                freq.put(word,1);
        }
        return freq;
    }

    public static Map<String, Integer> mergeGetOrDefault(List<String> words) {
        Map<String, Integer> freq = new TreeMap<>();
        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }
        return freq;
    }

    public static Map<String, Integer> mergePutIfAbsent(List<String> words) {
        Map<String, Integer> freq = new TreeMap<>();
        for (String word : words) {
            if(freq.putIfAbsent(word,1)!=null)//возвращает null если записи не было
                freq.put(word,freq.putIfAbsent(word,1)+1);//можно использовать и обычный get
        }
        return freq;
    }

    public static List<String> readWords(String filename) throws FileNotFoundException {//from n7
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

