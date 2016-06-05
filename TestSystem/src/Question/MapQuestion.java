package Question;

import Answer.ChoiceAnswer;
import Answer.MapAnswer;

import java.util.LinkedList;
import java.util.List;

public class MapQuestion extends Question {
    protected List<String> side1 = new LinkedList<String>();
    protected List<String> side2 = new LinkedList<String>();
    protected int side;

    public MapQuestion(String prompt, List<String> side1, List<String> side2 , MapAnswer answer, int score) {
        super(MAP);
        this.prompt = prompt; 
        this.side1 = side1;
    	this.side2 = side2;
        this.answer = answer;
        answer.setQuestion(side1, side2);
        this.setIsScore(true);
    }
    
    public MapQuestion(String prompt, List<String> side1, List<String> side2) {
        super(MAP);
        this.prompt = prompt; 
        this.side1 = side1;
    	this.side2 = side2;
        this.setIsScore(true);
    }
    
	public void setAnswer(int[][] answerPair) {
        ((MapAnswer)this.answer).setQuestion(side1, side2);
        ((MapAnswer)this.answer).setAnswer(answerPair);
	}

    @Override
    public String getQuestion() {
        String ret = "Map: " + prompt + "\n";
        for (int i = 0; i < side1.size(); i++) {
            ret += side1.get(i) + "\t" + side2.get(i) + "\n";
        }
        return ret;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public void setBothSide(List<String> side1, List<String> side2){
    	this.side1 = side1;
    	this.side2 = side2;
    }
    
    public List<String> getLeftItem() {
        return side1;
    }
    
    public List<String> getRightItem() {
       return side2;
    }

    public void setItem(String item) {
        // TODO Auto-generated method stub
        if (side == 1) {
            side1.add(item);
        } else {
            side2.add(item);
        }
    }

    public void remove(int index) {
        if (side == 1) {
            side1.remove(index);
        } else {
            side2.remove(index);
        }
    }

    public boolean changeItem(int index, String item) {
        if (side == 1) {
            if (side1.size() > index) {
                side1.remove(index);
                side1.add(index, item);
                return true;
            }
        } else {
            if (side2.size() > index) {
                side2.remove(index);
                side2.add(index, item);
                return true;
            }
        }
        return false;
    }

    public boolean changeItemNumber(int num) {
        if (side == 1) {
            if (side1.size() > num) {
                for (int i = num; i < side1.size(); i++) {
                    side1.remove(i);
                }
                return true;
            }
        } else {
            if (side2.size() > num) {
                for (int i = num; i < side2.size(); i++) {
                    side2.remove(i);
                }
            }
            return true;
        }
        return false;
    }
}
