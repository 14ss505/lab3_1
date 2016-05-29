package Instruction.modify;

import Paper.Page;
import Question.Question;
import Question.ItemQuestion;
import Question.MapQuestion;

/**
 * Created by mayezhou on 16/5/29.
 */
public abstract class ModifyQuestion {
    protected Page page;
    protected Question question;

    public ModifyQuestion(Page page, int index) {
        this.page = page;
        question = getQuestion(index);
    }

    public void setPrompt(String prompt) {
        question.setPrompt(prompt);
    }

    public void setAnswer(String answer){
        question.setAnswer(answer);
    }

    public Question getQuestion(int index) {
        if (index >= page.getQuestionList().size()) {
            System.out.println("Index out of bound!");
            return null;
        } else {
            return page.getQuestion(index);
        }
    }

    public boolean changeItemNumber(int num){
        if(question.getType() == Question.MAP){
            return ((MapQuestion)question).changeItemNumber(num);
        }
        return ((ItemQuestion)question).changeItemNumber(num);
    }

    public void setItem(String item){// TODO: control
        ((ItemQuestion)question).setItem(item);
    }

    public boolean remove(int index){
        if(question.getType() == Question.MAP){
            return ((MapQuestion)question).remove(index);
        }
        return ((ItemQuestion)question).remove(index);
    }

    public boolean changeItem(int index, String item){
        if(question.getType() == Question.MAP){
            return ((MapQuestion)question).changeItem(index, item);
        }
        return ((ItemQuestion)question).changeItem(index, item);
    }


    public abstract void execute();
}
