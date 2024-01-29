package Quiz_Project.Teja.Model;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
@Entity
@SequenceGenerator(name = "quiz_seq", sequenceName = "quiz_seq", allocationSize = 1)
@Data
public class Quiz{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_seq")
    private Integer id;
    private String title;
    @ManyToMany
    private List<Question> question;
}
