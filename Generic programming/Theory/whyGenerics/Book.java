package Theory.whyGenerics;

public class Book {
    String name;
    String authorName;
    int year;
    Book(String name, String authorName, int year){
        this.name=name;
        this.authorName=authorName;
        this.year=year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", year=" + year +
                '}';
    }
}
