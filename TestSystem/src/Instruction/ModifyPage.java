package Instruction;
import Interface.MenuOperation;

import Interface.MenuOperation;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyPage extends MenuOrder {
	private MenuOperation o;
	private int pageType;

	public ModifyPage(int pageType, MenuOperation o) {
		this.o = o;
		this.pageType = pageType;
	}

	@Override
	public void execute() {
		o.modify(pageType);
	}
}
