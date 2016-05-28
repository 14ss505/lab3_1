package MVC;

import Instruction.AddChoiceQuestion;
import Instruction.AddDecideQuestion;
import Instruction.AddEssayQuestion;
import Instruction.AddMapQuestion;
import Instruction.AddQuestion;
import Instruction.AddQuestionAgent;
import Instruction.AddRankQuestion;
import Instruction.AddTextQuestion;
import Instruction.QuestionCreator;
import Paper.Page;

public class AddQuestionControl {
	AddQuestionView view;
	Page page;

	public AddQuestionControl(Page page,AddQuestionView view) {
		this.view = view;
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
