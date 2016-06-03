package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Paper.Page;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.RankQuestion;
import Question.ShortEssayQuestion;
import agent.AddQuestionAgent;
import command.addquestion.AddChoiceQuestion;
import command.addquestion.AddDecideQuestion;
import command.addquestion.AddRankQuestion;
import command.addquestion.AddShortEssayQuestion;
import receiver.QuestionCreator;

public class AddTFListener implements ActionListener {
	Page page;
	DecideQuestion question;
	
	AddTFListener(Page page,DecideQuestion question){
		this.page = page;
		this.question = question;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		QuestionCreator qc = new QuestionCreator();
		AddDecideQuestion adq = new AddDecideQuestion(page, question, qc);
		AddQuestionAgent aqa = new AddQuestionAgent();
		aqa.placeQuestion(adq);

	}

}
class AddSAListener implements ActionListener {
	Page page;
	ShortEssayQuestion question;
	
	AddSAListener(Page page,ShortEssayQuestion question){
		this.page = page;
		this.question = question;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		QuestionCreator qc = new QuestionCreator();
		AddShortEssayQuestion adq = new AddShortEssayQuestion(page, question, qc);
		AddQuestionAgent aqa = new AddQuestionAgent();
		aqa.placeQuestion(adq);

	}

}
class AddRankListener implements ActionListener {
	Page page;
	RankQuestion question;
	
	AddRankListener(Page page,RankQuestion question){
		this.page = page;
		this.question = question;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		QuestionCreator qc = new QuestionCreator();
		AddRankQuestion adq = new AddRankQuestion(page, question, qc);
		AddQuestionAgent aqa = new AddQuestionAgent();
		aqa.placeQuestion(adq);

	}

}
class AddMCListener implements ActionListener {
	Page page;
	ChoiceQuestion question;
	
	AddMCListener(Page page,ChoiceQuestion question){
		this.page = page;
		this.question = question;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		QuestionCreator qc = new QuestionCreator();
		AddChoiceQuestion adq = new AddChoiceQuestion(page, question, qc);
		AddQuestionAgent aqa = new AddQuestionAgent();
		aqa.placeQuestion(adq);

	}

}
