package command.modifyquestion;

import Paper.Page;
import Question.EssayQuestion;
import Question.ShortEssayQuestion;
import command.ModifyQuestion;
import receiver.QuestionModifier;

public class ModifyShortEssayQuestion extends ModifyQuestion {
	public ModifyShortEssayQuestion(Page page, ShortEssayQuestion question,int index, QuestionModifier modifier) {
        super(page, question, index, modifier);
    }

    @Override
    public void execute() {
        modifier.modifyShortEssayQuestion(page, (ShortEssayQuestion)question, index);
    }
}
