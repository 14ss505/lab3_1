package command;

import Paper.Page;
import Question.Question;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public abstract class ModifyQuestion implements Command{
    protected String pageName;
    protected int index;
    protected int type;
    protected QuestionModifier modifier;
    protected String prompt;
    protected int score;
    protected String answer;

    public ModifyQuestion(String pageName,int index,int type, String prompt, int score, String answer, QuestionModifier modifier) {
        this.pageName = pageName;
        this.index = index;
        this.type = type;
        this.prompt = prompt;
        this.score = score;
        this.answer = answer;
        this.modifier = modifier;
    }

    public ModifyQuestion(String pageName,int index,int type, String prompt, QuestionModifier modifier) {
    	this.pageName = pageName;
        this.index = index;
        this.type = type;
        this.prompt = prompt;
        this.modifier = modifier;
    }

    public abstract void execute();
}
