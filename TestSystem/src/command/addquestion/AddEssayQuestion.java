package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddEssayQuestion extends AddQuestion {

	public AddEssayQuestion(Page page, String prompt, String answer, int score, QuestionCreator creator) {
		super(page, prompt, answer, score, creator);
	}

	public AddEssayQuestion(Page page, String prompt, QuestionCreator creator) {
		super(page, prompt, creator);
	}

	@Override
	public void execute() {
		creator.createEssayQuestion(prompt);
	}

}
