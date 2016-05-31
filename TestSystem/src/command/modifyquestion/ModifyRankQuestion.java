package command.modifyquestion;

import Paper.Page;
import Question.Question;
import command.ModifyQuestion;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyRankQuestion extends ModifyQuestion {
    private String[] items;

    public ModifyRankQuestion(Page page, Question question, String prompt, int score, String answer, String[] items) {
        super(page, question, prompt, score, answer);
        this.items = items;
    }

    public ModifyRankQuestion(Page page, Question question, String prompt, String[] items) {
        super(page, question, prompt);
        this.items = items;
    }

    @Override
    public void execute() {
        if (page.getType() == Page.SURVEY) {
            modifier.modifyRankQuestion(prompt, items);
        }
        else {
            modifier.modifyRankQuestion(prompt, items, score, answer);
        }
    }
}
