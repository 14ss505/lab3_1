package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Answer.ChoiceAnswer;
import Answer.EssayAnswer;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class AddEssayAnswer extends AddAnswer{

	public AddEssayAnswer(Page page,EssayAnswer answer,int index,AnswerCreator creator) {
		super(page,answer,index,creator);
	}

	@Override
	public void execute() {
		creator.createEssayAnswer(page,(EssayAnswer)answer,index);
	}
}
