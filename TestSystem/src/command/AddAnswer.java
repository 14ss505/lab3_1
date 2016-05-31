package command;

import Paper.Page;

public abstract class AddAnswer {
	protected Page page;

	public void setPage(Page p) {
		this.page = p;
	}

	public abstract void execute();
}
