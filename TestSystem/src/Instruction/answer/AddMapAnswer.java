package Instruction.answer;

import Interface.AnswerCreator;
import MVC.model.Question.Question;

public class AddMapAnswer  extends AddAnswer{
	private AnswerCreator creator;
	private String answer;
	private Question question;

	public AddMapAnswer(AnswerCreator creator,String answer,Question question) {
		this.creator = creator;
		this.answer = answer;
		this.question = question;
	}

	@Override
	public void execute() {
		creator.createMapAnswer(question,answer);
	}

}
