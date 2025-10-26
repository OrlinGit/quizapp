package bg.quiz.app.service;

import bg.quiz.app.model.Quiz;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {
    private List<Quiz> quiz = new ArrayList<>();


    public QuizService(){
        ObjectMapper objectMapper = new ObjectMapper();
        try(InputStream inputStream = getClass().getResourceAsStream("/quiz.json")){
            if(inputStream == null){
                throw new RuntimeException("File not found");
            }
            quiz = objectMapper.readValue(inputStream, new TypeReference<List<Quiz>>() {
            });
        } catch (Exception e) {
            {
                throw new RuntimeException("File with quizzes not found!", e);
            }
        }
    }

    public List<Quiz> getQuiz() {
        return quiz;
    }
}
