package library;

import java.util.ArrayList;

public class Shelf {
    ArrayList<Book> books;

    public Shelf(){
        this.books =new ArrayList<Book>();
    }

    public Shelf(Book book){
        this();
        books.add(book);
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "books=" + books +
                '}';
    }

    public Book get(int id) throws BookNotFoundException {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new BookNotFoundException("Book not found");
    }

    public boolean haveBook(Book bookArg) {
        for (Book book : books) {
            if (book.equal(bookArg)) {
                return true;
            }
        }
        return false;
    }

    public void add(Book newBook) throws BookAlreadyExistsException {
       if(this.haveBook(newBook))
           throw new BookAlreadyExistsException("This book already exists");
        else
            books.add(newBook);
    }

    public void delete(int id)throws BookNotFoundException {
        if(!books.removeIf(book -> book.getId() == id))
            throw new BookNotFoundException("Book not found");
    }
    }
