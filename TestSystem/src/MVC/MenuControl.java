package MVC;

import Instruction.*;
import Interface.MenuOperation;
import MVC.model.Paper.Page;

public class MenuControl {
	private Menu menu;
	private MenuView view;

	public MenuControl(Menu menu) {
		this.menu = menu;
		this.view = new MenuView(this, menu);
		menu.setMenu("1) Create a new Survey\n" + "2) Create a new Test\n" + "3) Display Survey\n"
				+ "4) Display a Test \n" + "5) Save a Survey\n" + "6) Save a Test \n" + "7) Modify a Survey\n"
				+ "8) Modify a Test\n" + "9) Take a Survey\n" + "10)Take a Test\n" + "11)Look survey outcome\n"
				+ "12)Look test outcome\n" + "13) Quit\n");
		view.display();
	}

	public void getNextMenu() {
		int num = view.getNext();
		menu.getNextMenu(num);
	}
}
