package main;

import MVC.Menu;
import MVC.MenuControl;
import exclude.ComandView;

public class StartUp {
	public static void main(String[] args) {

		Menu menu = new Menu();

		while (true) {
			MenuControl mc = new MenuControl(menu);
		}

	}
}
