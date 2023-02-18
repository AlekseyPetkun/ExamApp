package pro.sky.examapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.examapp.exceptions.ValidationException;
import pro.sky.examapp.model.Question;
import pro.sky.examapp.services.JavaQuestionService;

import java.util.Collection;

/**
 * Контроллер для CRUD-операций с вопросами.
 */
@RestController
@RequestMapping("/exam/java")
@Tag(name = "API по работе с вопросами на экзамен",
        description = "CRUD-операции для вопросов по экзамену")
public class JavaController {
    private final JavaQuestionService javaQuestionService;

    public JavaController(JavaQuestionService questionService) {
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
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        try {
            Question question1 = javaQuestionService.addAndSave(question);
            return ResponseEntity.ok(question1);
        } catch (ValidationException e) {
            e.getStackTrace();
            return ResponseEntity.notFound().build();
        }
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

    @DeleteMapping("/{question}")
    @Operation(
            summary = "Удаление вопроса с ответом",
            description = "Нужно написать вопрос и ответ, который хотите удалить"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Вопрос с ответом были удалены"
    )
    public ResponseEntity<Void> deleteQuestion(@PathVariable Question question) {
        javaQuestionService.remove(question);
        return ResponseEntity.ok().build();
    }
}
