package receiver;

import Paper.Page;
import Paper.Survey;
import Paper.Test;

public class PageCreator {
	Page page;

	public void createPage(int type,String personName) {
		if (type == 0) {
			page = new Survey();
			page.setType(Page.SURVEY);
			page.setCreatorName(personName);
		} else {
			page = new Test();
			page.setType(Page.TEST);
			page.setCreatorName(personName);
		}
	}
}
