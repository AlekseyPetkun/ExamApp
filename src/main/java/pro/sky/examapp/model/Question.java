package pro.sky.examapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Описание сущности вопрос-ответ.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    private String question;
    private String answer;
}
