package MVC;

import Instruction.CreatePage;
import Instruction.DisplayPage;
import Instruction.MenuAgent;
import Instruction.MenuOperation;
import Instruction.MenuOrder;
import View.ComandView;

public class MenuControl {
	private Menu menu;
	private MenuView view;

	public MenuControl(Menu menu, MenuView view) {
		this.menu = menu;
		this.view = view;
	}

	public void printMenu() {
		MenuOperation o = new MenuOperation();
		view.setMenu(menu.getMenu());
		view.display();
		int next = view.getNext();
		MenuOrder order = null;
		switch (next) {
		case 1:
			order = new CreatePage(ComandView.SURVEY, o);
			break;
		case 2:
			order = new CreatePage(ComandView.TEST, o);
			break;
		case 3:
			order = new DisplayPage(ComandView.SURVEY, o);
			break;
		case 4:
			order = new DisplayPage(ComandView.TEST, o);
			break;
		// add more
		case 5:
		case 6:
			control.save();
			break;
		case 7:
			this.modify(SURVEY);
			break;
		case 8:
			this.modify(TEST);
			break;
		case 9:
			this.answer(SURVEY);
			break;
		case 10:
			this.answer(TEST);
			break;
		case 11:
			this.displayOutcome(SURVEY);
			break;
		case 12:
			this.displayOutcome(TEST);
			break;
		case 13:
			System.exit(0);
		}
		MenuAgent agent = new MenuAgent();
		agent.placeOrder(order);
	}
}
