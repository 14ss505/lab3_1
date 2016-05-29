package MVC.control;

import Control.IO;
import Instruction.modify.*;
import MVC.view.ModifyView;
import Paper.Page;
import Question.Question;

import java.util.List;
import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyControl {
    protected ModifyView view;
    private Page page;
    private List<String>[] pageNameList;
    private IO io = new IO();

    public ModifyControl(ModifyView view) {
        this.view = view;
    }

    private int getQuestionType(int index) {
        if (index >= page.getQuestionList().size()) {
            System.out.println("Index out of bound!");
            return -1;
        } else {
            Question question = page.getQuestion(index);
            return question.getType();
        }
    }

    private void display(int type) {
        view.setPageNameList(pageNameList[type]);
        view.display();
        int index = view.getNum();
        if (view.getPageNameList().size() <= index) {
            System.out.println("we do not have so many pages");
        } else {
            page = io.readPage(pageNameList[type].get(index));
            page.display();
        }
    }

    public void modify(int type) {
        display(type);
        System.out.println("Please choose which question that you want to modify: ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int qType = getQuestionType(index);
        ModifyQuestion mq = null;
        switch (qType) {
            case 0:
            case 2:
                mq = new ModifyTFQuestion(page, index);
                break;
            case 1:
                mq = new ModifyChoiceQuestion(page, index);
                break;
            case 3:
                mq = new ModifyEssayQuestion(page, index);
                break;
            case 4:
                mq = new ModifyRankQuestion(page, index);
                break;
            case 5:
                mq = new ModifyMapQuestion(page, index);
                break;
        }
        mq.execute();
    }
}
