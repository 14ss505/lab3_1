package Question;

public abstract class PromptQuestion extends Question{

	public PromptQuestion(int type) {
		super(type);
	}

	@Override
	public abstract void setAnswer(String answer);
}
