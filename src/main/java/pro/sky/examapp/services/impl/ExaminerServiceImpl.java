package pro.sky.examapp.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examapp.exceptions.QuestionLimitException;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.ExaminerService;
import pro.sky.examapp.services.JavaQuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * Бизнес-логика по работе с экзаменационными вопросами.
 */

@Service
public class ExaminerServiceImpl implements ExaminerService {
    //    private final Random random = new Random();
    private final JavaQuestionService questionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") JavaQuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws QuestionLimitException {
        int size = questionService.getAll().size();
        if (size < amount) {
            throw new QuestionLimitException(toString());
        }
        List<Question> listQuestions = new ArrayList<>();
        int i = 0;
        while (i < amount) {
            listQuestions.add(questionService.getRandomQuestion());
            i++;
        }
        return listQuestions;
    }
}
