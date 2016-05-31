package MVC.model.Question;

import MVC.model.Answer.RankAnswer;

public class RankQuestion extends ItemQuestion {
	public RankQuestion(){
		super(4);
        answer = new RankAnswer();
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
