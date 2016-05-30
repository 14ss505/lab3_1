package MVC;

import java.util.List;
import java.util.Scanner;

import Paper.Iterator;
import Question.Question;

public class AddAnswerView {
	private int num;
	private String personName;
	Scanner sc = new Scanner(System.in);
	private Iterator<Question> iterator;
	
	public void display() {
		System.out.println("Input your name: ");
		setPersonName(sc.nextLine());
	}

	public String displayQuestion(Iterator<Question> iterator) {
		Question question = iterator.next();
		System.out.println(question.getQuestion());
        String answer = sc.nextLine();
        return answer;
	}

	public void finishAnswer(){
		System.out.println("Ok, it's all!");
	}
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Iterator<Question> getIterator() {
		return iterator;
	}

	public void setIterator(Iterator<Question> iterator) {
		this.iterator = iterator;
	}
}
