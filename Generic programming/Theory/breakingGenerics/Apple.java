package Theory.breakingGenerics;

public class Apple extends Fruit {
    String color;
    public Apple(String color){
        super();
        this.color=color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }
}
