package receiver;

import Answer.*;
import Paper.Record;
import Question.Question;

public class AnswerCreator {
	private Record record;

	public void createDecideAnswer(Question question, String answer) {
		DecideAnswer decide = new DecideAnswer();
		decide.setAnswer(answer);
		// record.addAnwser(decide);
		// record.save();
	}

	public void createChoiceAnswer(Question question, String answer) {
		ChoiceAnswer choice = new ChoiceAnswer();
		choice.setAnswer(answer);
		// record.addAnwser(choice);
		// record.save();
	}

	public void createTextAnswer(Question question, String answer) {
		TextAnswer text = new TextAnswer();
		text.setAnswer(answer);
		// record.addAnwser(text);
		// record.save();
	}

	public void createRankAnswer(Question question, String answer) {
		RankAnswer rank = new RankAnswer();
		rank.setAnswer(answer);
		// record.addAnwser(rank);
		// record.save();
	}

	public void createMapAnswer(Question question, String answer) {
		MapAnswer map = new MapAnswer();
		map.setAnswer(answer);
		// record.addAnwser(map);
		// record.save();
	}

	public void createEssayAnswer(Question question, String answer) {
		// record.save();
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
