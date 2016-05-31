package command.modifyquestion;

import Paper.Page;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyChoiceQuestion extends ModifyQuestion {
    protected String[] items;

    public ModifyChoiceQuestion(Page page, Question question, String prompt, int score, String answer, String[] items, QuestionModifier modifier) {
        super(page, question, prompt, score, answer, modifier);
        this.items = items;
    }

    public ModifyChoiceQuestion(Page page, Question question, String prompt, String[] items, QuestionModifier modifier) {
        super(page, question, prompt, modifier);
        this.items = items;
    }

    @Override
    public void execute() {
        if (page.getType() == Page.SURVEY) {
            modifier.modifyChoiceQuestion(prompt, items);
        }
        else {
            modifier.modifyChoiceQuestion(prompt, items, score, answer);
        }
    }
}
