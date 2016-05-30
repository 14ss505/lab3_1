package MVC;

import Instruction.*;
import Interface.MenuOperation;
import MVC.model.Paper.Page;

public class MenuControl {
	private Menu menu;
	private MenuView view;

	public MenuControl(Menu menu, MenuView view) {
		this.menu = menu;
		this.view = view;
		menu.setMenu("1) Create a new Survey\n" + "2) Create a new Test\n" + "3) Display Survey\n"
				+ "4) Display a Test \n" + "5) Save a Survey\n" + "6) Save a Test \n" + "7) Modify a Survey\n"
				+ "8) Modify a Test\n" + "9) Take a Survey\n" + "10)Take a Test\n" + "11)Look survey outcome\n"
				+ "12)Look test outcome\n" + "13) Quit\n");
		view.display();
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
		case 9:
			order = new AnswerPage(Page.SURVEY, o);
			break;
		case 10:
			order = new AnswerPage(Page.TEST, o);
			break;
		case 11:
			order = new DisplayOutcome(Page.SURVEY, o);
			break;
		case 12:
			order = new DisplayOutcome(Page.TEST, o);
			break;
		case 13:
			System.exit(0);
		}
		MenuAgent agent = new MenuAgent();
		agent.placeOrder(order);
	}
}
