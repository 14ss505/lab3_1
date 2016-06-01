package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Paper.Record;
import Question.Question;

public class AddChoiceAnswer extends AddAnswer {
	
	public AddChoiceAnswer(String pageName,String personName,String answer,AnswerCreator creator) {
		super(pageName, personName, answer, creator);
	}

	@Override
	public void execute() {
		creator.createChoiceAnswer(pageName,personName,answer);
	}
}
