package Control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import Answer.Answer;
import Answer.ChoiceAnswer;
import Answer.DecideAnswer;
import Answer.MapAnswer;
import Answer.RankAnswer;
import Answer.TextAnswer;
import Paper.Iterator;
import Paper.Page;
import Paper.Record;
import Paper.Test;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.EssayQuestion;
import Question.ItemQuestion;
import Question.MapQuestion;
import Question.Question;
import Question.RankQuestion;
import Question.ShortEssayQuestion;

public class Control {
	protected List<String>[] pageNameList;
	protected Page page;
	protected Question question;
	protected int index;
	protected Record record;
	protected IO io = new IO();
	protected List<String> recordName;
	protected Iterator<Question> iterator;
	
	public Control(){
		pageNameList = io.readInfo();
	}
	
	public void setPageName(String name){
		page.setPageName(name);
		if(page.getType()==1){
			pageNameList[1].add(name);
		}else{
			pageNameList[0].add(name);
		}
	}
	
	public void setItem(String item){
		((ItemQuestion)question).setItem(item);
	}
	
	public void setItem(int side, String item){
		MapQuestion map = (MapQuestion)question;
		map.setSide(side);
		map.setItem(item);
	}
	
	public void setSide(int side){
		MapQuestion map = (MapQuestion)question;
		map.setSide(side);
	}
	
	public void setAnswer(String answer){
		question.setAnswer(answer);
	}
	
	public void setPrompt(String prompt){
		question.setPrompt(prompt);

	}
	
	public void setScore(int score){
		question.setScore(score);
	}
	
	public List<String> getPageName(int type){
		return pageNameList[type];
	}
	
	public void displayPage(int index, int type){
		if(pageNameList[type].size() <= index){
			System.out.println("index out of bound!");
		}else{
			page = io.readPage(pageNameList[type].get(index));
			page.display();
		}
	}
	
	public void save(){
		if(page.getType()==1){
			Test test = (Test)page;
			test.computeScore();
		}
		io.writeInfo(pageNameList);
		io.writePage(page);
	}
	
	public int modify(int index){
		if(index >= page.getQuestionList().size()){
			System.out.println("Index out of bound!");
			return -1;
		}else{
			question = page.getQuestion(index);
			return question.getType();
		}
	}
	
	public boolean remove(int index){
		if(question.getType() == 5){
			return ((MapQuestion)question).remove(index);
		}
		return ((ItemQuestion)question).remove(index);
	}
	
	public boolean changeItem(int index, String item){
		if(question.getType() == Question.MAP){
			return ((MapQuestion)question).changeItem(index, item);		
		}
		return ((ItemQuestion)question).changeItem(index, item);
	}
	
	public boolean changeItemNumber(int num){
		if(question.getType() == Question.MAP){
			return ((MapQuestion)question).changeItemNumber(num);		
		}
		return ((ItemQuestion)question).changeItemNumber(num);
	}
	
	public void loadPage(int index, int type){
		page = io.readPage(pageNameList[type].get(index));
		record = new Record();
	}
	
	public void setRecordName(String name){
		record.setPersonName(name);
		iterator = page.iterator();
	}
	
	public String nextQuestion(){
		question = iterator.next();
		return question.getQuestion();
	}
	
	public boolean hasNextQuestion(){
		return iterator.hasNext();
	}
	
	public void answerQuestion(String answer){
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
	
	public void saveAnswer(){
		recordName = io.readRecordInfo(page.getPageName());
		recordName.add(page.getPageName()+"-"+record.getPersonName());
		if(page.getType()==1){
			this.grade();
		}
		io.writeReordInfo(page.getPageName(), recordName);
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
	
	public String getOutcome(int index, int type){
		this.loadPage(index, type);
		recordName = io.readRecordInfo(page.getPageName());
		List<Iterator<Answer>> recordList = new LinkedList<Iterator<Answer>>();
		for(int i=0; i<recordName.size(); i++){
			recordList.add(io.readRecord(recordName.get(i)).iterator());
		}
		Iterator<Question> questionIterator = page.iterator();
		List<String> outcome = new LinkedList<String>();
		while(questionIterator.hasNext()){
			Question question = questionIterator.next();
			Map<String, Integer> map = new HashMap<String, Integer>();
			for(int i=0; i<recordList.size(); i++){
				Answer answer = recordList.get(i).next();
				if(map.containsKey(answer.writeAnswer())){
					int value = map.get(answer.writeAnswer());
					map.put(answer.writeAnswer(), value+1);
				}else{
					map.put(answer.writeAnswer(), 1);
				}
			}
			String oneOutcome = question.getQuestion();
			for(String key: map.keySet()){
				oneOutcome +="Answer: " + key+"\t"+map.get(key)+"\n";
			}
			outcome.add(oneOutcome);
		}
		String ret = "";
		for(int i=0; i<outcome.size(); i++){
			ret += outcome.get(i)+"\n";
		}
		return ret;
	}
}
