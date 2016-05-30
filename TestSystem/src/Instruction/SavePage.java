package Instruction;

/**
 * Created by mayezhou on 16/5/29.
 */
public class SavePage extends MenuOrder {
    private MenuOperation o;
    private int pageType;

    public SavePage(int pageType, MenuOperation o) {
        this.o = o;
        this.pageType = pageType;
    }

    @Override
    public void execute() {
        o.save(pageType);
    }
}
