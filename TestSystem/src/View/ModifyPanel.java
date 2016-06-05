package View;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import Paper.Page;
import Question.Question;

public class ModifyPanel extends JPanel {
	JTextArea jta = new JTextArea();
	String pageName;
	String personName;
	int type;

	ModifyPanel(Page page, boolean isTest) {
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
				tfPanel.addComponentForModifying(page,question, index);
				add("tf", tfPanel);

				break;
			case Question.CHOICE:
				MCQuestionPanel mcPanel = new MCQuestionPanel(isTest, this);
				mcPanel.addComponentForModifying(page,question, index);
				add("mc", mcPanel);
				break;
			case Question.SHORTESSAY:
				SAQuestionPanel saPanel = new SAQuestionPanel(isTest, this);
				saPanel.addComponentForModifying(page,question, index);
				add("sa", saPanel);
				break;
			case Question.ESSAY:
				EssayQuestionPanel essayPanel = new EssayQuestionPanel(isTest, this);
				essayPanel.addComponentForModifying(page,question, index);
				add("essay", essayPanel);
				break;
			case Question.RANK:
				RankQuestionPanel rankingPanel = new RankQuestionPanel(isTest, this);
				rankingPanel.addComponentForModifying(page,question, index);
				add("rank", rankingPanel);
				break;
			case Question.MAP:
				MapQuestionPanel mappingPanel = new MapQuestionPanel(isTest, this);
				mappingPanel.addComponentForModifying(page,question, index);
				add("map", mappingPanel);
				break;
			}
		}
	}
}
