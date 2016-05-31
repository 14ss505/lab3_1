package Question;

import Answer.TextAnswer;

public class ShortEssayQuestion extends PromptQuestion {
	
	public ShortEssayQuestion() {
		super(2);
		answer = new TextAnswer();
		 this.isGradable = false;
	}
	
	@Override
	public String getQuestion(){
		return "Text: "+prompt;
	}
	
	@Override
	public void setAnswer(String answer) {
		this.answer.setAnswer(answer);
	}
}
