package MVC.control;

import MVC.model.Paper.Iterator;
import MVC.model.Paper.Page;
import MVC.model.Question.ItemQuestion;
import MVC.model.Question.MapQuestion;
import MVC.model.Question.Question;
import MVC.view.ModifyView;
import util.IO;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayezhou on 16/5/30.
 */
public class ModifyControl implements ModifyControllerInterface {
    private ModifyView view;
    private Page page;
    private Question question;
    private List<String>[] pageNameList;// TODO: 16/5/30 share
    private IO io;

    public ModifyControl() {
        io = new IO();
        pageNameList = io.readInfo();
    }

    public void setPrompt(String prompt) {
        question.setPrompt(prompt);
    }

    /*Chow invoke it*/
    public void modify() {

    }

    public void modify(int index) {
        if (index >= page.getQuestionList().size()) {
            view.warn("We do not have so many pages!");
        } else {
            question = page.getQuestion(index);
            view.setQuestion(question);
            switch (question.getType()) {
                case 0:
                    this.modifyTFQuestion();
                    break;
                case 1:
                    this.modifyChoiceQuestion();
                    break;
                case 2:
                    this.modifyTFQuestion();
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

    private void modifyMapQuestion() {
        view.modifyMapQuestion();
    }

    private void modifyRankQuestion() {
        view.modifyRankQuestion();
    }

    private void modifyEssayQuestion() {
        view.modifyEssayQuestion();
    }

    private void modifyChoiceQuestion() {
        view.modifyChoiceQuestion();
    }

    private void modifyTFQuestion() {
        view.modifyTFQuestion();
    }


    public void setAnswer(String answer) {
        question.setAnswer(answer);
    }

    public void changeItemNumber(int num) {
        if (question instanceof ItemQuestion) {
            if (((ItemQuestion) question).getItem().size() > num){//Caution: can only decrease!
                ((ItemQuestion) question).changeItemNumber(num);
            } else {
                view.warn("We don't have this item");
            }
        } else {
            view.warn("Wrong type of question!");
        }
    }

    public void setItem(String item) {
        if (question instanceof ItemQuestion) {
            ((ItemQuestion) question).setItem(item);
        } else {
            view.warn("Wrong type of question!");
        }
    }

    public void remove(int index) {
        if (question instanceof ItemQuestion) {
            if (((ItemQuestion) question).getItem().size() > index) {
                ((ItemQuestion) question).remove(index);
            } else {
                view.warn("We don't have this item");
            }
        } else if (question.getType() == Question.MAP){
            if (((MapQuestion) question).getItem().size() > index) {
                ((MapQuestion) question).remove(index);
            } else {
                view.warn("We don't have this item");
            }
        } else {
            view.warn("Wrong type of question!");
        }
    }

    public void changeItem(int index, String item) {
        if (question.getType() == Question.MAP) {
            if (((MapQuestion) question).getItem().size() > index) {
                ((MapQuestion) question).changeItem(index, item);
            } else {
                view.warn("We don't have this item");
            }
        } else if (question instanceof ItemQuestion) {
            if (((ItemQuestion) question).getItem().size() > index) {
                ((ItemQuestion) question).changeItem(index, item);
            } else {
                view.warn("We don't have this item");
            }
        } else {
            view.warn("Wrong type of question!");
        }
    }

    public void setSide(int i) {
        if (question.getType() == Question.MAP)
            ((MapQuestion) question).setSide(i);
        else
            view.warn("Wrong type of question!");
    }

    private List<String> getPageName(int type) {
        return pageNameList[type];
    }

    public List<String> displayPage(int index, int type) {
        LinkedList ret = new LinkedList();
        if(this.pageNameList[type].size() <= index) {
            return ret;
        } else {
            this.page = this.io.readPage(this.pageNameList[type].get(index));
            Question q;
            String answer;
            for(Iterator questions = this.page.iterator(); questions.hasNext(); ret.add(q.getQuestion() + answer + "\n")) {
                q = (Question)questions.next();
                int ty = q.getType();
                answer = "";
                if(type == Page.TEST && ty != Question.ESSAY) {
                    answer = "\nThe correct answer is " + q.getAnswer().writeAnswer();
                }
            }
            return ret;
        }
    }

    public String display(int type) {
        List<String> pageNameList = this.getPageName(type);
        String ret = "";
        for(int i=0; i<pageNameList.size(); i++){
            ret = i+": "+pageNameList.get(i);
        }
        return ret;
    }
}
