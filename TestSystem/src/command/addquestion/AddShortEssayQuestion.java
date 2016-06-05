package command.addquestion;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.ShortEssayQuestion;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddShortEssayQuestion extends AddQuestion {

	public AddShortEssayQuestion(Page page, ShortEssayQuestion question, QuestionCreator creator) {
		super(page, question, creator);
	}

	@Override
	public void execute() {
		creator.createShortEssayQuestion(page,(ShortEssayQuestion)question);
	}
}
