package command;

import Paper.Page;
import receiver.QuestionCreator;

public abstract class AddQuestion implements Command{
	protected int type;
	protected Page page;
	protected String answer;
	protected String prompt;
	protected QuestionCreator creator;
	protected int score;

	public AddQuestion(String pageName,String personName,int type, String prompt, String answer, int score, QuestionCreator creator) {
		this.score = score;
		this.page = page;
		this.type = page.getType();
		this.answer = answer;
		this.prompt = prompt;
		this.creator = creator;
	}

	public AddQuestion(String pageName,String personName,int type, String prompt, QuestionCreator creator) {
		this.page = page;
		this.type = page.getType();
		this.prompt = prompt;
		this.creator = creator;
	}

	public abstract void execute();
}
