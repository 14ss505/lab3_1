package Instruction;

import java.util.Scanner;

public class AddTextQuestion extends AddQuestion {

	private QuestionCreator creator;

	public AddTextQuestion(QuestionCreator creator) {
		this.creator = creator;
		this.page = creator.getPage();
	}

	@Override
	public void execute() {
		System.out.println("Enter the prompt for you text question:");
        Scanner scan = new Scanner(System.in);
        String prompt = scan.nextLine();
        if (type == 1) {
            System.out.println("Please enter you anwser:\n");
            String answer = scan.nextLine();
            System.out.println("Please enter your score\n");
            int score = scan.nextInt();
            creator.createTextQuestion(prompt, score, answer);
            return;
        }
        creator.createTextQuestion(prompt);

	}

}
