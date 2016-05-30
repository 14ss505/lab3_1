package Instruction;

import Interface.MenuOperation;

public class DisplayOutcome  extends MenuOrder{
	private MenuOperation o;
	private int pageType;

	public DisplayOutcome(int type,MenuOperation o) {
		this.pageType = type;
		this.o = o;
	}

	@Override
	public void execute() {
		o.displayOutcome(pageType);
	}

}
