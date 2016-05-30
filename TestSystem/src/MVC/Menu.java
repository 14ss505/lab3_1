package MVC;

import observer.MenuObserver;

public class Menu {
	private String menu;
	MenuObserver mo;

	public Menu(String s) {
		menu = s;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public void regObserver(MenuObserver mo) {
		this.mo = mo;
	}
	
	public void getNextMenu(int next){
		
	}

}
