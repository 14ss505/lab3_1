package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;

import javax.swing.*;

import Answer.DecideAnswer;
import Answer.ShortEssayAnswer;
import Paper.Page;
import Question.DecideQuestion;
import Question.Question;
import Question.ShortEssayQuestion;
import agent.AddQuestionAgent;
import agent.CreateAgent;
import agent.ModifyQuestionAgent;
import command.addquestion.AddChoiceQuestion;
import command.addquestion.AddDecideQuestion;
import command.addquestion.AddShortEssayQuestion;
import command.create.CreateSurvey;
import command.modifyquestion.ModifyDecideQuestion;
import receiver.PageCreator;
import receiver.QuestionCreator;
import receiver.QuestionModifier;

class TFQuestionPanel extends QuestionPanel {
	TFQuestionPanel(boolean isTest, JPanel outter) {
		super(isTest, outter);
		// TODO Auto-generated constructor stub
	}

	JTextField jtaQ = new JTextField(20);
	JTextField jtaS = new JTextField(20);
	JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");
	
	void addComponentForCreating(Page page) {
		this.page = page;
		removeAll();
		add(new JPanel());
		add(new JLabel("Enter Question:"));
		add(jtaQ);
		add(new JPanel());
		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);

		if (isTest) {
			add(new JPanel());
			add(new JPanel());
			add(jrbYes);
			add(jrbNo);
			ButtonGroup bg = new ButtonGroup();
			bg.add(jrbNo);
			bg.add(jrbYes);
		}
		for (int i = 0; i < 24; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		String answer = "";
		if (jrbYes.isSelected()) {
			answer = "1";
		} else {
			answer = "0";
		}

		jtaAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String answer = "";//@@@不能为空
				if (jrbYes.isSelected()) {
					answer = "1";
				} else {
					answer = "0";
				}
				/* 交互后端 */
				QuestionCreator qc = new QuestionCreator();
				
				DecideAnswer decideAnswer = new DecideAnswer(answer);//@@@@统一一下answer 的string格式
				DecideQuestion question = new DecideQuestion(jtaQ.getText(),decideAnswer,Integer.parseInt(jtaS.getText()));
				AddDecideQuestion adq = new AddDecideQuestion(page,question, qc);
				
				AddQuestionAgent aqa = new AddQuestionAgent();
				aqa.placeQuestion(adq);
				JOptionPane.showMessageDialog(null, "successful", "Add", JOptionPane.INFORMATION_MESSAGE);
				// outter.removeAll();
				CardLayout card = (CardLayout) outter.getLayout();
				card.show(outter, "blank");
				// 清空
				{
					jtaQ.setText("");
					jtaS.setText("");
					jrbYes.setSelected(false);
					jrbNo.setSelected(false);
					updateUI();
				}
			}

		});
		updateUI();
	}

	/* 预览题目 */
	void addComponentForDisplaying(Question question, int index) {
		// 得到question
		question = (DecideQuestion) question;
		String q = question.getPrompt();
		removeAll();
		jtaQ.setText(q);

		add(new JPanel());
		add(new JLabel((index + 1) + ". T/F Question:"));
		add(jtaQ);

		add(new JPanel());
		add(new JPanel());
		JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");
		add(jrbYes);
		add(jrbNo);
		String answer = question.getAnswer().getAnswer();

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbNo);
		bg.add(jrbYes);

		for (int i = 0; i < 25; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(new JPanel());
		add(new JPanel());
		add(jtaNext);
		updateUI();
	}

	/* 预览题目和答案 */
	void addComponentForModifying(Page page, Question question, int index) {
		// 得到question answer
		question = (DecideQuestion) question;
		String q = question.getPrompt();
		String a = question.getAnswer().getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);

		add(new JPanel());
		add(new JLabel((index + 1) + ". T/F Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());

		add(new JPanel());
		JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");
		add(jrbYes);
		add(jrbNo);
		add(new JPanel());

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbNo);
		bg.add(jrbYes);
		if (a.equals("1")) {
			jrbYes.setSelected(true);
		} else {
			jrbNo.setSelected(true);
		}
		jrbYes.setEnabled(false);
		jrbNo.setEnabled(false);

		for (int i = 0; i < 24; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(jtaModify);
		add(jtaSave);
		jtaSave.setEnabled(false);
		add(jtaNext);
		jtaModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtaQ.setEditable(true);
				jtaS.setEditable(true);
				jrbYes.setEnabled(true);
				jrbNo.setEnabled(true);
				jtaNext.setEnabled(false);
				jtaPre.setEnabled(false);
				jtaModify.setEnabled(false);
			}

		});
		jtaSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QuestionModifier receiver = new QuestionModifier();
				
				int question_index = 0;//@@@@获取修改题目的index
				DecideAnswer decideAnswer = new DecideAnswer(String.valueOf(jrbYes.isSelected()));//@@@@统一一下answer 的string格式
				DecideQuestion question = new DecideQuestion(jtaQ.getText(),decideAnswer,Integer.parseInt(jtaS.getText()));
				ModifyDecideQuestion command = new ModifyDecideQuestion(page, question, question_index,receiver);
				ModifyQuestionAgent invoker = new ModifyQuestionAgent();
				invoker.modifyQuestionOrder(command);

				jtaQ.setEditable(false);
				jtaS.setEditable(false);
				jrbYes.setEnabled(false);
				jrbNo.setEnabled(false);
				jtaSave.setEnabled(false);
				jtaNext.setEnabled(true);
				jtaPre.setEnabled(true);
				jtaModify.setEnabled(true);
			}

		});
		updateUI();

	}

	/* 预览题目 */
	void addComponentForAnswering(Question question, int index) {
		// addComponentForDisplaying();
		// 得到question
		question = (DecideQuestion) question;
		String q = question.getPrompt();
		removeAll();
		jtaQ.setText(q);

		add(new JPanel());
		add(new JLabel((index + 1) + ". T/F Question:"));
		add(jtaQ);

		add(new JPanel());
		add(new JPanel());
		JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");
		jrbYes.setSelected(false);
		jrbYes.setSelected(false);
		add(jrbYes);
		add(jrbNo);

		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbNo);
		bg.add(jrbYes);

		for (int i = 0; i < 25; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(jtaSubmit);
		add(new JPanel());
		add(jtaNext);
		updateUI();
	}

	@Override
	void addComponentForModifying() {
		// TODO Auto-generated method stub

	}

}

