package Instruction;

public class DisplayPage extends MenuOrder{
	private MenuOperation o;
	private int pageType;

	public DisplayPage(int type,MenuOperation o) {
		this.pageType = type;
		this.o = o;
		
	}

	@Override
	public void execute() {
		o.display(pageType);
	}
}
