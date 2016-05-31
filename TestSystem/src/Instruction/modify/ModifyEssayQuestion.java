package Instruction.modify;

import java.util.Scanner;

import Interface.QuestionModifier;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyEssayQuestion extends ModifyQuestion {
	private QuestionModifier qm = new QuestionModifier();

	public ModifyEssayQuestion(QuestionModifier qm) {
		this.qm = qm;
	}

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input new prompt: ");
        String prompt = scan.nextLine();
        qm.setPrompt(prompt);
    }
}
