package MVC.model.TabulateResult;

import java.util.List;

import MVC.model.Paper.Record;

public class TabulateEssayResult extends TabulateResult{
	public TabulateEssayResult(List<Record> records,int questionIndex){
		super(records,questionIndex);
		this.setResult();
	}
	
	@Override
	public void setResult() {
		for(int i=0;i<records.size();i++){
			result += "答卷"+(i+1)+":"+records.get(i).getAnswer(questionIndex);
		}
	}
}
