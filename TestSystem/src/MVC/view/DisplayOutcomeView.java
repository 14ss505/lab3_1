package MVC.view;

import java.util.List;
import java.util.Scanner;

import MVC.control.DisplayOutcomeControl;

public class DisplayOutcomeView {
	private int num;
	Scanner sc = new Scanner(System.in);
	private List<String> pageNameList;
	DisplayOutcomeControl doc;

	public DisplayOutcomeView(DisplayOutcomeControl doc) {
		this.doc = doc;
	}

	public void display() {
		System.out.println("choose the page:");
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < pageNameList.size(); i++) {
			System.out.println(i + ": " + pageNameList.get(i));
		}
		setNum(sc.nextInt());
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<String> getPageNameList() {
		return pageNameList;
	}

	public void setPageNameList(List<String> pageNameList) {
		this.pageNameList = pageNameList;
	}

	public void displayContinue() {
		System.out.println("Enter any key to continu");
		sc.nextLine();
	}
}
