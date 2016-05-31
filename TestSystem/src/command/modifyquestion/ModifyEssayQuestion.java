package command.modifyquestion;

import Paper.Page;
import Question.Question;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyEssayQuestion extends ModifyQuestion {
    public ModifyEssayQuestion(Page page, Question question, String prompt, int score, String answer, QuestionModifier modifier) {
        super(page, question, prompt, score, answer, modifier);
    }

    public ModifyEssayQuestion(Page page, Question question, String prompt, QuestionModifier modifier) {
        super(page, question, prompt, modifier);
    }

    @Override
    public void execute() {
        if (page.getType() == Page.SURVEY) {
            modifier.modifyEssayQuestion(prompt);
        }
        else {
            modifier.modifyEssayQuestion(prompt, score, answer);
        }
    }
}
