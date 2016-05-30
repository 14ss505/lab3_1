package Answer;

import java.util.LinkedList;
import java.util.List;

public class MapAnswer extends Answer {
    List<String> side1;
    List<String> side2;
    List<Integer> map;

    public MapAnswer() {
        super(Answer.MAP);
        side1 = new LinkedList<>();
        side2 = new LinkedList<>();
        map = new LinkedList<>();
    }

    @Override
    public String getAnswer() {//get correct answer
        String ret = "";
        for (int i = 0; i < map.size(); i++) {
            ret += "< " + side1.get(i) + ", " + side2.get(map.get(i)) + ">\n";
        }
        return ret;
    }


    @Override
    public void setAnswer(String answer) {//reset
        String[] answers = answer.split(" ");
        map.clear();
        for (int i = 0; i < answers.length; i++) {
            map.add(Integer.parseInt(answers[i]));
        }
    }

    public void setQuestion(List<String> side1, List<String> side2) {
        this.side1 = side1;
        this.side2 = side2;
    }


    @Override
    public String writeAnswer() {
        String ret = "";
        for (int i = 0; i < map.size(); i++) {
            ret += map.get(i) + " ";
        }
        return ret;
    }

}
