package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Answer.Answer;
import Answer.ChoiceAnswer;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class AddChoiceAnswer extends AddAnswer {
	
	public AddChoiceAnswer(Page page,ChoiceAnswer answer,int index,AnswerCreator creator,String personName) {
		super(page,answer,index,creator, personName);
	}

	@Override
	public void execute() {
		creator.createChoiceAnswer(page,(ChoiceAnswer)answer,index,personName);
	}
}
