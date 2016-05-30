package Interface;

import MVC.control.AddAnswerControl;
import MVC.control.AddQuestionControl;
import MVC.control.AnswerPageControl;
import MVC.control.CreatePageControl;
import MVC.control.DisplayControl;
import MVC.control.DisplayOutcomeControl;
import MVC.control.ModifyControl;
import MVC.control.SaveControl;
import MVC.model.Paper.Page;
import MVC.view.AddAnswerView;
import MVC.view.AddQuestionView;
import MVC.view.AnswerPageView;
import MVC.view.CreatePageView;
import MVC.view.DisplayOutcomeView;
import MVC.view.DisplayView;
import MVC.view.ModifyView;
import MVC.view.SaveView;
import util.PageFactory;

public class MenuOperation {
	private CreatePageControl cpcontrol;
	private AddQuestionControl aqcontrol;
	private AnswerPageControl apcontrol;
	private AddAnswerControl aacontrol;
	private DisplayControl dc;
	private SaveControl control;
	private ModifyControl modifyControl;
	private DisplayOutcomeControl docontrol;

	public void createPage(int type) {
		Page page = PageFactory.createPage(type);
		cpcontrol = new CreatePageControl(page);
		cpcontrol.setPageName();
		this.addQuestion(page);
		System.out.println();
	}

	public void addQuestion(Page page) {
		aqcontrol = new AddQuestionControl(page);
		aqcontrol.addQuestion();
	}

	public void answerPage(int pageType) {
		apcontrol = new AnswerPageControl();
		apcontrol.answer(pageType);
		this.addAnswer(apcontrol.getPage());
	}

	public void addAnswer(Page page) {
		aacontrol = new AddAnswerControl(page);
		aacontrol.addAnswer();
	}

	public void display(int type) {
		dc = new DisplayControl();
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
		docontrol = new DisplayOutcomeControl();
		docontrol.displayOutcome(pageType);
	}

	public CreatePageControl getCpcontrol() {
		return cpcontrol;
	}

	public void setCpcontrol(CreatePageControl cpcontrol) {
		this.cpcontrol = cpcontrol;
	}

	public AddQuestionControl getAqcontrol() {
		return aqcontrol;
	}

	public void setAqcontrol(AddQuestionControl aqcontrol) {
		this.aqcontrol = aqcontrol;
	}

	public AnswerPageControl getApcontrol() {
		return apcontrol;
	}

	public void setApcontrol(AnswerPageControl apcontrol) {
		this.apcontrol = apcontrol;
	}

	public AddAnswerControl getAacontrol() {
		return aacontrol;
	}

	public void setAacontrol(AddAnswerControl aacontrol) {
		this.aacontrol = aacontrol;
	}

	public DisplayControl getDc() {
		return dc;
	}

	public void setDc(DisplayControl dc) {
		this.dc = dc;
	}

	public SaveControl getControl() {
		return control;
	}

	public void setControl(SaveControl control) {
		this.control = control;
	}

	public ModifyControl getModifyControl() {
		return modifyControl;
	}

	public void setModifyControl(ModifyControl modifyControl) {
		this.modifyControl = modifyControl;
	}
}
