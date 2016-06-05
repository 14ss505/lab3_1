package receiver;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.EssayQuestion;
import Question.MapQuestion;
import Question.RankQuestion;
import Question.ShortEssayQuestion;
import util.DataCommand;

public class QuestionCreator {
	private DataCommand dataCommand= new DataCommand();

	public void createDecideQuestion(Page page,DecideQuestion question) {
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.addQuestion(question);
		dataCommand.savePage(pageLoad);
	}
	
	public void createChoiceQuestion(Page page,ChoiceQuestion question){
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.addQuestion(question);
		dataCommand.savePage(pageLoad);
	}
	
	public void createShortEssayQuestion(Page page,ShortEssayQuestion question){
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.addQuestion(question);
		dataCommand.savePage(pageLoad);
	}
	
	public void createEssayQuestion(Page page,EssayQuestion question){
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.addQuestion(question);
		dataCommand.savePage(pageLoad);
	}
	
	public void createRankQuestion(Page page,RankQuestion question){
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.addQuestion(question);
		dataCommand.savePage(pageLoad);
	}
	
	public void createMapQuestion(Page page,MapQuestion question){
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.addQuestion(question);
		dataCommand.savePage(pageLoad);
	}
}
