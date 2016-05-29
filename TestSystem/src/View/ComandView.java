package View;

import Control.Control;
import MVC.AddQuestionControl;
import MVC.AddQuestionView;
import MVC.CreatePageControl;
import MVC.CreatePageView;
import MVC.DisplayControl;
import MVC.DisplayView;
import MVC.Menu;
import MVC.MenuControl;
import MVC.MenuView;
import Paper.Page;
import util.PageFactory;

import java.util.List;
import java.util.Scanner;

public class ComandView {
	public static final int SURVEY = 0;
	public static final int TEST = 1;
	Control control = new Control();
	Scanner sc = new Scanner(System.in);
	int type;

    public void printFirstMenu() {
        Menu menu = new Menu();
        menu.setMenu("1) Create a new Survey\n"
                + "2) Create a new Test\n"
                + "3) Display Survey\n"
                + "4) Display a Test \n"
                + "5) Save a Survey\n"
                + "6) Save a Test \n"
                + "7) Modify a Survey\n"
                + "8) Modify a Test\n"
                + "9) Take a Survey\n"
                + "10)Take a Test\n"
                + "11)Look survey outcome\n"
                + "12)Look test outcome\n"
                + "13) Quit\n");
        MenuView view = new MenuView();
        MenuControl mc = new MenuControl(menu, view);
        mc.printMenu();
        switch (next) {
            case 1:
                createPage(SURVEY);
                break;
            case 2:
                createPage(TEST);
                break;
            case 3:
                this.display(SURVEY);
                break;
            case 4:
                this.display(TEST);
                break;
            case 5:
            case 6:
                control.save();
                break;
            case 7:
                this.modify(SURVEY);
                break;
            case 8:
                this.modify(TEST);
                break;
            case 9:
                this.answer(SURVEY);
                break;
            case 10:
                this.answer(TEST);
                break;
            case 11:
                this.displayOutcome(SURVEY);
                break;
            case 12:
                this.displayOutcome(TEST);
                break;
            case 13:
                System.exit(0);
        }
    }

	public void displayOutcome(int type) {
		System.out.println("choose the page:");
		Scanner scan = new Scanner(System.in);
		List<String> pageNameList = control.getPageName(type);
		for (int i = 0; i < pageNameList.size(); i++) {
			System.out.println(i + ": " + pageNameList.get(i));
		}
		int index = sc.nextInt();
		System.out.println(control.getOutcome(index, type));
		System.out.println("Enter any key to continu");
		scan.nextLine();
	}

	public void answer(int type) {
		Scanner scan = new Scanner(System.in);
		List<String> nameList = control.getPageName(type);
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(i + ") " + nameList.get(i));
		}

		int pageIndex = sc.nextInt();
		control.loadPage(pageIndex, 1);
		System.out.println("Input your name: ");
		String personName = scan.nextLine();
		control.setRecordName(personName);

		while (control.hasNextQuestion()) {
			System.out.println(control.nextQuestion());
			String answer = scan.nextLine();
			control.answerQuestion(answer);
		}

