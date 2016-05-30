package MVC;


import Control.IO;
import Instruction.RecordCreator;
import Paper.Iterator;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class AddAnswerControl {
	AddAnswerView view;
	Page page;
	private Iterator<Question> iterator;

	public AddAnswerControl(Page page,AddAnswerView view) {
		this.view = view;
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
