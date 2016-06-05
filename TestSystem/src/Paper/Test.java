package Paper;

import Question.Question;

public class Test extends Page {
	int totalScore;
	int testMinute;

	public Test(String pageName,String personName,int totalScore,int testMinute) {
		super(pageName,personName);
		type = TEST;
		this.totalScore = totalScore;
		this.testMinute = testMinute;
	}

	/*public Test(String pageName,String personName,int testMinute) {
    	super(pageName,personName);
		type = TEST;
		this.testMinute = testMinute;
	}*/

	public void setTotalScore(int score){
		totalScore = score;
	}
	
	public int getTestMinute() {
		return testMinute;
	}
	
	public void setTestMinute(int testMinute){
		this.testMinute = testMinute;
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
