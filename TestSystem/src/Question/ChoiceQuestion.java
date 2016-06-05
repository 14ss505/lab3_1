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
		answer.setItem(items);
		this.score = score;
		this.setIsScore(true);
    }
	
	public ChoiceQuestion(String prompt, List<String> items){
		super(CHOICE);
		this.prompt = prompt;
		this.items = items;
		this.setIsScore(true);
    }
	
	public void setAnswer(String answer) {
		((ChoiceAnswer)this.answer).setItem(items);
		((ChoiceAnswer)this.answer).setAnswer(answer);
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
