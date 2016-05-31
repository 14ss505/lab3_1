package MVC.control;

import java.util.List;

import MVC.model.Paper.Page;
import MVC.model.Paper.Record;
import MVC.view.AnswerPageView;
import MVC.view.CreatePageView;
import util.IO;

public class AnswerPageControl {
	private Page page;
	private AnswerPageView view;
	private IO io = new IO();
	private List<String> pageNameList;
	
	public AnswerPageControl(AnswerPageView view) {
		this.view = view;
	}

	public void answer(int type) {
		type = 0;
		String personName = null;//test-taker
		
		pageNameList = io.readAllPageNames(type);
		int index = 0;//the page  test-taker chooses
		
		if(pageNameList .size() <= index){
			System.out.println("index out of bound!");
		}else{
			page = io.readPage(pageNameList.get(index));
			page.display();
		} 
		Record record = new Record();
		record.setPersonName(personName);
		//io.writeRecord(page, personName);
	}
	
	public Page getPage(){
		return page;
	}
}
