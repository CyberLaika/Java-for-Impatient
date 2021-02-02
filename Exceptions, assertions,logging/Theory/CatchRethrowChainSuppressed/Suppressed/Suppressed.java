package Theory.CatchRethrowChainSuppressed.Suppressed;


import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Suppressed {
    public static void main(String[] args) throws Exception {
        try {
            ExceptionExample1.test();
        } catch (Exception ex) {
            System.out.println("Exception encountered: " + ex.toString());
            final Throwable[] suppressedExceptions = ex.getSuppressed();
            final int numSuppressed = suppressedExceptions.length;
            if (numSuppressed > 0) {
                System.out.println("There are " + numSuppressed
                                + " suppressed exceptions:");
                for (final Throwable exception : suppressedExceptions) {
                    System.out.println("" + exception.toString());
                }

            }
        }
    }

/*
    static void howIsTeamLead() throws MyException {
        throw new MyException("MyEx");
    }

    static void getLeaveWithSuppressed() throws MyException {
        try {
            howIsTeamLead();
        } catch (MyException e) {
            try{
                PrintWriter out = null;
                File f = null;
                out = new PrintWriter(f);
                out.println(e.getMessage());
            }catch (Exception e1) {
                e.addSuppressed(e1);
            }
            throw e;
        }
    }
*/
}
