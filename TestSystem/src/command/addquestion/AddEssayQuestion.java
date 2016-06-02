package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddEssayQuestion extends AddQuestion {

	public AddEssayQuestion(String pageName,String personName,int type, String prompt, String answer, int score, QuestionCreator creator) {
		super(pageName, personName, type, prompt, answer, score, creator);
	}

	public AddEssayQuestion(String pageName,String personName,int type, String prompt, QuestionCreator creator) {
		super(pageName, personName, type, prompt, creator);
	}

	@Override
	public void execute() {
		creator.createEssayQuestion(pageName,prompt);
	}

}
