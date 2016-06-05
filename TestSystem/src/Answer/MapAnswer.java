package Answer;

import java.util.LinkedList;
import java.util.List;

public class MapAnswer extends Answer {
    List<String> side1;
    List<String> side2;
    List<Integer> map ;

    public MapAnswer(int[][] answerPair) {
        super(Answer.MAP);
        map = new LinkedList<Integer>();
        setAnswer(answerPair);
        side1 = new LinkedList<>();
        side2 = new LinkedList<>();
    }

    public String[] getAnswer() {//get correct answer
        String[] ret = new String[map.size()];;
        for (int i = 0; i < map.size(); i++) {
            ret[i]= "< " + side1.get(i) + ", " + side2.get(map.get(i)) + ">";
        }
        return ret;
    }
    

    public int[][] getAnswerPair() {//get correct answer
    	int[][] answerPair = new int[map.size()][2];
		for(int i=0;i<map.size();i++){
			answerPair[i][0]=i;
			answerPair[i][1]=map.get(i);
			System.out.println("left"+i+":"+answerPair[i][0]);
			System.out.println("right"+i+":"+answerPair[i][1]);
		}
		return answerPair;
    }

    public void setAnswer(int[][] answerPair) {//reset
    	map.clear();
        for (int i = 0; i <answerPair.length; i++) {
        	System.out.println(answerPair[i][0]+" :::"+answerPair[i][1]);
            map.add(answerPair[i][0],answerPair[i][1]);
            System.out.println("map"+i+":::"+map.get(i));
        }
    }

    public void setQuestion(List<String> side1, List<String> side2) {
        this.side1 = side1;
        this.side2 = side2;
    }


    @Override
    public String writeAnswer() {
        String ret = "";
        System.out.println("map size:::"+ map.size());
        for (int i = 0; i < map.size()-1; i++) {
            ret += map.get(i) + " ";
        }
        if(map.size()>0)
        	ret+=map.get(map.size()-1);
        System.out.println("map write answer"+ret);
        return ret;
    }

}
