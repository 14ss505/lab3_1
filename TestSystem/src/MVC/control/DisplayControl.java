package MVC.control;

import java.util.List;

import util.IO;
import MVC.view.DisplayView;
import MVC.model.Paper.Page;

public class DisplayControl {
	private Page page;
	private DisplayView view;
	private List<String>[] pageNameList;
	private IO io = new IO();

	public DisplayControl() {
		this.pageNameList = io.readInfo();
		this.view = new DisplayView(this);
	}
	
	public void display(int type){
		view.setPageNameList(pageNameList[type]);
		view.display();
		int index = view.getNum();
		if(view.getPageNameList().size() <= index){
			System.out.println("index out of bound!");
		}else{
			page = io.readPage(pageNameList[type].get(index));
			page.display();
		} 
		
	}

}
