package Instruction;

public class AnswerPage  extends MenuOrder {
	private MenuOperation o;
	private int pageType;

	public AnswerPage(int type,MenuOperation o) {
		this.pageType = type;
		this.o = o;
	}

	@Override
	public void execute() {
		o.answerPage(pageType);
	}
}
