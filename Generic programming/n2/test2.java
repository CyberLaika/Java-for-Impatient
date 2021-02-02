package n2;

public class test2 {
    public static void main(String[] args) {

        StackE<String> str1= new StackE<>(5,String[]::new);
        StackO<String> str2 = new StackO<>(5);
        str1.push("hello");
        str2.push("goodbye");
        System.out.println(str1.pop());
        System.out.println(str2.pop());

        for(int i=0;i<10;i++){
            str1.push(Integer.toString(i));
            str2.push(Integer.toString(i));
        }
        for(int i=0;i<10;i++){
            System.out.println(str1.pop());
            System.out.println(str2.pop());
        }

    }
}
