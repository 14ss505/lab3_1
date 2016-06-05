package command;

import Paper.Page;
import Question.Question;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public abstract class ModifyQuestion implements Command{
    protected Page page;
    protected Question question;
	protected int index;
    protected QuestionModifier modifier;
   
    public ModifyQuestion(Page page,Question question,int index, QuestionModifier modifier) {
        this.page = page;
        this.question = question;
    	this.index = index;
        this.modifier = modifier;
    }

    public abstract void execute();
}
