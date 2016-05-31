package Answer;

import java.util.LinkedList;
import java.util.List;

public class RankAnswer extends Answer{
	List<Integer> rank = new LinkedList<Integer>();
	List<String> question = new LinkedList<String>();


	public RankAnswer() {
		super(Answer.RANK);
	}

	@Override
	public String getAnswer() {
		String ret = "";
		for(int i=0; i<question.size(); i++){
			ret+=" " + question.get(rank.get(i));
		}
		return ret;
	}

	@Override
	public void setAnswer(String answer) {
		String[] answers = answer.split(" ");
		rank.clear();
		for(int i=0; i<answers.length; i++){
			rank.add(Integer.parseInt(answers[i]));
		}
	}
	
	public void setQuestion(List<String> question){
		this.question = question;
	}

	@Override
	public String writeAnswer() {
		String ret = "";
		for(int i=0; i<rank.size(); i++){
			ret += rank.get(i) + " ";
		}
		return ret;
	}

}
