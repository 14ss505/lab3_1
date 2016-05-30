package Instruction.add;

import MVC.model.Paper.Page;

public abstract class AddQuestion {
	protected int type;
	protected Page page;

	public void setType(int t) {
		this.type = t;
	}

	public void setPage(Page p) {
		this.page = p;
	}

	public abstract void execute();
}
