package n6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class N6 {
    public static void copyFileA(File f1, File f2) throws Exception {

        Scanner in = null;
        PrintWriter out = null;
        Exception mainThrowable=null;
        try  {
            in = new Scanner(f1);
            out = new PrintWriter(f2);
            while (in.hasNext()) {
                out.println(in.next());
            }
            System.out.println("Success");
        } catch (FileNotFoundException | NullPointerException e) {
            mainThrowable =e;
            throw e;
        } finally {
            if(mainThrowable == null){
                try{
                    if(in!=null)
                        in.close();
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
                try{
                    if(out!=null)
                        out.close();
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }

            }else{
                try{
                    if(in!=null) {
                        in.close();
                        // throw new FileNotFoundException();
                    }
                }
                catch(Exception ex){
                    mainThrowable.addSuppressed(ex);
                    System.out.println(ex.getMessage());
                    throw mainThrowable;
                }
                try{
                    if(out!=null)
                        out.close();
                }
                catch(Exception ex){
                    mainThrowable.addSuppressed(ex);
                    System.out.println(ex.getMessage());
                    throw mainThrowable;
                }
            }


        }
    }

    public static void copyFileB(File f1, File f2) {

        Scanner in = null;
        PrintWriter out = null;
        try  {
            in = new Scanner(f1);
            out = new PrintWriter(f2);
            while (in.hasNext()) {
                out.println(in.next());
            }
            in.close();
            out.close();
            System.out.println("Success");
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
            try{
                if(in!=null)
                    in.close();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(out!=null)
                    out.close();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void copyFileC(File f1, File f2) {

        Scanner in = null;
        PrintWriter out = null;
        try  {
            in = new Scanner(f1);
            out = new PrintWriter(f2);
            while (in.hasNext()) {
                out.println(in.next());
            }
            System.out.println("Success");
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            try{
                if(in!=null)
                    in.close();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(out!=null)
                    out.close();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }


}
