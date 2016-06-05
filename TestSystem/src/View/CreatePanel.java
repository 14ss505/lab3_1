package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Chow on 2016/5/29.
 */
public abstract class CreatePanel extends JPanel {
    JButton jtaAdd = new JButton("Add");
    boolean isTest;

    CreatePanel(boolean isTest) {
        GridLayout layout = new GridLayout(0, 4);
        setLayout(layout);
        this.isTest = isTest;

    }

    abstract void addComponent();

}
