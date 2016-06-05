package Answer;

import java.util.LinkedList;
import java.util.List;

public class RankAnswer extends Answer{
	List<Integer> rank = new LinkedList<Integer>();
	List<String> question = new LinkedList<String>();


	public RankAnswer(String answer) {
		super(Answer.RANK);
		System.out.println("rank answer :"+answer);
		setAnswer(answer);
	}

	public String[] getAnswer() {
		String[] ret = new String[question.size()];
		for(int i=0; i<question.size(); i++){
			ret[i]= question.get(rank.get(i));
		}
		return ret;
	}

	public void setAnswer(String answer) {
		if(answer.equals("")){
			this.setDefaultAnswer();
			return;
		}
		
		String[] answers = answer.split(" ");
        rank.clear();
		for(int i=0; i<answers.length; i++){
			rank.add(Integer.parseInt(answers[i]));
			System.out.println("rank answer"+i+":"+Integer.parseInt(answers[i]));
		}
	}
	
	public void setDefaultAnswer(){
		rank.clear();
		for(int i=0; i<question.size(); i++){
			rank.add(-1);
		}
	}
	
	public void setQuestion(List<String> question){
		this.question = question;
	}

	@Override
	public String writeAnswer() {
		String ret = "";
		for(int i=0; i<rank.size()-1; i++){
			ret += rank.get(i) + " ";
		}
		if(rank.size()>0)
			ret +=rank.get(rank.size()-1);
		return ret;
	}

}
