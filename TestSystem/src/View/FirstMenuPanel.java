package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Paper.Page;
import agent.CreateAgent;
import command.create.CreateSurvey;
import command.create.CreateTest;
import receiver.PageCreator;

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

	void addRightDisplayPanel(boolean isTest) {
		LoadPagePanel loadPagePanel = new LoadPagePanel(this, rightPanel);
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

	void addRightCreatePanel(boolean isTest,Page page) {
		TFQuestionPanel tfPanel = new TFQuestionPanel(isTest);
		MCQuestionPanel mcPanel = new MCQuestionPanel(isTest);
		SAQuestionPanel saPanel = new SAQuestionPanel(isTest);
		EssayQuestionPanel essayPanel = new EssayQuestionPanel(isTest);
		RankQuestionPanel rankingPanel = new RankQuestionPanel(isTest);
		MapQuestionPanel mappingPanel = new MapQuestionPanel(isTest);

		// cardLayout

		tfPanel.addComponentForCreating(page);
		mcPanel.addComponentForCreating(page);
		saPanel.addComponentForCreating(page);
		essayPanel.addComponentForCreating(page);
		rankingPanel.addComponentForCreating(page);
		mappingPanel.addComponentForCreating(page);
		
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
		JButton jbtPre = new JButton("Preview");
		JButton jbtNex = new JButton("Next");
		registerPane.add(new JPanel());
		registerPane.add(jlName);
		registerPane.add(jtaName);
		registerPane.add(new JPanel());
		registerPane.add(new JPanel());
		registerPane.add(jlPageTitle);
		registerPane.add(jtaPageTitle);
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
					

					/*交互后端*/
					//receiver
					PageCreator pc=new PageCreator();
					//command
					CreateTest cs=new CreateTest(pc,jtaPageTitle.getText(),jtaName.getText());
					//invoker
					CreateAgent ca=new CreateAgent();
					ca.placeCreateOrder(cs);
					Page page=cs.getPage();
					
					// add every input panel for test
					addRightCreatePanel(true,page);

				} else {
					//receiver
					PageCreator pc=new PageCreator();
					//command
					CreateSurvey cs=new CreateSurvey(pc,jtaPageTitle.getText(),jtaName.getText());
					//invoker
					CreateAgent ca=new CreateAgent();
					ca.placeCreateOrder(cs);
					Page page=cs.getPage();
					
					// add every input panel for test
				 
					addRightCreatePanel(false,page);
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
					// add every input panel for test
					addRightDisplayPanel(true);
					
					
					
                //load test pages name and display in the load panel
				} else {
					addRightDisplayPanel(false);
					
					/*交互后端*/
					
				}
				card = (CardLayout) rightPanel.getLayout();
				card.show(rightPanel, "load");
				rightPanel.updateUI();

			}
		});
	}

}
