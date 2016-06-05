package command;

import Answer.Answer;
import Paper.Page;
import receiver.AnswerCreator;

public abstract class AddAnswer implements Command{
	protected AnswerCreator creator;
	protected Page page;
	protected Answer answer;
	protected int index;
	
	public AddAnswer(Page page,Answer answer,int index,AnswerCreator creator) {
		this.page = page;
		this.answer = answer;
		this.index = index;
		this.creator = creator;
	}
	public abstract void execute();
}
