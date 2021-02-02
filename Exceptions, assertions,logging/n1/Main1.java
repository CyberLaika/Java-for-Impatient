package n1;
import n1.N1;

import java.util.ArrayList;

public class Main1 {
    public static void main(String[] args) throws Exception{
        N1 n = new N1();
        ArrayList<Double> arr = new ArrayList<Double>();
        N1.writeValues();
        arr = N1.readValues("test10.txt");
        System.out.print(arr);
    }
}
