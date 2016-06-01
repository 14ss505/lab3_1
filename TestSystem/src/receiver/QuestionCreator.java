package receiver;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.EssayQuestion;
import Question.MapQuestion;
import Question.RankQuestion;
import Question.ShortEssayQuestion;

public class QuestionCreator {
	private Page page;

	public void createDecideQuestion(Page page,String prompt, int score, String answer) {
		this.page = page;
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		decide.setScore(score);
		decide.setAnswer(answer);
		page.addQuestion(decide);
		page.save();
	}
	
	public void createDecideQuestion(Page page,String prompt){
		this.page = page;
		DecideQuestion decide = new DecideQuestion();
		decide.setPrompt(prompt);
		page.addQuestion(decide);
		page.save();
	}
	
	public void createChoiceQuestion(Page page,String prompt, String[] items, int score, String answer){
		this.page = page;
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
	
	public void createChoiceQuestion(Page page,String prompt, String[] items){
		this.page = page;
		ChoiceQuestion choice = new ChoiceQuestion();
		choice.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			choice.setItem(items[i]);
		}
		page.addQuestion(choice);
		page.save();
	}
	
	public void createTextQuestion(Page page,String prompt){
		this.page = page;
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		page.addQuestion(text);
		page.save();
	}
	
	public void createTextQuestion(Page page,String prompt, int score, String answer){
		this.page = page;
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		text.setScore(score);
		text.setAnswer(answer);
		page.addQuestion(text);
		page.save();
	}
	
	public void createEssayQuestion(Page page,String prompt){
		this.page = page;
		EssayQuestion question = new EssayQuestion();
		question.setPrompt(prompt);
		page.addQuestion(question);
		page.save();
	}
	
	public void createRankQuestion(Page page,String prompt, String[] items){
		this.page = page;
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		page.addQuestion(question);
		page.save();
	}
	
	public void createRankQuestion(Page page,String prompt, String[] items, int score, String answer){
		this.page = page;
		RankQuestion question = new RankQuestion();
		question.setPrompt(prompt);
		for(int i=0; i<items.length; i++){
			question.setItem(items[i]);
		}
		question.setScore(score);
		question.setAnswer(answer);
		page.addQuestion(question);
		page.save();
	}
	
	public void createMapQuestion(Page page,String prompt, String[] side1, String[] side2){
		this.page = page;
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
		page.save();
	}
	
	public void createMapQuestion(Page page,String prompt, String[] side1, String[] side2, int score, String answer){
		this.page = page;
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
		page.save();
	}		

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}
