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
	
	public void createPage(int type) {
		page = PageFactory.createPage(type);
		cpcontrol = new CreatePageControl(page);
		cpcontrol.setPageName();
	}

	public void addQuestion() {
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
}
