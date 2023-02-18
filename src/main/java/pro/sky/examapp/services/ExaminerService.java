package pro.sky.examapp.services;

import pro.sky.examapp.exceptions.QuestionLimitException;
import pro.sky.examapp.model.Question;

import java.util.Collection;

public interface ExaminerService {

    /**
     * Получение списка вопросов.
     * @param amount количество вопросов, которое хотим получить.
     * @return список с заданным количеством вопросов.
     * @throws QuestionLimitException
     */
    Collection<Question> getQuestions(int amount) throws QuestionLimitException;
}
