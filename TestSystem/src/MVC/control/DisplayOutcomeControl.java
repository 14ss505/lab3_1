package MVC.control;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import MVC.model.Answer.Answer;
import MVC.model.Paper.Iterator;
import MVC.model.Paper.Page;
import MVC.model.Paper.Record;
import MVC.model.Question.Question;
import exclude.DisplayOutcomeViewcmd;
import util.IO;

public class DisplayOutcomeControl {
	private Page page;
	private DisplayOutcomeViewcmd view;
	private List<String>[] pageNameList;
	private IO io = new IO();

	public DisplayOutcomeControl() {
		this.pageNameList = io.readInfo();
		this.view = new DisplayOutcomeViewcmd(this);
	}

	public void displayOutcome(int type) {
		view.setPageNameList(pageNameList[type]);
		view.display();
		int index = view.getNum();
		if (view.getPageNameList().size() <= index) {
			System.out.println("index out of bound!");
		} else {
			getOutcome(index, type);
		}
		view.displayContinue();
	}

	public String getOutcome(int index, int type) {
		page = io.readPage(pageNameList[type].get(index));
		Record record = new Record();
		List<String> recordName = io.readRecordInfo(page.getPageName());
		List<Iterator<Answer>> recordList = new LinkedList<Iterator<Answer>>();
		for (int i = 0; i < recordName.size(); i++) {
			recordList.add(io.readRecord(recordName.get(i)).iterator());
		}
		Iterator<Question> questionIterator = page.iterator();
		List<String> outcome = new LinkedList<String>();
		while (questionIterator.hasNext()) {
			Question question = questionIterator.next();
			Map<String, Integer> map = new HashMap<String, Integer>();
			for (int i = 0; i < recordList.size(); i++) {
				Answer answer = recordList.get(i).next();
				if (map.containsKey(answer.writeAnswer())) {
					int value = map.get(answer.writeAnswer());
					map.put(answer.writeAnswer(), value + 1);
				} else {
					map.put(answer.writeAnswer(), 1);
				}
			}
			String oneOutcome = question.getQuestion();
			for (String key : map.keySet()) {
				oneOutcome += "Answer: " + key + "\t" + map.get(key) + "\n";
			}
			outcome.add(oneOutcome);
		}
		String ret = "";
		for (int i = 0; i < outcome.size(); i++) {
			ret += outcome.get(i) + "\n";
		}
		return ret;
	}
}
