package MVC.view;

import java.util.Scanner;

public class CreatePageView implements View{
	private String name;
	Scanner sc = new Scanner(System.in);

	@Override
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
