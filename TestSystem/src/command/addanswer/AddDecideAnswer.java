package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Answer.ChoiceAnswer;
import Answer.DecideAnswer;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class AddDecideAnswer extends AddAnswer{

	public AddDecideAnswer(Page page,DecideAnswer answer,int index,AnswerCreator creator) {
		super(page,answer,index,creator);
	}

	@Override
	public void execute() {
		creator.createDecideAnswer(page,(DecideAnswer)answer,index);
	}
}
