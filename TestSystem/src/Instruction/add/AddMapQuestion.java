package Instruction.add;

import java.util.Scanner;

public class AddMapQuestion extends AddQuestion {
	private QuestionCreator creator;

	public AddMapQuestion(QuestionCreator creator) {
		this.creator = creator;
		this.page = creator.getPage();
	}

	@Override
	public void execute() {
		System.out.println("Enter the prompt for you map question:");
        Scanner scan = new Scanner(System.in);
        String prompt = scan.nextLine();
        System.out.println("Please enter your left side choice number");
        int number = scan.nextInt();
        String[] side1 = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter your choice " + i);
            side1[i] = scan.nextLine();
        }
        System.out.println("Please enter your right side choice number");
        number = scan.nextInt();
        String[] side2 = new String[number];
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter your choice " + i);
            side2[i] = scan.nextLine();
        }
        if (type == 1) {
            System.out.println("Please enter you anwser:\n");
            String answer = scan.nextLine();
            System.out.println("Please enter your score\n");
            int score = scan.nextInt();
            creator.createMapQuestion(prompt, side1, side2, score, answer);
            return;
        }
        creator.createMapQuestion(prompt, side1, side2);

	}

}
