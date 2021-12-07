package model.entities.exception;

public class EtudiantException extends Exception {

    public EtudiantException() {
    }

    public EtudiantException(String message) {
        super(message);
    }

    public EtudiantException(String message, Throwable cause) {
        super(message, cause);
    }

    public EtudiantException(Throwable cause) {
        super(cause);
    }

    public EtudiantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
