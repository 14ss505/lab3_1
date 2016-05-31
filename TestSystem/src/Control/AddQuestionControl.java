package Control;

import Paper.Page;
import agent.AddQuestionAgent;
import command.AddQuestion;
import command.addquestion.AddChoiceQuestion;
import command.addquestion.AddDecideQuestion;
import command.addquestion.AddEssayQuestion;
import command.addquestion.AddMapQuestion;
import command.addquestion.AddRankQuestion;
import command.addquestion.AddTextQuestion;
import receiver.QuestionCreator;

public class AddQuestionControl {
	AddQuestionView view;
	Page page;

	public AddQuestionControl(Page page) {
		this.page = page;
	}

	public void setView(AddQuestionView view) {
		this.view = view;
	}

	public void addQuestion(int quetype) {
		AddQuestion aq = null;
		QuestionCreator qc = new QuestionCreator();
		qc.setPage(page);
		switch (quetype) {
		case 1:
			aq = new AddDecideQuestion(qc);
			break;
		case 2:
			aq = new AddChoiceQuestion(qc);
			break;
		case 3:
			aq = new AddTextQuestion(qc);
			break;
		case 4:
			aq = new AddEssayQuestion(qc);
			break;
		case 5:
			aq = new AddRankQuestion(qc);
			break;
		case 6:
			aq = new AddMapQuestion(qc);
			break;
		}
		AddQuestionAgent agent = new AddQuestionAgent();
		agent.placeQuestion(aq);
	}
}
