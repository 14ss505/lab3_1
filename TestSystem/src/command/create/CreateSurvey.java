package command.create;

import Paper.Survey;
import command.Create;
import receiver.PageCreator;

public class CreateSurvey extends Create {
	private PageCreator pc;
	private Survey survey;

	public CreateSurvey(PageCreator pc,Survey survey) {
		this.pc = pc;
		this.survey = survey;
	}

	public void execute() {
		pc.createPage(survey);
	}

}
