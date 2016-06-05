package Answer;

public abstract class Answer {
	public static final int CHOICE = 1;
	public static final int DECIDE = 0;
	public static final int MAP = 5;
	public static final int RANK = 4;
	public static final int SHORTESSAY = 2;
	public static final int ESSAY = 3;

	protected int type;

	public Answer(int type) {
		this.type = type;
	}
	public abstract String writeAnswer();
	public int getType() {
		return type;
	}
	public boolean match(Answer answer) {
        return answer.writeAnswer().equals(this.writeAnswer());
    }
}
