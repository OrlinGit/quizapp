package bg.quiz.app.controller;

import bg.quiz.app.model.Question;
import bg.quiz.app.model.Quiz;
import bg.quiz.app.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class HomeController {

    private QuizService quizService;

    public HomeController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping({"/", "/home"})
    public String home(@RequestParam(defaultValue = "0") int question, Model model){
        List<Quiz> quizList = quizService.getQuiz();

        if(quizList.isEmpty()){
            model.addAttribute("message", "There are no questions loaded in the quiz!");
            return "home";
        }
        List<Question> questions = quizList.get(0).getQuestions();
        if (questions.isEmpty()){
            model.addAttribute("message", "The Quiz is empty!");
        } else {
            model.addAttribute("allQuestions", questions.size());
            model.addAttribute("question", question);
            model.addAttribute("currentQuestion", questions.get(question));
        }

        return "home";
    }

    @PostMapping("/submit")
    public String submitQuiz(@RequestParam Map<String, String> allAnswers, Model model){
        List<Quiz> quizList = quizService.getQuiz();
        List<Question> questions = quizList.get(0).getQuestions();
        String finalMessage = "";
        boolean isPassed = false;

        int counter = 0;
        /*
        In the HasMap wrongAnswers I hold the answers that the user got wrong but with the correct answers
        */
        Map<String, Integer> wrongAnswers = new HashMap<>();

        for (int i = 0; i< questions.size(); i++){
            String answer = allAnswers.get("answer" + i);
            if (answer != null && Integer.parseInt(answer) == questions.get(i).getCorrectAnswer()){
                counter++;
            } else {
                wrongAnswers.put("answer" + i, questions.get(i).getCorrectAnswer());
            }
        }

        model.addAttribute("wrongAnswers", wrongAnswers);
        model.addAttribute("allAnswers", questions.size());
        model.addAttribute("correctAnswers", counter);

        if(counter > 0.75 * questions.size()){
            finalMessage = "Great Job!";
            isPassed = true;
        } else {
            finalMessage = "Try again!";
        }

        model.addAttribute("finalMessage", finalMessage);
        model.addAttribute("QuizPassed", isPassed);
        return "result";
    }
}
