package TabulateResult;

import java.util.List;

import Answer.MapAnswer;
import Paper.Record;

public class TabulateMapResult extends TabulateResult{
	public TabulateMapResult(List<Record> records,int questionIndex){
		super(records,questionIndex);
		this.setResult();
	}
	
	@Override
	public void setResult() {
		for(int i=0;i<records.size();i++){
			result += "答卷"+(i+1)+":"+"/n";
			String[] answers = ((MapAnswer)(records.get(i).getAnswer(questionIndex))).getAnswer();
			for(int j=0;j<answers.length;j++){
				result+="	"+answers[j]+"/n";
			}
		}
	}
}
