package pro.sky.examapp.services.impl;

import org.springframework.stereotype.Service;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.ValidationService;

/**
 * Бизнес-логика по работе с валидацией.
 */
@Service
public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Question question) {
        return question!=null
                && question.getQuestion()!=null
                && question.getAnswer()!=null
                && !question.getQuestion().isEmpty()
                && !question.getAnswer().isEmpty()
                && !question.getQuestion().equals(question.getAnswer());
    }
}
