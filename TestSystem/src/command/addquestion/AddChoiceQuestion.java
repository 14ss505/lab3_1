package command.addquestion;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;


public class AddChoiceQuestion extends AddQuestion {
	private String[] items;

	public AddChoiceQuestion(String pageName,String personName,int type, String promt, String answer, int score, String[] items, QuestionCreator creator) {
		super(pageName, personName, type, promt, answer, score, creator);
		this.items = items;
	}

	public AddChoiceQuestion( String pageName,String personName,int type, String promt, String[] items, QuestionCreator creator) {
		super(pageName,personName,type, promt, creator);
		this.items = items;
	}

	@Override
	public void execute() {
		if (type == Page.TEST) {
			creator.createChoiceQuestion(pageName,prompt, items, score, answer);
		} else {
			creator.createChoiceQuestion(pageName,prompt, items);
		}
	}
}
