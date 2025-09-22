package starplatinum.task;

/**
 * Custom exception class for Star Platinum application errors.
 */
public class StarPlatinumException extends Exception {

    /**
     * Creates a new StarPlatinumException with the specified message.
     *
     * @param message The error message.
     */
    public StarPlatinumException(String message) {
        super(message);
    }

    /**
     * Creates a new StarPlatinumException with the specified message and cause.
     *
     * @param message The error message.
     * @param cause The cause of this exception.
     */
    public StarPlatinumException(String message, Throwable cause) {
        super(message, cause);
    }
}