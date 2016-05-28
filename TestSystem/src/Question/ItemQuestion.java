package Question;

import java.util.LinkedList;
import java.util.List;

public abstract class ItemQuestion extends Question{
	List<String> items = new LinkedList<>();

	public ItemQuestion(int type) {
		super(type);
	}
	
	public void setItem(String item) {
		items.add(item);
	}
	public abstract List<String> getItem();
	public abstract boolean remove(int index);
	public abstract boolean changeItem(int index, String item);
	public abstract boolean changeItemNumber(int num);
}
