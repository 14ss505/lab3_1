package command.create;

import Paper.Page;
import command.Create;
import receiver.PageCreator;

public class CreateSurvey extends Create {
	private PageCreator pc;
	private Page page;

	public CreateSurvey(PageCreator pc,Page page) {
		this.pc = pc;
		this.page = page;
	}

	public void execute() {
		pc.createPage(page);
	}

}
