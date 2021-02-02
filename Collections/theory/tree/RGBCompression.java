package theory.tree;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;


public class RGBCompression {


    public static void compression(String filename) throws FileNotFoundException {
        TreeMap<String,Integer> map= new TreeMap<>();
        String original=pixelsToTreeMap(filename,map).toString();

    }

    public static StringBuilder pixelsToTreeMap(String filename,TreeMap<String,Integer> freq) throws FileNotFoundException {
        StringBuilder original= new StringBuilder();
        try (Scanner file = new Scanner(new File(filename))) {
            while (file.hasNext()) {
                String pixelsInLine = file.nextLine();
                original.append(pixelsInLine);
                original.append('\n');
                String[] rgb = pixelsInLine.split(" ");

                for (String s : rgb)
                    freq.put(s, freq.getOrDefault(s, 0) + 1);
            }
        }
        return original;
    }
}
