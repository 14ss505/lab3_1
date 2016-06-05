package TabulateResult;

import java.util.List;

import Answer.DecideAnswer;
import Paper.Record;
import Question.DecideQuestion;

public class TabulateDecideResult extends TabulateResult{
	
	public TabulateDecideResult(List<Record> records,int questionIndex){
		super(records,questionIndex);
		question = (DecideQuestion)this.getQuestion();
		this.setResult();
	}
	
	@Override
	public void setResult() {
		int Tnum = 0;
		int Fnum = 0;
		for(int i =0 ;i<records.size();i++){
			DecideAnswer answer = (DecideAnswer) records.get(i).getAnswer(questionIndex);
			int answerInt = Integer.parseInt(answer.writeAnswer());
			if(answerInt==1){
				Tnum++;
			}
			else{
				Fnum++;
			}
		}
		result = "选择'T'的人次为："+Tnum+"\n选择'F'的人次为："+Fnum;
	}
}
