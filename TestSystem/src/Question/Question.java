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
    protected boolean isScore;

    public Question(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getPrompt() {
        return prompt;
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
    
    public boolean match(Answer answer) {
        return this.answer.match(answer);
    }
    
    public abstract String getQuestion();

	public boolean isScore() {
		return isScore;
	}

	public void setIsScore(boolean isScore) {
		this.isScore = isScore;
	}
}
