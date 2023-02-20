package pro.sky.examapp.services.impl;


import org.springframework.stereotype.Service;
import pro.sky.examapp.exceptions.ValidationException;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.QuestionService;
import pro.sky.examapp.services.ValidationService;

import java.util.*;

/**
 * Бизнес-логика по работе с вопросами по Java.
 */

@Service
public class JavaQuestionServiceImpl implements QuestionService {

    private final Random random = new Random();
    private final Set<Question> javaQuestions = new LinkedHashSet<>();

    private final ValidationService validationService;

    public JavaQuestionServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }


    @Override
    public Question add(String question, String answer) {
        Question newQuestion =new Question(question, answer);
        addAndSave(newQuestion);
        return newQuestion;
    }

    @Override
    public Question addAndSave(Question question) throws ValidationException {
        if (!validationService.validate(question)) {
            throw new ValidationException(question.toString());
        }
        javaQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (javaQuestions.contains(question)) {
            javaQuestions.remove(question);
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        List<Question> list = new ArrayList<>(javaQuestions);
//        if (list.size() > 0) {
//            return list;
//        }
        return list;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(javaQuestions);
        int number = random.nextInt(getAll().size());
        return list.get(number);
    }
}
