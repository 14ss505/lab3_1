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
        String[] answers = answer.split(" ");
        this.answer = new int[answers.length];
        System.out.println("set:choice answer array length"+answers.length);
        for (int i = 0; i < answers.length; i++) {
        	System.out.println("set:choice answer"+"序号："+i+" 内容："+answers[i]);
            this.answer[i] = Integer.parseInt(answers[i]);
        }
    }

    @Override
    public String writeAnswer() {//must invoke setAnswer first
        String ret = "";
        System.out.println("write:choice answer array length"+answer.length);
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
