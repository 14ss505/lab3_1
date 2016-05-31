package agent;

import command.MenuOrder;

public class MenuAgent {
	public void placeOrder(MenuOrder order) {
		order.execute();
	}
}
