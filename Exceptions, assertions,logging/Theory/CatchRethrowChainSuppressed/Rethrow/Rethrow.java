package Theory.CatchRethrowChainSuppressed.Rethrow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rethrow {
    public static String readFile(File file) throws FileNotFoundException,NullPointerException {
        StringBuilder str = new StringBuilder();
        try (Scanner in = new Scanner(file)){
            while (in.hasNext())
                str.append(in.next());
            return str.toString();
        } catch (FileNotFoundException | NullPointerException e) {
            throw e;
        }
    }

}
