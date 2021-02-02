package n20;

import Theory.breakingGenerics.Apple;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

public class Test20 {

    @SafeVarargs
    public static <T> T[] repeat(int n, T... objs){
        @SuppressWarnings("unchecked")
        T[] result = (T[])java.lang.reflect.Array.newInstance(objs.getClass().getComponentType(),n*objs.length);
        for(int i=0;i<n;i++)
            for(int j=0;j<objs.length;j++)
                result[j+i*objs.length]=objs[j];
        return result;
    }


    public static void main(String[] args) {

        Object[] objects=new String[]{"Somebody", "once told me"};
        Object[] traitor=repeat (2,objects);// думает что возвращает Object[], но возвращает String[]. Если traitor будет иметь тип String[], то получим ошибку компиляции
        System.out.println(traitor.getClass().getComponentType());//получаем тип String
        System.out.println(Arrays.toString(traitor)+"\n");

        //1. Использование ковариантности
        //2. Использовать для varargs массив



        String[] str={"Somebody", "once told me"};
        Object[] traitor3=Test20.<Object>repeat (2,str);//думает что возвращает Object[], если traitor будет иметь тип String[], то получим ошибку компиляции
        System.out.println(traitor3.getClass().getComponentType());//получаем тип String
        System.out.println(Arrays.toString(traitor3));

    }

}
