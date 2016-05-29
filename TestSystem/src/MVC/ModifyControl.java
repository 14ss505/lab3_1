package MVC;

import Control.IO;
import Instruction.modify.ModifyChoiceQuestion;
import Instruction.modify.ModifyQuestion;
import Instruction.modify.ModifyTFQuestion;
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
//    private List<String>[] pageNameList;
//    private IO io = new IO();

    public ModifyControl(ModifyView view) {
        this.view = view;
//        this.pageNameList = io.readInfo();
    }

    public ModifyControl(ModifyView view, Page page) {
        this.view = view;
        this.page = page;
    }

    private int getQuestionType(int index){
        if(index >= page.getQuestionList().size()){
            System.out.println("Index out of bound!");
            return -1;
        }else{
            Question question = page.getQuestion(index);
            return question.getType();
        }
    }

    public void modify() {
        page.display();
        System.out.println("Please choose which question that you want to modify: ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        int qType = getQuestionType(index);
        ModifyQuestion mq;
        switch (qType) {
            case 0:
            case 2:
                mq = new ModifyTFQuestion(page,index);
                break;
            case 1:
                mq = new ModifyChoiceQuestion(page, index);
                break;
            case 3:
                this.modifyEssayQuestion();
                break;
            case 4:
                this.modifyRankQuestion();
                break;
            case 5:
                this.modifyMapQuestion();
                break;
        }
    }
}
