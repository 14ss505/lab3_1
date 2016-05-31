package Interface;

import MVC.control.*;
import MVC.view.*;
import MVC.model.Paper.Page;
import util.PageFactory;

public class MenuOperation {

	public void createPage(int type) {
		Page page = PageFactory.createPage(type);
		CreatePageView cpview = new CreatePageView();
		CreatePageControl cpcontrol = new CreatePageControl(page, cpview);
		cpcontrol.setPageName();
		this.addQuestion(page);
		System.out.println();
	}

	public void addQuestion(Page page) {
		AddQuestionView aqview = new AddQuestionView();
		AddQuestionControl aqcontrol = new AddQuestionControl(page, aqview);
		aqcontrol.addQuestion();
	}

	public void answerPage(int pageType) {
		AnswerPageView apview = new AnswerPageView();
		AnswerPageControl apcontrol = new AnswerPageControl(apview);
		apcontrol.answer(pageType);
		this.addAnswer(apcontrol.getPage());
	}

	public void addAnswer(Page page) {
		AddAnswerView aaview = new AddAnswerView();
		AddAnswerControl aacontrol = new AddAnswerControl(page, aaview);
		aacontrol.addAnswer();
	}

	public void display(int type) {
		DisplayView dv = new DisplayView();
		DisplayControl dc = new DisplayControl(dv);
		dc.display(type);
	}

	public void save(int pageType) {
		SaveView saveView = new SaveView();
		SaveControl control = new SaveControl(saveView);
		control.save(pageType);
	}

	public void modify(int pageType) {
		ModifyView modifyView = new ModifyView();
		ModifyControl modifyControl = new ModifyControl(modifyView);
		modifyControl.modify(pageType);
	}
	
	public void displayOutcome(int pageType) {
		DisplayOutcomeView doview = new DisplayOutcomeView();
		DisplayOutcomeControl docontrol = new DisplayOutcomeControl(doview);
		docontrol.displayOutcome(pageType);
	}

}
