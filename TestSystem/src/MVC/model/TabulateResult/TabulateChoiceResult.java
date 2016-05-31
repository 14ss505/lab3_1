package MVC.model.TabulateResult;

import java.util.List;

import MVC.model.Answer.ChoiceAnswer;
import MVC.model.Answer.DecideAnswer;
import MVC.model.Paper.Record;
import MVC.model.Question.ChoiceQuestion;
import MVC.model.Question.ItemQuestion;


public class TabulateChoiceResult extends TabulateResult{
	
	public TabulateChoiceResult(List<Record> records,int questionIndex){
		super(records,questionIndex);
		this.setResult();
	}
	
	@Override
	public void setResult() {
		List<String> items = ((ItemQuestion) question).getItem();
		int[] answersNum = new int[items.size()];
		for(int i =0 ;i<records.size();i++){
			ChoiceAnswer answer = (ChoiceAnswer) records.get(i).getAnswer(questionIndex);
			String[] answers = answer.getAnswer().split(" ");
			for (int j = 0; j < answers.length; j++) {
				if(answers[j].equals("1"))
					answersNum[j]++;
			}
		}
		
		for(int i =0 ;i<items.size();i++){
			result = "选择"+i+": "+items.get(i)+"的人次为："+answersNum[i]+"\n";
		}
		
	}
}
