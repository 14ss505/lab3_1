package Paper;

import java.util.LinkedList;
import java.util.List;

import Answer.Answer;
import Question.Question;

public class Record {
	protected List<Answer> answerList = new LinkedList<Answer>();
	protected int score;
	protected String personName;
	private Page page;

	public Record(){
		
	}
	
	public Record(Page page,String personName){
		this.page=page;
		this.personName=personName;
	}
	
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
			if(answerIndex < answerList.size()){
				return true;
			}
			return false;
		}

		@Override
		public Answer next() {
			return answerList.get(answerIndex++);
		}
		
	}

	public void grade(){
		if(page.getType()==0)//survey
			return;
		Iterator<Question> questionIterator = page.iterator();
		Iterator<Answer> answerIterator = this.iterator();
		if(questionIterator.hasNext()){
			Question q = questionIterator.next();
			if(q.IsGradable()){
				if(q.match(answerIterator.next())){
					this.addScore(q.getScore());
				}
			}else{
				answerIterator.next();
			}
		}
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
}
