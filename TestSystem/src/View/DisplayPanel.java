package View;

import javax.swing.*;

import Paper.Page;
import Question.Question;

import java.awt.*;

/**
 * Created by Chow on 2016/5/30.
 */
public class DisplayPanel extends JPanel {
	JTextArea jta = new JTextArea();

	DisplayPanel(Page page, boolean isTest) {
		// 参数是可以显示test或survey内容的数据类的实例
		setLayout(new CardLayout());
		/*
		 * jta.setText(content); jta.setLineWrap(true);
		 * jta.setWrapStyleWord(true); jta.setEditable(false); JScrollPane
		 * scrollPane=new JScrollPane(jta); setBorder
		 * (BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		 * add(scrollPane,BorderLayout.CENTER);
		 */
		System.out.println(page.getPageName());
		System.out.println(page.getQuestionList().size());
		
		int index = -1;
		for (Question question : page.getQuestionList()) {
			index++;
			switch (question.getType()) {
			case Question.DECIDE:
				TFQuestionPanel tfPanel = new TFQuestionPanel(isTest, this);
				tfPanel.addComponentForDisplaying(question, index);
				add("tf", tfPanel);

				break;
			case Question.CHOICE:
				MCQuestionPanel mcPanel = new MCQuestionPanel(isTest, this);
				mcPanel.addComponentForDisplaying(question,index);
				add("mc", mcPanel);
				break;
			case Question.SHORTESSAY:
				SAQuestionPanel saPanel = new SAQuestionPanel(isTest, this);
				saPanel.addComponentForDisplaying(question,index);
				add("sa", saPanel);
				break;
			case Question.ESSAY:
				EssayQuestionPanel essayPanel = new EssayQuestionPanel(isTest, this);
				essayPanel.addComponentForDisplaying(question,index);
				add("essay", essayPanel);
				break;
			case Question.RANK:
				RankQuestionPanel rankingPanel = new RankQuestionPanel(isTest, this);
				rankingPanel.addComponentForDisplaying(question,index);
				add("rank", rankingPanel);
				break;
			case Question.MAP:
				MapQuestionPanel mappingPanel = new MapQuestionPanel(isTest, this);
				mappingPanel.addComponentForDisplaying(question,index);
				add("map", mappingPanel);
				break;
			}
		}
	}
}
