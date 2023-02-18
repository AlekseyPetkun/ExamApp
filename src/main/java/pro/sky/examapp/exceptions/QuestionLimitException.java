package pro.sky.examapp.exceptions;

/**
 * Ошибка лимита вопросов.
 */
public class QuestionLimitException extends Exception{
    public QuestionLimitException(String message) {
        super("Заданное число вопросов превысило количество сохраненных");
    }
}
