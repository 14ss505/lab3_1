package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddTextQuestion extends AddQuestion {

    public AddTextQuestion(Page page, String prompt, String answer, int score, QuestionCreator creator) {
        super(page, prompt, answer, score, creator);
    }

    public AddTextQuestion(Page page, String prompt, QuestionCreator creator) {
        super(page, prompt, creator);
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