		System.out.println("Ok, it's all!");
		control.saveAnswer();
	}

	public void modify(int type) {
		this.type = type;
		this.display(type);
		System.out.println("Please choose which question that you want to modify: ");
		int index = sc.nextInt();
		int next = control.modify(index);
		switch (next) {
		case 0:
			this.modifyTFQuestion();
			break;
		case 1:
			this.modifyChoiceQuestion();
			break;
		case 2:
			this.modifyTFQuestion();
			break;
		case 3:
			this.modifyEssayQuestion();
			break;
		case 4:
			this.modifyRankQuestion();
			break;
		case 5:
			this.modifyMapQuestion();
			break;
		}
	}

	public void modifyTFQuestion() {
		// Scanner scan = new Scanner(System.in);
		System.out.println("1. modify prompt: ");
		if (type == TEST)
			System.out.println("2. modify answer");
		int next = sc.nextInt();
		if (next == 1) {
			System.out.println("Please input new prompt: ");
			// String prompt = scan.nextLine();
			String prompt = sc.nextLine();
			control.setPrompt(prompt);
		} else if (next == 2 && type == TEST) {
			System.out.println("Please input new anwser: ");
			// String answer = scan.nextLine();
			String answer = sc.nextLine();
			control.setAnswer(answer);
		} else {
			System.out.println("We don't hava this item");
		}
	}

	public void modifyChoiceQuestion() {
		// Scanner scan = new Scanner(System.in);
		System.out.println("1.modify the prompt\n" + "2.modify the number of choices available\n" + "3.add choices\n"
				+ "4.remove choices\n" + "5.modify any choices\n" + "6.the number of selections allowed");
		if (type == TEST)
			System.out.println("7. modify correct answer:");
		int next = sc.nextInt();
		switch (next) {
		case 1:
			System.out.println("Please input new prompt:");
			// String prompt = scan.nextLine();
			String prompt = sc.nextLine();
			control.setPrompt(prompt);
			break;
		case 2:
			System.out.println("Please input new item number");
			int num = sc.nextInt();
			boolean outcome2 = control.changeItemNumber(num);
			if (outcome2) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
		case 3:
			System.out.println("Please input new choice:");
			String item = sc.nextLine();
			// String item = scan.nextLine();
			control.setItem(item);
			break;
		case 4:
			System.out.println("Please input the index of the choice");
			int index = sc.nextInt();
			boolean outcome = control.remove(index);
			if (outcome) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 5:
			System.out.println("Please input the index of the choice:");
			int index1 = sc.nextInt();
			System.out.println("Please input the new item:");
			// String item1 = scan.nextLine();
			String item1 = sc.nextLine();
			boolean outcome1 = control.changeItem(index1, item1);
			if (outcome1) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 6:
		case 7:
			if (type == SURVEY)
				return;
			System.out.println("Please input new answer:");
			// String answer = scan.nextLine();
			String answer = sc.nextLine();
			control.setAnswer(answer);
			break;
		default:
			System.out.println("This is a wrong input");
		}
	}

	public void modifyRankQuestion() {
		// Scanner scan = new Scanner(System.in);
		System.out.println("1. modify the prompt\n" + "2. modify the number of items available\n"
				+ "3. modify the items to be ranked\n");
		if (type == 1)
			System.out.println("4. modify correct answer:");
		int next = sc.nextInt();
		switch (next) {
		case 1:
			System.out.println("Please input new prompt:");
			// String prompt = scan.nextLine();
			String prompt = sc.nextLine();
			control.setPrompt(prompt);
			break;
		case 2:
			System.out.println("Please input new number:");
			int num = sc.nextInt();
			boolean outcome2 = control.changeItemNumber(num);
			if (outcome2) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 3:
			System.out.println("Please input the item index: ");
			int index = sc.nextInt();
			System.out.println("Please input the new item");
			// String item = scan.nextLine();
			String item = sc.nextLine();
			boolean outcome = control.changeItem(index, item);
			if (outcome) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 4:
			if (type == 0)
				return;
			System.out.println("Please input new answer:");
			// String answer = scan.nextLine();
			String answer = sc.nextLine();
			control.setAnswer(answer);
			break;
		default:
			System.out.println("This is a wrong input");
		}
	}

	public void modifyMapQuestion() {
		// Scanner scan = new Scanner(System.in);
		System.out.println("1. modify the prompt\n" + "2. modify the number of items available\n"
				+ "3. modify the items on the left\n" + "4. modify the items on the right\n");
		if (type == TEST)
			System.out.println("5. modify correct answer:");
		int next = sc.nextInt();
		switch (next) {
		case 1:
			System.out.println("Please input new prompt:");
			// String prompt = scan.nextLine();
			String prompt = sc.nextLine();
			control.setPrompt(prompt);
			break;
		case 2:
			System.out.println("Please input new Number: ");
			int num = sc.nextInt();
			boolean outcome2 = control.changeItemNumber(num);
			if (outcome2) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 3:
			control.setSide(1);
			boolean outcome = this.changeItem();
			if (outcome) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 4:
			control.setSide(2);
			boolean outcome1 = this.changeItem();
			if (outcome1) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 5:
			if (type == 0)
				return;
			System.out.println("Please input new answer: ");
			// String answer = scan.nextLine();
			String answer = sc.nextLine();
			control.setAnswer(answer);
			break;
		}
	}

	private boolean changeItem() {
		// Scanner scan = new Scanner(System.in);
		System.out.println("Please input question index");
		int index = sc.nextInt();
		System.out.println("Please input new item");
		// String item = scan.nextLine();
		String item = sc.nextLine();
		return control.changeItem(index, item);
	}

	public void modifyEssayQuestion() {
		// Scanner scan = new Scanner(System.in);
		System.out.println("Please input new prompt: ");
		// String prompt = scan.nextLine();
		String prompt = sc.nextLine();
		control.setPrompt(prompt);
	}

}
