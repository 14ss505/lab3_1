package MVC.control;

import java.util.List;

import util.IO;
import MVC.model.Paper.Page;
import exclude.DisplayViewcmd;

public class DisplayControl {
	private Page page;
	private DisplayViewcmd view;
	private List<String> pageNameList;
	private IO io = new IO();

	public DisplayControl() {
		this.view = new DisplayViewcmd(this);
	}
	
	public void display(int type,int index){
		this.pageNameList = io.readAllPageNames(type);

		if(view.getPageNameList().size() <= index){
			System.out.println("index out of bound!");
		}else{
			page = io.readPage(pageNameList.get(index));
			page.display();
		} 
		
	}

}
