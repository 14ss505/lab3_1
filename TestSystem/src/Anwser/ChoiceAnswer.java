package Anwser;

import java.util.List;

public class ChoiceAnswer extends Answer{
	int[] anwser;
	List<String> item;

	public ChoiceAnswer(int type) {
		super(Answer.CHOICE);
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		String ret = "";
		for(int i=0; i<anwser.length; i++){
			ret += item.get(anwser[i]);
		}
		return ret;
	}
	
	@Override
	public String writeAnswer(){
		String ret = "";
		for(int i=0; i<anwser.length; i++){
			ret += anwser[i] + " ";
		}
		return ret;
	}
	
	@Override
	public void setAnswer(String anwser) {
		// TODO Auto-generated method stub
		String[] anwsers = anwser.split(" ");
		this.anwser = new int[anwsers.length];
		for(int i=0; i<anwser.length(); i++){
			this.anwser[i] = Integer.parseInt(anwsers[i]);
		}
	}
	
	public void setItem(List<String> item){
		this.item = item;
	}

	@Override
	public boolean match(Answer answer) {
		return answer.writeAnswer().equals(this.writeAnswer());
	}
	
	
}
