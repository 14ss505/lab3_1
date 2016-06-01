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

    public ModifyMapQuestion(String pageName,int index,int type, String prompt, int score, String answer, String[] side1, String[] side2, QuestionModifier modifier) {
        super(pageName,index,type, prompt, score, answer, modifier);
        this.side1 = side1;
        this.side2 = side2;
    }

    public ModifyMapQuestion(String pageName,int index,int type, String prompt, String[] side1, String[] side2, QuestionModifier modifier) {
        super(pageName,index,type, prompt, modifier);
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public void execute() {
        if (type == Page.SURVEY) {
            modifier.modifyMapQuestion(pageName,index,prompt, side1, side2);
        }
        else {
            modifier.modifyMapQuestion(pageName,index,prompt, side1, side2, score, answer);
        }
    }
}
