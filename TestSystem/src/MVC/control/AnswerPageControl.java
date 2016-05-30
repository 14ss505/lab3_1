package MVC.control;

import java.util.List;

import MVC.model.Paper.Page;
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
