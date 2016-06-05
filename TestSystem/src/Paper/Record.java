package Paper;

import java.util.LinkedList;
import java.util.List;

import Answer.Answer;
import Question.Question;

public class Record {
	protected List<Answer> answerList = new LinkedList<Answer>();
	protected int score;
	protected String personName;
	protected String pageName;
	private Page page;

	public Record(String pageName,String personName){
		this.pageName = pageName;
		this.personName = personName;
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

	public List<Answer> getAnswerList(){// TODO: prerequirement
		return answerList; 
	}
	
	public Iterator<Answer> iterator(){
		return new AnswerIterator();
	}

	public void resetAnswer(int index, Answer newAnswer) {
		answerList.add(index, newAnswer);
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
		if(page.getType()==Page.SURVEY)//survey
			return;
		if(answerList.size()==0)
			return;
		Iterator<Question> questionIterator = page.iterator();
		Iterator<Answer> answerIterator = this.iterator();
		if(questionIterator.hasNext()){
			Question q = questionIterator.next();
			if(q.isScore()){
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

	public void setPageName(String pageName) {
		this.pageName=pageName;
	}
	
	public String getPageName(){
		return pageName;
	}
	
}
