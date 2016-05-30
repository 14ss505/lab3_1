package Instruction.modify;

import MVC.model.Paper.Page;

import java.util.Scanner;

import Interface.QuestionModifier;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyTFQuestion extends ModifyQuestion {
	private QuestionModifier qm = new QuestionModifier();

	public ModifyTFQuestion(QuestionModifier qm) {
		this.qm = qm;
	}
    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. modify prompt: ");
        if (page.getType() == Page.TEST)
            System.out.println("2. modify answer");
        int next = scan.nextInt();
        if (next == Page.TEST) {
            System.out.println("Please input new prompt: ");
            String prompt = scan.nextLine();
            qm.setPrompt(prompt);
        } else if (next == 2 && page.getType() == Page.TEST) {
            System.out.println("Please input new anwser: ");
            String answer = scan.nextLine();
            qm.setAnswer(answer);
        } else {
            System.out.println("We don't hava this item");
        }
    }
}
