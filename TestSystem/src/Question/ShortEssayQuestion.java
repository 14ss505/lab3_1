package Question;

import Anwser.Answer;
import Anwser.TextAnswer;

public class ShortEssayQuestion extends PromptQuestion {
	
	TextAnswer answer;
	
	public ShortEssayQuestion() {
		super(2);
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public String getQuestion(){
		return "Text: "+prompt;
	}
	
	@Override
	public void setAnswer(String answer) {
		// TODO Auto-generated method stub
		
		this.answer = new TextAnswer();
		this.answer.setAnswer(answer);
	}
}
