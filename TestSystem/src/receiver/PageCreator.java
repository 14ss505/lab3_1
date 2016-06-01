package receiver;

import Paper.Page;
import Paper.Survey;
import Paper.Test;
import util.DataCommand;

public class PageCreator {
	Page page;
	private DataCommand dataCommand= new DataCommand();

	public void createPage(int type,String pageName,String personName) {

		if (type == 0) {
			page = new Survey(pageName, personName);
			page.setType(Page.SURVEY);
			page.setPageName(pageName);
			page.setPersonName(personName);
		} else {
			page = new Test(personName, personName);
			page.setType(Page.TEST);
			page.setPageName(pageName);
			page.setPersonName(personName);
		}
		dataCommand.updatePageList(pageName, type, personName);
	}
}
