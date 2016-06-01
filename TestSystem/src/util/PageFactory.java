package util;


import Paper.*;

/**
 * Created by mayezhou on 16/5/28.
 */
public class PageFactory {
    public static Page createPage(int type,String pageName,String personName){
        Page page = null;
        switch (type) {
            case 0:
                page = new Survey(pageName, personName);
                break;
            case 1:
                page = new Test(pageName, personName);
        }
        return page;
    }
}
