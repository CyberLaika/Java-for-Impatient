package library;

import java.util.ArrayList;

public class MainLib {

    public static void main(String[] args) throws BookAlreadyExistsException, ShelfNotFoundException {
        BookStorage lib = new BookStorage();
        lib.add(new Shelf());
        lib.add(new Shelf());
        try {
          //  lib.add(new Book(1, "NewBook1", "Kant"), lib.getShelf(0));
         //   lib.delete(1);
          //  lib.add(new Book(2, "NewBook2", "Kant"), lib.getShelf(0));
           // System.out.println(lib.toString());
            ArrayList<Book>trans1 = new ArrayList<>();
            ArrayList<Book>trans2 = new ArrayList<>();
            trans1.add(new Book(1, "NewBook1", "Stephan"));
            trans1.add(new Book(2, "NewBook2", "Kant"));
            lib.transaction(trans1,lib.getShelf(0));

            trans2.add(new Book(3, "NewBook3", "Dima"));
           trans2.add(new Book(1, "NewBook4", "Magnus"));
            lib.transaction(trans2,lib.getShelf(1));

            System.out.println(lib.toString());

        }
        catch (ShelfNotFoundException | BookNotFoundException e){
            e.printStackTrace();


        }
    }
}
