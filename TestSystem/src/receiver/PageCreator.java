package receiver;

import Paper.Page;
import Paper.Survey;
import Paper.Test;

public class PageCreator {
	Page page;

	public void createPage(int type) {
		if (type == 0) {
			page = new Survey();
			page.setType(Page.SURVEY);
		} else {
			page = new Test();
			page.setType(Page.TEST);
		}
	}
}
