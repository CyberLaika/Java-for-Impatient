package errorsCodes;

import javax.naming.InvalidNameException;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SummatorExs {

    public static ArrayList<Double> readValues(String filename) throws IOException, InvalidNameException {
        ArrayList<Double> arr = new ArrayList<>();
        if (filename == null || filename.isEmpty()) {
            throw new InvalidNameException();
        }
        BufferedReader bReader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = bReader.readLine()) != null) {
            arr.add(Double.parseDouble(line));
        }
        return arr;
    }

    public static double resultOfSum(String filename) throws IOException, InvalidNameException {
            double sum=0;
            for (double a : readValues(filename))
                sum += a;
            return sum;
    }
}