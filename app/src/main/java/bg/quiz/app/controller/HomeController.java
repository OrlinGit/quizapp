package bg.quiz.app.controller;

import bg.quiz.app.model.Question;
import bg.quiz.app.model.Quiz;
import bg.quiz.app.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


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

    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> allAnswers, Model model){
        List<Quiz> quizList = quizService.getQuiz(); // I use list if in future I need to add multiple Quizzes.
        List<Question> questions = quizList.get(0).getQuestions();

        int counter = 0;

        for (int i = 0; i< questions.size(); i++){
            String answer = allAnswers.get("answer" + i);
            if (answer != null && Integer.parseInt(answer) == questions.get(i).getCorrectAnswer()){
                counter++;
            }
        }

        model.addAttribute("allAnswers", questions.size());
        model.addAttribute("correctAnswers", counter);

        return "result";
    }
}
