package errorsCodes;

import javax.naming.InvalidNameException;
import java.io.IOException;

public class ErrMain {
    public static void main(String[] args) {
        Summator sum= new Summator();
        String filName="doubles.txt1";
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Errors2.ErrorCodes err=sum.resultOfSum(filName);
        if(err==Errors2.ErrorCodes.Success)
            System.out.println("Result: "+sum.getResult());
        else
            System.out.println(err.comment);
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("__________________________________________________________________________");

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            System.out.println(SummatorExs.resultOfSum(filName));
        }catch (IOException | InvalidNameException e){
            e.printStackTrace();
        }
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        }
        /*
        1.На каждом этапе вызова должны обрабатывать результаты предыдущего выполнения, за счёт возвращаемого значения
        2.Пишем много лишнего Boilerplate  кода(чем когда используем exceptions)
        3.Чтобы вернуть бизнес логику придётся извращаться
        */



}
