package Instruction.modify;

import MVC.model.Paper.Page;
import MVC.model.Question.Question;

/**
 * Created by mayezhou on 16/5/29.
 */
public abstract class ModifyQuestion {
    protected Page page;
    protected Question question;

    public void setPage(Page p){
    	this.page = p;
    }
    
    public void setQuestion(Question q){
    	this.question = q;
    }

    public abstract void execute();
}
