package Paper;

import java.util.LinkedList;
import java.util.List;

import Answer.Answer;

public class Record {
	protected List<Answer> answerList = new LinkedList<Answer>();
	protected int score;
	protected String personName;

	public int getScore() {
		return score;
	}
	public void addScore(int score) {
		this.score += score;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public void addAnwser(Answer answer){
		answerList.add(answer);
	}
	
	public Answer getAnswer(int index){// TODO: prerequirement
		if(index < answerList.size()){
			return answerList.get(index); 
		}
		return null;
	}

	public Iterator<Answer> iterator(){
		return new AnswerIterator();
	}
	
	class AnswerIterator implements Iterator<Answer>{
		int answerIndex = 0;
		
		@Override
		public boolean hasNext() {
			return answerIndex < answerList.size();
		}

		@Override
		public Answer next() {
			return answerList.get(answerIndex++);
		}
		
	}
}
