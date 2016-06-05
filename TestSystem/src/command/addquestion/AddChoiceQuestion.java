package command.addquestion;

import Paper.Page;
import Question.ChoiceQuestion;
import command.AddQuestion;
import receiver.QuestionCreator;


public class AddChoiceQuestion extends AddQuestion {
	
	public AddChoiceQuestion(Page page, ChoiceQuestion question, QuestionCreator creator) {
		super(page, question, creator);
	}

	@Override
	public void execute() {
		creator.createChoiceQuestion(page,(ChoiceQuestion)question);
	}
}
