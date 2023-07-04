package maximosan.train.exceptions;

public class UserUsernameMismatchException extends RuntimeException {

    public UserUsernameMismatchException(String errorMessage) {
        super(errorMessage);
    }
}