class SAQuestionPanel extends QuestionPanel {
	SAQuestionPanel(boolean isTest, JPanel outter) {
		super(isTest, outter);
		// TODO Auto-generated constructor stub
	}

	JTextField jtaQ = new JTextField(20);
	JTextField jtaA = new JTextField(20);
	JTextField jtaS = new JTextField(20);

	void addComponentForCreating(Page page) {
		this.page = page;
		removeAll();
		add(new JPanel());
		add(new JLabel("Enter Question:"));
		add(jtaQ);

		add(new JPanel());
		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		if (isTest) {
			add(new JPanel());
			add(new JPanel());
			add(new JLabel("Enter Answer:"));
			add(jtaA);
		}
		for (int i = 0; i < 24; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		jtaAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				

				/* 交互后端 */
				QuestionCreator qc = new QuestionCreator();
				
				ShortEssayAnswer answer = new ShortEssayAnswer(jtaA.getText());//@@@@统一一下answer 的string格式
				ShortEssayQuestion question = new ShortEssayQuestion(jtaQ.getText(), answer,
						Integer.parseInt(jtaS.getText()));
				AddShortEssayQuestion adq = new AddShortEssayQuestion(page, question, qc);
				
				AddQuestionAgent aqa = new AddQuestionAgent();
				aqa.placeQuestion(adq);

				JOptionPane.showMessageDialog(null, "successful", "Add", JOptionPane.INFORMATION_MESSAGE);
				// outter.removeAll();
				CardLayout card = (CardLayout) outter.getLayout();
				card.show(outter, "blank");
				// 清空
				{
					jtaQ.setText("");
					jtaS.setText("");
					jtaA.setText("");
					updateUI();
				}
			}

		});
		updateUI();
	}

	@Override
	void addComponentForDisplaying(Question question) {
		// TODO Auto-generated method stub
		// get Question;
		String q = question.getPrompt();

		add(new JPanel());
		add(new JLabel("Short Answer Question:"));
		add(jtaQ);
		jtaQ.setText(q);
		jtaQ.setEditable(false);

		add(new JPanel());
		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);

		for (int i = 0; i < 28; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		updateUI();

	}

	/* 预览题目和答案 */
	void addComponentForModifying(String pageName, String personName, int type, Question question) {

		addComponentForCreating(pageName, personName, type);
		jtaAdd.setText("Save");
		 

		;
		// jtaAdd.addActionListener((l = new AddSAListener(pageName, personName,
		// type, jtaQ.getText(), jtaA.getText(),
		// Integer.parseInt(jtaS.getText()))));
		jtaQ.setText(question.getPrompt());

	}

	@Override
	void addComponentForModifying() {
		// TODO Auto-generated method stub

	}
}

class EssayQuestionPanel extends QuestionPanel {
	EssayQuestionPanel(boolean isTest, JPanel outter) {
		super(isTest, outter);
		// TODO Auto-generated constructor stub
	}

	JTextField jtaQ = new JTextField(20);
	JTextArea jtaA = new JTextArea();
	ActionListener l;
	JTextField jtaS = new JTextField(20);
	Question question;

