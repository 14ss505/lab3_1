package MVC.view;

import MVC.control.ModifyController;
import MVC.model.Paper.Page;
import MVC.model.Question.Question;

import java.util.List;
import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyView extends Observer implements View{
    private Page page;
    private Question question;
    private ModifyController controller;
    
    private int num;
    private Scanner sc = new Scanner(System.in);
    private List<String> pageNameList;

    @Override
    public void display() {
        for (int i = 0; i < pageNameList.size(); i++) {
            System.out.println(i + ": " + pageNameList.get(i));
        }
        System.out.println("choose the page:");
        setNum(sc.nextInt());
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<String> getPageNameList() {
        return pageNameList;
    }

    public void setPageNameList(List<String> pageNameList) {
        this.pageNameList = pageNameList;
    }

    //new start
    public void modify() {
        System.out.println("Please choose which question that you want to modify: ");
        int index = sc.nextInt();
        controller.modify(index);
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
        }else if(next == 2 && page.getType() == 1){
            System.out.println("Please input new anwser: ");
            String answer = sc.nextLine();
            controller.setAnswer(answer);
        } else {
            warn("We don't hava this item");
        }
    }

    public void modifyChoiceQuestion() {
        System.out.println("1.modify the prompt\n"
                +"2.modify the number of choices available\n"
                +"3.add choices\n"
                +"4.remove choices\n"
                +"5.modify any choices\n"
                +"6.the number of selections allowed\n");
        if(page.getType() == Page.TEST)
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
                boolean outcome2 = controller.changeItemNumber(num);
                if (outcome2) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
            case 3:
                System.out.println("Please input new choice:");
                String item = sc.nextLine();
                // String item = scan.nextLine();
                controller.setItem(item);
                break;
            case 4:
                System.out.println("Please input the index of the choice");
                int index = sc.nextInt();
                boolean outcome = controller.remove(index);
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
                boolean outcome1 = controller.changeItem(index1, item1);
                if (outcome1) {
                    System.out.println("Ok, it has changed");
                } else {
                    System.out.println("We don't have this item");
                }
                break;
            case 6:
            case 7:
                if (page.getType() == SURVEY)
                    return;
                System.out.println("Please input new answer:");
                // String answer = scan.nextLine();
                String answer = sc.nextLine();
                controller.setAnswer(answer);
                break;
            default:
                System.out.println("This is a wrong input");
        }
    }

    public void warn(String s) {
        System.out.println(s);
    }
}
