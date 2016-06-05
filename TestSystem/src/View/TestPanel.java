package View;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import Paper.Page;
import Question.Question;
import Paper.Test;

public class TestPanel extends JPanel {
	JFrame outter;
	int time;

	TestPanel(Page page, boolean isTest, String name, JFrame outter) {
		// 参数是可以显示test或survey内容的数据类的实例
		setLayout(new CardLayout());
		this.outter = outter;
		this.time = ((Test) page).getTestMinute()*60;
		// add(new JLabel("you have completed the task,close this window to make
		// love"));
		/*
		 * jta.setText(content); jta.setLineWrap(true);
		 * jta.setWrapStyleWord(true); jta.setEditable(false); JScrollPane
		 * scrollPane=new JScrollPane(jta); setBorder
		 * (BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		 * add(scrollPane,BorderLayout.CENTER);
		 */
		JButton fuckoff = new JButton("get your jerk grade?");
	//	add(fuckoff);
		int index = -1;
		for (Question question : page.getQuestionList()) {
			index++;
			switch (question.getType()) {
			case Question.DECIDE:
				TFQuestionPanel tfPanel = new TFQuestionPanel(isTest, this);
				tfPanel.addComponentForAnswering(page, question, index, name);
				add("tf", tfPanel);

				break;
			case Question.CHOICE:
				MCQuestionPanel mcPanel = new MCQuestionPanel(isTest, this);
				mcPanel.addComponentForAnswering(page, question, index, name);
				add("mc", mcPanel);
				break;
			case Question.SHORTESSAY:
				SAQuestionPanel saPanel = new SAQuestionPanel(isTest, this);
				saPanel.addComponentForAnswering(page, question, index, name);
				add("sa", saPanel);
				break;
			case Question.ESSAY:
				EssayQuestionPanel essayPanel = new EssayQuestionPanel(isTest, this);
				essayPanel.addComponentForAnswering(page, question, index, name);
				add("essay", essayPanel);
				break;
			case Question.RANK:
				RankQuestionPanel rankingPanel = new RankQuestionPanel(isTest, this);
				rankingPanel.addComponentForAnswering(page, question, index, name);
				add("rank", rankingPanel);
				break;
			case Question.MAP:
				MapQuestionPanel mappingPanel = new MapQuestionPanel(isTest, this);
				mappingPanel.addComponentForAnswering(page, question, index, name);
				add("map", mappingPanel);
				break;
			}

			final Timer timer = new Timer(1000, new TimerListener());
			timer.start();
			updateUI();
			// 延迟0毫秒（即立即执行）开始，每隔1000毫秒执行一次

		}
	}

	private class TimerListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			outter.setTitle(--time + "SECONDS left");
			if (time == 0) {
				outter.setVisible(false);
			}

		}

	}
}
