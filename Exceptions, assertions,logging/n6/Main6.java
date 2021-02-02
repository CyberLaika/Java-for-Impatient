package n6;

import n5.N5;

import java.io.File;

public class Main6 {
    public static void main(String[] args) throws Exception {
        File f1=new File("test2.txt");
        File f2=new File("test228.txt");
        if (f1 == null || f2 == null)
            System.err.print("File could not be empty");
        else {
            System.out.println("Version A:");
            N6.copyFileA(f1, f2);
            System.out.println("Version B:");
            N6.copyFileB(f1, f2);
            System.out.println("Version C:");
            N6.copyFileC(f1, f2);
        }
    }
}
