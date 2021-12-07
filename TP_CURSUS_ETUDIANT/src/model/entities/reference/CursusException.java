package model.entities.reference;

public class CursusException extends Exception {
    public CursusException() {
    }

    public CursusException(String message) {
        super(message);
    }

    public CursusException(String message, Throwable cause) {
        super(message, cause);
    }

    public CursusException(Throwable cause) {
        super(cause);
    }

    public CursusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
