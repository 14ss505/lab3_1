package Question;

import Answer.DecideAnswer;

public class DecideQuestion extends PromptQuestion {
	public DecideQuestion() {
		super(0);
		answer = new DecideAnswer();
		this.isGradable = true;
	}

	@Override
	public String getQuestion() {
		String ret = "T/F: " + prompt + "\n" + "1. right\n2. false";
		return ret;
	}

}
