package agent;

import Paper.Page;
import command.Create;

public class CreateAgent {
	public void placeCreateOrder(Create c) {
		c.execute();
	}

	public Page getPage(Create c) {
		return c.getPage();
	}
}
