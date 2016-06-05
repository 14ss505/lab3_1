package Question;

import Answer.DecideAnswer;
import Answer.MapAnswer;
import Paper.Page;

public class DecideQuestion extends PromptQuestion {
	public DecideQuestion( String prompt, DecideAnswer answer, int score){
		super(DECIDE);
		this.prompt = prompt;
		this.answer = answer;
		this.score = score;
		this.setIsScore(true);
	}

	public DecideQuestion(String prompt){
		super(DECIDE);
		this.prompt = prompt;
		this.setIsScore(true);
	}
	
	@Override
	public String getQuestion(){
		String ret = "T/F: "+prompt+"\n"+"1. right\n2. false";
		return ret;
	}
	
	public void setAnswer(String answer) {
        ((DecideAnswer)this.answer).setAnswer(answer);
	}

}
