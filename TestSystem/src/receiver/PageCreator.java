package receiver;

import Paper.Page;
import Paper.Survey;
import Paper.Test;
import util.DataCommand;

public class PageCreator {
	Page page;
	private DataCommand dataCommand= new DataCommand();

	public void createPage(int type,String pageName,String personName) {

		dataCommand.createPage(pageName, personName, type);
	}
}
