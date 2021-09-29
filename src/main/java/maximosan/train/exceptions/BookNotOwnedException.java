package maximosan.train.exceptions;

public class BookNotOwnedException extends RuntimeException{
    public BookNotOwnedException(String errorMessage) {
        super(errorMessage);
    }
}