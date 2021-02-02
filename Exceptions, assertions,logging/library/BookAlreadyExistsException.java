package library;

import java.io.IOException;

public class BookAlreadyExistsException extends IOException {
    private static final long serialVersionUID = -898796973823962492L;

    public BookAlreadyExistsException() {
    }

    public BookAlreadyExistsException(String message) {
        super(message);
    }

    public BookAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

