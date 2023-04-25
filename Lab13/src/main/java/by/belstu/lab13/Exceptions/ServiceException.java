package by.belstu.lab13.Exceptions;

public class ServiceException extends Exception{
    public ServiceException(String message) {
        super(message);
    }
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    public ServiceException(Throwable cause) {
        super(cause);
    }
}
