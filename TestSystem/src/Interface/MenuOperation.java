package Interface;

import MVC.control.AddAnswerControl;
import MVC.control.AddQuestionControl;
import MVC.control.AnswerPageControl;
import MVC.control.CreatePageControl;
import MVC.control.DisplayControl;
import MVC.control.ModifyControl;
import MVC.control.SaveControl;
import MVC.model.Paper.Page;
import MVC.view.AddAnswerView;
import MVC.view.AddQuestionView;
import MVC.view.AnswerPageView;
import MVC.view.CreatePageView;
import MVC.view.DisplayView;
import MVC.view.ModifyView;
import MVC.view.SaveView;
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
