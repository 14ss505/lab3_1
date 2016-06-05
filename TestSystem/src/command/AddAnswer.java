package command;

import Answer.Answer;
import Paper.Page;
import receiver.AnswerCreator;

public abstract class AddAnswer implements Command{
	protected AnswerCreator creator;
	protected Page page;
	protected Answer answer;
	protected int index;
	protected String personName;
	
	public AddAnswer(Page page,Answer answer,int index,AnswerCreator creator,String personName) {
		this.page = page;
		this.answer = answer;
		this.index = index;
		this.creator = creator;
		this.personName = personName;
	}
	public abstract void execute();
}
