package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import Question.DecideQuestion;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddDecideQuestion extends AddQuestion {
	Page page;
	DecideQuestion question;
	
	public AddDecideQuestion(Page page, DecideQuestion question, QuestionCreator creator) {
		super(page, question, creator);
	}

	@Override
	public void execute() {
		creator.createDecideQuestion(page,(DecideQuestion)question);
	}

}
