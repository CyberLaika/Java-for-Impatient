package library;

import java.util.ArrayList;

public class BookStorage {
    ArrayList<Shelf> shelfs;
    public BookStorage(){
        shelfs= new ArrayList<Shelf>();
    }

    public void add( Shelf shelf){
        shelfs.add(shelf);
    }

    public void add(Book book, Shelf shelf) throws ShelfNotFoundException, BookAlreadyExistsException {
            int id;
            if((id=shelfs.indexOf(shelf))==-1)
                throw new ShelfNotFoundException("Shelf not found");
            else
                if(haveBookLib(book))
                    throw new BookAlreadyExistsException();
            else
                shelfs.get(id).add(book);

    }

    @Override
    public String toString() {
        return "BookStorage{" +
                "shelfs=" + shelfs.toString() +
                '}';
    }

    public Shelf getShelf(int n) throws ShelfNotFoundException {
        if(n<shelfs.size())
            return shelfs.get(n);
        throw new ShelfNotFoundException("Shelf not found");
    }

    public Book get(int id) throws BookNotFoundException {
        for(int i=0;i<shelfs.size();i++){
            try{
                return shelfs.get(i).get(id);
            } catch (BookNotFoundException e) {
                System.out.println("Shelf "+i+" "+e.getMessage());
            }
        }
        throw new BookNotFoundException();

    }

    public Shelf where(int id) throws BookNotFoundException {
        for(int i=0;i<shelfs.size();i++){
            try{
                 shelfs.get(i).get(id);
                 return shelfs.get(i);
            } catch (BookNotFoundException e) {
                System.out.println("Shelf "+i+" "+e.getMessage());
            }
        }
        throw new BookNotFoundException();

    }

    public boolean haveBookLib(Book book){
        for (Shelf shelf : shelfs) {
            if (shelf.haveBook(book))
                return true;
        }
            return false;
    }

    public void delete(int id) throws BookNotFoundException {
        for(int i=0;i<shelfs.size();i++){
            try{
                shelfs.get(i).delete(id);
                return;
            } catch (BookNotFoundException e) {
                System.out.println("Shelf "+i+" "+e.getMessage());
            }
        }
        throw new BookNotFoundException();
    }

    public void transaction(ArrayList<Book> booksArr, Shelf shelf) throws BookNotFoundException {
        int i=0;
        try{
            for(;i<booksArr.size();i++){
                this.add(booksArr.get(i),shelf);
            }
        } catch (ShelfNotFoundException e) {
            e.printStackTrace();
        }
        catch (BookAlreadyExistsException e) {
            e.printStackTrace();
            i--;
            for(;i>=0;i--)
                this.delete(booksArr.get(i).getId());
        }
    }



}
