package command.create;

import Paper.Page;
import command.Create;
import receiver.PageCreator;

public class CreateSurvey extends Create {
	private PageCreator pc;

	public CreateSurvey(PageCreator pc) {
		this.pc = pc;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		pc.createPage(Page.TEST);
	}

}
