package bg.quiz.app.controller;

import bg.quiz.app.model.Quiz;
import bg.quiz.app.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private QuizService quizService;

    public HomeController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model){
        List<Quiz> quizList = quizService.getQuiz();
        if (quizList.isEmpty()){
            model.addAttribute("questions", null);
        } else {
            model.addAttribute("questions", quizList.get(0).getQuestions());
        }

        return "home";
    }

}
