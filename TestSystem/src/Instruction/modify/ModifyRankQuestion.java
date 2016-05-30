package Instruction.modify;

import MVC.model.Paper.Page;

import java.util.Scanner;

import Interface.QuestionModifier;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyRankQuestion extends ModifyQuestion {
	private QuestionModifier qm = new QuestionModifier();

	public ModifyRankQuestion(QuestionModifier qm) {
		this.qm = qm;
	}

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1. modify the prompt\n" + "2. modify the number of items available\n"
				+ "3. modify the items to be ranked\n");
		if (page.getType() == Page.TEST)
			System.out.println("4. modify correct answer:");
		int next = scan.nextInt();
		switch (next) {
		case 1:
			System.out.println("Please input new prompt:");
			String prompt = scan.nextLine();
			qm.setPrompt(prompt);
			break;
		case 2:
			System.out.println("Please input new number:");
			int num = scan.nextInt();
			boolean outcome2 = qm.changeItemNumber(num);
			if (outcome2) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 3:
			System.out.println("Please input the item index: ");
			int index = scan.nextInt();
			System.out.println("Please input the new item");
			String item = scan.nextLine();
			boolean outcome = qm.changeItem(index, item);
			if (outcome) {
				System.out.println("Ok, it has changed");
			} else {
				System.out.println("We don't have this item");
			}
			break;
		case 4:
			if (page.getType() == Page.SURVEY)
				return;
			System.out.println("Please input new answer:");
			String answer = scan.nextLine();
			qm.setAnswer(answer);
			break;
		default:
			System.out.println("This is a wrong input");
		}
	}
}
