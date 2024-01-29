package Quiz_Project.Teja.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String category;
    public String difficulty_level;
    public String question_Title;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String right_Answer;
}
