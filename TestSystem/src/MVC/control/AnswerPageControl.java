package MVC.control;

import java.util.List;

import MVC.model.Paper.Page;
import MVC.model.Paper.Record;
import exclude.AnswerPageViewcmd;
import util.IO;



public class AnswerPageControl {
	private Page page;
	private AnswerPageViewcmd view;
	private List<String>[] pageNameList;
	private IO io = new IO();
	
	public AnswerPageControl() {
		this.pageNameList = io.readInfo();
		this.view = new AnswerPageViewcmd(this,page);
	}

	public void answer(String personName,int type) {
		pageNameList[type] = io.readAllPageNames(type);
		int index = 0;//the page  test-taker chooses
		
		if(pageNameList[type] .size() <= index){
			System.out.println("index out of bound!");
		}else{
			page = io.readPage(pageNameList[type].get(index));
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
