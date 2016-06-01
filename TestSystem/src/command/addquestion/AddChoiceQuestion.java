package command.addquestion;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;


public class AddChoiceQuestion extends AddQuestion {
	private String[] items;

	public AddChoiceQuestion(Page page, String promt, String answer, int score, String[] items, QuestionCreator creator) {
		super(page, promt, answer, score, creator);
		this.items = items;
	}

	public AddChoiceQuestion(Page page, String promt, String[] items, QuestionCreator creator) {
		super(page, promt, creator);
		this.items = items;
	}

	@Override
	public void execute() {
		if (type == Page.TEST) {
			creator.createChoiceQuestion(page,prompt, items, score, answer);
		} else {
			creator.createChoiceQuestion(page,prompt, items);
		}
	}
}
