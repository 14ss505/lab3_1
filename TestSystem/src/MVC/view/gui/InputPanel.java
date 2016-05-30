import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;

import javax.swing.*;


class InputTFPanel extends CreatePanel {
    JTextField jtaQ = new JTextField(20);

    public InputTFPanel(boolean isTest) {
        super(isTest);
        addComponent();
    }

    void addComponent() {
        add(new JPanel());
        add(new JLabel("Enter Question:"));
        add(jtaQ);
        if (isTest) {
            add(new JPanel());
            add(new JPanel());
            JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");
            add(jrbYes);
            add(jrbNo);
            ButtonGroup bg = new ButtonGroup();
            bg.add(jrbNo);
            bg.add(jrbYes);
        }
        for (int i = 0; i < 28; i++) {
            add(new JPanel());
        }
        add(jtaAdd);
        updateUI();
    }
}

class InputSAPanel extends CreatePanel {
    JTextField jtaQ = new JTextField(20);
    JTextField jtaA = new JTextField(20);

    public InputSAPanel(boolean isTest) {
        super(isTest);
        addComponent();
    }

    void addComponent() {
        add(new JPanel());
        add(new JLabel("Enter Question:"));
        add(jtaQ);
        if (isTest) {
            add(new JPanel());
            add(new JPanel());
            add(new JLabel("Enter Answer:"));
            add(jtaA);
        }
        for (int i = 0; i < 28; i++) {
            add(new JPanel());
        }
        add(jtaAdd);
        updateUI();
    }
}

class InputEssayPanel extends CreatePanel {
    JTextField jtaQ = new JTextField(20);
    JTextArea jtaA = new JTextArea();

    public InputEssayPanel(boolean isTest) {
        super(isTest);
        addComponent();
    }

    void addComponent() {
        add(new JPanel());
        add(new JLabel("Enter Question:"));
        add(jtaQ);
        if (isTest) {
            add(new JPanel());
            add(new JPanel());
            add(new JLabel("Enter Answer:"));
            add(jtaA);
        }
        for (int i = 0; i < 28; i++) {
            add(new JPanel());
        }
        add(jtaAdd);
        updateUI();
    }
}


class MCInputPanel extends CreatePanel {
    JTextField jtaQ = new JTextField(20);
    JTextField jtaNum = new JTextField(5);
    JLabel jlQ = new JLabel("Enter Question:");
    JLabel jlN = new JLabel("Enter number of answers:");
    ArrayList<JTextField> jtfAnss = new ArrayList<JTextField>();

    public MCInputPanel(boolean isTest) {
        super(isTest);
        addComponent();
        GridLayout layout = new GridLayout(0, 3);
        this.setLayout(layout);
    }

    @Override
    void addComponent() {
        //totallly 42 grids
        add(jlQ);
        add(jtaQ);
        add(new JPanel());
        add(jlN);
        add(jtaNum);
        add(new JPanel());
        //第三行开始，又加12行
        for (int i = 0; i < 36; i++) {
            add(new JPanel());
        }
        //add(jbtNext);

        jtaNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(jtaNum.getText());

                for (int i = 41; i >= 6; i--) {
                    remove(i);
                }
                for (int i = 0; i < num; i++) {
                    JTextField jtaA = new JTextField(10);
                    add(new JLabel("Choice" + (i + 1)));
                    add(jtaA);
                    add(new JPanel());
                    jtfAnss.add(jtaA);
                }
                if (isTest) {
                    add(new JPanel());
                    JButton jbtSetAns = new JButton("Set Answers");
                    add(jbtSetAns);
                    add(new JPanel());
                    jbtSetAns.addActionListener(new setAnsListener());
                } else {
                    add(new JPanel());
                    add(new JPanel());
                    add(new JPanel());
                }


                for (int i = 0; i < 36 - 3 * (num + 1); i++) {
                    add(new JPanel());
                }
                updateUI();//刷新界面
            }
        });
    }

    class setAnsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            for (int i = 41; i >= 6; i--) {
                remove(i);
            }
            ArrayList<JCheckBox> jtfAnss2 = new ArrayList<JCheckBox>();
            for (int i = 0; i < jtfAnss.size(); i++) {
                JCheckBox jchb = new JCheckBox();
                jchb.setText(jtfAnss.get(i).getText());
                add(jchb);
                jtfAnss2.add(jchb);
                add(new JPanel());
                add(new JPanel());

            }
            int num = jtfAnss.size();
            for (int i = 1; i < 36 - 3 * num; i++) {
                add(new JPanel());
            }
            add(jtaAdd);
            updateUI();//刷新界面
        }
    }
}

class RankInputPanel extends CreatePanel {

    JTextField jtaQ = new JTextField(20);
    JTextField jtaNum = new JTextField(5);
    JLabel jlQ = new JLabel("Enter Question:");
    JLabel jlN = new JLabel("Enter number of elements:");
    JButton jbtNext = new JButton("Next");

    public RankInputPanel(boolean isTest) {
        super(isTest);
        GridLayout layout = new GridLayout(0, 3);
        this.setLayout(layout);
    }

    @Override
    void addComponent() {
        add(jlQ);
        add(jtaQ);
        add(new JPanel());
        add(jlN);
        add(jtaNum);
        add(new JPanel());
        //第三行开始，又加12行
        for (int i = 1; i < 36; i++) {
            add(new JPanel());
        }
        add(jbtNext);
        jtaNum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(jtaNum.getText());
                ArrayList<JTextField> jtfAns = new ArrayList<JTextField>(num);
                for (int i = 6; i < 42; i++) {
                    remove(6);
                }
                for (int i = 0; i < num; i++) {
                    JTextField jtaA = new JTextField(10);
                    add(new JLabel("Rank" + (i + 1)));
                    add(jtaA);
                    add(new JPanel());
                    jtfAns.add(jtaA);
                }
                for (int i = 1; i < 36 - 3 * num; i++) {
                    add(new JPanel());
                }
                add(jbtNext);
                updateUI();
            }
        });
    }
}

class MapInputPanel extends CreatePanel {

    public MapInputPanel(boolean isTest) {
        super(isTest);
    }

    @Override
    void addComponent() {

    }
}
