package Answer;

public class EssayAnswer extends Answer {
	String Essay;

	public EssayAnswer() {
		super(Answer.ESSAY);
	}

	@Override
	public String getAnswer() {
		return Essay;
	}

	@Override
	public void setAnswer(String anwser) {
		Essay = anwser;
	}

	@Override
	public String writeAnswer() {
		return Essay;
	}
}
