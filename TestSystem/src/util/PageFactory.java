package util;

import Paper.Page;
import Paper.Survey;
import Paper.Test;

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
