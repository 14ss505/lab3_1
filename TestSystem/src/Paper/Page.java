package Paper;

import java.util.LinkedList;
import java.util.List;

import Question.Question;
import util.IO;

public class Page {
	public static final int SURVEY = 0;
	public static final int TEST = 1;

	protected String pageName;
	protected int type;
	protected List<Question> questionList = new LinkedList<Question>();
	private IO io = new IO();
	
	public void setPageName(String pageName){
		this.pageName = pageName;
	}
	
	public String getPageName(){
		return this.pageName;
	}
	
	public void addQuestion(Question question){
		questionList.add(question);
	}

	public void resetQuestion(int index, Question newQuestion) {
		questionList.set(index, newQuestion);
	}

	public int getQuestionIndex(Question question) {
		return questionList.indexOf(question);
	}
	
	public Question getQuestion(int index){
		if(index >= questionList.size()){
			return null;
		}else{
			return questionList.get(index);
		}
	}
	
	public List<Question> getQuestionList(){// TODO: avoid
		return questionList;
	}
	
	public int getQuestionSize(){
		return questionList.size();
	}
	
	public int getType(){
		return type;
	}
	
	public Iterator<Question> iterator(){
		return new IteratorQuestion();
	}

	public void display() {// TODO: 16/5/29 return string
		Iterator<Question> questions = this.iterator();
		while(questions.hasNext()) {
			Question q = questions.next();
			System.out.println(q.getQuestion());
			int ty = q.getType();
			if(type==TEST && ty != Question.ESSAY){
				System.out.println("The correct answer is " + q.getAnswer().writeAnswer());
			}
		}
	}
	
	class IteratorQuestion implements Iterator<Question>{
		int questionIndex;

		@Override
		public boolean hasNext() {
			if(questionList.size() > questionIndex)
				return true;
			return false;
		}

		@Override
		public Question next() {
			return questionList.get(questionIndex++);
		}
		
		
	}
	public void save(){
		io.writePage(this);
	}

	public void setType(int t) {
		// TODO Auto-generated method stub
		this.type = t;
		
	}
	
}
