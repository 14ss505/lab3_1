package command.create;

import Paper.Page;
import command.Create;
import receiver.PageCreator;

public class CreateTest extends Create {
	private PageCreator pc;
	private Page page;
	
	public CreateTest(PageCreator pc,Page page) {
		this.pc = pc;
		this.page = page;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		pc.createPage(page);
	}

}
