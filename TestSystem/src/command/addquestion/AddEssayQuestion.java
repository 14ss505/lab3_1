package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.EssayQuestion;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddEssayQuestion extends AddQuestion {

	public AddEssayQuestion(Page page, EssayQuestion question, QuestionCreator creator) {
		super(page, question, creator);
	}

	@Override
	public void execute() {
		creator.createEssayQuestion(page,(EssayQuestion)question);
	}

}