	void addComponentForCreating(String pageName, String personName, int type) {
		this.pageName=pageName;
		this.personName=personName;
		this.type=type;
		removeAll();
		add(new JPanel());
		add(new JLabel("Enter Question:"));
		add(jtaQ);

		add(new JPanel());
		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		if (isTest) {
			add(new JPanel());
			add(new JPanel());
			add(new JLabel("Enter Answer:"));
			add(new JScrollPane(jtaA));
		}
		for (int i = 0; i < 24; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		// jtaAdd.addActionListener(new AddSAListener(pageName, PersonName,
		// type, jtaQ.getText(), jtaA.getText(),
		// Integer.parseInt(jtaS.getText())));
		jtaAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				/* 交互后端 */
				QuestionCreator qc = new QuestionCreator();
				AddTextQuestion adq = new AddTextQuestion(pageName, personName, type, jtaQ.getText(), jtaA.getText(),
						Integer.parseInt(jtaS.getText()), qc);
				AddQuestionAgent aqa = new AddQuestionAgent();
				aqa.placeQuestion(adq);

				JOptionPane.showMessageDialog(null, "successful", "Add", JOptionPane.INFORMATION_MESSAGE);
				// outter.removeAll();
				CardLayout card = (CardLayout) outter.getLayout();
				card.show(outter, "blank");
				// 清空
				{
					jtaQ.setText("");
					jtaS.setText("");
					jtaA.setText("");
					updateUI();
				}
			}
		});
		updateUI();
	}

	@Override
	void addComponentForDisplaying(Question question) {
		// TODO Auto-generated method stub
		String q = question.getPrompt();

		add(new JPanel());
		add(new JLabel("Essay Question:"));
		add(jtaQ);
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);

		for (int i = 0; i < 28; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		updateUI();

	}

	@Override
	void addComponentForModifying() {

		addComponentForCreating(pageName, personName, type);
		jtaAdd.setText("Save");

		jtaAdd.removeActionListener(l);

		;
		jtaAdd.addActionListener((l = new AddSAListener(pageName, personName, type, jtaQ.getText(), jtaA.getText(),
				Integer.parseInt(jtaS.getText()))));
		jtaQ.setText(question.getPrompt());

	}
}

class MCQuestionPanel extends QuestionPanel {
	JTextField jtaQ = new JTextField(20);
	JTextField jtaNum = new JTextField(5);
	JLabel jlQ = new JLabel("Enter Question:");
	JLabel jlN = new JLabel("Enter number of answers:");
	ArrayList<JTextField> jtfAnss = new ArrayList<JTextField>();
	String[] items;
	ActionListener l;
	JLabel jtaS;

	MCQuestionPanel(boolean isTest, JPanel outter) {
		super(isTest, outter);
		// TODO Auto-generated constructor stub
		GridLayout layout = new GridLayout(0, 3);
		this.setLayout(layout);
	}

	@Override
	void addComponentForCreating(String pageName, String personName, int type) {
		this.pageName=pageName;
		this.personName=personName;
		this.type=type;
		// totallly 42 grids
		removeAll();
		add(jlQ);
		add(jtaQ);
		add(new JPanel());
		JTextField jtaS = new JTextField(20);

		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());
		add(jlN);
		add(jtaNum);
		add(new JLabel("输入后敲击回车"));
		// 第三行开始，又加12行
		for (int i = 0; i < 33; i++) {
			add(new JPanel());
		}
		// add(jbtNext);

