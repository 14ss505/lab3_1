package MVC.control;

import Instruction.RecordCreator;
import MVC.model.Paper.Iterator;
import MVC.model.Paper.Page;
import MVC.model.Question.Question;
import exclude.AddAnswerView;
import exclude.AddAnswerViewcmd;

public class AddAnswerControl {
	AddAnswerView view;
	Page page;
	private Iterator<Question> iterator;

	public AddAnswerControl(Page page) {
		this.view = new AddAnswerViewcmd(this);
		this.page = page;
		this.iterator = page.iterator();
	}

	public void setView(AddAnswerView view) {
		this.view = view;
	}

	public void addAnswer() {
		if (view instanceof AddAnswerViewcmd) {
			AddAnswerViewcmd view = (AddAnswerViewcmd) this.view;
			view.setIterator(iterator);
			view.display();

			RecordCreator rc = new RecordCreator(view.getPersonName(), page);

			while (iterator.hasNext()) {
				Question q = iterator.next();
				String answer = view.displayQuestion(iterator);
				rc.answerQuestion(q, answer);
			}
			view.finishAnswer();
			rc.saveAnswer();
		} else {
			// gui view
		}
	}
}
