package n8;

public class test8 {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<>("abc","def");
        System.out.println("Max item:"+pair.max());
        System.out.println("Min item:"+pair.min());

        Pair<Integer> pair2= new Pair<>(1,2);
        System.out.println("Max item:"+pair2.max());
        System.out.println("Min item:"+pair2.min());
    }
}
