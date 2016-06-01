package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Paper.Record;
import Question.Question;

public class AddDecideAnswer extends AddAnswer{
	private AnswerCreator creator;
	private String answer;
	private Record record;

	public AddDecideAnswer(Record record,String answer,AnswerCreator creator) {
		this.creator = creator;
		this.answer = answer;
		this.record = record;
	}

	@Override
	public void execute() {
		creator.createDecideAnswer(record.getPageName(),record.getPersonName(),answer);
	}
}
