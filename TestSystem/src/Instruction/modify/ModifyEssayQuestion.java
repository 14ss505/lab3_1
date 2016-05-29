package Instruction.modify;

import Paper.Page;

import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyEssayQuestion extends ModifyQuestion {
    public ModifyEssayQuestion(Page page, int index) {
        super(page, index);
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input new prompt: ");
        String prompt = scan.nextLine();
        setPrompt(prompt);
    }
}
