package MVC;

import java.util.Scanner;

public class CreatePageView {
	private String name;
	Scanner sc = new Scanner(System.in);

	public void display() {
		System.out.println("Please input your pageName");
		setName(sc.next());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
