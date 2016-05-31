package Question;

import Answer.Answer;

import java.util.ArrayList;


public abstract class Question {
    public static final int DECIDE = 0;
    public static final int CHOICE = 1;
    public static final int SHORTESSAY = 2;
    public static final int ESSAY = 3;
    public static final int RANK = 4;
    public static final int MAP = 5;

    protected String prompt;
    protected int score;
    protected int type;
    protected Answer answer;
    protected boolean isGradable;
//    protected ArrayList<ModifyObserver> modifyObservers = new ArrayList<>();

    public Question(int type) {
        this.type = type;
    }
/*
    public void registerObserver(ModifyObserver o) {
        modifyObservers.add(o);
    }

    public void notifyModifyObservers() {
        for (ModifyObserver o :
                modifyObservers) {
            o.accomplishedModify();
        }
    }

    public void removeObserver(ModifyObserver o) {
        try {
            modifyObservers.remove(o);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
*/
    public int getType() {
        return type;
    }

    public String getQuestion() {// TODO: why not abstract
        return null;
    }

    public String getPrompt() {
        return prompt;
    }

    public boolean IsGradable(){
    	return isGradable;
    }

    public void setIsGradable(boolean isGradable){
    	this.isGradable=isGradable;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer.setAnswer(answer);
    }

    public boolean match(Answer answer) {
        return this.answer.match(answer);
    }
}
