package Instruction.modify;

import Paper.Page;
import Question.ItemQuestion;
import Question.MapQuestion;
import Question.Question;

import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyChoiceQuestion extends ModifyQuestion {

    public ModifyChoiceQuestion(Page page, int index) {
        super(page, index);
    }


    public void setItem(String item){// TODO: control
        ((ItemQuestion)question).setItem(item);
    }

    public boolean remove(int index){// TODO: control
        if(question.getType() == 5){
            return ((MapQuestion)question).remove(index);
        }
        return ((ItemQuestion)question).remove(index);
    }

    public boolean changeItem(int index, String item){// TODO: control
        if(question.getType() == Question.MAP){
            return ((MapQuestion)question).changeItem(index, item);
        }
        return ((ItemQuestion)question).changeItem(index, item);
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1.modify the prompt\n" + "2.modify the number of choices available\n" + "3.add choices\n"
                + "4.remove choices\n" + "5.modify any choices\n" + "6.the number of selections allowed");
        if (page.getType() == Page.TEST)
            System.out.println("7. modify correct answer:");
        int next = scan.nextInt();
        switch (next) {
            case 1:
                System.out.println("Please input new prompt:");
                String prompt = scan.nextLine();
                setPrompt(prompt);
                break;
            case 2:
                System.out.println("Please input new item number");
                int num = scan.nextInt();
                boolean outcome2 = ((ItemQuestion)question).changeItemNumber(num);// TODO: control
                if (outcome2) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
            case 3:
                System.out.println("Please input new choice:");
                String item = scan.nextLine();
                setItem(item);
                break;
            case 4:
                System.out.println("Please input the index of the choice");
                int index = scan.nextInt();
                boolean outcome = remove(index);
                if (outcome) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
                break;
            case 5:
                System.out.println("Please input the index of the choice:");
                int index1 = scan.nextInt();
                System.out.println("Please input the new item:");
                String item1 = scan.nextLine();
                boolean outcome1 = changeItem(index1, item1);
                if (outcome1) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
                break;
            case 6:
            case 7:
                if (page.getType() == Page.SURVEY)
                    return;
                System.out.println("Please input new answer:");
                String answer = scan.nextLine();
                setAnswer(answer);
                break;
            default:
                System.out.println("This is a wrong input");
        }
    }
}
