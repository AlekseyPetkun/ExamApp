package pro.sky.examapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.examapp.exceptions.ValidationException;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.QuestionService;

import java.time.Month;
import java.util.Collection;

/**
 * Контроллер для CRUD-операций с вопросами.
 */
@RestController
@RequestMapping("/exam/java")
@Tag(name = "API по работе с вопросами на экзамен по Java",
        description = "CRUD-операции для вопросов по экзамену")
public class JavaQuestionController {
    private final QuestionService javaQuestionService;

    public JavaQuestionController(QuestionService questionService) {
        this.javaQuestionService = questionService;
    }

    @PostMapping
    @Operation(
            summary = "Создание вопроса с ответом",
            description = "Нужно написать вопрос и ответ"
    )

    @ApiResponse(
            responseCode = "200",
            description = "Вопрос с ответом был добавлен"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Вопрос с ответом не добавлен"
    )
    public ResponseEntity<Question> addQuestion(@RequestParam(required = false) String question,
                                                @RequestParam(required = false) String answer) throws ValidationException {
//        try {

        return ResponseEntity.ok(javaQuestionService.add(question, answer));
//        } catch (ValidationException e) {
//            e.getStackTrace();
//            return ResponseEntity.notFound().build();
//        }
    }


    @GetMapping
    @Operation(
            summary = "Показать все вопросы с ответами"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Вопрос с ответом были найдены"
    )
    public ResponseEntity<Collection<Question>> getAllQuestions() {
        return ResponseEntity.ok(javaQuestionService.getAll());
    }

    @DeleteMapping()
    @Operation(
            summary = "Удаление вопроса с ответом",
            description = "Нужно написать вопрос и ответ, который хотите удалить"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Вопрос с ответом были удалены"
    )
    public ResponseEntity<Void> deleteQuestion(@RequestParam(required = false) String question,
                                               @RequestParam(required = false) String answer) {

        javaQuestionService.remove(new Question(question, answer));
        return ResponseEntity.ok().build();
    }
}
