package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.ArrayList;

import javax.swing.*;

import Paper.Page;
import agent.AddQuestionAgent;
import agent.CreateAgent;
import command.addquestion.AddDecideQuestion;
import command.create.CreateSurvey;
import receiver.PageCreator;
import receiver.QuestionCreator;

class TFQuestionPanel extends QuestionPanel {
	JTextField jtaQ = new JTextField(20);

	public TFQuestionPanel(boolean isTest) {
		super(isTest);
	}

	void addComponentForCreating(Page page) {
		removeAll();
		add(new JPanel());
		add(new JLabel("Enter Question:"));
		add(jtaQ);
		JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");

		if (isTest) {
			add(new JPanel());
			add(new JPanel());
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
		jtaAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String answer="";
				if(jrbYes.isSelected()){
					answer="1";
				}else{
					answer="0";
				}
				/*交互后端*/
				QuestionCreator qc=new QuestionCreator();
				AddDecideQuestion adq=new AddDecideQuestion(page,jtaQ.getText(),answer,0,qc);
				AddQuestionAgent aqa=new AddQuestionAgent();
				aqa.placeQuestion(adq);
				
			}
			
		});
		updateUI();
	}

	/* 预览题目 */
	void addComponentForDisplaying() {
		// 得到question

		String question = "i am a Q";
		removeAll();
		jtaQ.setText(question);

		add(new JPanel());
		add(new JLabel("T/F Question:"));
		add(jtaQ);

		add(new JPanel());
		add(new JPanel());
		JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");
		add(jrbYes);
		add(jrbNo);
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbNo);
		bg.add(jrbYes);

		for (int i = 0; i < 28; i++) {
			add(new JPanel());
		}
		add(jtaNext);
		updateUI();
	}

	/* 预览题目和答案 */
	void addComponentForModifying() {
		// 得到question和选择
		String question = "i am a Q";

		removeAll();
		jtaQ.setText(question);
		add(new JPanel());
		add(new JLabel("T/F Question:"));
		add(jtaQ);
		if (isTest) {
			add(new JPanel());
			add(new JPanel());
			JRadioButton jrbYes = new JRadioButton("T"), jrbNo = new JRadioButton("F");
			// here Answer
			jrbYes.setSelected(true);
			//
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

	/* 预览题目 */
	void addComponentForAnswering() {
		addComponentForDisplaying();
	}
}

class SAQuestionPanel extends QuestionPanel {
	JTextField jtaQ = new JTextField(20);
	JTextField jtaA = new JTextField(20);

	SAQuestionPanel(boolean isTest) {
		super(isTest);
		// TODO Auto-generated constructor stub
	}

	void addComponentForCreating(Page page) {
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

	@Override
	void addComponentForDisplaying() {
		// TODO Auto-generated method stub
		// get Question;
		String question = "i am Q";

		add(new JPanel());
		add(new JLabel("Short Answer Question:"));
		add(jtaQ);
		jtaQ.setText(question);
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
		// TODO Auto-generated method stub
		// get Question;Answer
		String question = "i am Q";
		String answer = "i am A";

		add(new JPanel());
		add(new JLabel("Short Answer Question:"));
		add(jtaQ);
		jtaQ.setText(question);
		jtaQ.setEditable(false);

		add(new JPanel());
		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);
		jtaA.setText(answer);
		jtaA.setEditable(false);

		for (int i = 0; i < 28; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		updateUI();

	}
}

class EssayQuestionPanel extends QuestionPanel {
	JTextField jtaQ = new JTextField(20);
	JTextArea jtaA = new JTextArea();

	EssayQuestionPanel(boolean isTest) {
		super(isTest);
		// TODO Auto-generated constructor stub
	}

	void addComponentForCreating(Page page) {
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

	@Override
	void addComponentForDisplaying() {
		// TODO Auto-generated method stub
		String question = "i am Q";

		add(new JPanel());
		add(new JLabel("Essay Question:"));
		add(jtaQ);
		jtaQ.setText(question);
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
		// TODO Auto-generated method stub
		String question = "i am Q";
		String answer = "i am A";

		add(new JPanel());
		add(new JLabel("Essay Question:"));
		add(jtaQ);
		jtaQ.setText(question);
		jtaQ.setEditable(false);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);
		jtaA.setText(answer);
		jtaA.setEditable(false);

		for (int i = 0; i < 28; i++) {
			add(new JPanel());
		}
		add(jtaAdd);
		updateUI();

	}
}

class MCQuestionPanel extends QuestionPanel {
	JTextField jtaQ = new JTextField(20);
	JTextField jtaNum = new JTextField(5);
	JLabel jlQ = new JLabel("Enter Question:");
	JLabel jlN = new JLabel("Enter number of answers:");
	ArrayList<JTextField> jtfAnss = new ArrayList<JTextField>();

	MCQuestionPanel(boolean isTest) {
		super(isTest);
		// TODO Auto-generated constructor stub
		GridLayout layout = new GridLayout(0, 3);
		this.setLayout(layout);
	}

	@Override
	void addComponentForCreating(Page page) {
		// totallly 42 grids
		add(jlQ);
		add(jtaQ);
		add(new JPanel());
		add(jlN);
		add(jtaNum);
		add(new JPanel());
		// 第三行开始，又加12行
		for (int i = 0; i < 36; i++) {
			add(new JPanel());
		}
		// add(jbtNext);

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
			updateUI();// 刷新界面
		}
	}

	@Override
	void addComponentForDisplaying() {
		// TODO Auto-generated method stub
		// totallly 42 grids
		String question = "i am Q";
		JLabel jlQ = new JLabel("Multiple Choice Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(question);
		add(new JPanel());

		// getNum
		int num = 3;
		
		//get Answers
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
		addComponentForDisplaying();
	}
}

class RankQuestionPanel extends QuestionPanel {

	JTextField jtaQ = new JTextField(20);
	JTextField jtaNum = new JTextField(5);
	JLabel jlQ = new JLabel("Enter Question:");
	JLabel jlN = new JLabel("Enter number of elements:");
	JButton jbtNext = new JButton("Next");

	RankQuestionPanel(boolean isTest) {

		// TODO Auto-generated constructor stub
		super(isTest);
		GridLayout layout = new GridLayout(0, 3);
		this.setLayout(layout);
	}

	@Override
	void addComponentForCreating(Page page) {
		add(jlQ);
		add(jtaQ);
		add(new JPanel());
		add(jlN);
		add(jtaNum);
		add(new JPanel());
		// 第三行开始，又加12行
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

	@Override
	void addComponentForDisplaying() {
		// TODO Auto-generated method stub
		// totallly 42 grids
				String question = "i am Q";
				JLabel jlQ = new JLabel("Multiple Choice Question");
				add(jlQ);
				add(jtaQ);
				jtaQ.setText(question);
				add(new JPanel());

				// getNum
				int num = 3;
				
				//get Answers
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
				updateUI();// 刷新界面
	}

	@Override
	void addComponentForModifying() {
		// TODO Auto-generated method stub
		addComponentForDisplaying();
	}
}

class MapQuestionPanel extends QuestionPanel {

	MapQuestionPanel(boolean isTest) {
		super(isTest);
		// TODO Auto-generated constructor stub
	}

	@Override
	void addComponentForCreating(Page page) {

	}

	@Override
	void addComponentForDisplaying() {
		// TODO Auto-generated method stub

	}

	@Override
	void addComponentForModifying() {
		// TODO Auto-generated method stub

	}
}
