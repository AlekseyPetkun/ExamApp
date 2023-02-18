package pro.sky.examapp.services.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.examapp.exceptions.ValidationException;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.JavaQuestionService;
import pro.sky.examapp.services.ValidationService;

import java.util.*;

/**
 * Бизнес-логика по работе с вопросами по Java.
 */

@Service
public class JavaQuestionServiceImpl implements JavaQuestionService {

    private final Random random = new Random();
    private static final Set<Question> questions = new LinkedHashSet<>();

    private final ValidationService validationService;

    public JavaQuestionServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }


    @Override
    public Question add(String question, String answer) {
        if (StringUtils.isEmpty(question) && StringUtils.isEmpty(answer)&& question.equals(answer)) {
            return null;
        }
        return new Question(question, answer);
    }

    @Override
    public Question addAndSave(Question question) throws ValidationException {
        if (!validationService.validate(question)) {
            throw new ValidationException(question.toString());
        }
        questions.add(question);
            return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.contains(question)) {
            questions.remove(question);
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        List<Question> list = new ArrayList<>(questions);
        if (list.size() > 0) {
            return list;
        }
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(questions);
        int number = random.nextInt(getAll().size());
        return list.get(number);
    }
}
