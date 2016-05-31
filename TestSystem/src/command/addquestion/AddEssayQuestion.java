package command.addquestion;

import java.util.Scanner;

import command.AddQuestion;
import receiver.QuestionCreator;

public class AddEssayQuestion extends AddQuestion {
	private QuestionCreator creator;

	public AddEssayQuestion(QuestionCreator creator) {
		this.creator = creator;
		this.page = creator.getPage();
	}

	@Override
	public void execute() {
		System.out.println("Enter the prompt for you essay question:");
		Scanner scan = new Scanner(System.in);
		String prompt = scan.nextLine();
		creator.createEssayQuestion(prompt);

	}

}
