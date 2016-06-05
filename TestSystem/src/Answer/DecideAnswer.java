package Answer;

public class DecideAnswer extends Answer{
	
	int answer;

	public DecideAnswer(String answer) {
		super(Answer.DECIDE);
		 setAnswer(answer);
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
