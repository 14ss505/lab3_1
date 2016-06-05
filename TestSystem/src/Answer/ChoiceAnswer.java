package Answer;

import java.util.List;

public class ChoiceAnswer extends Answer {
    int[] answer;
    List<String> item;

    public ChoiceAnswer(String answer) {
        super(Answer.CHOICE);
        setAnswer(answer);
    }

    @Override
    public String getAnswer() {
        String ret = "";
        for (int i = 0; i < answer.length; i++) {
            ret += item.get(answer[i]);
        }
        return ret;
    }

    @Override
    public void setAnswer(String answer) {
        String[] answers = answer.split(" ");
        this.answer = new int[answers.length];
        for (int i = 0; i < answer.length(); i++) {
            this.answer[i] = Integer.parseInt(answers[i]);
        }
    }

    @Override
    public String writeAnswer() {//must invoke setAnswer first
        String ret = "";
        for (int i = 0; i < answer.length; i++) {
            ret += answer[i] + " ";
        }
        return ret;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

}
