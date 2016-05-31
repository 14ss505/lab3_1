package MVC.control;

import util.IO;
import MVC.view.CreatePageView;

import java.util.List;

import MVC.model.Paper.Page;

public class CreatePageControl {
	private Page page;
	private CreatePageView view;
	private IO io = new IO();
	private List<String> pageNameList;

	public CreatePageControl(Page page, CreatePageView view) {
		this.page = page;
		this.view = view;
	}

	public void setPageName() {
		int type = page.getType();
		String personName = null;
		String pageName = null;
		
		pageNameList = io.readAllPageNames(type, personName);
		//check if the page has exist
		page.setPageName(pageName);
		io.writePage(page, personName);
		
	}

}
