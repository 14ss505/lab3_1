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
		} else {
			page = new Test(personName, personName);
			page.setType(Page.TEST);
		}
		dataCommand.updatePageList(pageName, type, personName);
	}
}
