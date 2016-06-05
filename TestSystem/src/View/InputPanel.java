package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.*;

import Answer.ChoiceAnswer;
import Answer.DecideAnswer;
import Answer.EssayAnswer;
import Answer.MapAnswer;
import Answer.RankAnswer;
import Answer.ShortEssayAnswer;
import Paper.Page;
import Paper.Test;
import Paper.Survey;
import Question.ChoiceQuestion;
import Question.DecideQuestion;
import Question.EssayQuestion;
import Question.MapQuestion;
import Question.Question;
import Question.RankQuestion;
import Question.ShortEssayQuestion;
import agent.AddAnswerAgent;
import agent.AddQuestionAgent;
import agent.CreateAgent;
import agent.ModifyQuestionAgent;
import command.addanswer.AddChoiceAnswer;
import command.addanswer.AddDecideAnswer;
import command.addanswer.AddEssayAnswer;
import command.addanswer.AddMapAnswer;
import command.addanswer.AddRankAnswer;
import command.addanswer.AddShortEssayAnswer;
import command.addquestion.AddChoiceQuestion;
import command.addquestion.AddDecideQuestion;
import command.addquestion.AddEssayQuestion;
import command.addquestion.AddMapQuestion;
import command.addquestion.AddRankQuestion;
import command.addquestion.AddShortEssayQuestion;
import command.create.CreateSurvey;
import command.modifyquestion.ModifyChoiceQuestion;
import command.modifyquestion.ModifyDecideQuestion;
import command.modifyquestion.ModifyEssayQuestion;
import command.modifyquestion.ModifyMapQuestion;
import command.modifyquestion.ModifyRankQuestion;
import command.modifyquestion.ModifyShortEssayQuestion;
import receiver.AnswerCreator;
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

	void addComponentForCreating(final Page page) {
		// System.out.println(page.getPageName());
		// this.page = page;
		removeAll();
		add(new JPanel());
		add(new JLabel("Enter Question:"));
		add(jtaQ);

		if (isTest) {
			add(new JPanel());
			add(new JPanel());
			add(new JLabel("Enter Score:"));
			add(jtaS);

			add(new JPanel());
			add(new JPanel());
			add(jrbYes);
			add(jrbNo);
			ButtonGroup bg = new ButtonGroup();
			bg.add(jrbNo);
			bg.add(jrbYes);
		} else {

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
				String answer = "";// @@@不能为空
				if (jrbYes.isSelected()) {
					answer = "1";
				} else {
					answer = "0";
				}
				if (isTest) {
					/* 交互后端 */
					QuestionCreator qc = new QuestionCreator();

					DecideAnswer decideAnswer = new DecideAnswer(answer);// @@@@统一一下answer
																			// 的string格式
					DecideQuestion question = new DecideQuestion(jtaQ.getText(), decideAnswer,
							Integer.parseInt(jtaS.getText()));
					AddDecideQuestion adq = new AddDecideQuestion(page, question, qc);

					AddQuestionAgent aqa = new AddQuestionAgent();
					aqa.placeQuestion(adq);
				} else {
					/* 交互后端 */
					QuestionCreator qc = new QuestionCreator();

					DecideQuestion question = new DecideQuestion(jtaQ.getText());
					AddDecideQuestion adq = new AddDecideQuestion(page, question, qc);

					AddQuestionAgent aqa = new AddQuestionAgent();
					aqa.placeQuestion(adq);
				}

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

	void addComponentForDisplaying(Question question1, int index) {

		// 得到question
		DecideQuestion question = (DecideQuestion) question1;
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
		String answer = ((DecideAnswer) (question.getAnswer())).getAnswer();

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
		String a = ((DecideAnswer) (question.getAnswer())).getAnswer();
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

				DecideAnswer decideAnswer = new DecideAnswer(String.valueOf(jrbYes.isSelected()));// @@@@统一一下answer
																									// 的string格式
				DecideQuestion question = new DecideQuestion(jtaQ.getText(), decideAnswer,
						Integer.parseInt(jtaS.getText()));
				ModifyDecideQuestion command = new ModifyDecideQuestion(page, question, index, receiver);
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
	void addComponentForAnswering(Page page, Question question1, int index, String name) {
		// addComponentForDisplaying();
		// 得到question
		this.page = page;
		DecideQuestion question = (DecideQuestion) question1;
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
		jtaSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/* answer */
				AnswerCreator receiver = new AnswerCreator();
				String ans="";
				if(jrbYes.isSelected()){
					ans="1";
				}else{
					ans="0";
				}

				DecideAnswer answer = new DecideAnswer(ans);// @@@@统一一下answer
																							// 的string格式
				AddDecideAnswer command = new AddDecideAnswer(page, answer, index, receiver, name);
				AddAnswerAgent invoker = new AddAnswerAgent();
				invoker.placeAnswer(command);
			}

		});
		updateUI();
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

	void addComponentForCreating(final Page page) {
		// this.page = page;
		removeAll();
		add(new JPanel());
		add(new JLabel("Enter Question:"));
		add(jtaQ);

		if (isTest) {
			add(new JPanel());
			add(new JPanel());
			add(new JLabel("Enter Score:"));
			add(jtaS);
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

				if (isTest) {
					/* 交互后端 */
					QuestionCreator qc = new QuestionCreator();

					ShortEssayAnswer answer = new ShortEssayAnswer(jtaA.getText());// @@@@统一一下answer
																					// 的string格式
					ShortEssayQuestion question = new ShortEssayQuestion(jtaQ.getText(), answer,
							Integer.parseInt(jtaS.getText()));
					AddShortEssayQuestion adq = new AddShortEssayQuestion(page, question, qc);

					AddQuestionAgent aqa = new AddQuestionAgent();
					aqa.placeQuestion(adq);
				} else {
					/* 交互后端 */
					QuestionCreator qc = new QuestionCreator();
					ShortEssayQuestion question = new ShortEssayQuestion(jtaQ.getText());
					AddShortEssayQuestion adq = new AddShortEssayQuestion(page, question, qc);

					AddQuestionAgent aqa = new AddQuestionAgent();
					aqa.placeQuestion(adq);
				}

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
	void addComponentForDisplaying(Question question1, int index) {
		// TODO Auto-generated method stub
		// get Question;
		ShortEssayQuestion question = (ShortEssayQuestion) question1;
		String q = question.getPrompt();

		add(new JPanel());
		add(new JLabel(((index + 1) + ". Short Answer Question:")));
		add(jtaQ);
		jtaQ.setText(q);
		jtaQ.setEditable(false);

		add(new JPanel());
		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		jtaA.setText("");
		add(jtaA);

		for (int i = 0; i < 25; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(new JPanel());
		add(new JPanel());
		add(jtaNext);
		updateUI();

	}

	public void addComponentForModifying(Page page, Question question1, int index) {
		// TODO Auto-generated method stub
		ShortEssayQuestion question = (ShortEssayQuestion) question1;
		String q = question.getPrompt();
		String a = ((ShortEssayAnswer) (question.getAnswer())).getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);
		jtaA.setText(a);
		jtaA.setEditable(false);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Short Answer Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);
		add(new JPanel());

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
				jtaA.setEditable(true);

				jtaNext.setEnabled(false);
				jtaSave.setEnabled(false);
				jtaPre.setEnabled(false);
				jtaModify.setEnabled(false);
			}

		});
		jtaSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QuestionModifier receiver = new QuestionModifier();

				ShortEssayAnswer decideAnswer = new ShortEssayAnswer(jtaA.getText());// @@@@统一一下answer
																						// 的string格式
				ShortEssayQuestion question = new ShortEssayQuestion(jtaQ.getText(), decideAnswer,
						Integer.parseInt(jtaS.getText()));
				ModifyShortEssayQuestion command = new ModifyShortEssayQuestion(page, question, index, receiver);
				ModifyQuestionAgent invoker = new ModifyQuestionAgent();
				invoker.modifyQuestionOrder(command);

				jtaQ.setEditable(false);
				jtaS.setEditable(false);
				jtaA.setEditable(false);

				jtaSave.setEnabled(false);
				jtaNext.setEnabled(true);
				jtaPre.setEnabled(true);
				jtaModify.setEnabled(true);
			}

		});
		updateUI();

	}

	void addComponentForAnswering(Page page, Question question1, int index, String name) {

		ShortEssayQuestion question = (ShortEssayQuestion) question1;
		String q = question.getPrompt();
		String a = ((ShortEssayAnswer) (question.getAnswer())).getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);
		jtaA.setText(a);
		jtaA.setEditable(true);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Short Answer Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);
		add(new JPanel());

		for (int i = 0; i < 24; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(jtaSubmit);
		add(new JPanel());

		add(jtaNext);
		jtaSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/* answer */
				AnswerCreator receiver = new AnswerCreator();

				ShortEssayAnswer answer = new ShortEssayAnswer(jtaA.getText());// @@@@统一一下answer
																				// 的string格式
				AddShortEssayAnswer command = new AddShortEssayAnswer(page, answer, index, receiver, name);
				AddAnswerAgent invoker = new AddAnswerAgent();
				invoker.placeAnswer(command);
			}

		});
		updateUI();
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

	void addComponentForCreating(final Page page) {

		removeAll();
		add(new JPanel());
		add(new JLabel("Enter Question:"));
		add(jtaQ);

		if (isTest) {
			add(new JPanel());
			add(new JPanel());
			add(new JLabel("Enter Score:"));
			add(jtaS);
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
				if (isTest) {
					/* 交互后端 */
					QuestionCreator qc = new QuestionCreator();
					EssayAnswer answer = new EssayAnswer(jtaA.getText());
					EssayQuestion question = new EssayQuestion(jtaQ.getText(), answer,
							Integer.parseInt(jtaS.getText()));
					AddEssayQuestion adq = new AddEssayQuestion(page, question, qc);
					AddQuestionAgent aqa = new AddQuestionAgent();
					aqa.placeQuestion(adq);
				} else {
					/* 交互后端 */
					QuestionCreator qc = new QuestionCreator();

					EssayQuestion question = new EssayQuestion(jtaQ.getText());
					AddEssayQuestion adq = new AddEssayQuestion(page, question, qc);
					AddQuestionAgent aqa = new AddQuestionAgent();
					aqa.placeQuestion(adq);
				}

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
	void addComponentForDisplaying(Question question1, int index) {
		// TODO Auto-generated method stub
		EssayQuestion question = (EssayQuestion) question1;
		String q = question.getPrompt();
		removeAll();
		add(new JPanel());
		add(new JLabel((index + 1) + ". Essay Question:"));
		add(jtaQ);
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);

		for (int i = 0; i < 29; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(new JPanel());
		add(new JPanel());
		add(jtaNext);
		updateUI();

	}

	public void addComponentForModifying(Page page, Question question1, int index) {
		// TODO Auto-generated method stub
		EssayQuestion question = (EssayQuestion) question1;
		String q = question.getPrompt();
		String a = ((EssayAnswer) (question.getAnswer())).getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);
		jtaA.setText(a);
		jtaA.setEditable(false);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Short Answer Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);
		add(new JPanel());

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
				jtaA.setEditable(true);

				jtaNext.setEnabled(false);
				jtaSave.setEnabled(false);
				jtaPre.setEnabled(false);
				jtaModify.setEnabled(false);
			}

		});
		jtaSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				QuestionModifier receiver = new QuestionModifier();

				EssayAnswer decideAnswer = new EssayAnswer(jtaA.getText());// @@@@统一一下answer
																			// 的string格式
				EssayQuestion question = new EssayQuestion(jtaQ.getText(), decideAnswer,
						Integer.parseInt(jtaS.getText()));
				ModifyEssayQuestion command = new ModifyEssayQuestion(page, question, index, receiver);
				ModifyQuestionAgent invoker = new ModifyQuestionAgent();
				invoker.modifyQuestionOrder(command);

				jtaQ.setEditable(false);
				jtaS.setEditable(false);
				jtaA.setEditable(false);

				jtaSave.setEnabled(false);
				jtaNext.setEnabled(true);
				jtaPre.setEnabled(true);
				jtaModify.setEnabled(true);
			}

		});
		updateUI();

	}

	void addComponentForAnswering(Page page, Question question1, int index, String name) {
		// TODO Auto-generated method stub
		EssayQuestion question = (EssayQuestion) question1;
		String q = question.getPrompt();
		String a = ((EssayAnswer) (question.getAnswer())).getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);
		jtaA.setText(a);
		jtaA.setEditable(true);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Short Answer Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Answer:"));
		add(jtaA);
		add(new JPanel());

		for (int i = 0; i < 24; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(jtaSubmit);
		add(new JPanel());

		add(jtaNext);
		jtaSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/* answer */
				AnswerCreator receiver = new AnswerCreator();

				EssayAnswer answer = new EssayAnswer(jtaA.getText());// @@@@统一一下answer
																		// 的string格式
				AddEssayAnswer command = new AddEssayAnswer(page, answer, index, receiver, name);
				AddAnswerAgent invoker = new AddAnswerAgent();
				invoker.placeAnswer(command);
			}

		});
		updateUI();
	}

}

