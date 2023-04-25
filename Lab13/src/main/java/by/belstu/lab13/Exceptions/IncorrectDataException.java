package by.belstu.lab13.Exceptions;

public class IncorrectDataException extends Exception{
    public IncorrectDataException(String message) {
        super(message);
    }
    public IncorrectDataException(String message, Throwable cause) {
        super(message, cause);
    }
    public IncorrectDataException(Throwable cause) {
        super(cause);
    }
}
