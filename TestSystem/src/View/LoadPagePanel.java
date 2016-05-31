package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Chow on 2016/5/30.
 */
public class LoadPagePanel extends JPanel {
    JList jlist;
    FirstMenuPanel first;
    JPanel right;
    JFrame displayFrame=new JFrame();
    DisplayPanel displayPanel=new DisplayPanel("Java的Border是用来呈现围绕Swing组件边缘边框的对象,它本身是一个接口,里面定义了paintBorder、getBorderInsets和isBorderOpaque三个需要实现的方法.如果想用自己的Border类来绘制组件的边框,必须实现这三个方法,里面有很多布局和绘制的问题,比较麻烦.\n" +
            "\n" +
            "Java为了方便使用,提供了虚拟类AbstractBorder,继承它就可以比较简单的实现自己的边框了,但还是有布局和重绘以及组件位置的问题需要自己实现,为此Java又提供了EmptyBorder、CompoundBorder、EtchedBorder、LineBorder、MatteBorder和TitledBorder为我们可以使用的大部分Border提供了实现,并且创立了工厂类BorderFactory为各种Border实现提供实例.");

    LoadPagePanel(FirstMenuPanel first,JPanel right) {
        this.right=right;
        this.first=first;
        setLayout(new BorderLayout());
        addList();
        displayFrame.add(displayPanel);
        displayFrame.setSize(400,300);
        displayFrame.setLocationRelativeTo(null);

    }

    void addList() {
        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Debbie Scott");
        listModel.addElement("Scott Hommel");
        listModel.addElement("Sharon Zakhour");
        listModel.addElement("Debbie Scott");
        listModel.addElement("Scott Hommel");
        listModel.addElement("Sharon Zakhour");
        jlist = new JList(listModel);
        add(new JScrollPane(jlist),BorderLayout.CENTER);

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(0,5));
        JButton jbtPre=new JButton("Preview");
        JButton jbtDisPlay=new JButton("Display");
        JButton jbtModify=new JButton("Modify");
        JButton jbtTake=new JButton("Take this one");
        JButton jbtTabulate=new JButton("Tabulate");
        panel.add(jbtPre);
        panel.add(jbtDisPlay);
        panel.add(jbtModify);
        panel.add(jbtTake);
        panel.add(jbtTabulate);
        add(panel,BorderLayout.SOUTH);

        jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    jlist.setSelectionBackground(Color.blue);
                  //  add(new JButton("456456"));
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
                displayFrame.setVisible(true);
            }
        });
    }
}
