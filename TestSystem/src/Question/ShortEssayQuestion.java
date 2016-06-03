package Question;

import java.util.List;

public class ShortEssayQuestion extends PromptQuestion {
	
	public ShortEssayQuestion(String prompt) {
		super(SHORTESSAY);
		this.prompt = prompt;
		//answer = new TextAnswer();
		this.isGradable = false;
	}
	
	public ShortEssayQuestion() {
		super(SHORTESSAY);
		//answer = new TextAnswer();
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
