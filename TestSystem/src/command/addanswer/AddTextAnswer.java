package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Paper.Record;
import Question.Question;

public class AddTextAnswer extends AddAnswer{

	public AddTextAnswer(String pageName,String personName,String answer,AnswerCreator creator) {
		super(pageName, personName, answer, creator);
	}

	@Override
	public void execute() {
		creator.createTextAnswer(pageName,personName,answer);
	}
}
