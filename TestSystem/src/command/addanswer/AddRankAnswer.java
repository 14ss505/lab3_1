package command.addanswer;

import command.AddAnswer;
import receiver.AnswerCreator;
import Answer.ChoiceAnswer;
import Answer.RankAnswer;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class AddRankAnswer  extends AddAnswer{
	
	public AddRankAnswer(Page page,RankAnswer answer,int index,AnswerCreator creator,String personName) {
		super(page,answer,index,creator, personName);
	}

	@Override
	public void execute() {
		creator.createRankAnswer(page,(RankAnswer)answer,index,personName);
	}
}
