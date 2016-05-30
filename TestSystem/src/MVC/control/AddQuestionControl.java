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
import MVC.view.AddQuestionView;
import MVC.model.Paper.Page;

public class AddQuestionControl {
	AddQuestionView view;
	Page page;

	public AddQuestionControl(Page page) {
		this.view = new AddQuestionView(this);
		this.page = page;
	}
	
	public void addQuestion(){
		view.display();
		if(view.getNext()==1){
			view.displaymore();
			int temp = view.getNext2();
			AddQuestion aq = null;
            QuestionCreator qc = new QuestionCreator();
            qc.setPage(page);
            switch (temp) {
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
            addQuestion();
		}
	}
}
