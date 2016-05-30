package MVC.model.Question;

import MVC.model.Answer.DecideAnswer;

public class DecideQuestion extends PromptQuestion {
	public DecideQuestion(){
		super(0);
		answer = new DecideAnswer();
	}

	
	@Override
	public String getQuestion(){
		String ret = "T/F: "+prompt+"\n"+"1. right\n2. false";
		return ret;
	}
	
}
