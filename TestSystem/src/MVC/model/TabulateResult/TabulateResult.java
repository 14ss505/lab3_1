package MVC.model.TabulateResult;

import java.util.List;

import MVC.model.Paper.Record;
import MVC.model.Question.Question;

public abstract class TabulateResult {
	protected Question question;
	protected int questionIndex;
	protected List<Record> records;
	protected String result;
	
	public TabulateResult(List<Record> records,int questionIndex){
		this.records=records;
		List<Question> questionList = records.get(0).getPage().getQuestionList();
		this.question = questionList.get(questionIndex);
		this.questionIndex = questionIndex;
	}
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public abstract void setResult();
	
	public String getResult(){
		return result;
	}
	
}
