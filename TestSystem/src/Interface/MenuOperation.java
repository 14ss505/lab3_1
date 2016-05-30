package Interface;

import MVC.control.*;
import MVC.view.*;
import MVC.AddAnswerControl;
import MVC.AddAnswerView;
import MVC.AddQuestionControl;
import MVC.AddQuestionView;
import MVC.AnswerPageControl;
import MVC.AnswerPageView;
import MVC.CreatePageControl;
import MVC.CreatePageView;
import MVC.DisplayControl;
import MVC.DisplayOutcomeControl;
import MVC.DisplayOutcomeView;
import MVC.DisplayView;
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

	public void answerPage(int pageType) {
		AnswerPageView apview = new AnswerPageView();
		AnswerPageControl apcontrol = new AnswerPageControl(apview);
		apcontrol.answer(pageType);
		this.addQuestion(apcontrol.getPage());
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
}
