package n11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BoundedShuffle {



   public static List<String> myShuffle(String filename) throws FileNotFoundException {
       List<String> list= readWords(filename);
       Collections.shuffle(list.subList(1, list.size()-1));
       return list;
   }


    public static List<String> readWords(String filename) throws FileNotFoundException {
        ArrayList<String> list = new ArrayList<>();
        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNext())
                list.add(file.nextLine());
        }
        List<String> result = new ArrayList<>();
        for (String str : list) {
            String[] words = str.split("\\s+");//один или более пробелов
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].replaceAll("[^\\w]", "");//всем кроме букв и цифр в мусорку
            }
            result.addAll(Arrays.asList(words));
        }
        return result;
    }
}
