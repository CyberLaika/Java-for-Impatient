package Theory.whyGenerics;


import java.util.ArrayList;
import java.util.Objects;

public class TestPair {
    //зачем generics когда можно использовать object
    public static void main(String[] args) {
        ArrayList<MyPairObj> booksObj= new ArrayList<>();
        booksObj.add( new MyPairObj(1438, new Book("Harry Potter and the Sorcerer’s Stone","Joanne Rowling", 1997)));
        booksObj.add(new MyPairObj(1796, new Book("Harry Potter and the Chamber of Secrets","Joanne Rowling", 1998)));
        booksObj.add( new MyPairObj(2075, new Book("Harry Potter and the Prisoner of Azkaban","Joanne Rowling", 1999)));
        booksObj.add( new MyPairObj(2076, "Harry Potter and the Goblet of Fire"));  //может привести к ошибке

        ArrayList<MyPairGen<Integer,Book>> booksGen = new ArrayList<>();
        booksGen.add( new MyPairGen<>(1438, new Book("Harry Potter and the Sorcerer’s Stone","Joanne Rowling", 1997)));
        booksGen.add(new MyPairGen<>(1796, new Book("Harry Potter and the Chamber of Secrets","Joanne Rowling", 1998)));
        booksGen.add( new MyPairGen<>(2075, new Book("Harry Potter and the Prisoner of Azkaban","Joanne Rowling", 1999)));
       // booksGen.add( new MyPairGen<>(2075,  "Harry Potter and the Goblet of Fire"));  //ошибка на этапе компиляции


        System.out.println(Objects.requireNonNull(search1(1438, booksObj)).toString());
        System.out.println(Objects.requireNonNull(search2(1438, booksGen)).toString());

        //1 нет необходимости кастить
        //2 ловим ошибки на этапе компиляции, а не в runtime
    }

    public static String search1(int key,ArrayList<MyPairObj> booksObj){
        for (int i=0;i<booksObj.size();i++)
            if ((int)booksObj.get(i).getKey() == key)
                return (String)booksObj.get(i).getValue();//ошибка в runtimeClassCastException
            return null;
    }

   public static String search2(int key,ArrayList<MyPairGen<Integer,Book>> booksGen){
        for (int i=0;i<booksGen.size();i++)
            if (booksGen.get(i).getKey() == key)
               // return booksGen.get(i).getValue();//ошбика на этапе компиляции
                i++;
        return null;
    }



}











































