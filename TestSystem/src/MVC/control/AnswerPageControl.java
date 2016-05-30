package MVC.control;

import java.util.List;

import MVC.model.Paper.Page;
import MVC.view.AnswerPageView;
import util.IO;



public class AnswerPageControl {
	private Page page;
	private AnswerPageView view;
	private List<String>[] pageNameList;
	private IO io = new IO();
	
	public AnswerPageControl(AnswerPageView view) {
		this.pageNameList = io.readInfo();
		this.view = view;
	}

	public void answer(int type) {
		view.setPageNameList(pageNameList[type]);
		view.display();
		int index = view.getNum();
		
		if(view.getPageNameList().size() <= index){
			System.out.println("index out of bound!");
		}else{
			page = io.readPage(pageNameList[type].get(index));
		}
	}
	
	public Page getPage(){
		return page;
	}
}
