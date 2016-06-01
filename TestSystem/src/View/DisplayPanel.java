package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Chow on 2016/5/30.
 */
public class DisplayPanel extends JPanel {
	JTextArea jta = new JTextArea();

	DisplayPanel(String content, boolean isTest) {
		// 参数是可以显示test或survey内容的数据类的实例
		setLayout(new CardLayout());
		/*
		 * jta.setText(content); jta.setLineWrap(true);
		 * jta.setWrapStyleWord(true); jta.setEditable(false); JScrollPane
		 * scrollPane=new JScrollPane(jta); setBorder
		 * (BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		 * add(scrollPane,BorderLayout.CENTER);
		 */

		TFQuestionPanel tfPanel = new TFQuestionPanel(isTest);
		MCQuestionPanel mcPanel = new MCQuestionPanel(isTest);
		SAQuestionPanel saPanel = new SAQuestionPanel(isTest);
		EssayQuestionPanel essayPanel = new EssayQuestionPanel(isTest);
		RankQuestionPanel rankingPanel = new RankQuestionPanel(isTest);
		MapQuestionPanel mappingPanel = new MapQuestionPanel(isTest);

		// cardLayout

		tfPanel.addComponentForDisplaying();
		mcPanel.addComponentForDisplaying();
		saPanel.addComponentForDisplaying();
		essayPanel.addComponentForDisplaying();
		rankingPanel.addComponentForDisplaying();
		mappingPanel.addComponentForDisplaying();

		add("tf", tfPanel);
		add("mc", mcPanel);
		add("sa", saPanel);
		add("essay", essayPanel);
		add("rank", rankingPanel);
		add("map", mappingPanel);

	}
}
