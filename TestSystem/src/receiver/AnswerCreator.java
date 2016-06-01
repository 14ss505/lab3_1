package receiver;

import Answer.*;
import Paper.Record;
import Question.Question;
import util.DataCommand;


public class AnswerCreator {
	private DataCommand dataCommand= new DataCommand();
	
	public void createDecideAnswer(String pageName,String personName,String answer) {
		Record record = dataCommand.getRecord(pageName, personName);
		DecideAnswer decide = new DecideAnswer();
		decide.setAnswer(answer);
		record.addAnwser(decide);
		dataCommand.saveRecord(record);
	}
	
	public void createChoiceAnswer(String pageName,String personName,String answer) {
		Record record = dataCommand.getRecord(pageName, personName);
		ChoiceAnswer choice = new ChoiceAnswer();
		choice.setAnswer(answer);
		record.addAnwser(choice);
		dataCommand.saveRecord(record);
	}
	
	public void createTextAnswer(String pageName,String personName,String answer) {
		Record record = dataCommand.getRecord(pageName, personName);
		TextAnswer text = new TextAnswer();
		text.setAnswer(answer);
		record.addAnwser(text);
		dataCommand.saveRecord(record);
	}
	
	public void createRankAnswer(String pageName,String personName,String answer) {
		Record record = dataCommand.getRecord(pageName, personName);
		RankAnswer rank = new RankAnswer();
		rank.setAnswer(answer);
		record.addAnwser(rank);
		dataCommand.saveRecord(record);
	}
	
	public void createMapAnswer(String pageName,String personName,String answer) {
		Record record = dataCommand.getRecord(pageName, personName);
		MapAnswer map = new MapAnswer();
		map.setAnswer(answer);
		record.addAnwser(map);
		dataCommand.saveRecord(record);
	}

	public void createEssayAnswer(String pageName,String personName,String answer) {
		Record record = dataCommand.getRecord(pageName, personName);
		EssayAnswer essay = new EssayAnswer();
		essay.setAnswer(answer);
		record.addAnwser(essay);
		dataCommand.saveRecord(record);	
	}
}
