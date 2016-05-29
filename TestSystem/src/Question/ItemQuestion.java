package Question;

import java.util.LinkedList;
import java.util.List;

public abstract class ItemQuestion extends Question {
    List<String> items = new LinkedList<>();

    public ItemQuestion(int type) {
        super(type);
    }

    public List<String> getItem() {// TODO: avoid
        return items;
    }

    public void setItem(String item) {
        items.add(item);
    }

    public boolean remove(int index) {// TODO: prerequirement, not here
        if (items.size() > index) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public boolean changeItem(int index, String item) {
        if (items.size() > index) {
            items.set(index, item);
            return true;
        }
        return false;
    }

    public boolean changeItemNumber(int num) {// TODO: prerequirement, not here
        if (items.size() > num) {//decrease
            for (int i = items.size() -1; i >= num; i--) {
                items.remove(i);
            }
            return true;
        }
        return false;
    }
}
