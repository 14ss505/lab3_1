package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chow on 2016/5/29.
 */
public class MenuPanel extends JPanel {
    JPanel controlledPanel;

    public MenuPanel(JPanel controlledPanel) {
        this.controlledPanel = controlledPanel;
        setLayout(new GridLayout(7, 1));
    }

    protected class ZButton extends JButton {
        public ZButton(String name, String btName) {
            super(name);
            addActionListener(new BtListener(btName));
        }
    }

    private class BtListener implements ActionListener {
        String btName;

        public BtListener(String btName) {
            this.btName = btName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            CardLayout card = (CardLayout) controlledPanel.getLayout();
            card.show(controlledPanel, btName);
        }

    }

}
