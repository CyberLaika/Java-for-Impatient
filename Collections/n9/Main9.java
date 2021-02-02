package n9;

import java.io.FileNotFoundException;

public class Main9 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(Merge.mergeMerge(Merge.readWords("test.txt")));
        System.out.println(Merge.mergeContaints(Merge.readWords("test.txt")));
        System.out.println(Merge.mergeGet(Merge.readWords("test.txt")));
        System.out.println(Merge.mergeGetOrDefault(Merge.readWords("test.txt")));
        System.out.println(Merge.mergePutIfAbsent(Merge.readWords("test.txt")));
    }
}
