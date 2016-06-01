package Question;

import Answer.Answer;
import Answer.EssayAnswer;

public class EssayQuestion extends Question {
	public EssayQuestion(){
		super(3);
		answer = new EssayAnswer();
		this.isGradable = false;
	}
	
	@Override
	public String getQuestion(){
		return "Essay: "+prompt;
	}

	@Override
	public void setAnswer(String answer) {
		this.answer.setAnswer(answer);
	}

	@Override
	public boolean match(Answer answer) {
		//Do nothing
		return false;
	}
}
