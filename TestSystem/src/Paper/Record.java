package Paper;

import java.util.LinkedList;
import java.util.List;

import org.jdom.Element;

import Answer.Answer;
import Answer.ChoiceAnswer;
import Answer.DecideAnswer;
import Answer.EssayAnswer;
import Answer.MapAnswer;
import Answer.RankAnswer;
import Answer.ShortEssayAnswer;
import Question.Question;

public class Record {
	protected Answer[] answerList;
	protected int score;
	protected String personName;
	protected String pageName;
	private Page page;

	public Record(String pageName,String personName){
		this.pageName = pageName;
		this.personName = personName;
	}
	
	public int getTotalScore() {
		return score;
	}

	public void setTotalScore(int totalScore) {
		this.score = totalScore;
	}
	
	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
		initList(page);
	}
	
	private void initList(Page page){
		int length = page.getQuestionSize();
		answerList = new Answer[length];
		for(int i=0;i<length;i++){
			defaultAnswer(i,page.getQuestion(i).getAnswer().getType());
		}
	}
	
	private void defaultAnswer(int index,int answerType){
		switch (answerType) {
		case Answer.DECIDE:{
			DecideAnswer decide = new DecideAnswer("");
			answerList[index] = decide;
			break;
		}
		case Answer.CHOICE:{
			ChoiceAnswer choice = new ChoiceAnswer("");
			answerList[index] = choice;
			break;
		}
		case Answer.SHORTESSAY:{
			ShortEssayAnswer text = new ShortEssayAnswer("");
			answerList[index] = text;
			break;
		}
		case Answer.ESSAY:{
			EssayAnswer essay = new EssayAnswer("");
			answerList[index] = essay;
			break;
		}
		case Answer.RANK:{
			RankAnswer rank = new RankAnswer("");
			answerList[index] = rank;
			break;
		}
		case Answer.MAP:{
			int[][] array = {{0,0}};
			MapAnswer map = new MapAnswer(array);
			answerList[index] = map;
			break;
		}
		}
	}
	
	public void setPageName(String pageName) {
		this.pageName=pageName;
	}
	
	public String getPageName(){
		return pageName;
	}
	
	
	public Answer getAnswer(int index){// TODO: prerequirement
		if(index < answerList.length){
			return answerList[index]; 
		}
		return null;
	}

	public Answer[] getAnswerList(){// TODO: prerequirement
		return answerList; 
	}
	
	public Iterator<Answer> iterator(){
		return new AnswerIterator();
	}

	public void setAnswer(int index, Answer newAnswer) {
		System.out.println("index:"+index+" answer: "+newAnswer.writeAnswer());
		System.out.println("before add:answer list length:"+answerList.length);
		answerList[index]=newAnswer;
		System.out.println("after add:answer list length:"+answerList.length);
	}
	
	class AnswerIterator implements Iterator<Answer>{
		int answerIndex = 0;
		
		@Override
		public boolean hasNext() {
			if(answerIndex < answerList.length){
				return true;
			}
			return false;
		}

		@Override
		public Answer next() {
			return answerList[answerIndex++];
		}
		
	}

	public void grade(){
		if(page.getType()==Page.SURVEY)//survey
			return;
		if(answerList.length==0)
			return;
		Iterator<Question> questionIterator = page.iterator();
		Iterator<Answer> answerIterator = this.iterator();
		if(questionIterator.hasNext()&&answerIterator.hasNext()){
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

	public void addScore(int score) {
		this.score += score;
	}
}
