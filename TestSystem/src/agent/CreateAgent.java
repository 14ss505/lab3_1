package agent;

import command.Create;

public class CreateAgent {
	public void placeCreateOrder(Create c,String personName) {
		c.execute(personName);
	}
}
