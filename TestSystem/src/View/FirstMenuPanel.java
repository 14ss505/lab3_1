package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.*;

import Paper.Page;
import Paper.Survey;
import Paper.Test;
import agent.CreateAgent;
import command.create.CreateSurvey;
import command.create.CreateTest;
import receiver.PageCreator;
import util.DataCommand;

public class FirstMenuPanel extends MenuPanel {

	private ZButton jbtCreate = new ZButton("Create", "1");
	private ZButton jbtDisplay = new ZButton("Choose a Page to do something", "1");

	JPanel rightPanel;
	public ArrayList<ZButton> jbtGroup = new ArrayList<ZButton>();

	public FirstMenuPanel(JPanel controlledPanel, JPanel rightPanel) {
		super(controlledPanel);
		this.rightPanel = rightPanel;
		jbtGroup.add(0, jbtCreate);
		jbtGroup.add(1, jbtDisplay);
		this.add(jbtCreate);
		this.add(jbtDisplay);

		jbtCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// make the other button disable
				for (int i = 1; i < jbtGroup.size(); i++) {
					jbtGroup.get(i).setEnabled(false);
				}
				// add register panel
				initRightCreatePanel();
			}
		});
		jbtDisplay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// make the other button disable
				for (int i = 0; i < jbtGroup.size(); i++) {
					if (i != 1)
						jbtGroup.get(i).setEnabled(false);
				}
				// add register panel
				initDisplayRightPanel();
				updateUI();
			}
		});
	}

	private void initDisplayRightPanel() {
		// add panel to show the page in the database
		rightPanel.removeAll();
		CardLayout card = new CardLayout();
		rightPanel.setLayout(card);

		JPanel registerPane = new JPanel();
		rightPanel.add("register", registerPane);
		initRegisterPanel2(registerPane);

	}

	void addRightDisplayPanel(boolean isTest, java.util.List<String> pageNames) {
		LoadPagePanel loadPagePanel = new LoadPagePanel(isTest,this, rightPanel, pageNames);
		rightPanel.add("load", loadPagePanel);

		loadPagePanel.updateUI();
		rightPanel.updateUI();
	}

	public void initRightCreatePanel() {
		rightPanel.removeAll();
		CardLayout card = new CardLayout();
		rightPanel.setLayout(card);

		JPanel registerPane = new JPanel();
		rightPanel.add("register", registerPane);
		rightPanel.add("blank", new JPanel());

		initRegisterPanel(registerPane);
	}

	void addRightCreatePanel(boolean isTest,String pageName,String personName,int type) {
		TFQuestionPanel tfPanel = new TFQuestionPanel(isTest,rightPanel);
		MCQuestionPanel mcPanel = new MCQuestionPanel(isTest,rightPanel);
		SAQuestionPanel saPanel = new SAQuestionPanel(isTest,rightPanel);
		EssayQuestionPanel essayPanel = new EssayQuestionPanel(isTest,rightPanel);
		RankQuestionPanel rankingPanel = new RankQuestionPanel(isTest,rightPanel);
		MapQuestionPanel mappingPanel = new MapQuestionPanel(isTest,rightPanel);

		// cardLayout

		tfPanel.addComponentForCreating(pageName,personName, type);
		mcPanel.addComponentForCreating(pageName,personName, type);
		saPanel.addComponentForCreating(pageName,personName, type);
		essayPanel.addComponentForCreating(pageName,personName, type);
		rankingPanel.addComponentForCreating(pageName,personName, type);
		mappingPanel.addComponentForCreating(pageName,personName, type);

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
		JLabel jlPageTitle = new JLabel("Your Page Title:");
		JTextField jtaPageTitle = new JTextField(10);
		JLabel jlTime = new JLabel("Time(unit:minute):");
		JTextField jtaTime = new JTextField(10);
		JButton jbtPre = new JButton("Preview");
		JButton jbtNex = new JButton("Next");
		registerPane.add(new JPanel());
		registerPane.add(jlName);
		registerPane.add(jtaName);
		registerPane.add(new JPanel());
		registerPane.add(new JPanel());
		registerPane.add(jlPageTitle);
		registerPane.add(jtaPageTitle);
		registerPane.add(new JPanel());
		registerPane.add(new JPanel());
		registerPane.add(jlTime);
		registerPane.add(jtaTime);
		for (int i = 0; i < 21; i++) {
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
				// choose test or survey
				if (jrbT.isSelected()) {

					/* 交互后端 */
					// receiver
					PageCreator pc = new PageCreator();
					// command
					int totalScore = 0,testMinute = 0;//@@@@需要获取totalScore,以及testMinute
					Test test = new Test(jtaPageTitle.getText(), jtaName.getText(),totalScore,testMinute);
					CreateTest cs = new CreateTest(pc, test);
					// invoker
					CreateAgent ca = new CreateAgent();
					ca.placeCreateOrder(cs);

					// add every input panel for test
					addRightCreatePanel(true,jtaPageTitle.getText(),jtaName.getText(),Page.TEST);

				} else {
					// receiver
					PageCreator pc = new PageCreator();
					// command
					Survey survey = new Survey(jtaPageTitle.getText(), jtaName.getText());
					CreateSurvey cs = new CreateSurvey(pc, survey);
					// invoker
					CreateAgent ca = new CreateAgent();
					ca.placeCreateOrder(cs);

					// add every input panel for test

					addRightCreatePanel(false,jtaPageTitle.getText(),jtaName.getText(),Page.SURVEY);
				}

			}
		});
	}

	void initRegisterPanel2(JPanel registerPane) {
		registerPane.setLayout(new GridLayout(0, 4));
		JRadioButton jrbT = new JRadioButton("Test"), jrbS = new JRadioButton("Survey");
		registerPane.add(new JPanel());
		registerPane.add(jrbT);
		registerPane.add(jrbS);
		registerPane.add(new JPanel());
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbT);
		bg.add(jrbS);

		JButton jbtPre = new JButton("Preview");
		JButton jbtNex = new JButton("Next");
		registerPane.add(new JPanel());
		registerPane.add(new JPanel());
		registerPane.add(new JPanel());

		for (int i = 0; i < 25; i++) {
			registerPane.add(new JPanel());
		}
		registerPane.add(jbtPre);
		registerPane.add(new JPanel());
		registerPane.add(new JPanel());
		registerPane.add(jbtNex);

		jbtPre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < jbtGroup.size(); i++) {
					jbtGroup.get(i).setEnabled(true);
				}
				registerPane.removeAll();
				registerPane.updateUI();
				rightPanel.removeAll();
				rightPanel.updateUI();
			}
		});

		jbtNex.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) rightPanel.getLayout();
				card.show(rightPanel, "blank");
				rightPanel.updateUI();

				// choose test or survey
				if (jrbT.isSelected()) {

					DataCommand dc = new DataCommand();

					java.util.List<String> pageNames =   dc.getAllPageName(1);
					// add every input panel for test
					addRightDisplayPanel(true, pageNames);

					// load test pages name and display in the load panel
				} else {
					DataCommand dc = new DataCommand();

					ArrayList<String> pageNames = (ArrayList<String>) dc.getAllPageName(0);

					addRightDisplayPanel(false, pageNames);

					/* 交互后端 */

				}
				card = (CardLayout) rightPanel.getLayout();
				card.show(rightPanel, "load");
				rightPanel.updateUI();

			}
		});
	}

}
