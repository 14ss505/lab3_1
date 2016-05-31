package MVC.view;

import java.util.Scanner;

public class AddQuestionView implements View{
	Scanner sc = new Scanner(System.in);
	private int next;
	private int next2;

	@Override
	public void display() {
		System.out.println("1. add a new MVC.model.Question\n"
                + "2. compele this page\n");
        setNext(sc.nextInt());
	}
	
	public void displaymore(){
		System.out.println("1) Add a new T/F question\n"
                + "2) Add a new multiple choice question\n"
                + "3) Add a new short answer question\n"
                + "4) Add a new essay question\n"
                + "5) Add a new ranking question\n"
                + "6) Add a new map question\n");
		setNext2(sc.nextInt());
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getNext2() {
		return next2;
	}

	public void setNext2(int next2) {
		this.next2 = next2;
	}
}
