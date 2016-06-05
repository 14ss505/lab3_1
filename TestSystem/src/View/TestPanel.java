package View;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Paper.Page;
import Question.Question;

public class TestPanel extends JPanel {
	JTextArea jta = new JTextArea();
	String pageName;
	String personName;
	int type;

	TestPanel(Page page, boolean isTest,String name) {
		// 参数是可以显示test或survey内容的数据类的实例
		setLayout(new CardLayout());
		/*
		 * jta.setText(content); jta.setLineWrap(true);
		 * jta.setWrapStyleWord(true); jta.setEditable(false); JScrollPane
		 * scrollPane=new JScrollPane(jta); setBorder
		 * (BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		 * add(scrollPane,BorderLayout.CENTER);
		 */
	 
		int index = -1;
		for (Question question : page.getQuestionList()) {
			index++;
			switch (question.getType()) {
			case Question.DECIDE:
				TFQuestionPanel tfPanel = new TFQuestionPanel(isTest, this);
				tfPanel.addComponentForAnswering(page,question, index,name);
				add("tf", tfPanel);

				break;
			case Question.CHOICE:
				MCQuestionPanel mcPanel = new MCQuestionPanel(isTest, this);
				mcPanel.addComponentForAnswering(page,question, index,name);
				add("mc", mcPanel);
				break;
			case Question.SHORTESSAY:
				SAQuestionPanel saPanel = new SAQuestionPanel(isTest, this);
				saPanel.addComponentForAnswering(page,question, index,name);
				add("sa", saPanel);
				break;
			case Question.ESSAY:
				EssayQuestionPanel essayPanel = new EssayQuestionPanel(isTest, this);
				essayPanel.addComponentForAnswering(page,question, index,name);
				add("essay", essayPanel);
				break;
			case Question.RANK:
				RankQuestionPanel rankingPanel = new RankQuestionPanel(isTest, this);
				rankingPanel.addComponentForAnswering(page,question, index,name);
				add("rank", rankingPanel);
				break;
			case Question.MAP:
				MapQuestionPanel mappingPanel = new MapQuestionPanel(isTest, this);
				mappingPanel.addComponentForAnswering(page,question, index,name);
				add("map", mappingPanel);
				break;
			}
		}
	}
}
