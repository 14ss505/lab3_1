package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Paper.Record;
import Question.Question;

public class AddMapAnswer  extends AddAnswer{
	private AnswerCreator creator;
	private String answer;
	private Record record;

	public AddMapAnswer(Record record,String answer,AnswerCreator creator) {
		this.creator = creator;
		this.answer = answer;
		this.record= record;
	}


	@Override
	public void execute() {
		creator.createMapAnswer(record.getPageName(),record.getPersonName(),answer);
	}

}
