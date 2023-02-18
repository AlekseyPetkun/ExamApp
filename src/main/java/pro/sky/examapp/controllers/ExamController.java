package pro.sky.examapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examapp.exceptions.QuestionLimitException;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.ExaminerService;

import java.util.Collection;

/**
 *Контроллер для получения вопросов.
 */

@RestController
@RequestMapping("/exam")
@Tag(name = "API по работе с вопросами на экзамен",
        description = "Получение вопросов с ответами в случайном порядке")
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    @Operation(
            summary = "Получение списка вопросов с ответами",
            description = "Нужно написать число Вопросов с ответами, которое хотите получить"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Список вопросов с ответами был получен"
    )
    public ResponseEntity<Collection<Question>> getQuestions(@PathVariable int amount) {
        try {
            Collection<Question>amountQuestions = examinerService.getQuestions(amount);
            return ResponseEntity.ok(amountQuestions);
        } catch (QuestionLimitException e) {
            e.getStackTrace();
//            throw new RuntimeException(e);
            return ResponseEntity.notFound().build();
        }
    }
}
