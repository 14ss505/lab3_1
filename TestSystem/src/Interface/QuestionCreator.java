package Interface;

import MVC.model.Paper.Page;
import MVC.model.Question.ChoiceQuestion;
import MVC.model.Question.DecideQuestion;
import MVC.model.Question.EssayQuestion;
import MVC.model.Question.MapQuestion;
import MVC.model.Question.RankQuestion;
import MVC.model.Question.ShortEssayQuestion;

public class QuestionCreator {
	private Page page;

	public void createDecideQuestion(String prompt, int score, String answer) {
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		decide.setScore(score);
		decide.setAnswer(answer);
		page.addQuestion(decide);
		page.save();
	}
	
	public void createDecideQuestion(String prompt){
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		page.addQuestion(decide);
		page.save();
	}
	
	public void createChoiceQuestion(String prompt, String[] items, int score, String answer){
		ChoiceQuestion choice = new ChoiceQuestion();
		choice.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			choice.setItem(items[i]);
		}
		choice.setScore(score);
		choice.setAnswer(answer);
		page.addQuestion(choice);
		page.save();
	}
	
	public void createChoiceQuestion(String prompt, String[] items){
		ChoiceQuestion choice = new ChoiceQuestion();
		choice.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			choice.setItem(items[i]);
		}
		page.addQuestion(choice);
	}
	
	public void createTextQuestion(String prompt){
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		page.addQuestion(text);
	}
	
	public void createTextQuestion(String prompt, int score, String answer){
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		text.setScore(score);
		text.setAnswer(answer);
		page.addQuestion(text);
	}
	
	public void createEssayQuestion(String prompt){
		EssayQuestion question = new EssayQuestion();
		question.setPrompt(prompt);
		page.addQuestion(question);
	}
	
	public void createRankQuestion(String prompt, String[] items){
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		page.addQuestion(question);
	}
	
	public void createRankQuestion(String prompt, String[] items, int score, String answer){
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		question.setScore(score);
		question.setAnswer(answer);
		page.addQuestion(question);
	}
	
	public void createMapQuestion(String prompt, String[] side1, String[] side2){
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
	}
	
	public void createMapQuestion(String prompt, String[] side1, String[] side2, int score, String answer){
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
	}		

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}

