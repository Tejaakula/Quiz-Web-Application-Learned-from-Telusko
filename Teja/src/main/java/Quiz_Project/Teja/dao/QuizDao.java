package Quiz_Project.Teja.dao;
import Quiz_Project.Teja.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz, Integer>{
}
