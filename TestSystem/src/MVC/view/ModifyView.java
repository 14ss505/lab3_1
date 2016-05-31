package MVC.view;

import MVC.control.ModifyControl;
import MVC.model.Paper.Page;
import MVC.model.Question.Question;

import java.util.List;
import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyView implements ModifyObserver {
    private Page page;
    private Question question;
    private ModifyControl controller;

    private Scanner sc = new Scanner(System.in);

    public ModifyView(ModifyControl controller) {
        this.controller = controller;
    }

    // TODO: 16/5/30  GUI
    public void createView() {

    }

    public void modify() {
        this.display();
        System.out.println("Please choose which question that you want to modify: ");
        int index = sc.nextInt();
        controller.modify(index);
    }

    public void display() {
        System.out.println("choose the page:" + "1. Modify a Survey\n" + "2. Modify a Test\n");
        int type = sc.nextInt();
        System.out.println(controller.display(type));
        System.out.println("input the page number:");
        int index = sc.nextInt();
        List<String> question = controller.displayPage(index, type);
        for (int i = 0; i < question.size(); i++) {
            System.out.println(question.get(i));
        }
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void modifyTFQuestion() {
        System.out.println("1. modify prompt: ");
        if (page.getType() == Page.TEST)
            System.out.println("2. modify answer");
        int next = sc.nextInt();
        if (next == 1) {
            System.out.println("Please input new prompt: ");
            String prompt = sc.nextLine();
            controller.setPrompt(prompt);
        } else if (next == 2 && page.getType() == Page.TEST) {
            System.out.println("Please input new anwser: ");
            String answer = sc.nextLine();
            controller.setAnswer(answer);
        } else {
            warn("We don't hava this item");
        }
    }

    public void modifyChoiceQuestion() {
        System.out.println("1.modify the prompt\n"
                + "2.modify the number of choices available\n"
                + "3.add choices\n"
                + "4.remove choices\n"
                + "5.modify any choices\n"
                + "6.the number of selections allowed\n");
        if (page.getType() == Page.TEST)
            System.out.println("7. modify correct answer:");
        int next = sc.nextInt();
        switch (next) {
            case 1:
                System.out.println("Please input new prompt:");
                String prompt = sc.nextLine();
                controller.setPrompt(prompt);
                break;
            case 2:
                System.out.println("Please input new item number");
                int num = sc.nextInt();
                controller.changeItemNumber(num);
            case 3:
                System.out.println("Please input new choice:");
                String item = sc.nextLine();
                controller.setItem(item);
                break;
            case 4:
                System.out.println("Please input the index of the choice");
                int index = sc.nextInt();
                controller.remove(index);
                break;
            case 5:
                System.out.println("Please input the index of the choice:");
                int index1 = sc.nextInt();
                System.out.println("Please input the new item:");
                String item1 = sc.nextLine();
                controller.changeItem(index1, item1);
                break;
            case 6:
            case 7:
                if (page.getType() == Page.SURVEY)
                    return;
                System.out.println("Please input new answer:");
                String answer = sc.nextLine();
                controller.setAnswer(answer);
                break;
            default:
                this.warn("This is a wrong input");
        }
    }

    public void warn(String s) {
        System.out.println(s);
    }

    @Override
    public void accomplishedModify() {
        System.out.println("Ok, it has changed");
    }

    public void modifyEssayQuestion() {
        System.out.println("Please input new prompt: ");
        String prompt = sc.nextLine();
        controller.setPrompt(prompt);
    }

    public void modifyRankQuestion() {
        System.out.println("1. modify the prompt\n" + "2. modify the number of items available\n"
                + "3. modify the items to be ranked\n");
        if (page.getType() == 1)
            System.out.println("4. modify correct answer:");
        int next = sc.nextInt();
        switch (next) {
            case 1:
                System.out.println("Please input new prompt:");
                String prompt = sc.nextLine();
                controller.setPrompt(prompt);
                break;
            case 2:
                System.out.println("Please input new number:");
                int num = sc.nextInt();
                controller.changeItemNumber(num);
                break;
            case 3:
                System.out.println("Please input the item index: ");
                int index = sc.nextInt();
                System.out.println("Please input the new item");
                String item = sc.nextLine();
                controller.changeItem(index, item);
                break;
            case 4:
                if (page.getType() == 0)
                    return;
                System.out.println("Please input new answer:");
                String answer = sc.nextLine();
                controller.setAnswer(answer);
                break;
            default:
                this.warn("This is a wrong input");
        }
    }

    public void modifyMapQuestion() {
        System.out.println("1. modify the prompt\n" + "2. modify the number of items available\n"
                + "3. modify the items on the left\n" + "4. modify the items on the right\n");
        if (page.getType() == Page.TEST)
            System.out.println("5. modify correct answer:");
        int next = sc.nextInt();
        switch (next) {
            case 1:
                System.out.println("Please input new prompt:");
                String prompt = sc.nextLine();
                controller.setPrompt(prompt);
                break;
            case 2:
                System.out.println("Please input new Number: ");
                int num = sc.nextInt();
                controller.changeItemNumber(num);
                break;
            case 3:
                controller.setSide(1);
            case 4:
                if (next == 4) {
                    controller.setSide(2);
                }
                System.out.println("Please input question index");
                int index = sc.nextInt();
                System.out.println("Please input new item");
                String item = sc.nextLine();
                controller.changeItem(index, item);
                break;
            case 5:
                if (page.getType() == 0)
                    return;
                System.out.println("Please input new answer: ");
                String answer = sc.nextLine();
                controller.setAnswer(answer);
                break;
            default:
                this.warn("Invalid Input!");
        }
    }
}
