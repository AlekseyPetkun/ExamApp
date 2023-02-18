package pro.sky.examapp.exceptions;

/**
 * Ошибка валидации.
 */

public class ValidationException extends Exception{
    public ValidationException(String message) {
        super("Ошибка валидации!");
    }
}
