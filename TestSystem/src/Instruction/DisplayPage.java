package Instruction;

public class DisplayPage extends MenuOrder{
	private MenuOperation o;
	private int type;

	public DisplayPage(int type,MenuOperation o) {
		this.type = type;
		this.o = o;
		
	}

	@Override
	public void execute() {
		o.display(type);
	}
}
