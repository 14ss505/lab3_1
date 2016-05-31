package receiver;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.MapQuestion;
import Question.Question;
import Question.RankQuestion;
import Question.ShortEssayQuestion;

public class QuestionModifier {
	private Page page;
	private Question question;
	private int index;

	public QuestionModifier(Page page, Question question) {
		this.page = page;
		this.question = question;
	}

	public void setPage(Page p) {
		this.page = p;
	}

	public void setQuestion(Question q) {
		this.question = q;
		this.index = page.getQuestionIndex(q);
	}

	public void modifyTFQuestion(String prompt, int score, String answer) {
		Question newQuestion = new DecideQuestion();
		newQuestion.setPrompt(prompt);
		newQuestion.setScore(score);
		newQuestion.setAnswer(answer);
		page.resetQuestion(index, newQuestion);
	}

	public void modifyTFQuestion(String prompt) {
		Question newQuestion = new DecideQuestion();
		newQuestion.setPrompt(prompt);
		page.resetQuestion(index, newQuestion);
	}

	public void modifyChoiceQuestion(String prompt, String[] items, int score, String answer) {
		ChoiceQuestion newQuestion = new ChoiceQuestion();
		newQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			newQuestion.setItem(items[i]);
		}
		newQuestion.setScore(score);
		newQuestion.setAnswer(answer);
		page.resetQuestion(index, newQuestion);
	}

	public void modifyChoiceQuestion(String prompt, String[] items) {
		ChoiceQuestion newQuestion = new ChoiceQuestion();
		newQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			newQuestion.setItem(items[i]);
		}
		page.resetQuestion(index, newQuestion);
	}

	public void modifyEssayQuestion(String prompt, int score, String answer) {
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		text.setScore(score);
		text.setAnswer(answer);
		page.resetQuestion(index, text);
	}

	public void modifyEssayQuestion(String prompt) {
		ShortEssayQuestion text = new ShortEssayQuestion();
		text.setPrompt(prompt);
		page.resetQuestion(index, text);
	}

	public void modifyRankQuestion(String prompt, String[] items, int score, String answer) {
		RankQuestion rankQuestion = new RankQuestion();
		rankQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			rankQuestion.setItem(items[i]);
		}
		rankQuestion.setScore(score);
		rankQuestion.setAnswer(answer);
		page.resetQuestion(index, rankQuestion);
	}

	public void modifyRankQuestion(String prompt, String[] items) {
		RankQuestion rankQuestion = new RankQuestion();
		rankQuestion.setPrompt(prompt);
		for (int i = 0; i < items.length; i++) {
			rankQuestion.setItem(items[i]);
		}
		page.resetQuestion(index, rankQuestion);
	}

	public void modifyMapQuestion(String prompt, String[] side1, String[] side2, int score, String answer) {
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
	}

	public void modifyMapQuestion(String prompt, String[] side1, String[] side2) {
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
	}

	public Page getPage() {
		return page;
	}

	public Question getQuestion() {
		return question;
	}
}
