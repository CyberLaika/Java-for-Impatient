package n4;

public class test4 {
    public static void main(String[] args) {
        Table<Integer,String> arr= new Table<>();
        //Table.Entry entry= new Table.Entry(10,"First");// не будет работать, так как вложенный класс не обобщенный
        //если класс вложенный(не статический), то ему не обязательно быть обобщенным, чтобы использовать дженерики внешнего класса
        //если класс вложенный статический. то без дженериков уже никуда
        arr.set(1,"First");
        arr.set(2,"Second");
        System.out.println();
    }
}
