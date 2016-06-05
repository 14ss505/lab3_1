package Question;

import java.util.List;

import Answer.ChoiceAnswer;
import Answer.RankAnswer;

public class RankQuestion extends ItemQuestion {
	
	public RankQuestion(String prompt, List<String> items, RankAnswer answer, int score){
		super(RANK);
		this.prompt = prompt;
		this.items = items;
		this.answer = answer;
		answer.setQuestion(items);
		this.score = score;
		this.setIsScore(true);
    }
	
	public RankQuestion(String prompt, List<String> items){
		super(RANK);
		this.prompt = prompt;
		this.items = items;
		this.setIsScore(true);
	}
	
	public void setAnswer(String answer) {
        ((RankAnswer)this.answer).setQuestion(items);
        ((RankAnswer)this.answer).setAnswer(answer);
	}

	@Override
	public String getQuestion(){
		String ret = "Rank: "+prompt + "\n";
		for(int i=0; i<items.size(); i++){
			ret += items.get(i)+"\n";
		}
		return ret;
	}

}
