package MVC.control;

import util.IO;
import Instruction.modify.ModifyQuestion;
import Instruction.modify.*;
import Interface.QuestionModifier;
import MVC.view.ModifyView;
import MVC.model.Paper.Page;
import MVC.model.Question.Question;

import java.util.List;
import java.util.Scanner;

/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyControl {
	protected ModifyView view;
	private Page page;
	private Question question;
	private List<String>[] pageNameList;
	private IO io = new IO();

	public ModifyControl(ModifyView view,Page page,Question question) {
		this.view = view;
		this.page = page;
		this.question = question;
	}

	private int getQuestionType(int index) {
		if (index >= page.getQuestionList().size()) {
			System.out.println("Index out of bound!");
			return -1;
		} else {
			question = page.getQuestion(index);
			return question.getType();
		}
	}

	private void display(int type) {
		view.setPageNameList(pageNameList[type]);
		view.display();
		int index = view.getNum();
		if (view.getPageNameList().size() <= index) {
			System.out.println("we do not have so many pages");
		} else {
			page = io.readPage(pageNameList[type].get(index));
			page.display();
		}
	}

	public void modify(int type) {
		display(type);
		System.out.println("Please choose which question that you want to modify: ");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		int qType = getQuestionType(index);
		ModifyQuestion mq = null;
		QuestionModifier qm = new QuestionModifier();
		qm.setPage(page);
		qm.setQuestion(question);
		switch (qType) {
		case 0:
		case 2:
			mq = new ModifyTFQuestion(qm);
			break;
		case 1:
			mq = new ModifyChoiceQuestion(qm);
			break;
		case 3:
			mq = new ModifyEssayQuestion(qm);
			break;
		case 4:
			mq = new ModifyRankQuestion(qm);
			break;
		case 5:
			mq = new ModifyMapQuestion(qm);
			break;
		}
		ModifyQuestionAgent agent = new ModifyQuestionAgent();
		agent.placeQuestion(mq);
	}
}
