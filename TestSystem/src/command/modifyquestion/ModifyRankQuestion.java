package command.modifyquestion;

import Paper.Page;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyRankQuestion extends ModifyQuestion {
    private String[] items;

    public ModifyRankQuestion(String pageName,int index,int type, String prompt, int score, String answer, String[] items, QuestionModifier modifier) {
        super(pageName,index,type,prompt, score, answer, modifier);
        this.items = items;
    }

    public ModifyRankQuestion(String pageName,int index,int type, String prompt, String[] items, QuestionModifier modifier) {
        super(pageName,index,type, prompt, modifier);
        this.items = items;
    }

    @Override
    public void execute() {
        if (type == Page.SURVEY) {
            modifier.modifyRankQuestion(pageName,index,prompt, items);
        }
        else {
            modifier.modifyRankQuestion(pageName,index,prompt, items, score, answer);
        }
    }
}
