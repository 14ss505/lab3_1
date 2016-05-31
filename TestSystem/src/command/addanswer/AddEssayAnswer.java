package command.addanswer;

import Interface.AnswerCreator;
import MVC.model.Question.Question;
import command.AddAnswer;

public class AddEssayAnswer extends AddAnswer{
	private AnswerCreator creator;
	private String answer;
	private Question question;

	public AddEssayAnswer(AnswerCreator creator,String answer,Question question) {
		this.creator = creator;
		this.answer = answer;
		this.question = question;
	}

	@Override
	public void execute() {
		creator.createEssayAnswer(question,answer);
	}

}
