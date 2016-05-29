package MVC.control;

import Control.IO;
import MVC.view.SaveView;
import Paper.Page;
import Paper.Test;

import java.util.List;

/**
 * Created by mayezhou on 16/5/29.
 */
public class SaveControl {
    private SaveView view;
    private Page page;
    private List<String>[] pageNameList;
    private IO io = new IO();

    public SaveControl(SaveView view) {
        this.view = view;
    }

    public void save(int type) {
        display(type);
        if (page.getType() == Page.TEST) {
            Test test = (Test) page;
            test.computeScore();
        }
        io.writeInfo(pageNameList);
        io.writePage(page);
    }

    private void display(int type) {
        view.setPageNameList(pageNameList[type]);
        view.display();
        int index = view.getNum();
        if (view.getPageNameList().size() <= index) {
            System.out.println("we do not have so many pages");
        } else {
            page = io.readPage(pageNameList[type].get(index));
            page.display();
        }
    }
}
