package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Question.Question;

public class AddTextAnswer extends AddAnswer{
	private AnswerCreator creator;
	private String answer;
	private Question question;

	public AddTextAnswer(AnswerCreator creator,String answer,Question question) {
		this.creator = creator;
		this.answer = answer;
		this.question = question;
	}

	@Override
	public void execute() {
		creator.createTextAnswer(question,answer);
	}
}
