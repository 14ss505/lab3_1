package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.MapQuestion;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddMapQuestion extends AddQuestion {
	
	public AddMapQuestion(Page page, MapQuestion question, QuestionCreator creator) {
		super(page, question, creator);
	}

	@Override
	public void execute() {
		creator.createMapQuestion(page,(MapQuestion)question);
	}
}
