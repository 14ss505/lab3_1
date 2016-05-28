package Instruction;

import java.util.Scanner;

public class AddRankQuestion extends AddQuestion {
	private QuestionCreator creator;

	public AddRankQuestion(QuestionCreator creator) {
		this.creator = creator;
		this.page = creator.getPage();
	}
	@Override
	public void execute() {
		System.out.println("Enter the prompt for you rank question:");
        Scanner scan = new Scanner(System.in);
        String prompt = scan.nextLine();
        System.out.println("Please enter your choice number");
        int number = scan.nextInt();
        String[] items = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter your choice " + i);
            items[i] = scan.nextLine();
        }
        if (type == 1) {
            System.out.println("Please enter you anwser:\n");
            String answer = scan.nextLine();
            System.out.println("Please enter your score\n");
            int score = scan.nextInt();
            creator.createRankQuestion(prompt, items, score, answer);
            return;
        }
        creator.createRankQuestion(prompt, items);

	}

}
