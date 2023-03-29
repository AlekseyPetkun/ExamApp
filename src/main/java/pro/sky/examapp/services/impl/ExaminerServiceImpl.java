package pro.sky.examapp.services.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examapp.exceptions.QuestionLimitException;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.ExaminerService;
import pro.sky.examapp.services.QuestionService;

import java.util.*;

/**
 * Бизнес-логика по работе с экзаменационными вопросами.
 */

@Service
public class ExaminerServiceImpl implements ExaminerService {
    //    private final Random random = new Random();
    private final QuestionService javaQuestionService;


    public ExaminerServiceImpl(@Qualifier("javaQuestionServiceImpl") QuestionService questionService) {
        this.javaQuestionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws QuestionLimitException {
        int size = javaQuestionService.getAll().size();
        if (size < amount) {
            throw new QuestionLimitException("Заданное число вопросов превысило количество сохраненных");
        }
        Set<Question> listQuestions = new HashSet<>();

        while (listQuestions.size() < amount) {
            listQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return listQuestions;
    }
}
