package MVC.control;

import Instruction.add.AddChoiceQuestion;
import Instruction.add.AddDecideQuestion;
import Instruction.add.AddEssayQuestion;
import Instruction.add.AddMapQuestion;
import Instruction.add.AddQuestion;
import Instruction.add.AddQuestionAgent;
import Instruction.add.AddRankQuestion;
import Instruction.add.AddTextQuestion;
import Interface.QuestionCreator;
import MVC.model.Paper.Page;
import exclude.AddQuestionView;
import exclude.AddQuestionViewcmd;

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
