package command.addquestion;

import Paper.Page;
import command.AddQuestion;
import receiver.QuestionCreator;

import java.util.Scanner;


public class AddChoiceQuestion extends AddQuestion {

	private QuestionCreator creator;

	public AddChoiceQuestion(QuestionCreator creator) {
		this.creator = creator;
		this.page = creator.getPage();
	}

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the prompt for you Choice question:");
		String prompt = scan.nextLine();
		System.out.println("Please enter your choice number");
		int number = scan.nextInt();
		String[] items = new String[number];
		for (int i = 0; i < number; i++) {
			System.out.println("\nEnter your choice " + i);
			items[i] = scan.nextLine();
		}
		if (type == Page.TEST) {
			System.out.println("Please enter you anwser:\n");
			String answer = scan.nextLine();
			System.out.println("Please enter your score\n");
			int score = scan.nextInt();
			creator.createChoiceQuestion(prompt, items, score, answer);
			return;
		}
		creator.createChoiceQuestion(prompt, items);

	}
}
