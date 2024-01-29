package Quiz_Project.Teja.dao;
import Quiz_Project.Teja.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
    List<Question> findBycategory(String category);
    @Query(value = "select * from question q where q.category=:category order by random() limit :numQ", nativeQuery = true)
    List<Question> findRandomquestionBycategory(String category, Integer numQ);
}