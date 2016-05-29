package MVC.control;

import java.util.List;

import Control.IO;
import MVC.view.CreatePageView;
import Paper.Page;

public class CreatePageControl {
	private Page page;
	private CreatePageView view;
	private List<String>[] pageNameList;
	private IO io = new IO();

	public CreatePageControl(Page page, CreatePageView view) {
		this.pageNameList = io.readInfo();
		this.page = page;
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
