package Instruction.modify;

import Paper.Page;
import Question.MapQuestion;

import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyMapQuestion extends ModifyQuestion {
    public ModifyMapQuestion(Page page, int index) {
        super(page, index);
    }

    public void setSide(int side) {
        MapQuestion map = (MapQuestion) question;
        map.setSide(side);
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. modify the prompt\n" + "2. modify the number of items available\n"
                + "3. modify the items on the left\n" + "4. modify the items on the right\n");
        if (page.getType() == Page.TEST)
            System.out.println("5. modify correct answer:");
        int next = scan.nextInt();
        switch (next) {
            case 1:
                System.out.println("Please input new prompt:");
                String prompt = scan.nextLine();
                setPrompt(prompt);
                break;
            case 2:
                System.out.println("Please input new Number: ");
                int num = scan.nextInt();
                boolean outcome2 = changeItemNumber(num);
                if (outcome2) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
                break;
            case 3:
                setSide(1);
                boolean outcome = this.changeItem();
                if (outcome) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
                break;
            case 4:
                setSide(2);
                boolean outcome1 = this.changeItem();
                if (outcome1) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
                break;
            case 5:
                if (page.getType() == Page.SURVEY)
                    return;
                System.out.println("Please input new answer: ");
                String answer = scan.nextLine();
                setAnswer(answer);
                break;
        }
    }

    private boolean changeItem() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input question index");
        int index = scan.nextInt();
        System.out.println("Please input new item");
        String item = scan.nextLine();
        return super.changeItem(index, item);
    }
}
