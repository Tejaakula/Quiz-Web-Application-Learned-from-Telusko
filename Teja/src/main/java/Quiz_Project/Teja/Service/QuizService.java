package Quiz_Project.Teja.Service;
import Quiz_Project.Teja.Model.Question;
import Quiz_Project.Teja.Model.QuestionWrapper;
import Quiz_Project.Teja.Model.Quiz;
import Quiz_Project.Teja.Model.Response;
import Quiz_Project.Teja.dao.QuestionDao;
import Quiz_Project.Teja.dao.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService{
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<String> CreateQuiz(String category, Integer numQ, String title){
        try{
            List<Question> questions = questionDao.findRandomquestionBycategory(category, numQ);
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestion(questions);
            quizDao.save(quiz);
            return new ResponseEntity<>("Created", HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Not Able to create", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        try{
            Optional<Quiz> quiz = quizDao.findById(id);
            List<Question> questionfromDB = quiz.get().getQuestion();
            List<QuestionWrapper> questiontoUser = new ArrayList<>();
            for(Question q : questionfromDB){
                QuestionWrapper qw = new QuestionWrapper(q.getId(), q.difficulty_level, q.getQuestion_Title(), q.option1, q.option2, q.option3, q.option4);
                questiontoUser.add(qw);
            }
            return new ResponseEntity<>(questiontoUser, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Integer> CalculateScore(Integer id, List<Response> response) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestion();
        int i = 0;
        int right = 0;
        for(Response responses : response){
            if(responses.getResponse().equals(questions.get(i).getRight_Answer())){
                right++;
            }
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
