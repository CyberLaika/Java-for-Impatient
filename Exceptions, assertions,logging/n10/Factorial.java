package n10;

import java.math.BigInteger;
import java.util.Arrays;

public class Factorial {
    public static int factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("The value must be positive");
        }
        if (x == 0 ||x == 1) {
            Exception e = new Exception();
            StackTraceElement[] frames = e.getStackTrace();
            for (StackTraceElement frame : frames) System.out.println(frame.toString());
            return 1;
        }
        return (factorial(x - 1) * x);
    }
}
