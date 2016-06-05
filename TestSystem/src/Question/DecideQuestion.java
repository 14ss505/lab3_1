package Question;

import Answer.DecideAnswer;
import Paper.Page;

public class DecideQuestion extends PromptQuestion {
	public DecideQuestion( String prompt, DecideAnswer answer, int score){
		super(DECIDE);
		this.prompt = prompt;
		this.answer = answer;
		this.setAnswer(answer.getAnswer());
		this.score = score;
		this.isGradable = true;
	}

	public DecideQuestion(String prompt){
		super(DECIDE);
		this.prompt = prompt;
		//this.answer = new DecideAnswer();
		this.isGradable = true;
	}
	/*
	public DecideQuestion(){
		super(DECIDE);
		//this.answer = new DecideAnswer();
		this.isGradable = true;
	}*/
	
	@Override
	public String getQuestion(){
		String ret = "T/F: "+prompt+"\n"+"1. right\n2. false";
		return ret;
	}
	
}
