package command.create;

import Paper.Page;
import command.Create;
import receiver.PageCreator;

public class CreateTest extends Create {
	private PageCreator pc;
	private String pageName;
	private String personName;
	
	public CreateTest(PageCreator pc,String pageName,String personName) {
		this.pc = pc;
		this.pageName = pageName;
		this.personName = personName;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		pc.createPage(Page.TEST,pageName,personName);
	}
	@Override
	public Page getPage() {
		// TODO Auto-generated method stub
		return pc.getPage();
	}

}
