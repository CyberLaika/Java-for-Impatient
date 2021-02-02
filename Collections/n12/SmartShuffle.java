package n12;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;

public class SmartShuffle {
    public static List<String> myShuffle(String filename) throws FileNotFoundException {
        List<String> list= n11.BoundedShuffle.readWords(filename);
        if ((list.get(0).charAt(0) > 'A') && (list.get(0).charAt(0) < 'Z'))
            list.set(0,list.get(0).toLowerCase());
        Collections.shuffle(list);
        return list;
    }

}
