package Exception;

/**
 * @author : 조재철
 * @since 1.0
 */
public class NotFoundMemberException extends IllegalArgumentException {

    public NotFoundMemberException(String message) {
        super(message);
    }
}
