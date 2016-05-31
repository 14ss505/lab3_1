package MVC.control;

import java.util.List;

import util.IO;
import MVC.model.Paper.Page;
import MVC.view.gui.FirstMenuPanel;

public class CreatePageControl {
	private FirstMenuPanel view;
	private Page page;
	private List<String>[] pageNameList;
	private IO io = new IO();

	public CreatePageControl(Page page) {
		this.pageNameList = io.readInfo();
		this.page = page;
	}

	public void setPageName(String pageName,String personName) {
		page.setPageName(pageName);
		page.setPersonName(personName);
		if (page.getType() == 0) {
			pageNameList[1].add(page.getPageName());
		} else {
			pageNameList[0].add(page.getPageName());
		}

	}

}
