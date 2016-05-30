package exclude;

import MVC.Menu;
import MVC.MenuControl;
import observer.MenuObserver;

import java.util.Scanner;



public class MenuViewcmd implements View, MenuObserver {
	private int next;
	private Menu m;
	private MenuControl mc;
	
	

	public MenuViewcmd(MenuControl mc, Menu m) {
		this.mc = mc;
		this.m = m;
		m.regObserver(this);
		mc.setView(this);
	}

	@Override
	public void display() {
		System.out.println(m.getMenu());
		Scanner sc = new Scanner(System.in);
		setNext(sc.nextInt());
		mc.getNextMenu();
	}

	public void nextView() {
		
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
}
