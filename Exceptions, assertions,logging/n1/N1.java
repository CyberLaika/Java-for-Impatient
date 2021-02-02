package n1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class N1 {

    public static ArrayList<Double> readValues(String filename) throws FileNotFoundException,NumberFormatException {/////////////////добавить NumberFormatException
        ArrayList<Double> array=new ArrayList<Double>();
        if(filename.isEmpty())
            throw new IllegalArgumentException("Filename is empty");
        BufferedReader in = new BufferedReader(new FileReader(filename));
       array= (ArrayList<Double>) in.lines().mapToDouble(Double::parseDouble).boxed().collect(Collectors.toList());
        return array;
    }

    public static void writeValues() throws IOException {
        FileWriter fw = new FileWriter("test10.txt");
        //fw.write("Hello World");
        fw.write("96\n412\n49\n76.4");
        fw.close();
    }
}

   /* double[] array = null;
        try (
                BufferedReader in = new BufferedReader(new FileReader(filename))) {
                array = in.lines().mapToDouble(Double::parseDouble).toArray();
                } catch (IOException e) {
                System.out.println("ГДЕ?");
                e.printStackTrace();
                }
                catch (NumberFormatException e) {
                System.out.println("Так себе число.");
                e.printStackTrace();
                }
                ArrayList<Double> arr = new ArrayList<Double>();
        assert array != null;/////////////////////////////////////////////////////////////////////////////////////////////
        for (double v : array) arr.add(v);
        return arr;
        }

    */