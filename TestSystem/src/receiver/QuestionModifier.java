package receiver;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.MapQuestion;
import Question.Question;
import Question.RankQuestion;
import Question.ShortEssayQuestion;
import util.DataCommand;

public class QuestionModifier {
	private DataCommand dataCommand= new DataCommand();

	public void modifyTFQuestion(String pageName,int index,String prompt, int score, String answer) {
		Page page = dataCommand.getPage(pageName);
		Question newQuestion = new DecideQuestion();
		newQuestion.setPrompt(prompt);
		newQuestion.setScore(score);
		newQuestion.setAnswer(answer);
		page.resetQuestion(index, newQuestion);
		dataCommand.savePage(page);
	}

	public void modifyTFQuestion(String pageName,int index,String prompt) {
		Page page = dataCommand.getPage(pageName);
		Question newQuestion = new DecideQuestion();
		newQuestion.setPrompt(prompt);
		page.resetQuestion(index, newQuestion);
		dataCommand.savePage(page);
	}

	public void modifyChoiceQuestion(String pageName,int index,String prompt, String[] items, int score, String answer) {
		Page page = dataCommand.getPage(pageName);
		ChoiceQuestion newQuestion = new ChoiceQuestion();
		newQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			newQuestion.setItem(items[i]);
		}
		newQuestion.setScore(score);
		newQuestion.setAnswer(answer);
		page.resetQuestion(index, newQuestion);
		dataCommand.savePage(page);
	}

	public void modifyChoiceQuestion(String pageName,int index,String prompt, String[] items) {
		Page page = dataCommand.getPage(pageName);
		ChoiceQuestion newQuestion = new ChoiceQuestion();
		newQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			newQuestion.setItem(items[i]);
		}
		page.resetQuestion(index, newQuestion);
		dataCommand.savePage(page);
	}

	public void modifyEssayQuestion(String pageName,int index,String prompt, int score, String answer) {
		Page page = dataCommand.getPage(pageName);
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		text.setScore(score);
		text.setAnswer(answer);
		page.resetQuestion(index, text);
		dataCommand.savePage(page);
	}

	public void modifyEssayQuestion(String pageName,int index,String prompt) {
		Page page = dataCommand.getPage(pageName);
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		page.resetQuestion(index, text);
		dataCommand.savePage(page);
	}

	public void modifyRankQuestion(String pageName,int index,String prompt, String[] items, int score, String answer) {
		Page page = dataCommand.getPage(pageName);
		RankQuestion rankQuestion = new RankQuestion();
		rankQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			rankQuestion.setItem(items[i]);
		}
		rankQuestion.setScore(score);
		rankQuestion.setAnswer(answer);
		page.resetQuestion(index, rankQuestion);
		dataCommand.savePage(page);
	}

	public void modifyRankQuestion(String pageName,int index,String prompt, String[] items) {
		Page page = dataCommand.getPage(pageName);
		RankQuestion rankQuestion = new RankQuestion();
		rankQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			rankQuestion.setItem(items[i]);
		}
		page.resetQuestion(index, rankQuestion);
		dataCommand.savePage(page);
	}

	public void modifyMapQuestion(String pageName,int index,String prompt, String[] side1, String[] side2, int score, String answer) {
		Page page = dataCommand.getPage(pageName);
		MapQuestion map = new MapQuestion();
		map.setPrompt(prompt);
		map.setSide(1);
		for (int i = 0; i < side1.length; i++) {
			map.setItem(side1[i]);
		}
		map.setSide(2);
		for (int i = 0; i < side2.length; i++) {
			map.setItem(side2[i]);
		}
		map.setScore(score);
		map.setAnswer(answer);
		page.resetQuestion(index, map);
		dataCommand.savePage(page);
	}

	public void modifyMapQuestion(String pageName,int index,String prompt, String[] side1, String[] side2) {
		Page page = dataCommand.getPage(pageName);
		MapQuestion map = new MapQuestion();
		map.setPrompt(prompt);
		map.setSide(1);
		for (int i = 0; i < side1.length; i++) {
			map.setItem(side1[i]);
		}
		map.setSide(2);
		for (int i = 0; i < side2.length; i++) {
			map.setItem(side2[i]);
		}
		page.resetQuestion(index, map);
		dataCommand.savePage(page);
	}
}
