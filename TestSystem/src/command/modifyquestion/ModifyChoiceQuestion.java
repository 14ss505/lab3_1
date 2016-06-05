package command.modifyquestion;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyChoiceQuestion extends ModifyQuestion {
   
    public ModifyChoiceQuestion(Page page,ChoiceQuestion question,int index, QuestionModifier modifier) {
        super(page, question, index, modifier);
    }

    @Override
    public void execute() {
       modifier.modifyChoiceQuestion(page, (ChoiceQuestion)question, index);
    }
}
