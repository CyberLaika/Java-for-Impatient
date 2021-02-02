package library;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BookNotFoundException extends IOException {
    private static final long serialVersionUID = -897556973823780492L;

    public BookNotFoundException(){ }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
