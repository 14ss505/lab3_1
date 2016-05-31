package command;

import Paper.Page;
import Question.Question;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public abstract class ModifyQuestion implements Command{
    protected Page page;
    protected int type;
    protected Question question;
    protected QuestionModifier modifier;
    protected String prompt;
    protected int score;
    protected String answer;

    public ModifyQuestion(Page page, Question question, String prompt, int score, String answer, QuestionModifier modifier) {
        this.page = page;
        this.type = page.getType();
        this.question = question;
        this.prompt = prompt;
        this.score = score;
        this.answer = answer;
        this.modifier = modifier;
    }

    public ModifyQuestion(Page page, Question question, String prompt, QuestionModifier modifier) {
        this.page = page;
        this.type = page.getType();
        this.question = question;
        this.prompt = prompt;
        this.modifier = modifier;
    }

    public void setPage(Page p) {
        this.page = p;
        this.type = page.getType();
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public abstract void execute();
}
