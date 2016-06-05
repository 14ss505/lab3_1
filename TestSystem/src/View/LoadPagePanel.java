package View;

import javax.swing.*;

import Paper.Page;
import util.DataCommand;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chow on 2016/5/30.
 */
public class LoadPagePanel extends JPanel {
	JList jlist;
	FirstMenuPanel first;
	JPanel right;
	JFrame displayFrame = new JFrame();
	java.util.List<String> pageNames;
	String choosedPage;

	boolean isTest;

	LoadPagePanel(boolean isTest, FirstMenuPanel first, JPanel right, List<String> pageNames2) {
		this.pageNames = pageNames2;
		this.isTest = isTest;
		this.right = right;
		this.first = first;
		setLayout(new BorderLayout());
		addList();

		displayFrame.setSize(800, 600);
		displayFrame.setLocationRelativeTo(null);

	}

	void addList() {
		DefaultListModel listModel = new DefaultListModel();

		for (int i = 0; i < pageNames.size(); i++) {
			listModel.addElement(pageNames.get(i));
		}
		jlist = new JList(listModel);
		add(new JScrollPane(jlist), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 5));
		JButton jbtPre = new JButton("Preview");
		JButton jbtDisPlay = new JButton("Display");
		JButton jbtModify = new JButton("Modify");
		JButton jbtTake = new JButton("Take this one");
		JButton jbtTabulate = new JButton("Tabulate");
		panel.add(jbtPre);
		panel.add(jbtDisPlay);
		panel.add(jbtModify);
		panel.add(jbtTake);
		panel.add(jbtTabulate);
		add(panel, BorderLayout.SOUTH);

		jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (e.getClickCount() == 1) {
					jlist.setSelectionBackground(Color.blue);
					// add(new JButton("456456"));
					choosedPage = (String) jlist.getSelectedValue();
					updateUI();
				}
			}
		});

		jbtPre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < first.jbtGroup.size(); i++) {
					first.jbtGroup.get(i).setEnabled(true);
				}
				right.removeAll();
				first.updateUI();
				right.updateUI();
			}
		});

		jbtDisPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// String pageName=(String) jlist.getSelectedValue();
				DataCommand dc = new DataCommand();
				System.out.println(choosedPage);
				Page page = dc.getPage(choosedPage);
				
				// 改掉displayPanel
				// displayFrame.removeAll();
				displayFrame.add(new DisplayPanel(page, isTest));
				displayFrame.setVisible(true);
				// displayFrame.up

			}
		});

		jbtModify.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DataCommand dc = new DataCommand();
				Page page = dc.getPage(choosedPage);
				// 改掉displayPanel
				//displayFrame.removeAll();
				displayFrame.add(new ModifyPanel(page, isTest));
				displayFrame.setVisible(true);
			}
		});

		jbtTake.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name=JOptionPane.showInputDialog("Please your name then we can have a drink");
				DataCommand dc = new DataCommand();
				Page page = dc.createRecord(choosedPage,name);
				displayFrame.add(new TestPanel(page, isTest,name));
				displayFrame.setVisible(true);
			}
		});

		jbtTabulate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFrame.setVisible(true);
			}
		});
	}
}
