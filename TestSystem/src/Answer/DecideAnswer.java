package Answer;

public class DecideAnswer extends Answer{
	String answer;

	public DecideAnswer(String answer) {
		super(Answer.DECIDE);
		 setAnswer(answer);
	}

	public String getAnswer() {
		String ret = ""+answer;
		return ret;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	@Override
	public String writeAnswer() {
		return answer+"";
	}

}
