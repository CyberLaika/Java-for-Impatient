package n5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class N5 {
    public static void copyFile(String filename1, String filename2) throws Exception {

     //   if (filename1 == null || filename2 == null) {
       //     System.out.println("fileName can't be null");
      //  } else {
            Scanner in = null;
            PrintWriter out = null;
            Exception mainThrowable=null;
            try {
                File  f1 = new File(filename1);
                File f2 = new File(filename2);
                in = new Scanner(f1);
                out = new PrintWriter(f2);
                while (in.hasNext()) {
                    out.println(in.next());
                }
             //   throw new NullPointerException();
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
    }
//}