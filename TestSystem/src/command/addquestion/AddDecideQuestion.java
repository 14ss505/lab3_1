package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddDecideQuestion extends AddQuestion {

	public AddDecideQuestion(String pageName,String personName,int type, String prompt, String answer, int score, QuestionCreator creator) {
		super(pageName, personName, type, prompt, answer, score, creator);
	}

	public AddDecideQuestion(String pageName,String personName,int type, String prompt, QuestionCreator creator) {
		super(pageName, personName, type, prompt, creator);
	}

	@Override
	public void execute() {
		if (type == Page.TEST) {
			creator.createDecideQuestion(page.getPageName(),prompt, score, answer);

		} else {
			creator.createDecideQuestion(page.getPageName(),prompt);
		}
	}

}
