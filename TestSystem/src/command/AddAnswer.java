package command;

import Paper.Page;
import receiver.AnswerCreator;

public abstract class AddAnswer implements Command{
	protected AnswerCreator creator;
	protected String answer;
	protected String pageName;
	protected String personName;
	
	public AddAnswer(String pageName,String personName,String answer,AnswerCreator creator) {
		this.creator = creator;
		this.answer = answer;
		this.pageName=pageName;
		this.personName = personName;
	}
	public abstract void execute();
}
