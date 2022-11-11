package Exception;

/**
 * @author : 조재철
 * @since 1.0
 */
public class DuplicateIdException extends IllegalArgumentException {

    public DuplicateIdException(String message) {
        super(message);
    }
}
