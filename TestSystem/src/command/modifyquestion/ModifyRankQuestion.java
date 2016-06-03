package command.modifyquestion;

import Paper.Page;
import Question.Question;
import Question.RankQuestion;
import command.ModifyQuestion;
import receiver.QuestionModifier;

/**
 * Created by mayezhou on 16/5/31.
 */
public class ModifyRankQuestion extends ModifyQuestion {
  
    public ModifyRankQuestion(Page page, RankQuestion question, int index, QuestionModifier modifier) {
        super(page, question, index, modifier);
    }

    @Override
    public void execute() {
       modifier.modifyRankQuestion(page, (RankQuestion)question, index);
    }
}
