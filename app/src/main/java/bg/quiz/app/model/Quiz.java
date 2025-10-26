package bg.quiz.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    private String id;
    private List<Question> questions;


    /*
    Lombok did not create this getter for some reason, so I added it manually.
     */
    public List<Question> getQuestions() {
        return questions;
    }
}
