package MVC;

import Instruction.*;
import Interface.MenuOperation;
import MVC.view.MenuView;
import Paper.Page;

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
			order = new CreatePage(Page.SURVEY, o);
			break;
		case 2:
			order = new CreatePage(Page.TEST, o);
			break;
		case 3:
			order = new DisplayPage(Page.SURVEY, o);
			break;
		case 4:
			order = new DisplayPage(Page.TEST, o);
			break;
		case 5:
			order = new SavePage(Page.SURVEY, o);
			break;
		case 6:
			order = new SavePage(Page.TEST, o);
			break;
		case 7:
			order = new ModifyPage(Page.SURVEY, o);
			break;
		case 8:
			order = new ModifyPage(Page.TEST, o);
			break;
			// TODO: ymm starts here
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
