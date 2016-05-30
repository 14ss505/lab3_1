package Instruction;

import java.util.List;

import Answer.Answer;
import Answer.ChoiceAnswer;
import Answer.DecideAnswer;
import Answer.MapAnswer;
import Answer.RankAnswer;
import Answer.TextAnswer;
import Control.IO;
import Paper.Iterator;
import Paper.Page;
import Paper.Record;
import Question.Question;

public class RecordCreator {
	private Record record;
	private String personName;
	private Page page;
	private IO io = new IO();
	
	public RecordCreator(String personName,Page page){
		record = new Record();
		this.personName = personName;
		this.page = page;
		record.setPersonName(personName);
	}
	public void saveAnswer(){
		List<String> recordName = io.readRecordInfo(page.getPageName());
		recordName.add(page.getPageName()+"-"+record.getPersonName());
		if(page.getType()==1){
			this.grade();
		}
		io.writeRecordInfo(page.getPageName(), recordName);
		io.writeRecord(page.getPageName()+"-"+record.getPersonName(), record);
	}
	
	public void grade(){
		Iterator<Question> questionIterator = page.iterator();
		Iterator<Answer> answerIterator = record.iterator();
		if(questionIterator.hasNext()){
			Question q = questionIterator.next();
			if(q.getType() != 3){
				if(q.match(answerIterator.next())){
					record.addScore(q.getScore());
				}
			}else{
				answerIterator.next();
			}
		}
	}
	
	public void answerQuestion(Question question,String answer){
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
	}
}
