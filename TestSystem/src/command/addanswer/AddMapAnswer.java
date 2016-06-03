package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Answer.ChoiceAnswer;
import Answer.MapAnswer;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class AddMapAnswer  extends AddAnswer{

	public AddMapAnswer(Page page,MapAnswer answer,int index,AnswerCreator creator) {
		super(page,answer,index,creator);
	}

	@Override
	public void execute() {
		creator.createMapAnswer(page,(MapAnswer)answer,index);
	}
}
