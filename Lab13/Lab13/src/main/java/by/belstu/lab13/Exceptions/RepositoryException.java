package by.belstu.lab13.Exceptions;

public class RepositoryException extends Exception {
    public RepositoryException(String message) {
        super(message);
    }
    public RepositoryException(String message, Throwable cause) {
        super(message, cause);
    }
    public RepositoryException(Throwable cause) {
        super(cause);
    }
}
