package n11;

import n12.SmartShuffle;

import java.io.FileNotFoundException;

public class Main11 {
    public static void main(String[] args) throws FileNotFoundException {
        for(String str: BoundedShuffle.myShuffle("sentence.txt"))
            System.out.print(str+" ");
    }
}
