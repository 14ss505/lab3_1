package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddRankQuestion extends AddQuestion {
    private String[] items;

    public AddRankQuestion(Page page, String prompt, String answer, int score, QuestionCreator creator, String[] items) {
        super(page, prompt, answer, score, creator);
        this.items = items;
    }

    public AddRankQuestion(Page page, String prompt, QuestionCreator creator, String[] items) {
        super(page, prompt, creator);
        this.items = items;
    }

    @Override
	public void execute() {
        if (type == Page.TEST) {
            creator.createRankQuestion(prompt, items, score, answer);
        } else {
            creator.createRankQuestion(prompt, items);

        }
	}
}
