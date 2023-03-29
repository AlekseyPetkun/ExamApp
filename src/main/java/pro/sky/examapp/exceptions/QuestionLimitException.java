package pro.sky.examapp.exceptions;

/**
 * Ошибка лимита вопросов.
 */
public class QuestionLimitException extends RuntimeException{
    public QuestionLimitException(String message) {
        super("Заданное число вопросов превысило количество сохраненных");
    }
}
