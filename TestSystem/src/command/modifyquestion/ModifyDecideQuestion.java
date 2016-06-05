package command.modifyquestion;

import Paper.Page;
import Question.DecideQuestion;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyDecideQuestion extends ModifyQuestion {

    public ModifyDecideQuestion(Page page, 	DecideQuestion question,int index, QuestionModifier modifier) {
        super(page, question, index, modifier);
    }
    
    @Override
    public void execute() {
        modifier.modifyDecideQuestion(page, (DecideQuestion)question, index);
    }
}
