package Answer;

public class EssayAnswer extends Answer {
	String Essay;

	public EssayAnswer(String answer) {
		super(Answer.ESSAY);
		setAnswer(answer);
	}

	public String getAnswer() {
		return Essay;
	}

	public void setAnswer(String anwser) {
		Essay = anwser;
	}

	@Override
	public String writeAnswer() {
		return Essay;
	}
}
