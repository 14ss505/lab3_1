package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Answer.ChoiceAnswer;
import Answer.ShortEssayAnswer;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class AddShortEssayAnswer extends AddAnswer{

	public AddShortEssayAnswer(Page page,ShortEssayAnswer answer,int index,AnswerCreator creator) {
		super(page,answer,index,creator);
	}

	@Override
	public void execute() {
		creator.createShortEssayAnswer(page,(ShortEssayAnswer)answer,index);
	}
}
