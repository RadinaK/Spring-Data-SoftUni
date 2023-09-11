package bg.softuni.springdatademo.exceptions;

public class EntityMissingException extends RuntimeException {
    public EntityMissingException(String msg) {
        super(msg);
    }
}
