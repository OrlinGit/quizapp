package bg.quiz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Quiz {
    private String id;
    private List<Question> questions;

}
