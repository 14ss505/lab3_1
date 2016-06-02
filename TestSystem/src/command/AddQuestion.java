package command;

import receiver.QuestionCreator;

public abstract class AddQuestion implements Command{
	protected String pageName;
	protected String personName;
	protected int type;
	protected String answer;
	protected String prompt;
	protected QuestionCreator creator;
	protected int score;

	public AddQuestion(String pageName,String personName,int type, String prompt, String answer, int score, QuestionCreator creator) {
		this.pageName = pageName;
		this.personName = personName;
		this.type=type;
		this.score = score;
		this.answer = answer;
		this.prompt = prompt;
		this.creator = creator;
	}

	public AddQuestion(String pageName,String personName,int type, String prompt, QuestionCreator creator) {
		this.pageName = pageName;
		this.personName = personName;
		this.type=type;
		this.prompt = prompt;
		this.creator = creator;
	}

	public abstract void execute();
}
