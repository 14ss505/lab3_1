package command.create;

import Paper.Test;
import command.Create;
import receiver.PageCreator;

public class CreateTest extends Create {
	private PageCreator pc;
	private Test test;
	
	public CreateTest(PageCreator pc,Test test) {
		this.pc = pc;
		this.test = test;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		pc.createPage(test);
	}

}
