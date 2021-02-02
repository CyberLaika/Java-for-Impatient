package n14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class test14 {
    public static <T extends  AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception{
        Exception e = null;
        for(T elem :elems){
            try{
                elem.close();
            }catch(Exception ex){
                if(e==null)
                    e=ex;
                else
                    e.initCause(ex);
            }
        }
        if(e!=null)
            throw e;
    }

    public static void main(String[] args) throws Exception {
       ArrayList<Scanner> arr= new ArrayList<>();
       for(int i=0;i<10;i++)
        arr.add(new Scanner(new File("test.txt")));
      //  arr.set(1,null);
       // arr.set(2,null);
        closeAll(arr);
    }
}
