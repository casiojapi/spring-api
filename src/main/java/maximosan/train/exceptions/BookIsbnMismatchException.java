package maximosan.train.exceptions;

public class BookIsbnMismatchException extends RuntimeException {

    public BookIsbnMismatchException(String errorMessage) {
        super(errorMessage);
    }
}