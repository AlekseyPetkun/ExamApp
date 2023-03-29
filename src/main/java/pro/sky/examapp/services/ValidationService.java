package pro.sky.examapp.services;

import pro.sky.examapp.model.Question;

/**
 * Сервис валидации.
 */
public interface ValidationService {
    /**
     * Валидация сущности Question
     * @param question сущность для валидации.
     * @return валидность сущности
     */
    boolean validate(Question question);
}
