package Instruction.modify;

import Paper.Page;
import Question.Question;

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

    public abstract void execute();
}
