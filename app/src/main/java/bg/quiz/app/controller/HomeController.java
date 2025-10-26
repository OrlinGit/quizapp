package bg.quiz.app.controller;

import bg.quiz.app.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private QuizService quizService;

    public HomeController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model){
        model.addAttribute("quiz", quizService.getQuiz());
        return "home";
    }

}
