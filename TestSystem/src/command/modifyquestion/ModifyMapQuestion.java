package command.modifyquestion;

import Paper.Page;
import Question.MapQuestion;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyMapQuestion extends ModifyQuestion {
    
	public ModifyMapQuestion(Page page, MapQuestion question, int index, QuestionModifier modifier) {
        super(page, question, index, modifier);
	}

    @Override
    public void execute() {
        modifier.modifyMapQuestion(page, (MapQuestion)question, index);
    }
}
