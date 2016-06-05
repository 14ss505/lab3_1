package Question;

import java.util.List;

import Answer.ChoiceAnswer;
import Paper.Page;


public class ChoiceQuestion extends ItemQuestion {
	public ChoiceQuestion(String prompt, List<String> items, ChoiceAnswer answer, int score){
		super(CHOICE);
		this.prompt = prompt;
		this.items = items;
		this.answer = answer;
		this.setAnswer(answer.getAnswer());
		this.score = score;
        this.isGradable = true;
    }
	
	public ChoiceQuestion(String prompt, List<String> items){
		super(CHOICE);
		this.prompt = prompt;
		this.items = items;
		//this.answer = new ChoiceAnswer();
        this.isGradable = true;
    }

	public ChoiceQuestion(){
		super(CHOICE);
		//this.answer = new ChoiceAnswer();
        this.isGradable = true;
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
