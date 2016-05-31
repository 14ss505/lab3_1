package MVC.model.Question;

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
        notifyModifyObservers();
    }

    public void remove(int index) {
        items.remove(index);
        notifyModifyObservers();
    }

    public boolean changeItem(int index, String item) {
        if (items.size() > index) {
            items.set(index, item);
            return true;
        }
        return false;
    }

    public void changeItemNumber(int num) {
        for (int i = items.size() - 1; i >= num; i--) {
            items.remove(i);
        }
        notifyModifyObservers();
    }

}
