package Control;

import java.util.List;

import Paper.Page;
import Paper.Test;
import util.IO;

/**
 * Created by mayezhou on 16/5/31.
 */
public class SaveControl {
    private SaveView view;
    private Page page;
    private IO io = new IO();
    private List<String>[] pageNameList;

    public SaveControl() {
    }

    public SaveControl(SaveView view, Page page) {
        this.view = view;
        this.page = page;
    }

    public SaveView getView() {
        return view;
    }

    public void setView(SaveView view) {
        this.view = view;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public void save() {
        if (page.getType() == Page.TEST) {
            Test test = (Test) page;
            test.computeScore();
        }
        io.writeInfo(pageNameList);
        io.writePage(page);
    }
}
