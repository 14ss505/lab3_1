package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddMapQuestion extends AddQuestion {
	private String[] side1;
    private String[] side2;

    public AddMapQuestion(Page page, String prompt, String answer, int score, QuestionCreator creator) {
        super(page, prompt, answer, score, creator);
    }

    public AddMapQuestion(Page page, String prompt, QuestionCreator creator) {
        super(page, prompt, creator);
    }

    @Override
	public void execute() {
        if (type == Page.TEST) {
            creator.createMapQuestion(page,prompt, side1, side2, score, answer);
        } else {
            creator.createMapQuestion(page,prompt, side1, side2);
        }
	}
}
