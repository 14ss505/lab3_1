package Instruction;

import Interface.MenuOperation;

public class CreatePage extends MenuOrder {
	private MenuOperation o;
	private int pageType;

	public CreatePage(int type,MenuOperation o) {
		this.pageType = type;
		this.o = o;
	}

	@Override
	public void execute() {
		o.createPage(pageType);
	}

}
