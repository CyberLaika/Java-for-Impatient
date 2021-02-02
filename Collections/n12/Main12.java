package n12;

import n11.BoundedShuffle;

import java.io.FileNotFoundException;

public class Main12 {
    public static void main(String[] args) throws FileNotFoundException {
        for(String str:SmartShuffle.myShuffle("sentence.txt"))
        System.out.print(str+" ");
    }
}
