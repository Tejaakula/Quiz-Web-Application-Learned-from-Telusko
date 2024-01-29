package Quiz_Project.Teja.Model;

import lombok.Data;

@Data
public class QuestionWrapper {
    public Integer id;
    public String difficulty_level;
    public String question_Title;
    public String option1;
    public String option2;
    public String option3;
    public String option4;

    public QuestionWrapper(Integer id, String difficulty_level, String question_Title, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.difficulty_level = difficulty_level;
        this.question_Title = question_Title;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(String difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public String getQuestion_Title() {
        return question_Title;
    }

    public void setQuestion_Title(String question_Title) {
        this.question_Title = question_Title;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
}