class MCQuestionPanel extends QuestionPanel {
	int index;
	JTextField jtaQ = new JTextField(20);
	JTextField jtaNum = new JTextField(5);
	JLabel jlQ = new JLabel("Enter Question:");
	JLabel jlN = new JLabel("Enter number of answers:");
	ArrayList<JTextField> jtfAnss = new ArrayList<JTextField>();
	List<String> items = new ArrayList<String>();;

	JTextField jtaS = new JTextField(20);;

	MCQuestionPanel(boolean isTest, JPanel outter) {
		super(isTest, outter);
		// TODO Auto-generated constructor stub
		GridLayout layout = new GridLayout(0, 3);
		this.setLayout(layout);
	}

	@Override
	void addComponentForCreating(Page page) {
		this.page = page;
		// totallly 42 grids
		removeAll();
		add(jlQ);
		add(jtaQ);
		add(new JPanel());
		if (isTest) {
			add(new JLabel("Enter Score:"));
			add(jtaS);
			add(new JPanel());
		} else {
			add(new JPanel());
			add(new JPanel());
			add(new JPanel());
		}

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
					JButton jbtSetAns = new JButton("Next");
					add(jbtSetAns);
					add(new JPanel());
					jbtSetAns.addActionListener(new setAnsListener());
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
			ArrayList<JCheckBox> jtfAnss2 = new ArrayList<JCheckBox>();
			if (isTest) {
				for (int i = 41; i >= 6; i--) {
					remove(i);
				}

				for (int i = 0; i < jtfAnss.size(); i++) {
					JCheckBox jchb = new JCheckBox();
					jchb.setText(jtfAnss.get(i).getText());
					items.add(jtfAnss.get(i).getText());
					add(jchb);
					jtfAnss2.add(jchb);
					add(new JPanel());
					add(new JPanel());

				}
				int num = jtfAnss.size();
				for (int i = 1; i < 36 - 3 * num; i++) {
					add(new JPanel());
				}
			}
			add(jtaAdd);
			jtaAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isTest) {
						String ans = "";
						for (int i = 0; i < jtfAnss2.size(); i++) {
							if (jtfAnss2.get(i).isSelected()) {
								ans += i;
								ans += " ";
							}
						}
						ans = ans.substring(0, ans.length() - 1);
						// System.out.println(ans);

						/* 交互后端 */
						QuestionCreator qc = new QuestionCreator();
						ChoiceAnswer answer = new ChoiceAnswer(ans);
						ChoiceQuestion question = new ChoiceQuestion(jtaQ.getText(), items, answer,
								Integer.parseInt(jtaS.getText()));
						AddChoiceQuestion adq = new AddChoiceQuestion(page, question, qc);
						AddQuestionAgent aqa = new AddQuestionAgent();
						aqa.placeQuestion(adq);
					} else {

						/* 交互后端 */
						QuestionCreator qc = new QuestionCreator();

						ChoiceQuestion question = new ChoiceQuestion(jtaQ.getText(), items);
						AddChoiceQuestion adq = new AddChoiceQuestion(page, question, qc);
						AddQuestionAgent aqa = new AddQuestionAgent();
						aqa.placeQuestion(adq);
					}

