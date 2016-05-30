package MVC;

import MVC.model.Paper.Page;
import MVC.view.View;
import observer.MenuObserver;

import java.util.Scanner;

import Instruction.AnswerPage;
import Instruction.CreatePage;
import Instruction.DisplayOutcome;
import Instruction.DisplayPage;
import Instruction.MenuAgent;
import Instruction.MenuOrder;
import Instruction.ModifyPage;
import Instruction.SavePage;
import Interface.MenuOperation;

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
	}

	public View nextView() {
		MenuOperation o = new MenuOperation();
		MenuOrder order = null;
		switch (next) {
		case 1:
			order = new CreatePage(Page.SURVEY, o);
			break;
		case 2:
			order = new CreatePage(Page.TEST, o);
			break;
		case 3:
			order = new DisplayPage(Page.SURVEY, o);
			break;
		case 4:
			order = new DisplayPage(Page.TEST, o);
			break;
		case 5:
			order = new SavePage(Page.SURVEY, o);
			break;
		case 6:
			order = new SavePage(Page.TEST, o);
			break;
		case 7:
			order = new ModifyPage(Page.SURVEY, o);
			break;
		case 8:
			order = new ModifyPage(Page.TEST, o);
			break;
		case 9:
			order = new AnswerPage(Page.SURVEY, o);
			break;
		case 10:
			order = new AnswerPage(Page.TEST, o);
			break;
		case 11:
			order = new DisplayOutcome(Page.SURVEY, o);
			break;
		case 12:
			order = new DisplayOutcome(Page.TEST, o);
			break;
		case 13:
			System.exit(0);
		}
		MenuAgent agent = new MenuAgent();
		agent.placeOrder(order);
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
}
