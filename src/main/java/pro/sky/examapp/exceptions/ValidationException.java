package pro.sky.examapp.exceptions;

/**
 * Ошибка валидации.
 */

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super("Ошибка валидации!");
    }
}
