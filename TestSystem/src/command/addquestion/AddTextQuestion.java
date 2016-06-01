package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddTextQuestion extends AddQuestion {

    public AddTextQuestion(String pageName,String personName,int type, String prompt, String answer, int score, QuestionCreator creator) {
        super(pageName, personName, type, prompt, answer, score, creator);
    }

    public AddTextQuestion(String pageName,String personName,int type, String prompt, QuestionCreator creator) {
        super(pageName, personName, type, prompt, creator);
    }

    @Override
	public void execute() {
        if (type == Page.TEST) {
            creator.createTextQuestion(page.getPageName(),prompt, score, answer);
        } else {
            creator.createTextQuestion(page.getPageName(),prompt);
        }
	}
}
