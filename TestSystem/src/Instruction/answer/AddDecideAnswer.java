package Instruction.answer;

import Interface.AnswerCreator;
import MVC.model.Question.Question;

public class AddDecideAnswer extends AddAnswer{
	private AnswerCreator creator;
	private String answer;
	private Question question;

	public AddDecideAnswer(AnswerCreator creator,String answer,Question question) {
		this.creator = creator;
		this.answer = answer;
		this.question = question;
	}

	@Override
	public void execute() {
		creator.createDecideAnswer(question,answer);
	}
}