					JOptionPane.showMessageDialog(null, "successful", "Add", JOptionPane.INFORMATION_MESSAGE);
					// outter.removeAll();
					CardLayout card = (CardLayout) outter.getLayout();
					card.show(outter, "blank");
					// 清空
					{
						jtaQ.setText("");
						jtaS.setText("");
						addComponentForCreating(page);

						updateUI();
					}
				}

			});
			updateUI();// 刷新界面
		}
	}

	@Override
	void addComponentForDisplaying(Question question1, int index) {
		// TODO Auto-generated method stub
		// totallly 42 grids
		ChoiceQuestion question = ((ChoiceQuestion) question1);
		String q = question.getPrompt();
		JLabel jlQ = new JLabel((index + 1) + ". Multiple Choice Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(q);
		add(new JPanel());

		List<String> items = (List<String>) question.getItem();
		int num = items.size();

		for (int i = 0; i < items.size(); i++) {
			JCheckBox jchb = new JCheckBox();
			jchb.setText(items.get(i));
			add(jchb);

			add(new JPanel());
			add(new JPanel());

		}

		for (int i = 1; i < 36 - 3 * num; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(new JPanel());
		add(new JPanel());
		add(jtaNext);
		updateUI();// 刷新界面

	}

	public void addComponentForModifying(Page page, Question question1, int index) {
		this.index = index;
		this.page = page;
		// TODO Auto-generated method stub
		GridLayout layout = new GridLayout(0, 4);
		this.setLayout(layout);
		ChoiceQuestion question = (ChoiceQuestion) question1;
		String q = question.getPrompt();
		List<String> item = question.getItem();
		int[] selected = ((ChoiceAnswer) (question.getAnswer())).getBinaryAnswer();
		// String[] a = ((ChoiceAnswer) (question.getAnswer())).getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Multiple Choice Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());
		ArrayList<JCheckBox> jchbs = new ArrayList<JCheckBox>();
		for (int i = 0; i < item.size(); i++) {
			JCheckBox jchb = new JCheckBox(item.get(i));
			if (selected[i] == 1) {
				jchb.setSelected(true);
			}
			jchb.setEnabled(false);
			jchbs.add(jchb);
			add(jchb);
			add(new JPanel());
			add(new JPanel());
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
				GridLayout layout = new GridLayout(0, 3);
				setLayout(layout);
				// TODO Auto-generated method stub
				removeAll();
				add(jlQ);
				add(jtaQ);
				jtaQ.setEditable(true);
				add(new JPanel());

				add(new JLabel("Enter Score:"));
				add(jtaS);
				jtaS.setEditable(true);
				add(new JPanel());
				add(jlN);
				add(jtaNum);
				add(new JLabel("输入后敲击回车"));
				// 第三行开始，又加12行
				for (int i = 0; i < 33; i++) {
					add(new JPanel());
				}
				// add(jbtNext);
				updateUI();
				jtaNum.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int num = Integer.parseInt(jtaNum.getText());

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
							jbtSetAns.addActionListener(new setAnsListener2());
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

				jtaNext.setEnabled(false);
				jtaSave.setEnabled(true);
				jtaPre.setEnabled(false);
				jtaModify.setEnabled(false);
			}

		});

		updateUI();
	}

	class setAnsListener2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 41; i >= 6; i--) {
				remove(i);
			}
			ArrayList<JCheckBox> jtfAnss2 = new ArrayList<JCheckBox>();
			for (int i = 0; i < jtfAnss.size(); i++) {
				JCheckBox jchb = new JCheckBox();
				jchb.setText(jtfAnss.get(i).getText());
				items.add(jtfAnss.get(i).getText());
				add(jchb);
				jtfAnss2.add(jchb);
				add(new JPanel());
				add(new JPanel());

			}
			int num = jtfAnss.size();
			for (int i = 0; i < 36 - 3 * num; i++) {
				add(new JPanel());
			}
			add(jtaPre);
			add(jtaModify);
			add(jtaSave);

			add(jtaNext);
			jtaSave.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					GridLayout layout = new GridLayout(0, 3);
					setLayout(layout);
					String ans = "";
					for (int i = 0; i < jtfAnss2.size(); i++) {
						if (jtfAnss2.get(i).isSelected()) {
							ans += i;
							ans += " ";
						}
					}
					ans = ans.substring(0, ans.length() - 1);
					// System.out.println(ans);

					/* 交互后端 */
					QuestionModifier qc = new QuestionModifier();
					ChoiceAnswer answer = new ChoiceAnswer(ans);
					ChoiceQuestion question = new ChoiceQuestion(jtaQ.getText(), items, answer,
							Integer.parseInt(jtaS.getText()));
					ModifyChoiceQuestion adq = new ModifyChoiceQuestion(page, question, index, qc);
					ModifyQuestionAgent aqa = new ModifyQuestionAgent();
					aqa.modifyQuestionOrder(adq);

					GridLayout layout1 = new GridLayout(0, 4);
					setLayout(layout1);

					String q = question.getPrompt();
					List<String> item = question.getItem();
					int[] selected = ((ChoiceAnswer) (question.getAnswer())).getBinaryAnswer();
					// String[] a = ((ChoiceAnswer)
					// (question.getAnswer())).getAnswer();
					String score = String.valueOf(question.getScore());
					removeAll();
					removeAll();
					jtaQ.setText(q);
					jtaQ.setEditable(false);
					jtaS.setText(score);
					jtaS.setEditable(false);

					add(new JPanel());
					add(new JLabel((index + 1) + ". Multiple Choice Question:"));
					add(jtaQ);
					add(new JPanel());

					add(new JPanel());
					add(new JLabel("Enter Score:"));
					add(jtaS);
					add(new JPanel());
					ArrayList<JCheckBox> jchbs = new ArrayList<JCheckBox>();
					for (int i = 0; i < item.size(); i++) {
						JCheckBox jchb = new JCheckBox(item.get(i));
						if (selected[i] == 1) {
							jchb.setSelected(true);
						}
						jchb.setEnabled(false);
						jchbs.add(jchb);
						add(jchb);
						add(new JPanel());
						add(new JPanel());
						add(new JPanel());
					}
					add(jtaPre);
					add(jtaModify);
					add(jtaSave);
					jtaSave.setEnabled(false);
					add(jtaNext);

					jtaQ.setEditable(false);
					jtaS.setEditable(false);

					jtaSave.setEnabled(false);
					jtaNext.setEnabled(true);
					jtaPre.setEnabled(true);
					jtaModify.setEnabled(true);
					updateUI();// 刷新界面
				}

			});
			updateUI();// 刷新界面
		}
	}

	void addComponentForAnswering(Page page, Question question1, int index, String name) {
		// TODO Auto-generated method stub
		this.index = index;
		this.page = page;
		// TODO Auto-generated method stub
		GridLayout layout = new GridLayout(0, 4);
		this.setLayout(layout);
		ChoiceQuestion question = (ChoiceQuestion) question1;
		String q = question.getPrompt();
		List<String> item = question.getItem();

		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Multiple Choice Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());
		ArrayList<JCheckBox> jchbs = new ArrayList<JCheckBox>();
		for (int i = 0; i < item.size(); i++) {
			JCheckBox jchb = new JCheckBox(item.get(i));

			jchb.setEnabled(true);
			jchbs.add(jchb);
			add(jchb);
			add(new JPanel());
			add(new JPanel());
			add(new JPanel());
		}
		add(jtaPre);
		add(jtaSubmit);
		add(new JPanel());
		add(jtaNext);
		jtaSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/* answer */
				String ans = "";
				for (int i = 0; i < jchbs.size(); i++) {
					if (jchbs.get(i).isSelected()) {
						ans += i;
						ans += " ";
					}
				}
				ans = ans.substring(0, ans.length() - 1);
				AnswerCreator receiver = new AnswerCreator();

				ChoiceAnswer answer = new ChoiceAnswer(ans);// @@@@统一一下answer
															// 的string格式
				AddChoiceAnswer command = new AddChoiceAnswer(page, answer, index, receiver, name);
				AddAnswerAgent invoker = new AddAnswerAgent();
				invoker.placeAnswer(command);
			}

		});
		updateUI();
	}
}

