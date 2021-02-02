package Theory.TryWihoutResources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) throws Throwable {
        //fileRot13(null,"tt.txt");
        fileRot13("theoryTest.txt", "tt.txt");
    }

    public static void fileRot13(String filenameFrom, String filenameTo) throws Throwable {
        Scanner in = null;
        PrintWriter out = null;
        Throwable th = null;
        Throwable f1 = null;
        Throwable f2 = null;
        try {
            File fileFrom = new File(filenameFrom);
            File fileTO = new File(filenameTo);
            in = new Scanner(fileFrom);
            out = new PrintWriter(fileTO);
            while (in.hasNextLine()) {
                out.println(strRot13(in.nextLine()));
            }
        } catch (NullPointerException e) {
            System.err.println("null filename");
            th = e;
        } catch (FileNotFoundException e) {
            System.err.println("File wasn't found");
            th = e;
        } catch (SecurityException e) {
            System.err.println("Don't have access to file");
            th = e;
        } catch (IllegalStateException e) {
            System.err.println("Scanner is closed, data can't be written");
            th = e;
        } catch (IllegalArgumentException e) {
            System.err.println("Please use english");
            th = e;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    if (th == null)
                        th = e;
                    else
                        th.addSuppressed(e);
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    if (th == null)
                        th = e;
                    else
                        th.addSuppressed(e);
                }
            }
        }
        if (th != null) {
            throw th;
        }
    }


    public static void fileRot13Res(String filenameFrom, String filenameTo) throws Throwable {
        Throwable th = null;
        Throwable f1 = null;
        Throwable f2 = null;
        File fileFrom = new File(filenameFrom);
        File fileTO = new File(filenameTo);
        try (Scanner in = new Scanner(fileFrom);
             PrintWriter out = new PrintWriter(fileTO);) {
            while (in.hasNextLine()) {
                out.println(strRot13(in.nextLine()));
            }
        } catch (NullPointerException e) {
            System.err.println("null filename");
            th = e;
            throw th;
        } catch (FileNotFoundException e) {
            System.err.println("File wasn't found");
            th = e;
            throw th;
        } catch (SecurityException e) {
            System.err.println("Don't have access to file");
            th = e;
            throw th;
        } catch (IllegalStateException e) {
            System.err.println("Scanner is closed, data can't be written");
            th = e;
            throw th;
        } catch (IllegalArgumentException e) {
            System.err.println("Please use english");
            th = e;
            throw th;
        }
    }


    public static String strRot13(String str) throws IllegalArgumentException {
        int abyte = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            abyte = str.charAt(i);
            if (abyte > 150)
                throw new IllegalArgumentException("Remember, no Russian");
            int cap = abyte & 32;
            abyte &= ~cap;
            abyte = ((abyte >= 'A') && (abyte <= 'Z') ?
                    ((abyte - 'A' + 13) % 26 + 'A')
                    : abyte) | cap;
            result.append((char) abyte);
        }
        return result.toString();
    }
}
