package command;

import Paper.Page;
import Question.Question;
import receiver.QuestionCreator;

public abstract class AddQuestion implements Command{
	protected Page page;
	protected Question question;
	protected QuestionCreator creator;
	
	public AddQuestion(Page page,Question question, QuestionCreator creator) {
		this.page = page;
		this.question = question;
		this.creator = creator;
	}
	
	public abstract void execute();
}
