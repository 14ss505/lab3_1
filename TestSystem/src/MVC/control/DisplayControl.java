package MVC.control;

import java.util.List;

import util.IO;
import MVC.view.DisplayView;
import MVC.model.Paper.Page;

public class DisplayControl {
	private Page page;
	private DisplayView view;
	private List<String> pageNameList;
	private IO io = new IO();

	public DisplayControl(DisplayView view) {
		
		this.view = view;
	}
	
	public void display(int type){
		this.pageNameList = io.readAllPageNames(type);//display for test-taker or modifier?
		
		int index=0 ;
		
		if(pageNameList .size() <= index){
			System.out.println("index out of bound!");
		}else{
			page = io.readPage(pageNameList.get(index));
			page.display();
		} 
		
	}

}
