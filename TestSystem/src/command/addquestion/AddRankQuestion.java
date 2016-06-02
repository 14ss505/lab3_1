package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddRankQuestion extends AddQuestion {
    private String[] items;

    public AddRankQuestion(String pageName,String personName,int type, String prompt, String answer, int score, QuestionCreator creator, String[] items) {
        super(pageName, personName, type, prompt, answer, score, creator);
        this.items = items;
    }

    public AddRankQuestion(String pageName,String personName,int type, String prompt, QuestionCreator creator, String[] items) {
        super(pageName, personName, type, prompt, creator);
        this.items = items;
    }

    @Override
	public void execute() {
        if (type == Page.TEST) {
            creator.createRankQuestion(pageName,prompt, items, score, answer);
        } else {
            creator.createRankQuestion(pageName,prompt, items);

        }
	}
}
