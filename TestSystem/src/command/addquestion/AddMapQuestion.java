package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddMapQuestion extends AddQuestion {
	private String[] side1;
    private String[] side2;

    public AddMapQuestion(String pageName,String personName,int type, String prompt, String answer, int score, QuestionCreator creator) {
        super(pageName, personName, type, prompt, answer, score, creator);
    }

    public AddMapQuestion(String pageName,String personName,int type, String prompt, QuestionCreator creator) {
        super(pageName, personName, type, prompt, creator);
    }

    @Override
	public void execute() {
        if (type == Page.TEST) {
            creator.createMapQuestion(page.getPageName(),prompt, side1, side2, score, answer);
        } else {
            creator.createMapQuestion(page.getPageName(),prompt, side1, side2);
        }
	}
}
