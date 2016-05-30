package MVC.model.Answer;

public class DecideAnswer extends Answer{
	
	int answer;

	public DecideAnswer() {
		super(Answer.DECIDE);
	}

	@Override
	public String getAnswer() {
		String ret = ""+answer;
		return ret;
	}


	@Override
	public void setAnswer(String anwser) {
		this.answer = Integer.parseInt(anwser);
	}


	@Override
	public String writeAnswer() {
		return answer+"";
	}

}
