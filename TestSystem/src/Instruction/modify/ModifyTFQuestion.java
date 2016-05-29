package Instruction.modify;

import Paper.Page;

import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyTFQuestion extends ModifyQuestion {
    public ModifyTFQuestion(Page page, int index) {
        super(page, index);
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
            setPrompt(prompt);
        } else if (next == 2 && page.getType() == Page.TEST) {
            System.out.println("Please input new anwser: ");
            String answer = scan.nextLine();
            setAnswer(answer);
        } else {
            System.out.println("We don't hava this item");
        }
    }
}
