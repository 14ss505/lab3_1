package Interface;

<<<<<<< HEAD
import MVC.control.AddAnswerControl;
import MVC.control.AddQuestionControl;
import MVC.control.AnswerPageControl;
import MVC.control.CreatePageControl;
import MVC.control.DisplayControl;
import MVC.control.DisplayOutcomeControl;
import MVC.control.ModifyControl;
import MVC.control.SaveControl;
import MVC.model.Paper.Page;
import exclude.AddAnswerViewcmd;
import exclude.AddQuestionViewcmd;
import exclude.AnswerPageViewcmd;
import exclude.CreatePageViewcmd;
import exclude.DisplayOutcomeViewcmd;
import exclude.DisplayViewcmd;
import exclude.ModifyViewcmd;
import exclude.SaveViewcmd;
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
	private Page page;
	
	public void createPage(int type,String name) {
		page = PageFactory.createPage(type);
		cpcontrol = new CreatePageControl(page);
		cpcontrol.setPageName(name);
	}

	public void addQuestion(int type) {
		aqcontrol = new AddQuestionControl(page);
		aqcontrol.addQuestion(type);
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
		SaveViewcmd saveView = new SaveViewcmd();
		SaveControl control = new SaveControl(saveView);
		control.save(pageType);
	}

	public void modify(int pageType) {
		ModifyViewcmd modifyView = new ModifyViewcmd();
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
=======
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

>>>>>>> refs/heads/mmy
}
