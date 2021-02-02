package n4;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main4 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Double> sum= new ArrayList<>();
        Errors.ErrorCodes0 error=N4.SumOfValuesError("tt.txt", sum);
        double error2=N4.sumOfValuesErrorEx("tt.txt", sum);
      /*  if(error==Errors.ErrorCodes.FileNotFound)
            System.out.println(sum.get(sum.size()-1));
        else
            System.out.println("\u001B[31m" + "Error:" + "\u001B[0m"+ Errors.ErrorCodes.getEnum(error).comment);
        System.out.println();
        */
    }

}
