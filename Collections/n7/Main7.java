package n7;

import java.io.FileNotFoundException;
import java.util.List;

public class Main7 {
    public static void main(String[] args) throws FileNotFoundException {
        List<String> list= FileFreqReader.readWords("test.txt");
        System.out.println(FileFreqReader.freqReader(list).toString());
    }
}

