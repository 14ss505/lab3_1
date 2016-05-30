package MVC;

import MVC.view.View;
import observer.MenuObserver;

import java.util.Scanner;



public class MenuView implements View, MenuObserver {
	private int next;
	private Menu m;
	private MenuControl mc;
	
	

	public MenuView(MenuControl mc, Menu m) {
		this.mc = mc;
		this.m = m;
		m.regObserver(this);
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
