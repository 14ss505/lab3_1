package Interface;

import java.util.List;

import MVC.model.Answer.Answer;
import MVC.model.Answer.ChoiceAnswer;
import MVC.model.Answer.DecideAnswer;
import MVC.model.Answer.MapAnswer;
import MVC.model.Answer.RankAnswer;
import MVC.model.Answer.TextAnswer;
import MVC.model.Paper.Iterator;
import MVC.model.Paper.Page;
import MVC.model.Paper.Record;
import MVC.model.Question.DecideQuestion;
import MVC.model.Question.Question;
import util.IO;


public class AnswerCreator {
	private Record record;
	
	public void createDecideAnswer(Question question,String answer) {
		DecideAnswer decide = new DecideAnswer();
		decide.setAnswer(answer);
		record.addAnwser(decide);
		record.save();
	}
	
	public void createChoiceAnswer(Question question,String answer) {
		ChoiceAnswer choice = new ChoiceAnswer();
		choice.setAnswer(answer);
		record.addAnwser(choice);
		record.save();
	}
	
	public void createTextAnswer(Question question,String answer) {
		TextAnswer text = new TextAnswer();
		text.setAnswer(answer);
		record.addAnwser(text);
		record.save();
	}
	
	public void createRankAnswer(Question question,String answer) {
		RankAnswer rank = new RankAnswer();
		rank.setAnswer(answer);
		record.addAnwser(rank);
		record.save();
	}
	
	public void createMapAnswer(Question question,String answer) {
		MapAnswer map = new MapAnswer();
		map.setAnswer(answer);
		record.addAnwser(map);
		record.save();
	}

	public void createEssayAnswer(Question question, String answer) {
		record.save();	
	}
	/*public void answerQuestion(Question question,String answer){
		switch(question.getType()){
		case 0: DecideAnswer decide = new DecideAnswer();
				decide.setAnswer(answer);
				record.addAnwser(decide);
				break;
		case 1: ChoiceAnswer choice = new ChoiceAnswer();
				choice.setAnswer(answer);
				record.addAnwser(choice);
				break;
		case 2:
		case 3:	TextAnswer text = new TextAnswer();
				text.setAnswer(answer);
				record.addAnwser(text);
				break;
		case 4: RankAnswer rank = new RankAnswer();
				rank.setAnswer(answer);
				record.addAnwser(rank);
				break;
		case 5: MapAnswer map = new MapAnswer();
				map.setAnswer(answer);
				record.addAnwser(map);
				break;
		}
	}*/

	public void setRecord(Record record) {
		this.record = record;
	}

}
