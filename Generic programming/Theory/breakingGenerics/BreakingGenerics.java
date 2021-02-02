package Theory.breakingGenerics;

import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;

public class BreakingGenerics {

    public static void main(String[] args) {
        Apple redApple= new Apple("red");
        Apple greenApple= new Apple("green");

        //a
        Pair<String,String>  pair1 =   new Pair(redApple,greenApple);
        Pair<String,String>  pair2 =  (Pair) new Pair<Apple,Apple>(redApple,greenApple);

        //b
        Pair<String,String> pair3=new Pair<>("not redApple","not greenApple");
        Pair<Apple,Apple>  pair4 =   new Pair<>(redApple,greenApple);
       // pair3=(Pair<String,String>)pair4;

        pair3 = new Pair(redApple,greenApple);

        System.out.println(pair1.getValue());
    }



}
