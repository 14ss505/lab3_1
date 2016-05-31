package Instruction.add;

import java.util.Scanner;

public class AddDecideQuestion extends AddQuestion {

	private QuestionCreator creator;

	public AddDecideQuestion(QuestionCreator creator) {
		this.creator = creator;
		this.page = creator.getPage();
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("Enter the prompt for you True/False question:\n");
		Scanner scan = new Scanner(System.in);
		String prompt = scan.nextLine();
		if (page.getType() == 0) {
			System.out.println("Please enter you answer:\n");
			String answer = scan.nextLine();
			System.out.println("Please enter your score\n");
			int score = scan.nextInt();
			creator.createDecideQuestion(prompt, score, answer);
			return;
		}
		creator.createDecideQuestion(prompt);
	}

}
