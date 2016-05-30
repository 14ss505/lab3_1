package Instruction;

<<<<<<< HEAD
import Interface.MenuOperation;

=======
>>>>>>> 7636a3de64ecfb6ebccdb001e0e63419a4c65aa6
/**
 * Created by mayezhou on 16/5/29.
 */
public class ModifyPage extends MenuOrder {
    private MenuOperation o;
    private int pageType;

    public ModifyPage(int pageType, MenuOperation o) {
        this.o = o;
        this.pageType = pageType;
    }

    @Override
    public void execute() {
        o.modify(pageType);
    }
}
