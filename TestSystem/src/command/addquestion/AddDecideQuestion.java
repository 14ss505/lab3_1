package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddDecideQuestion extends AddQuestion {

	public AddDecideQuestion(Page page, String prompt, String answer, int score, QuestionCreator creator) {
		super(page, prompt, answer, score, creator);
	}

	public AddDecideQuestion(Page page, String prompt, QuestionCreator creator) {
		super(page, prompt, creator);
	}

	@Override
	public void execute() {
		if (type == Page.TEST) {
			creator.createDecideQuestion(prompt, score, answer);

		} else {
			creator.createDecideQuestion(prompt);
		}
	}

}
