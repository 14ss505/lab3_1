package command.create;

import Paper.Page;
import command.Create;
import receiver.PageCreator;

public class CreateSurvey extends Create {
	private PageCreator pc;
	private String pageName;
	private String personName;

	public CreateSurvey(PageCreator pc,String pageName,String personName) {
		this.pc = pc;
		this.pageName = pageName;
		this.personName = personName;
	}

	public void execute() {
		pc.createPage(Page.TEST,pageName,personName);
	}

}
