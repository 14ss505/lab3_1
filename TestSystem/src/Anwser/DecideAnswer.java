package Anwser;

public class DecideAnswer extends Answer{
	
	int anwser;

	public DecideAnswer(int type, int anwser) {
		super(Answer.DECIDE);
		this.anwser = anwser;
	}

	@Override
	public String getAnswer() {
		// TODO Auto-generated method stub
		String ret = ""+anwser;
		return ret;
	}


	@Override
	public void setAnswer(String anwser) {
		// TODO Auto-generated method stub
		this.anwser = Integer.parseInt(anwser);
	}


	@Override
	public String writeAnswer() {
		// TODO Auto-generated method stub
		return anwser+"";
	}

	@Override
	public boolean match(Answer answer) {
		return answer.writeAnswer().equals(this.writeAnswer());
	}

}