class RankQuestionPanel extends QuestionPanel {

	JTextField jtaQ = new JTextField(20);
	JTextField jtaS = new JTextField(20);
	JTextField jtaNum = new JTextField(5);
	JLabel jlQ = new JLabel("Enter Question:");
	JLabel jlN = new JLabel("Enter number of elements:");
	JButton jbtNext = new JButton("Next");
	List<String> items = new ArrayList<String>();

	RankQuestionPanel(boolean isTest, JPanel outter) {

		// TODO Auto-generated constructor stub
		super(isTest, outter);
		GridLayout layout = new GridLayout(0, 3);
		this.setLayout(layout);
	}

	@Override
	void addComponentForCreating(final Page page) {
		add(jlQ);
		add(jtaQ);
		add(new JPanel());
		JTextField jtaS = new JTextField(20);

		if (isTest) {
			add(new JLabel("Enter Score:"));
			add(jtaS);
			add(new JPanel());
		} else {
			add(new JPanel());
			add(new JPanel());
			add(new JPanel());
		}

		add(jlN);
		add(jtaNum);
		add(new JLabel("哥们 敲回车"));
		// 第三行开始，又加12行
		for (int i = 1; i < 34; i++) {
			add(new JPanel());
		}
		// add(jbtNext);
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
				add(jtaAdd);
				jtaAdd.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub

						String ans = "";
						for (int i = 0; i < num; i++) {
							items.add(jtfAns.get(i).getText());
							ans += i;
							ans += " ";

						}
						ans = ans.substring(0, ans.length() - 1);
						// System.out.println(ans);
						if (isTest) {
							/* 交互后端 */
							QuestionCreator qc = new QuestionCreator();
							RankAnswer answer = new RankAnswer(ans);
							RankQuestion question = new RankQuestion(jtaQ.getText(), items, answer,
									Integer.parseInt(jtaS.getText()));
							AddRankQuestion adq = new AddRankQuestion(page, question, qc);
							AddQuestionAgent aqa = new AddQuestionAgent();
							aqa.placeQuestion(adq);
						} else {
							QuestionCreator qc = new QuestionCreator();

							RankQuestion question = new RankQuestion(jtaQ.getText(), items);
							AddRankQuestion adq = new AddRankQuestion(page, question, qc);
							AddQuestionAgent aqa = new AddQuestionAgent();
							aqa.placeQuestion(adq);
						}

						JOptionPane.showMessageDialog(null, "successful", "Add", JOptionPane.INFORMATION_MESSAGE);
						// outter.removeAll();
						CardLayout card = (CardLayout) outter.getLayout();
						card.show(outter, "blank");
						// 清空
						{
							jtaQ.setText("");
							jtaS.setText("");
							addComponentForCreating(page);

							updateUI();
						}
					}

				});
				updateUI();
			}
		});
	}

	// @Override
	void addComponentForDisplaying(Question question1, int index) {
		// TODO Auto-generated method stub
		// totallly 42 grids
		RankQuestion question = ((RankQuestion) question1);
		String q = question.getPrompt();
		JLabel jlQ = new JLabel((index + 1) + ". Rank Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(q);
		add(new JPanel());

		List<String> items = question.getItem();
		// items=items.sort(null);
		Collections.sort(items);
		int num = items.size();

		for (int i = 0; i < items.size(); i++) {
			JCheckBox jchb = new JCheckBox();
			jchb.setText(items.get(i));
			jchb.setEnabled(false);
			add(jchb);

			add(new JPanel());
			add(new JPanel());

		}

		for (int i = 0; i < 36 - 3 * num; i++) {
			add(new JPanel());
		}
		add(jtaPre);

		add(new JPanel());
		add(jtaNext);
		updateUI();// 刷新界面
	}

	public void addComponentForModifying(Page page, Question question1, int index) {
		// TODO Auto-generated method stub
		this.page = page;
		setLayout(new GridLayout(0, 4));
		RankQuestion question = (RankQuestion) question1;
		String q = question.getPrompt();
		String[] a = ((RankAnswer) (question.getAnswer())).getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Rank Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());

		List<String> items = question.getItem();
		// items=items.sort(null);
		Collections.sort(items);
		int num = items.size();
		ArrayList<JTextField> jtfs = new ArrayList<JTextField>();
		for (int i = 0; i < items.size(); i++) {
			JTextField jchb = new JTextField();
			jchb.setText(items.get(i));
			jchb.setEditable(false);
			jtfs.add(jchb);
			add(jchb);

			add(new JPanel());
			add(new JPanel());
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
				for (int i = 0; i < jtfs.size(); i++) {
					jtfs.get(i).setEditable(true);
				}
				jtaQ.setEditable(true);
				jtaS.setEditable(true);
				jtaNext.setEnabled(false);
				jtaPre.setEnabled(false);
				jtaModify.setEnabled(false);
			}

		});
		jtaSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ans = "";
				List<String> items = new ArrayList<String>();
				for (int i = 0; i < num; i++) {
					items.add(jtfs.get(i).getText());
					ans += i;
					ans += " ";

				}
				ans = ans.substring(0, ans.length() - 1);
				// System.out.println(ans);

				/* 交互后端 */
				QuestionModifier qc = new QuestionModifier();
				RankAnswer answer = new RankAnswer(ans);
				RankQuestion question = new RankQuestion(jtaQ.getText(), items, answer,
						Integer.parseInt(jtaS.getText()));
				ModifyRankQuestion adq = new ModifyRankQuestion(page, question, index, qc);
				ModifyQuestionAgent aqa = new ModifyQuestionAgent();
				aqa.modifyQuestionOrder(adq);

				jtaQ.setEditable(false);
				jtaS.setEditable(false);
				for (int i = 0; i < jtfs.size(); i++) {
					jtfs.get(i).setEditable(false);
				}
				jtaSave.setEnabled(false);
				jtaNext.setEnabled(true);
				jtaPre.setEnabled(true);
				jtaModify.setEnabled(true);
				updateUI();// 刷新界面
			}

		});
		updateUI();

	}

	void addComponentForAnswering(Page page, Question question1, int index, String name) {
		// TODO Auto-generated method stub
		this.page = page;
		setLayout(new GridLayout(0, 4));
		RankQuestion question = (RankQuestion) question1;
		String q = question.getPrompt();
		String[] a = ((RankAnswer) (question.getAnswer())).getAnswer();
		String score = String.valueOf(question.getScore());
		removeAll();
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		jtaS.setText(score);
		jtaS.setEditable(false);

		add(new JPanel());
		add(new JLabel((index + 1) + ". Rank Question:"));
		add(jtaQ);
		add(new JPanel());

		add(new JPanel());
		add(new JLabel("Enter Score:"));
		add(jtaS);
		add(new JPanel());

		List<String> items = question.getItem();
		// items=items.sort(null);
		// Collections.sort(items);

		ArrayList<JTextField> jtfs = new ArrayList<JTextField>();
		for (int i = 0; i < items.size(); i++) {
			JTextField jchb = new JTextField();
			jchb.setText(i + ") " + items.get(i));
			jchb.setEditable(false);
			jtfs.add(jchb);
			add(jchb);

			add(new JPanel());
			add(new JPanel());
			add(new JPanel());

		}

		add(new JLabel("将选项序号输入 以空格隔开"));
		JTextField ans = new JTextField(10);
		add(ans);
		add(new JPanel());
		add(new JPanel());

		add(jtaPre);
		add(jtaSubmit);
		add(new JPanel());
		add(jtaNext);
		jtaSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/* answer */

				AnswerCreator receiver = new AnswerCreator();

				RankAnswer answer = new RankAnswer(ans.getText());// @@@@统一一下answer
																	// 的string格式
				AddRankAnswer command = new AddRankAnswer(page, answer, index, receiver, name);
				AddAnswerAgent invoker = new AddAnswerAgent();
				invoker.placeAnswer(command);
			}

		});
		updateUI();
	}
}

