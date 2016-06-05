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
			int[][] answerPair = ((MapAnswer)(records.get(i).getAnswer(questionIndex))).getAnswerPair();
			for(int j=0;j<answerPair.length;j++){
				result+="	<"+answerPair[j][0]+","+answerPair[j][1]+"/n";
			}
		}
	}
}
