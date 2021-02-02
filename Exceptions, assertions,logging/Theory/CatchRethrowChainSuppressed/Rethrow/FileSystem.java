package Theory.CatchRethrowChainSuppressed.Rethrow;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileSystem {
    ArrayList<File> files;
    String currentCommand;
    File currentFile;
    FileSystem(){
        this.files=new ArrayList<File>();
        this.currentCommand="";
    }
    FileSystem(String str){
        ArrayList<File> files=new ArrayList<File>();
        String currentCommand="str";
    }

    public void monitor(){
        boolean fl=true;
        while (fl){
        Scanner i = new Scanner(System.in);
       currentCommand = i.nextLine();
        switch(currentCommand) {
            case "Считать файл":
                try {
                    System.out.println(Rethrow.readFile(currentFile));
                } catch (FileNotFoundException | NullPointerException e) {
                    e.printStackTrace();
                    files.remove(currentFile);
                }
                break;
            case "Удалить файл":
                files.remove(currentFile);
                break;
            case "Добавить файл":
                try {
                    Scanner in = new Scanner(System.in);
                    String filename = in.nextLine();
                    files.add(new File(filename));
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                break;
            default:
                fl = false;
        }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = null;
        out = new PrintWriter(new File("tt.txt"));
           out.println("Hello world");
           out.close();
      //  Scanner in = new Scanner(new File("tt.txt"));
     //   in.close();
        FileSystem fl = new FileSystem();
        fl.monitor();
    }

}