package Control;

import java.util.List;

import Paper.Page;
import View.FirstMenuPanel;
import util.IO;

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
