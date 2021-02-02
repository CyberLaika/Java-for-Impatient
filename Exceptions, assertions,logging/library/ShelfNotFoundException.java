package library;

import java.io.IOException;

public class ShelfNotFoundException  extends IOException {
    private static final long serialVersionUID = -897436973829580492L;

    public ShelfNotFoundException(){ }

    public ShelfNotFoundException(String message) {
        super(message);
    }

    public ShelfNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

