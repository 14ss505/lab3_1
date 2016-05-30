package MVC.view.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Interface.MenuOperation;
import MVC.model.Paper.Page;

public class FirstMenuPanel extends MenuPanel {

    private ZButton jbtCreate = new ZButton("Create", "1");
    private ZButton jbtDisplay = new ZButton("Choose", "display");

    JPanel rightPanel;
    public ArrayList<ZButton> jbtGroup = new ArrayList<ZButton>();
    MenuOperation mo = new MenuOperation();

    public FirstMenuPanel(JPanel controlledPanel, JPanel rightPanel) {
        super(controlledPanel);
        jbtGroup.add(0, jbtCreate);
        jbtGroup.add(1, jbtDisplay);
        this.rightPanel = rightPanel;
        this.add(jbtCreate);
        this.add(jbtDisplay);

        jbtCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < jbtGroup.size(); i++) {
                    jbtGroup.get(i).setEnabled(false);
                }
                initRightCreatePanel();
            }
        });
        jbtDisplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < jbtGroup.size(); i++) {
                    if(i!=1)
                    jbtGroup.get(i).setEnabled(false);
                }
                initDisplayRightPanel();


                updateUI();
            }
        });
    }

    private void initDisplayRightPanel() {
        //add panel to show the page in the database
        LoadPagePanel loadPagePanel=new LoadPagePanel(this,rightPanel);
        rightPanel.removeAll();
        rightPanel.add(loadPagePanel);
        loadPagePanel.updateUI();
        rightPanel.updateUI();
    }

    public void initRightCreatePanel() {
        CardLayout card = new CardLayout();
        rightPanel.setLayout(card);

        JPanel registerPane = new JPanel();
        rightPanel.add("register", registerPane);
        rightPanel.add("blank", new JPanel());

        initRegisterPanel(registerPane);
    }

    void addRightCreatePanel(boolean isTest) {
        InputTFPanel tfPanel = new InputTFPanel(isTest);
        MCInputPanel mcPanel = new MCInputPanel(isTest);
        InputSAPanel saPanel = new InputSAPanel(isTest);
        InputEssayPanel essayPanel = new InputEssayPanel(isTest);
        RankInputPanel rankingPanel = new RankInputPanel(isTest);
        MapInputPanel mappingPanel = new MapInputPanel(isTest);

        // cardLayout

        rightPanel.add("tf", tfPanel);
        rightPanel.add("mc", mcPanel);
        rightPanel.add("sa", saPanel);
        rightPanel.add("essay", essayPanel);
        rightPanel.add("rank", rankingPanel);
        rightPanel.add("map", mappingPanel);
    }


    void initRegisterPanel(JPanel registerPane) {
        registerPane.setLayout(new GridLayout(0, 4));
        JRadioButton jrbT = new JRadioButton("Test"), jrbS = new JRadioButton("Survey");
        registerPane.add(new JPanel());
        registerPane.add(jrbT);
        registerPane.add(jrbS);
        registerPane.add(new JPanel());
        ButtonGroup bg = new ButtonGroup();
        bg.add(jrbT);
        bg.add(jrbS);
        JLabel jlName = new JLabel("Your Name:");
        JTextField jtaName = new JTextField(10);
        JButton jbtPre = new JButton("Preview");
        JButton jbtNex = new JButton("Next");
        registerPane.add(new JPanel());
        registerPane.add(jlName);
        registerPane.add(jtaName);
        for (int i = 0; i < 29; i++) {
            registerPane.add(new JPanel());
        }
        registerPane.add(jbtPre);
        registerPane.add(new JPanel());
        registerPane.add(new JPanel());
        registerPane.add(jbtNex);

        jbtPre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 1; i < jbtGroup.size(); i++) {
                    jbtGroup.get(i).setEnabled(true);
                }
                registerPane.removeAll();
                registerPane.updateUI();
            }
        });

        jbtNex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout card = (CardLayout) rightPanel.getLayout();
                card.show(rightPanel, "blank");
                card = (CardLayout) controlledPanel.getLayout();
                card.show(controlledPanel, "2");
                rightPanel.updateUI();
                for (int i = 1; i < jbtGroup.size(); i++) {
                    jbtGroup.get(i).setEnabled(true);
                }
                //choose test or survey
                if (jrbT.isSelected()) {
                    //add every input panel for test
                    addRightCreatePanel(true);
                    mo.createPage(Page.TEST,"huhu");

                } else {
                    addRightCreatePanel(false);
                }

            }
        });
    }


}

