package Question;

import java.util.List;

import Answer.Answer;
import Answer.EssayAnswer;

public class EssayQuestion extends Question {
	
	public EssayQuestion(String prompt,EssayAnswer answer,int score ){
		super(ESSAY);
		this.prompt = prompt;
		this.answer = answer;
		this.score = score;
		this.setIsScore(false);
	}
	
	public EssayQuestion(String prompt){
		super(ESSAY);
		this.prompt = prompt;
		this.setIsScore(false);
	}
	
	@Override
	public String getQuestion(){
		return "Essay: "+prompt;
	}

	public void setAnswer(String answer) {
		((EssayAnswer)(this.answer)).setAnswer(answer);
	}

	@Override
	public boolean match(Answer answer) {
		//Do nothing
		return false;
	}
}
