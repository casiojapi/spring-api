package maximosan.train.exceptions;

public class BookAlreadyOwnedException extends RuntimeException{
    public BookAlreadyOwnedException(String errorMessage) {
        super(errorMessage);
    }
}