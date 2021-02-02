package n12;

public class Person {
    int id;
    String name;
    String function;
    Person(int id, String name, String function){
        this.id=id;
        this.name=name;
        this.function=function;
    }
    public String toString(){
        return function+" "+name;
    }

    public int getId(){
        return id;
    }
}
