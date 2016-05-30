package MVC.model.Question;

import MVC.model.Answer.Answer;

public class EssayQuestion extends Question {
	public EssayQuestion(){
		super(3);
	}
	
	@Override
	public String getQuestion(){
		return "Essay: "+prompt;
	}

	@Override
	public void setAnswer(String answer) {
		//Do nothing
		
	}

	@Override
	public boolean match(Answer answer) {
		//Do nothing
		return false;
	}
}
