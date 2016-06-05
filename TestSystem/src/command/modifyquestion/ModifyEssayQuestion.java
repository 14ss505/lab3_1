package command.modifyquestion;

import Paper.Page;
import Question.EssayQuestion;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyEssayQuestion extends ModifyQuestion {
    public ModifyEssayQuestion(Page page, EssayQuestion question,int index, QuestionModifier modifier) {
        super(page, question, index, modifier);
    }

    @Override
    public void execute() {
        modifier.modifyEssayQuestion(page, (EssayQuestion)question, index);
    }
}
