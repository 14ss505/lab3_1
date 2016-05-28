package Instruction;

public class CreatePage extends MenuOrder {
	private MenuOperation o;
	private int type;

	public CreatePage(int type,MenuOperation o) {
		this.type = type;
		this.o = o;
		
	}

	@Override
	public void execute() {
		o.createPage(type);
	}

}
