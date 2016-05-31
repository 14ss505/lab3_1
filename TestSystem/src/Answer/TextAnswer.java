package Answer;

public class TextAnswer extends Answer{
	
	String text;

	public TextAnswer() {
		super(Answer.TEXT);
	}

	@Override
	public String getAnswer() {
		return text;
	}

	@Override
	public void setAnswer(String anwser) {
		text = anwser;
	}

	@Override
	public String writeAnswer() {
		return text;
	}
}
