package Theory;

import Theory.breakingGenerics.Apple;
import Theory.breakingGenerics.Fruit;
import Theory.breakingGenerics.StrangeApple;
import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

public class PECS {
    public static void method(){
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple("red"));

        Fruit fruit=apples.get(0);
        Apple apple=apples.get(0);
        apples.add(new StrangeApple("red"));
        //StrangeApple strangeApple = apples.get(0);

        ArrayList<StrangeApple> strangeAppleArrayList=new ArrayList<>();
        //apples=strangeAppleArrayList;//инвариантность
    }

    public static void method1() throws Throwable{
        //ошибка вызванная ковраиантностью массивов
        Throwable[] t = new Exception[4];
        t[0] = new IllegalArgumentException();
        t[1] = new FileNotFoundException();
        t[2] = new IllegalAccessError();//вот тут
        t[3] = new NullPointerException();
        for (Throwable ts : t)
            throw ts;
    }




    public static void method2(ArrayList<? extends Exception> arr){//ковариантность ..  Producer-extends
        //зачем нужен extends, если уго убрать, тогда в method2Test будет ошибка
        for(int i=1;i<arr.size();i++) {
            arr.get(0).initCause(arr.get(i));
        }
        Exception ex=arr.get(0);//разрешено
        // arr.add(new Exception());//однако запись уже запрещена(так как точный тип неизвестен)
        // arr.add(new SocketException());
        //т.е. можно сказать, что subtype wildcard позволяет присваивать родителю всех его потомков, читать из него при этом можно только сам класс и его предков
        //а записать в него нельзя вообще ничего
        arr.get(0).printStackTrace();
    }

    public static void method2Test(){
        ArrayList<IOException> arr= new ArrayList<>();

        arr.add(new IOException());
        arr.add(new FileNotFoundException());
        arr.add(new SocketException());

        method2(arr);
    }

    public static void method3(ArrayList<? super IOException> arr){//позволяет передавать в arr не только лист IOException, но и лист всех его предков
        for(int i=0;i<10;i++)
            arr.add(new IOException());

        //Exception ex= arr.get(0);//для контрвариатности так уже нельзя
        Pair<String,String> pair = new Pair<>( new Apple("red").toString(),new Apple("red").toString());

        Object obj=arr.get(0);
        arr.add( new IOException());
        arr.add(new SocketException());//зато для контрвариатности можно добавлять сам класс и его потомков
    }

    public static void method3Test()
    {
        ArrayList<IOException> arr= new ArrayList<>();
        ArrayList<Exception> arr2= new ArrayList<>();

        method3(arr);
        method3(arr2);
    }

    public static  <T>T method322(T obj){
        return obj;
    }
    public static void main(String[] args)  {
        method2Test();


        //инвариантность генериков->ковариатность



        /*
        ArrayList<?> objs= new ArrayList<Exception>();
        objs.add("Hello");
        objs.add(5);
        objs.add(new Exception());
         */
    }
}
