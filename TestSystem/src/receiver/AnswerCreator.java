package receiver;

import Answer.*;
import Paper.Page;
import Paper.Record;
import Question.Question;
import util.DataCommand;


public class AnswerCreator {
	private DataCommand dataCommand= new DataCommand();
	
	public void createDecideAnswer(Page page,DecideAnswer answer,int index) {
		Record record = dataCommand.getRecord(page.getPageName(), page.getPersonName());
		record.resetAnswer(index, answer);
		dataCommand.saveRecord(record);
	}
	
	public void createChoiceAnswer(Page page,ChoiceAnswer answer,int index) {
		Record record = dataCommand.getRecord(page.getPageName(), page.getPersonName());
		record.resetAnswer(index, answer);
		dataCommand.saveRecord(record);
	}
	
	public void createShortEssayAnswer(Page page,ShortEssayAnswer answer,int index) {
		Record record = dataCommand.getRecord(page.getPageName(), page.getPersonName());
		record.resetAnswer(index, answer);
		dataCommand.saveRecord(record);
	}
	
	public void createRankAnswer(Page page,RankAnswer answer,int index) {
		Record record = dataCommand.getRecord(page.getPageName(), page.getPersonName());
		record.resetAnswer(index, answer);
		dataCommand.saveRecord(record);
	}
	
	public void createMapAnswer(Page page,MapAnswer answer,int index) {
		Record record = dataCommand.getRecord(page.getPageName(), page.getPersonName());
		record.resetAnswer(index, answer);
		dataCommand.saveRecord(record);
	}

	public void createEssayAnswer(Page page,EssayAnswer answer,int index) {
		Record record = dataCommand.getRecord(page.getPageName(), page.getPersonName());
		record.resetAnswer(index, answer);
		dataCommand.saveRecord(record);
	}
}
