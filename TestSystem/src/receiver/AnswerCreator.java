package receiver;

import Answer.*;
import Paper.Record;
import Question.Question;
import util.DataCommand;


public class AnswerCreator {
	private Record record;
	private DataCommand dataCommand= new DataCommand();
	
	public void createDecideAnswer(Question question,String answer) {
		DecideAnswer decide = new DecideAnswer();
		decide.setAnswer(answer);
		record.addAnwser(decide);
		dataCommand.saveRecord(record);
	}
	
	public void createChoiceAnswer(Question question,String answer) {
		ChoiceAnswer choice = new ChoiceAnswer();
		choice.setAnswer(answer);
		record.addAnwser(choice);
		dataCommand.saveRecord(record);
	}
	
	public void createTextAnswer(Question question,String answer) {
		TextAnswer text = new TextAnswer();
		text.setAnswer(answer);
		record.addAnwser(text);
		dataCommand.saveRecord(record);
	}
	
	public void createRankAnswer(Question question,String answer) {
		RankAnswer rank = new RankAnswer();
		rank.setAnswer(answer);
		record.addAnwser(rank);
		dataCommand.saveRecord(record);
	}
	
	public void createMapAnswer(Question question,String answer) {
		MapAnswer map = new MapAnswer();
		map.setAnswer(answer);
		record.addAnwser(map);
		dataCommand.saveRecord(record);
	}

	public void createEssayAnswer(Question question, String answer) {
		EssayAnswer essay = new EssayAnswer();
		essay.setAnswer(answer);
		record.addAnwser(essay);
		dataCommand.saveRecord(record);	
	}

	public void setRecord(Record record) {
		this.record = record;
	}

}
