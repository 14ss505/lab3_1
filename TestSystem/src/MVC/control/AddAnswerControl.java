package MVC.control;

import Instruction.add.AddChoiceQuestion;
import Instruction.add.AddDecideQuestion;
import Instruction.add.AddEssayQuestion;
import Instruction.add.AddMapQuestion;
import Instruction.add.AddQuestion;
import Instruction.add.AddQuestionAgent;
import Instruction.add.AddRankQuestion;
import Instruction.add.AddTextQuestion;
import Instruction.answer.AddAnswer;
import Instruction.answer.AddAnswerAgent;
import Instruction.answer.AddChoiceAnswer;
import Instruction.answer.AddDecideAnswer;
import Instruction.answer.AddEssayAnswer;
import Instruction.answer.AddMapAnswer;
import Instruction.answer.AddRankAnswer;
import Instruction.answer.AddTextAnswer;
import Interface.AnswerCreator;
import Interface.QuestionCreator;
import MVC.model.Paper.Iterator;
import MVC.model.Paper.Page;
import MVC.model.Paper.Record;
import MVC.model.Question.Question;
import MVC.view.AddAnswerView;

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
		//RecordCreator rc = new RecordCreator(view.getPersonName(),page);
		String personName;
		Record record = new Record();
		record.setPersonName(personName);
		
		AddAnswer ar = null;
        AnswerCreator ac = new AnswerCreator();
        ac.setRecord(record);
        
        while (iterator.hasNext()) {
          	Question q = iterator.next();
           	String answer = view.displayQuestion(iterator);
           	//TODO:if answer == NULL
           	int temp = q.getType();
			
           	switch (temp) {
                case 1:
                    ar = new AddDecideAnswer(ac,answer,q);
                    break;
                case 2:
                	ar = new AddChoiceAnswer(ac,answer,q);
                    break;
                case 3:
                	ar = new AddTextAnswer(ac,answer,q);
                    break;
                case 4:
                	ar = new AddEssayAnswer(ac,answer,q);
                    break;
                case 5:
                	ar = new AddRankAnswer(ac,answer,q);
                    break;
                case 6:
                	ar = new AddMapAnswer(ac,answer,q);
                    break;
            }
            AddAnswerAgent agent = new AddAnswerAgent();
            agent.placeRecord(ar);
          //  rc.answerQuestion(q,answer);
         }
	}
}
