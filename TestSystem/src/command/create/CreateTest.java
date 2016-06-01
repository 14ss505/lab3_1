package command.create;

import Paper.Page;
import command.Create;
import receiver.PageCreator;

public class CreateTest extends Create {
	private PageCreator pc;
	
	public CreateTest(PageCreator pc){
		this.pc = pc;
	}
	@Override
	public void execute(String personName) {
		// TODO Auto-generated method stub
		pc.createPage(Page.TEST,personName);
	}

}
