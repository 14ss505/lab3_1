package receiver;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.EssayQuestion;
import Question.MapQuestion;
import Question.Question;
import Question.RankQuestion;
import Question.ShortEssayQuestion;
import util.DataCommand;

public class QuestionModifier {
	private DataCommand dataCommand= new DataCommand();

	public void modifyDecideQuestion(Page page,	DecideQuestion q,int index) {
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.resetQuestion(index, q);
		dataCommand.savePage(pageLoad);
	}

	public void modifyChoiceQuestion(Page page,	ChoiceQuestion q,int index) {
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.resetQuestion(index, q);
		dataCommand.savePage(pageLoad);
	}

	public void modifyEssayQuestion(Page page,	EssayQuestion q,int index) {
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.resetQuestion(index, q);
		dataCommand.savePage(pageLoad);
	}
	
	public void modifyRankQuestion(Page page,	RankQuestion q,int index) {
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.resetQuestion(index, q);
		dataCommand.savePage(pageLoad);
	}

	public void modifyMapQuestion(Page page,	MapQuestion q,int index) {
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.resetQuestion(index, q);
		dataCommand.savePage(pageLoad);
	}
	public void modifyShortEssayQuestion(Page page,	ShortEssayQuestion q,int index) {
		Page pageLoad = dataCommand.getPage(page.getPageName());
		pageLoad.resetQuestion(index, q);
		dataCommand.savePage(pageLoad);
	}
	
}
