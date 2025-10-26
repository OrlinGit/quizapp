package bg.quiz.app.service;

import bg.quiz.app.model.Quiz;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class QuizService {
    private Map<String, Quiz> quiz = new HashMap<>();
    InputStream inputStream = getClass().getResourceAsStream("/quiz.json");

    public QuizService(){
        ObjectMapper objectMapper = new ObjectMapper();
    }

}
