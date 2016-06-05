package Question;

import java.util.List;

import Answer.RankAnswer;

public class RankQuestion extends ItemQuestion {
	public RankQuestion(String prompt, List<String> items, RankAnswer answer, int score){
		super(RANK);
		this.prompt = prompt;
		this.items = items;
		this.answer = answer;
		this.setAnswer(answer.getAnswer());
		this.score = score;
        this.isGradable = true;
    }
	
	public RankQuestion(String prompt, List<String> items){
		super(RANK);
		this.prompt = prompt;
		this.items = items;
		//this.answer = new RankAnswer();
        this.isGradable = true;
    }

	public RankQuestion(){
		super(RANK);
		//this.answer = new RankAnswer();
        this.isGradable = true;
    }
	
	
	@Override
	public void setAnswer(String answer) {
        super.setAnswer(answer);
        ((RankAnswer)this.answer).setQuestion(items);
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
