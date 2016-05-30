package util;

import MVC.model.Paper.Page;
import MVC.model.Paper.Survey;
import MVC.model.Paper.Test;

/**
 * Created by mayezhou on 16/5/28.
 */
public class PageFactory {
    public static Page createPage(int type){
        Page page = null;
        switch (type) {
            case 0:
                page = new Survey();
                break;
            case 1:
                page = new Test();
        }
        return page;
    }
}
