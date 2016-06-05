package Answer;

public class ShortEssayAnswer extends Answer{
	
	String text;

	public ShortEssayAnswer(String answer) {
		super(Answer.SHORTESSAY);
		setAnswer(answer);
	}

	public String getAnswer() {
		return text;
	}

	public void setAnswer(String answer) {
		if(answer.equals("")){
			this.setDefaultAnswer();
			return;
		}
		text = answer;
	}

	public void setDefaultAnswer(){
		text = "";
	}

	@Override
	public String writeAnswer() {
		return text;
	}
}
