package command.addquestion;

import java.util.Scanner;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.RankQuestion;
import command.AddQuestion;
import receiver.QuestionCreator;

public class AddRankQuestion extends AddQuestion {
   
	public AddRankQuestion(Page page,RankQuestion question, QuestionCreator creator) {
		super(page, question, creator);
	}

	@Override
	public void execute() {
		creator.createRankQuestion(page,(RankQuestion)question);
	}
}
