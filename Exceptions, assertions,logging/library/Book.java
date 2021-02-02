package library;

public class Book {
    int id;
    String name;
    String author;

    public Book(int id, String name, String Author){
        this.id=id;
        this.name=name;
        this.author =Author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book getBook(){ return this; }

    public int getId(){return this.id;}

    public String getName(){return this.name;}

    public String getAuthor(){return this.author;}

    public boolean equal(Book book){
        return id == book.id || name.equals(book.name) && author.equals(book.author);
    }

}
