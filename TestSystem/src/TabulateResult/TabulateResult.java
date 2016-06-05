package TabulateResult;

import java.util.List;

import Paper.Record;
import Question.Question;

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
		System.out.println("tabulate result:"+result);
		return result;
	}
	
}