class MapQuestionPanel extends QuestionPanel {
	JTextField jtaQ = new JTextField(20);
	JTextField jtaS = new JTextField(20);
	JTextField jtaLNum = new JTextField(5);
	JTextField jtaRNum = new JTextField(5);
	JLabel jlQ = new JLabel("Enter Question:");
	JLabel jlS = new JLabel("Enter Score:");
	JLabel jlLN = new JLabel("Enter number of elements:");
	JLabel jlRN = new JLabel("Enter number of elements:");

	List<JTextField> lefts = new ArrayList<JTextField>();
	List<JTextField> rights = new ArrayList<JTextField>();

	int min;
	boolean leftBig;
	int max;

	MapQuestionPanel(boolean isTest, JPanel outter) {
		super(isTest, outter);
		// TODO Auto-generated constructor stub
	}

	@Override
	void addComponentForCreating(Page page) {
		this.page = page;

		removeAll();
		add(new JPanel());
		add(jlQ);
		add(jtaQ);
		add(new JPanel());
		if (isTest) {
			add(new JPanel());
			add(jlS);
			add(jtaS);
			add(new JPanel());
		} else {
			add(new JPanel());
			add(new JPanel());
			add(new JPanel());
			add(new JPanel());
		}

		add(jlLN);
		add(new JPanel());
		add(jlRN);
		add(new JPanel());

		add(jtaLNum);
		add(new JPanel());
		add(jtaRNum);
		add(new JLabel("输入后敲击回车"));

		// 第三行开始，又加12行
		for (int i = 0; i < 32; i++) {
			add(new JPanel());
		}
		// add(jbtNext);

		jtaRNum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int numR = Integer.parseInt(jtaRNum.getText());
				int numL = Integer.parseInt(jtaLNum.getText());

				for (int i = 47; i >= 16; i--) {
					remove(i);
				}

				min = (numR < numL) ? numR : numL;
				max = (numR > numL) ? numR : numL;
				leftBig = (numR < numL) ? true : false;
				for (int i = 0; i < min; i++) {
					JTextField jtaAL = new JTextField(10);
					JTextField jtaAR = new JTextField(10);
					add(jtaAL);
					add(new JPanel());
					add(jtaAR);
					add(new JPanel());

					lefts.add(jtaAL);
					rights.add(jtaAR);
				}
				for (int i = 0; i < max - min; i++) {
					if (leftBig) {
						JTextField jtaAL = new JTextField(10);
						add(jtaAL);
						add(new JPanel());
						add(new JPanel());
						add(new JPanel());
						lefts.add(jtaAL);
					} else {
						JTextField jtaAR = new JTextField(10);
						add(new JPanel());
						add(new JPanel());
						add(jtaAR);
						add(new JPanel());

						rights.add(jtaAR);
					}
				}
				if (isTest) {
					add(new JPanel());
					add(new JPanel());
					add(new JPanel());
					JButton jbtSetAns = new JButton("Set Answers");
					add(jbtSetAns);
					jbtSetAns.addActionListener(new setAnsListener());
				} else {
					add(new JPanel());
					add(new JPanel());
					add(new JPanel());
					JButton jbtSetAns = new JButton("Next");
					add(jbtSetAns);
					jbtSetAns.addActionListener(new setAnsListener());
				}
				updateUI();// 刷新界面
			}
		});
	}

	class setAnsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 16 + (max + 1) * 4 - 1; i >= 0; i--) {
				remove(i);
			}
			add(new JPanel());
			add(jlQ);
			add(new JLabel(jtaQ.getText()));
			add(new JPanel());

			
			ArrayList<JTextField> labels = new ArrayList<JTextField>();
			if (isTest) {
				add(new JPanel());
				add(jlS);
				add(new JLabel(jtaS.getText()));
				add(new JPanel());
				for (int i = 0; i < min; i++) {
					JLabel jtaAL = new JLabel(lefts.get(i).getText());
					JLabel jtaAR = new JLabel(rights.get(i).getText());
					add(jtaAL);
					JTextField label = new JTextField(5);
					labels.add(label);
					add(label);

					add(new JPanel());
					add(jtaAR);

				}
				for (int i = 0; i < max - min; i++) {
					if (leftBig) {
						JLabel jtaAL = new JLabel(lefts.get(i).getText());
						add(jtaAL);
						JTextField label = new JTextField(5);
						labels.add(label);
						add(label);
						add(new JPanel());
						add(new JPanel());
					} else {
						JLabel jtaAR = new JLabel(rights.get(i).getText());
						add(new JPanel());
						add(new JPanel());

						add(new JPanel());
						add(jtaAR);
					}
				}
				for (int i = 0; i < 16; i++) {
					add(new JPanel());
				}
				add(new JPanel());
				add(new JPanel());
				add(new JPanel());
			}
			add(jtaAdd);
			jtaAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					if (isTest) {
						int[][] ans = new int[labels.size()][2];
						for (int i = 0; i < labels.size(); i++) {
							ans[i][0] = i;
							ans[i][1] = Integer.parseInt(labels.get(i).getText());
						}
						List<String> items1 = new ArrayList<String>();
						List<String> items2 = new ArrayList<String>();
						for (int i = 0; i < lefts.size(); i++) {
							items1.add(lefts.get(i).getText());
						}
						for (int i = 0; i < rights.size(); i++) {
							items2.add(rights.get(i).getText());
						}
						/* 交互后端 */
						QuestionCreator qc = new QuestionCreator();
						MapAnswer answer = new MapAnswer(ans);
						MapQuestion question = new MapQuestion(jtaQ.getText(), items1, items2, answer,
								Integer.parseInt(jtaS.getText()));
						AddMapQuestion adq = new AddMapQuestion(page, question, qc);
						AddQuestionAgent aqa = new AddQuestionAgent();
						aqa.placeQuestion(adq);
					} else {

						List<String> items1 = new ArrayList<String>();
						List<String> items2 = new ArrayList<String>();
						for (int i = 0; i < lefts.size(); i++) {
							items1.add(lefts.get(i).getText());
						}
						for (int i = 0; i < rights.size(); i++) {
							items2.add(rights.get(i).getText());
						}
						/* 交互后端 */
						QuestionCreator qc = new QuestionCreator();

						MapQuestion question = new MapQuestion(jtaQ.getText(), items1, items2);
						AddMapQuestion adq = new AddMapQuestion(page, question, qc);
						AddQuestionAgent aqa = new AddQuestionAgent();
						aqa.placeQuestion(adq);
					}

					JOptionPane.showMessageDialog(null, "successful", "Add", JOptionPane.INFORMATION_MESSAGE);
					// outter.removeAll();
					CardLayout card = (CardLayout) outter.getLayout();
					card.show(outter, "blank");
					// 清空
					{
						jtaQ.setText("");
						jtaS.setText("");
						addComponentForCreating(page);

						updateUI();
					}
				}

			});
			updateUI();// 刷新界面
		}
	}

	@Override
	void addComponentForDisplaying(Question question1, int index) {
		// TODO Auto-generated method stub
		MapQuestion question = (MapQuestion) question1;

		String q = question.getPrompt();
		JLabel jlQ = new JLabel((index + 1) + ". Matching Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(q);
		add(new JPanel());
		add(new JPanel());

		List<String> items1 = question.getLeftItem();
		List<String> items2 = question.getRightItem();
		// items=items.sort(null);
		// Collections.sort(items1);
		// Collections.sort(items2);
		int numR = items2.size();
		int numL = items1.size();

		int min = (numR < numL) ? numR : numL;
		int max = (numR > numL) ? numR : numL;
		boolean leftBig = (numR < numL) ? true : false;
		for (int i = 0; i < min; i++) {
			JLabel jtaAL = new JLabel(i + ") " + items1.get(i));
			JLabel jtaAR = new JLabel(i + ") " + items2.get(i));
			add(jtaAL);
			add(new JPanel());
			add(jtaAR);
			add(new JPanel());

		}
		for (int i = 0; i < max - min; i++) {
			if (leftBig) {
				JLabel jtaAL = new JLabel((min + i) + ") " + items1.get(min + i));
				add(jtaAL);
				add(new JPanel());
				add(new JPanel());
				add(new JPanel());

			} else {
				JLabel jtaAR = new JLabel((min + i) + ") " + items2.get(min + i));
				add(new JPanel());
				add(new JPanel());
				add(jtaAR);
				add(new JPanel());
			}
		}
		for (int i = 0; i < 16; i++) {
			add(new JPanel());
		}
		add(jtaPre);

		add(new JPanel());
		add(jtaNext);
		updateUI();// 刷新界面
	}

	public void addComponentForModifying(Page page, Question question1, int index) {
		// TODO Auto-generated method stub
		MapQuestion question = (MapQuestion) question1;
		String q = question.getPrompt();
		// String a = ((MapAnswer) (question.getAnswer())).getAnswer();
		int[][] a = ((MapAnswer) (question.getAnswer())).getAnswerPair();

		String score = String.valueOf(question.getScore());

		JLabel jlQ = new JLabel((index + 1) + ". Matching Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		add(new JPanel());
		add(new JPanel());

		add(jlS);
		add(jtaS);
		jtaS.setText(score);
		jtaS.setEditable(false);
		add(new JPanel());
		add(new JPanel());

		List<String> items1 = question.getLeftItem();
		List<String> items2 = question.getRightItem();
		// items=items.sort(null);
		// Collections.sort(items1);
		// Collections.sort(items2);
		int numR = items2.size();
		int numL = items1.size();

		ArrayList<JTextField> lefts = new ArrayList<JTextField>();
		ArrayList<JTextField> pair = new ArrayList<JTextField>();
		ArrayList<JTextField> rights = new ArrayList<JTextField>();
		int min = (numR < numL) ? numR : numL;
		int max = (numR > numL) ? numR : numL;
		boolean leftBig = (numR < numL) ? true : false;
		// System.out.println(Arrays.toString(a[0]));
		for (int i = 0; i < min; i++) {

			JTextField jtf1 = new JTextField((i) + ") " + items1.get(i));
			JTextField jtf2 = new JTextField((i) + ") " + items2.get(i));
			JTextField jtf3 = new JTextField("" + a[i][1]);

			jtf1.setEditable(false);
			jtf2.setEditable(false);
			jtf3.setEditable(false);
			lefts.add(jtf1);
			pair.add(jtf3);
			rights.add(jtf2);

			add(jtf1);
			add(jtf3);
			add(jtf2);
			add(new JPanel());

		}
		for (int i = 0; i < max - min; i++) {
			if (leftBig) {
				JTextField jtf1 = new JTextField((min + i) + ") " + items1.get(min + i));

				JTextField jtf3 = new JTextField("" + a[min + i][1]);
				jtf1.setEditable(false);

				jtf3.setEditable(false);
				lefts.add(jtf1);
				pair.add(jtf3);

				add(jtf1);
				add(jtf3);
				add(new JPanel());
				add(new JPanel());

			} else {
				JTextField jtf2 = new JTextField((min + i) + ") " + items2.get(i + min));

				jtf2.setEditable(false);

				rights.add(jtf2);
				add(new JPanel());
				add(new JPanel());
				add(jtf2);
				add(new JPanel());
			}
		}
		for (int i = 0; i < 16; i++) {
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

				jtaNext.setEnabled(false);
				jtaPre.setEnabled(false);
				jtaModify.setEnabled(false);

				for (int i = 0; i < lefts.size(); i++) {
					lefts.get(i).setEditable(true);
				}
				for (int i = 0; i < pair.size(); i++) {
					pair.get(i).setEditable(true);
				}
				for (int i = 0; i < rights.size(); i++) {
					rights.get(i).setEditable(true);
				}
			}

		});
		jtaSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int[][] ans = new int[lefts.size()][2];
				for (int i = 0; i < lefts.size(); i++) {
					ans[i][0] = i;
					ans[i][1] = Integer.parseInt(pair.get(i).getText());
				}
				List<String> items1 = new ArrayList<String>();
				List<String> items2 = new ArrayList<String>();
				for (int i = 0; i < lefts.size(); i++) {
					items1.add(lefts.get(i).getText());
				}
				for (int i = 0; i < rights.size(); i++) {
					items2.add(rights.get(i).getText());
				}
				/* 交互后端 */
				QuestionModifier qc = new QuestionModifier();
				MapAnswer answer = new MapAnswer(ans);
				MapQuestion question = new MapQuestion(jtaQ.getText(), items1, items2, answer,
						Integer.parseInt(jtaS.getText()));
				ModifyMapQuestion adq = new ModifyMapQuestion(page, question, index, qc);
				ModifyQuestionAgent aqa = new ModifyQuestionAgent();
				aqa.modifyQuestionOrder(adq);

				jtaQ.setEditable(false);
				jtaS.setEditable(false);

				jtaSave.setEnabled(false);
				jtaNext.setEnabled(true);
				jtaPre.setEnabled(true);
				jtaModify.setEnabled(true);
			}

		});
		updateUI();

	}

	void addComponentForAnswering(Page page, Question question1, int index, String name) {
		// TODO Auto-generated method stub
		MapQuestion question = (MapQuestion) question1;
		String q = question.getPrompt();
		// String a = ((MapAnswer) (question.getAnswer())).getAnswer();
		int[][] a = ((MapAnswer) (question.getAnswer())).getAnswerPair();

		String score = String.valueOf(question.getScore());

		JLabel jlQ = new JLabel((index + 1) + ". Matching Question");
		add(jlQ);
		add(jtaQ);
		jtaQ.setText(q);
		jtaQ.setEditable(false);
		add(new JPanel());
		add(new JPanel());

		add(jlS);
		add(jtaS);
		jtaS.setText(score);
		jtaS.setEditable(false);
		add(new JPanel());
		add(new JPanel());

		List<String> items1 = question.getLeftItem();
		List<String> items2 = question.getRightItem();
		// items=items.sort(null);
		// Collections.sort(items1);
		// Collections.sort(items2);
		int numR = items2.size();
		int numL = items1.size();

		ArrayList<JTextField> lefts = new ArrayList<JTextField>();
		ArrayList<JTextField> pair = new ArrayList<JTextField>();
		ArrayList<JTextField> rights = new ArrayList<JTextField>();
		int min = (numR < numL) ? numR : numL;
		int max = (numR > numL) ? numR : numL;
		boolean leftBig = (numR < numL) ? true : false;
		// System.out.println(Arrays.toString(a[0]));
		for (int i = 0; i < min; i++) {

			JTextField jtf1 = new JTextField((i) + ") " + items1.get(i));
			JTextField jtf2 = new JTextField((i) + ") " + items2.get(i));
			JTextField jtf3 = new JTextField();

			jtf1.setEditable(false);
			jtf2.setEditable(false);

			lefts.add(jtf1);
			pair.add(jtf3);
			rights.add(jtf2);

			add(jtf1);
			add(jtf3);
			add(jtf2);
			add(new JPanel());

		}
		for (int i = 0; i < max - min; i++) {
			if (leftBig) {
				JTextField jtf1 = new JTextField((min + i) + ") " + items1.get(min + i));

				JTextField jtf3 = new JTextField();
				jtf1.setEditable(false);

				lefts.add(jtf1);
				pair.add(jtf3);

				add(jtf1);
				add(jtf3);
				add(new JPanel());
				add(new JPanel());

			} else {
				JTextField jtf2 = new JTextField((min + i) + ") " + items2.get(i + min));

				jtf2.setEditable(false);

				rights.add(jtf2);
				add(new JPanel());
				add(new JPanel());
				add(jtf2);
				add(new JPanel());
			}
		}
		for (int i = 0; i < 16; i++) {
			add(new JPanel());
		}
		add(jtaPre);
		add(jtaSubmit);
		add(new JPanel());
		add(jtaNext);
		jtaSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				/* answer */
				int[][] ans = new int[lefts.size()][2];
				for (int i = 0; i < lefts.size(); i++) {
					ans[i][0] = i;
					Pattern pattern = Pattern.compile("[0-9]*");
				        
					if(pattern.matcher(pair.get(i).getText()).matches()){
						ans[i][1] = Integer.parseInt(pair.get(i).getText());
					}else{
						ans[i][1]=-1;
					}
					
				}
				List<String> items1 = new ArrayList<String>();
				List<String> items2 = new ArrayList<String>();
				for (int i = 0; i < lefts.size(); i++) {
					items1.add(lefts.get(i).getText());
				}
				for (int i = 0; i < rights.size(); i++) {
					items2.add(rights.get(i).getText());
				}
				AnswerCreator receiver = new AnswerCreator();

				MapAnswer answer = new MapAnswer(ans);// @@@@统一一下answer
														// 的string格式
				AddMapAnswer command = new AddMapAnswer(page, answer, index, receiver, name);
				AddAnswerAgent invoker = new AddAnswerAgent();
				invoker.placeAnswer(command);
			}

		});
		updateUI();
	}
}
