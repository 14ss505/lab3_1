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

	public void createDecideQuestion(String pageName,String prompt, int score, String answer) {
		Page page = dataCommand.getPage(pageName);
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		decide.setScore(score);
		decide.setAnswer(answer);
		page.addQuestion(decide);
		dataCommand.savePage(page);
	}
	
	public void createDecideQuestion(String pageName,String prompt){
		Page page = dataCommand.getPage(pageName);
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		page.addQuestion(decide);
		dataCommand.savePage(page);
	}
	
	public void createChoiceQuestion(String pageName,String prompt, String[] items, int score, String answer){
		Page page = dataCommand.getPage(pageName);
		ChoiceQuestion choice = new ChoiceQuestion();
		choice.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			choice.setItem(items[i]);
		}
		choice.setScore(score);
		choice.setAnswer(answer);
		page.addQuestion(choice);
		dataCommand.savePage(page);
	}
	
	public void createChoiceQuestion(String pageName,String prompt, String[] items){
		Page page = dataCommand.getPage(pageName);
		ChoiceQuestion choice = new ChoiceQuestion();
		choice.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			choice.setItem(items[i]);
		}
		page.addQuestion(choice);
		dataCommand.savePage(page);
	}
	
	public void createTextQuestion(String pageName,String prompt){
		Page page = dataCommand.getPage(pageName);
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		page.addQuestion(text);
		dataCommand.savePage(page);
	}
	
	public void createTextQuestion(String pageName,String prompt, int score, String answer){
		Page page = dataCommand.getPage(pageName);
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		text.setScore(score);
		text.setAnswer(answer);
		page.addQuestion(text);
		dataCommand.savePage(page);
	}
	
	public void createEssayQuestion(String pageName,String prompt){
		Page page = dataCommand.getPage(pageName);
		EssayQuestion question = new EssayQuestion();
		question.setPrompt(prompt);
		page.addQuestion(question);
		dataCommand.savePage(page);
	}
	
	public void createRankQuestion(String pageName,String prompt, String[] items){
		Page page = dataCommand.getPage(pageName);
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		page.addQuestion(question);
		dataCommand.savePage(page);
	}
	
	public void createRankQuestion(String pageName,String prompt, String[] items, int score, String answer){
		Page page = dataCommand.getPage(pageName);
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		question.setScore(score);
		question.setAnswer(answer);
		page.addQuestion(question);
		dataCommand.savePage(page);
	}
	
	public void createMapQuestion(String pageName,String prompt, String[] side1, String[] side2){
		Page page = dataCommand.getPage(pageName);
		MapQuestion map = new MapQuestion();
		map.setPrompt(prompt);
		map.setSide(1);
		for(int i=0; i<side1.length; i++){
			map.setItem(side1[i]);
		}
		map.setSide(2);
		for(int i=0; i<side2.length; i++){
			map.setItem(side2[i]);
		}
		page.addQuestion(map);
		dataCommand.savePage(page);
	}
	
	public void createMapQuestion(String pageName,String prompt, String[] side1, String[] side2, int score, String answer){
		Page page = dataCommand.getPage(pageName);
		MapQuestion map = new MapQuestion();
		map.setPrompt(prompt);
		map.setSide(1);
		for(int i=0; i<side1.length; i++){
			map.setItem(side1[i]);
		}
		map.setSide(2);
		for(int i=0; i<side2.length; i++){
			map.setItem(side2[i]);
		}
		map.setScore(score);
		map.setAnswer(answer);
		page.addQuestion(map);
		dataCommand.savePage(page);
	}		
}
