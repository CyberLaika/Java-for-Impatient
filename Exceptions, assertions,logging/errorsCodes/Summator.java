package errorsCodes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Summator {

    private ArrayList<Double> arr = new ArrayList<>();
    private double sum;

    public Errors2.ErrorCodes readValues(String filename) {
        if (filename == null || filename.isEmpty()) {
            return Errors2.ErrorCodes.InvalidFIleName;
        }
        try {
            BufferedReader bReader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = bReader.readLine()) != null) {
                arr.add(Double.parseDouble(line));
            }
            return Errors2.ErrorCodes.Success;
        } catch (FileNotFoundException e) {
            return Errors2.ErrorCodes.FileNotFound;
        } catch (NumberFormatException numberFormatException) {
            return Errors2.ErrorCodes.InvalidNumberFormat;
        } catch (IOException e) {
            return Errors2.ErrorCodes.Fail;
        }
    }

    public Errors2.ErrorCodes resultOfSum(String filename) {
        Errors2.ErrorCodes err;
        if ((err = readValues(filename)) == Errors2.ErrorCodes.Success) {
            for (double a : arr)
                this.sum += a;
            return Errors2.ErrorCodes.Success;
        } else {
            return err;
        }
    }
     public double getResult(){return sum;}
    }
