package Instruction;

import MVC.AddQuestionControl;
import MVC.AddQuestionView;
import MVC.CreatePageControl;
import MVC.CreatePageView;
import MVC.DisplayControl;
import MVC.DisplayView;
import Paper.Page;
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

	public void display(int type) {
		DisplayView dv = new DisplayView();
		DisplayControl dc = new DisplayControl(dv);
		dc.display(type);
	}

	public void save(int pageType) {
		// TODO: 16/5/29  
	}

	public void modify(int pageType) {
		// TODO: 16/5/29  
	}
}
