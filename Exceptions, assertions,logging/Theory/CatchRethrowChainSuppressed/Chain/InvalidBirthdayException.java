package Theory.CatchRethrowChainSuppressed.Chain;

public class InvalidBirthdayException extends Exception {

    private static final long serialVersionUID = -897436973829584692L;

    public InvalidBirthdayException(){ }

    public InvalidBirthdayException(String message) { super(message); }

    public InvalidBirthdayException(String message, Throwable cause) {
        super(message, cause);
    }

}

