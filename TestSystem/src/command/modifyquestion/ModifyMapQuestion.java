package command.modifyquestion;

import Paper.Page;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyMapQuestion extends ModifyQuestion {
    private String[] side1;
    private String[] side2;

    public ModifyMapQuestion(Page page, Question question, String prompt, int score, String answer, String[] side1, String[] side2, QuestionModifier modifier) {
        super(page, question, prompt, score, answer, modifier);
        this.side1 = side1;
        this.side2 = side2;
    }

    public ModifyMapQuestion(Page page, Question question, String prompt, String[] side1, String[] side2, QuestionModifier modifier) {
        super(page, question, prompt, modifier);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public void execute() {
        if (page.getType() == Page.SURVEY) {
            modifier.modifyMapQuestion(prompt, side1, side2);
        }
        else {
            modifier.modifyMapQuestion(prompt, side1, side2, score, answer);
        }
    }
}
