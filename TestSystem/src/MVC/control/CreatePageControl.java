package MVC.control;

import java.util.List;

import util.IO;
import MVC.view.CreatePageView;
import MVC.model.Paper.Page;

public class CreatePageControl {
	private CreatePageView view;
	private Page page;
	private List<String>[] pageNameList;
	private IO io = new IO();

	public CreatePageControl(Page page) {
		view = new CreatePageView(this);
		this.pageNameList = io.readInfo();
		this.page = page;
		
	}

	public CreatePageView getView() {
		return view;
	}

	public void setView(CreatePageView view) {
		this.view = view;
	}
	
	public void setPageName() {
		view.display();
		page.setPageName(view.getName());
		if (page.getType() == 0) {
			pageNameList[1].add(page.getPageName());
		} else {
			pageNameList[0].add(page.getPageName());
		}
		
	}

	

}
