package Theory.CatchRethrowChainSuppressed.Chain;


import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Chain {
    public static void main(String[] args) {
        Reader stringReader =
                (filename) -> {
                    StringBuilder result = new StringBuilder();
                    try {
                        Scanner in = new Scanner(new File(filename));
                        while (in.hasNextLine()) {
                            result.append(in.nextLine());
                        }
                        return result.toString();
                        // throw new FileNotFoundException();
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                };
        System.out.println(stringReader.read("test.txt"));
    }
}