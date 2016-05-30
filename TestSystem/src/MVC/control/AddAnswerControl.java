package MVC.control;

import Instruction.RecordCreator;
import MVC.model.Paper.Iterator;
import MVC.model.Paper.Page;
import MVC.model.Question.Question;
import MVC.view.AddAnswerView;

public class AddAnswerControl {
	AddAnswerView view;
	Page page;
	private Iterator<Question> iterator;

	public AddAnswerControl(Page page) {
		this.view = new AddAnswerView(this);
		this.page = page;
		this.iterator=page.iterator();
	}
	
	public void addAnswer(){
		view.setIterator(iterator);
		view.display();
		
		RecordCreator rc = new RecordCreator(view.getPersonName(),page);
       
        while (iterator.hasNext()) {
          	Question q = iterator.next();
           	String answer = view.displayQuestion(iterator);
           	//TODO:if answer == NULL
            rc.answerQuestion(q,answer);
         }
  
    	view.finishAnswer();
        rc.saveAnswer();
	}
}
