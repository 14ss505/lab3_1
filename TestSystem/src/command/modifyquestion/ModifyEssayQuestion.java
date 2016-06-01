package command.modifyquestion;

import Paper.Page;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyEssayQuestion extends ModifyQuestion {
    public ModifyEssayQuestion(String pageName,int index,int type, String prompt, int score, String answer, QuestionModifier modifier) {
        super(pageName,index,type, prompt, score, answer, modifier);
    }

    public ModifyEssayQuestion(String pageName,int index,int type, String prompt, QuestionModifier modifier) {
        super(pageName,index,type, prompt, modifier);
    }

    @Override
    public void execute() {
        if (type == Page.SURVEY) {
            modifier.modifyEssayQuestion(pageName,index,prompt);
        }
        else {
            modifier.modifyEssayQuestion(pageName,index,prompt, score, answer);
        }
    }
}
