package MVC;

import java.util.Scanner;

public class MenuView {
	private String menu;
	Scanner sc = new Scanner(System.in);
	private int next;
	
	public void display() {
		setMenu("1) Create a new Survey\n" + "2) Create a new Test\n" + "3) Display Survey\n" + "4) Display a Test \n"
				+ "5) Save a Survey\n" + "6) Save a Test \n" + "7) Modify a Survey\n" + "8) Modify a Test\n"
				+ "9) Take a Survey\n" + "10)Take a Test\n" + "11)Look survey outcome\n" + "12)Look test outcome\n"
				+ "13) Quit\n");
		setNext(sc.nextInt());	
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
}
