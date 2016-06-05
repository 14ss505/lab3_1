package Question;

import java.util.List;

import Answer.ShortEssayAnswer;

public class ShortEssayQuestion extends PromptQuestion {
	
	public ShortEssayQuestion(String prompt,ShortEssayAnswer answer,int score ){
		super(SHORTESSAY);
		this.prompt = prompt;
		this.answer = answer;
		this.score = score;
		this.setIsScore(true);
	}
	
	public ShortEssayQuestion(String prompt) {
		super(SHORTESSAY);
		this.prompt = prompt;
		answer = new ShortEssayAnswer("");
		this.setIsScore(true);
	}
	
	@Override
	public String getQuestion(){
		return "Text: "+prompt;
	}
	
	public void setAnswer(String answer) {
		((ShortEssayAnswer)(this.answer)).setAnswer(answer);
	}
}
