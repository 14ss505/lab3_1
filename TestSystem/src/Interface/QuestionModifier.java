package Interface;

import MVC.model.Paper.Page;
import MVC.model.Question.ItemQuestion;
import MVC.model.Question.MapQuestion;
import MVC.model.Question.Question;

public class QuestionModifier {
	private Page page;

	private Question question;

	public void setPage(Page p) {
		this.page = p;
	}

	public void setQuestion(Question q) {
		this.question = q;
	}
	
	public Page getPage() {
		return page;
	}

	public Question getQuestion() {
		return question;
	}

	public void setPrompt(String prompt) {
		question.setPrompt(prompt);
	}

	public void setAnswer(String answer) {
		question.setAnswer(answer);
	}

	public Question getQuestion(int index) {
		if (index >= page.getQuestionList().size()) {
			System.out.println("Index out of bound!");
			return null;
		} else {
			return page.getQuestion(index);
		}
	}

	public boolean changeItemNumber(int num) {
		if (question.getType() == Question.MAP) {
			return ((MapQuestion) question).changeItemNumber(num);
		}
		return ((ItemQuestion) question).changeItemNumber(num);
	}

	public void setItem(String item) {// TODO: control
		((ItemQuestion) question).setItem(item);
	}

	public boolean remove(int index) {
		if (question.getType() == Question.MAP) {
			return ((MapQuestion) question).remove(index);
		}
		return ((ItemQuestion) question).remove(index);
	}

	public boolean changeItem(int index, String item) {
		if (question.getType() == Question.MAP) {
			return ((MapQuestion) question).changeItem(index, item);
		}
		return ((ItemQuestion) question).changeItem(index, item);
	}

}
