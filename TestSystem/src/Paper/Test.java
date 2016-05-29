package Paper;

import Question.Question;

public class Test extends Page {
	int totalScore;

	public Test(int totalScore) {
		type = TEST;
		this.totalScore = totalScore;
	}

	public Test() {
		type = TEST;
	}

	public void setTotalScore(int score){
		totalScore = score;
	}
	
	public int getTotalScore() {
		return totalScore;
	}
	
	public void computeScore(){
		totalScore = 0;
		for(int i=0; i<questionList.size(); i++){
			Question question = questionList.get(i);
			totalScore += question.getScore();
		}
	}
}
