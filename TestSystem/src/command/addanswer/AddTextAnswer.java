package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Paper.Record;
import Question.Question;

public class AddTextAnswer extends AddAnswer{
	private AnswerCreator creator;
	private String answer;
	private Record record;

	public AddTextAnswer(Record record,String answer,AnswerCreator creator) {
		this.creator = creator;
		this.answer = answer;
		this.record= record;
	}

	@Override
	public void execute() {
		creator.createTextAnswer(record.getPageName(),record.getPersonName(),answer);
	}
}
