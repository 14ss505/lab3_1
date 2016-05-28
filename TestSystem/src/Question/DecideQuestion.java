package Question;

import Anwser.Answer;
import Anwser.DecideAnswer;

public class DecideQuestion extends PromptQuestion {
	DecideAnswer answer;
	
	public DecideQuestion(){
		super(0);
	}

	
	@Override
	public String getQuestion(){
		String ret = "T/F: "+prompt+"\n"+"1. right\n2. false";
		return ret;
	}
	
	@Override
	public void setAnswer(String anwser){
		answer = new DecideAnswer();
		answer.setAnswer(anwser);
	}
	
	public boolean match(String answer) {
		return this.answer.getAnswer().equals(answer);
	}
}
