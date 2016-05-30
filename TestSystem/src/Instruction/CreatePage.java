package Instruction;

import Interface.MenuOperation;

public class CreatePage extends MenuOrder {
	private MenuOperation o;
	private int pageType;
	//private Page newPage;

	public int getPageType() {
		return pageType;
	}

	public void setPageType(int pageType) {
		this.pageType = pageType;
	}

	public CreatePage(int type, MenuOperation o) {
		this.pageType = type;
		this.o = o;
	}

	@Override
	public void execute() {
		o.createPage(pageType);
	}

	
	


}
