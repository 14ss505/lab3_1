package Anwser;

public class TextAnswer extends Answer{
	
	String text;

	public TextAnswer(int type) {
		super(Answer.TEXT);
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public void setAnswer(String anwser) {
		// TODO Auto-generated method stub
		text = anwser;
	}

	@Override
	public String writeAnswer() {
		// TODO Auto-generated method stub
		return text;
	}

	@Override
	public boolean match(Answer answer) {
		return answer.writeAnswer().equals(this.writeAnswer());
	}

}
