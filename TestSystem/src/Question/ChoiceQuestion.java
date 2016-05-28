package Question;

import Anwser.ChoiceAnswer;

public class ChoiceQuestion extends ItemQuestion {
	public ChoiceQuestion(){
		super(1);
        this.answer = new ChoiceAnswer();
    }

	@Override
	public void setAnswer(String answer) {
        super.setAnswer(answer);
        ((ChoiceAnswer)this.answer).setItem(items);
	}

	@Override
	public String getQuestion(){
		String ret = "ChoiceQuestion: "+prompt+"\n";
		for(int i=0; i<items.size(); i++){
			ret += items.get(i)+"\n";
		}
		return ret;
	}
}
