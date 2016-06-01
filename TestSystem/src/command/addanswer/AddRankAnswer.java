package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Paper.Record;
import Question.Question;

public class AddRankAnswer  extends AddAnswer{

	public AddRankAnswer(String pageName,String personName,String answer,AnswerCreator creator) {
		super(pageName, personName, answer, creator);
	}

	@Override
	public void execute() {
		creator.createRankAnswer(pageName,personName,answer);
	}
}
