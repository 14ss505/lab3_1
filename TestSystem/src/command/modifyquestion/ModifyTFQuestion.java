package command.modifyquestion;

import Paper.Page;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyTFQuestion extends ModifyQuestion {

    public ModifyTFQuestion(Page page, Question question, String prompt, int score, String answer) {
        super(page, question, prompt, score, answer);
    }

    public ModifyTFQuestion(Page page, Question question, String prompt) {
        super(page, question, prompt);
    }

    @Override
    public void execute() {
        if (page.getType() == Page.SURVEY) {
            modifier.modifyTFQuestion(prompt);
        }
        else {
            modifier.modifyTFQuestion(prompt, score, answer);
        }
    }
}
