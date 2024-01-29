package Quiz_Project.Teja.Controller;
import Quiz_Project.Teja.Model.Question;
import Quiz_Project.Teja.Model.QuestionWrapper;
import Quiz_Project.Teja.Model.Response;
import Quiz_Project.Teja.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> CreateQuiz(@RequestParam String category, @RequestParam Integer numQ, @RequestParam String title){
        return quizService.CreateQuiz(category, numQ, title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> CalculateScore(@PathVariable Integer id, @RequestBody List<Response> response){
        return quizService.CalculateScore(id, response);
    }
}
