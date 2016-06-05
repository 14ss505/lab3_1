package Answer;

import java.util.List;

public class ChoiceAnswer extends Answer {
    int[] answer;
    List<String> item;

    public ChoiceAnswer(String answer) {
        super(Answer.CHOICE);
        setAnswer(answer);
    }

    public String[] getAnswer() {
        String[] ret = new String[answer.length];
        for (int i = 0; i < answer.length; i++) {
            ret[i]= item.get(answer[i]);
        }
        return ret;
    }
    
    public int[] getBinaryAnswer() {
        int[] ret = new int[item.size()];
        for (int i = 0; i < item.size(); i++) {
            ret[i]= 0;
        }
        for (int i = 0; i < answer.length; i++) {
            ret[answer[i]]= 1;
        }
        return ret;
    }
   
   public int[] getIntAnswer() {
       return answer;
   }

   public void setAnswer(String answer) {
	   if(answer.equals("")){
		  this.setDefaultAnswer();
		   return;
	   }
        String[] answers = answer.split(" ");
        this.answer = new int[answers.length];
        for (int i = 0; i < answers.length; i++) {
        	this.answer[i] = Integer.parseInt(answers[i]);
        }
    }

   public void setDefaultAnswer(){
	    this.answer = new int[1];
		this.answer[0] = -1;
   }
   
    @Override
    public String writeAnswer() {//must invoke setAnswer first
        String ret = "";
        for (int i = 0; i < answer.length-1; i++) {
            ret += answer[i] + " ";
        }
        if(answer.length>0)
        	ret +=answer[answer.length-1];
        return ret;
    }

    public void setItem(List<String> item) {
        this.item = item;
    }

}