		jtaNum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(jtaNum.getText());
				items = new String[num];
				for (int i = 41; i >= 9; i--) {
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

				for (int i = 0; i < 33 - 3 * (num + 1); i++) {
					add(new JPanel());
				}
				updateUI();// 刷新界面
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
				items[i] = jtfAnss.get(i).getText();
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
			jtaAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
					/* 交互后端 */
					QuestionCreator qc = new QuestionCreator();
					System.out.println(pageName);
					System.out.println(personName);
					System.out.println(type);
					System.out.println(jtaQ.getText());
					System.out.println(Integer.parseInt(jtaS.getText()));
					AddChoiceQuestion adq = new AddChoiceQuestion(pageName, personName, type, jtaQ.getText(), "WTF",
							Integer.parseInt(jtaS.getText()),items, qc);
					AddQuestionAgent aqa = new AddQuestionAgent();
					aqa.placeQuestion(adq);
					JOptionPane.showMessageDialog(null, "successful", "Add", JOptionPane.INFORMATION_MESSAGE);
					// outter.removeAll();
					CardLayout card = (CardLayout) outter.getLayout();
					card.show(outter, "blank");
					// 清空
					{
						jtaQ.setText("");
						jtaS.setText("");
						addComponentForCreating(pageName, pageName, num);
						
						updateUI();
					}
				}

			});	updateUI();// 刷新界面
		}
	}

	@Override
	void addComponentForDisplaying(Question question) {
		// TODO Auto-generated method stub
		// totallly 42 grids
		String q = question.getPrompt();
		JLabel jlQ = new JLabel("Multiple Choice Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(q);
		add(new JPanel());

		// getNum
		int num = 3;

		// get Answers
		ArrayList<String> jtfAnsString = new ArrayList<String>();

		ArrayList<JCheckBox> jtfAnss2 = new ArrayList<JCheckBox>();
		for (int i = 0; i < jtfAnss.size(); i++) {
			JCheckBox jchb = new JCheckBox();
			jchb.setText(jtfAnsString.get(i));
			add(jchb);
			jtfAnss2.add(jchb);
			add(new JPanel());
			add(new JPanel());

		}

		for (int i = 1; i < 36 - 3 * num; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		updateUI();// 刷新界面

	}

	@Override
	void addComponentForModifying() {
		// TODO Auto-generated method stub
		// addComponentForDisplaying(question);
		addComponentForCreating(pageName, personName, type);
		jtaAdd.setText("Save");

		jtaAdd.removeActionListener(l);

		;
		jtaAdd.addActionListener((l = new AddSAListener(pageName, personName, type, jtaQ.getText(), "233",
				Integer.parseInt(jtaS.getText()))));

	}
}

class RankQuestionPanel extends QuestionPanel {

	JTextField jtaQ = new JTextField(20);
	JTextField jtaS;
	JTextField jtaNum = new JTextField(5);
	JLabel jlQ = new JLabel("Enter Question:");
	JLabel jlN = new JLabel("Enter number of elements:");
	JButton jbtNext = new JButton("Next");
	String[] items;
	ActionListener l;

	RankQuestionPanel(boolean isTest, JPanel outter) {

		// TODO Auto-generated constructor stub
		super(isTest, outter);
		GridLayout layout = new GridLayout(0, 3);
		this.setLayout(layout);
	}

	@Override
	void addComponentForCreating(String pageName, String PersonName, int type) {
		add(jlQ);
		add(jtaQ);
		add(new JPanel());
		JTextField jtaS = new JTextField(20);

		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());
		add(jlN);
		add(jtaNum);
		add(new JPanel());
		// 第三行开始，又加12行
		for (int i = 1; i < 33; i++) {
			add(new JPanel());
		}
		add(jbtNext);
		jtaNum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int num = Integer.parseInt(jtaNum.getText());
				ArrayList<JTextField> jtfAns = new ArrayList<JTextField>(num);
				for (int i = 9; i < 42; i++) {
					remove(9);
				}
				for (int i = 0; i < num; i++) {
					JTextField jtaA = new JTextField(10);
					add(new JLabel("Rank" + (i + 1)));
					add(jtaA);
					add(new JPanel());
					jtfAns.add(jtaA);
				}
				for (int i = 1; i < 33 - 3 * num; i++) {
					add(new JPanel());
				}
				add(jbtNext);
				updateUI();
			}
		});
	}

	// @Override
	void addComponentForDisplaying(Question question) {
		// TODO Auto-generated method stub
		// totallly 42 grids
		String q = "i am Q";
		JLabel jlQ = new JLabel("Multiple Choice Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(q);
		add(new JPanel());

		// getNum
		int num = 3;

		// get Answers
		ArrayList<String> jtfAnsString = new ArrayList<String>();

		ArrayList<JCheckBox> jtfAnss2 = new ArrayList<JCheckBox>();
		for (int i = 0; i < jtfAnss2.size(); i++) {
			JCheckBox jchb = new JCheckBox();
			jchb.setText(jtfAnsString.get(i));
			add(jchb);
			jtfAnss2.add(jchb);
			add(new JPanel());
			add(new JPanel());

		}

		for (int i = 1; i < 36 - 3 * num; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		jtaAdd.addActionListener(new AddMCListener(pageName, personName, type, jtaQ.getText(), "什么鬼", score, items));
		updateUI();// 刷新界面
	}

	@Override
	void addComponentForModifying() {
		// TODO Auto-generated method stub
		// addComponentForDisplaying();
		addComponentForCreating(pageName, personName, type);
		jtaAdd.setText("Save");

		jtaAdd.removeActionListener(l);

		;
		jtaAdd.addActionListener((l = new AddMCListener(pageName, personName, type, jtaQ.getText(), "233",
				Integer.parseInt(jtaS.getText()), items)));
	}
}

class MapQuestionPanel extends QuestionPanel {

	MapQuestionPanel(boolean isTest, JPanel outter) {
		super(isTest, outter);
		// TODO Auto-generated constructor stub
	}

	@Override
	void addComponentForCreating(String pageName, String PersonName, int type) {

	}

	@Override
	void addComponentForDisplaying(Question question) {
		// TODO Auto-generated method stub

	}

	@Override
	void addComponentForModifying() {
		// TODO Auto-generated method stub

	}
}
