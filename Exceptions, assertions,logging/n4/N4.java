package n4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class N4 {
    public static Errors.ErrorCodes0 SumOfValuesError(String filename, ArrayList<Double> result){
            double resultOfSum = 0;
            if (filename == null || filename.isEmpty()) {
                return Errors.ErrorCodes0.InvalidFIleName;
            }
            Scanner in;
            try {
                in = new Scanner(new File(filename));
                while (in.hasNextDouble()) {
                    resultOfSum +=in.nextDouble();
                }
            } catch (FileNotFoundException e) {
                return Errors.ErrorCodes0.FileNotFound;
            }
            result.add(resultOfSum);
            return Errors.ErrorCodes0.Success;
        }



    public static double sumOfValuesErrorEx(String filename, ArrayList<Double> result) throws FileNotFoundException {
        double resultOfSum = 0;
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("FIlename can't be empty");
        }
        Scanner in;
        try {
            in = new Scanner(new File(filename));
            while (in.hasNextDouble()) {
                resultOfSum +=in.nextDouble();
            }
        } catch (FileNotFoundException e) {
            throw e;
        }
        result.add(resultOfSum);
        return resultOfSum;
    }
}





/*
1.На каждом этапе вызова должны обрабатывать результаты предыдущего выполнения, за счёт возвращаемого значения
2.Пишем много лишнего боллерплэйд кода(чем когда используем exceptions)
3.Чтобы вернуть бизнес логику придётся извращаться
 */