package View;

import javax.swing.*;

import Paper.Page;
import Question.Question;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Chow on 2016/5/29.
 */
public abstract class QuestionPanel extends JPanel {
	JButton jtaAdd = new JButton("Add");
	JButton jtaSave = new JButton("Save");
	JButton jtaNext = new JButton("Next");
	JButton jtaPre = new JButton("Previous");
	JButton jtaSubmit = new JButton("Submit");
	JButton jtaModify = new JButton("Modify");
	QuestionPanel me;

	JPanel outter;
	String pageName;
	Page page;
	String personName;
	int type;
	int score;

	boolean isTest;

	QuestionPanel(boolean isTest, JPanel outter) {
		this.me=this;
		this.outter = outter;
		GridLayout layout = new GridLayout(0, 4);
		setLayout(layout);
		this.isTest = isTest;

		jtaAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});
		jtaNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) outter.getLayout();

				card.next(outter);
			}

		});
		jtaPre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) outter.getLayout();
				card.previous(outter);

			}

		});
		jtaSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CardLayout card = (CardLayout) outter.getLayout();
			//	card.previous(outter);
				
				outter.remove(me);
				outter.updateUI();
				//card.removeLayoutComponent(me);

			}

		});
		jtaModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jtaSave.setEnabled(true);
			}

		});

	}

	void addComponentForCreating(Page page) {
	}

	void addComponentForModifying() {
	}

	abstract void addComponentForAnswering(Page page, Question question, int index,String name);
	// addComponentForDisplaying();

	void addComponentForDisplaying(Question question, int index) {
		// TODO Auto-generated method stub

	}

}
