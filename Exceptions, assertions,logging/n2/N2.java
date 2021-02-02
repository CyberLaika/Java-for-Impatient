package n2;

import n1.N1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class N2 {
    public static double sumOfValues(String filename) throws FileNotFoundException,NumberFormatException {
        ArrayList<Double> array= new ArrayList<Double>();
       array= N1.readValues(filename);
       double sum=0;
        for(Double v:array)
            sum+=v;
        return sum;
    }
}
