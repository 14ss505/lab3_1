package MVC.view;

import java.util.Scanner;

import MVC.control.AddAnswerControl;
import MVC.model.Paper.Iterator;
import MVC.model.Question.Question;

public class AddAnswerView {
	private int num;
	private String personName;
	Scanner sc = new Scanner(System.in);
	private Iterator<Question> iterator;
	private AddAnswerControl aac;
	
	public AddAnswerView(AddAnswerControl aac){
		this.aac = aac;
	}
	
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
