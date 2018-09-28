package cmApiApp.exceptions;

public class TooMuchException extends Exception {

    private String message;
    private int ableToAdd;

    public TooMuchException(String message, int overflowAmount) {
        super(message);
        this.message = message;
        this.ableToAdd = overflowAmount;
    }

    @Override
    public String getMessage() {
        return this.message + ", able to add " + this.ableToAdd;
    }

}
