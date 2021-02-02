package n3;

import n2.N2;

import java.io.FileNotFoundException;

public class Main3 {
    public static void main(String[] args) {
      try {
         System.out.print(N2.sumOfValues("testA.txt"));
      }catch(NumberFormatException e){
          e.printStackTrace();
        System.out.print("Неверный формат чисел");
        }catch (FileNotFoundException e){
          e.printStackTrace();
          System.out.print("Файл не найден");
      }
    }
}
