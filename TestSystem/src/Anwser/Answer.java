package Anwser;

public abstract class Answer {
	public static final int CHOICE = 1;
	public static final int DECIDE = 0;
	public static final int MAP = 5;
	public static final int RANK = 4;
	public static final int TEXT = 2;

	protected int type;

	public Answer(int type) {
		this.type = type;
	}

	public abstract String getAnswer();
	public abstract void setAnswer(String aswser);
	public abstract String writeAnswer();
	public int getType() {
		return type;
	}
	public abstract boolean match(Answer answer);
}
