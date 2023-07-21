package pro.sky.examapp.services;

import pro.sky.examapp.exceptions.ValidationException;
import pro.sky.examapp.model.Question;

import java.util.Collection;

/**
 * Сервис по работе с вопросами по Java.
 */
public interface QuestionService {

    /**
     * Получаем сущность в виде вопроса-ответа.
     *
     * @param question вопрос.
     * @param answer   ответ на вопрос.
     * @return сущность вопрос-ответ.
     * @throws ValidationException
     */
    Question add(String question, String answer);

    /**
     * @param question сущность вопрос-ответ.
     * @return сохраненную сущность.
     * @throws ValidationException
     */
    Question addAndSave(Question question);

    /**
     * Удаляем сущность.
     *
     * @param question сущность, которую нужно удалить.
     * @return удаленную сущность.
     */
    Question remove(Question question);

    /**
     * Получаем список всех сущностей.
     *
     * @return список всех сущностей.
     */
    Collection<Question> getAll();

    /**
     * Получаем случайно выбранную сущность.
     *
     * @return случайно выбранная сущность.
     */
    Question getRandomQuestion();
}
