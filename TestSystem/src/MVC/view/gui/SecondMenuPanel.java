import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SecondMenuPanel extends MenuPanel {
    private ZButton jbtTF = new ZButton("T/F Question", "tf");
    private ZButton jbtMC = new ZButton("MultipleChoice Question", "mc");
    private ZButton jbtSA = new ZButton("ShortAnswer Question", "sa");
    private ZButton jbtEssay = new ZButton("Essay Question", "essay");
    private ZButton jbtRanking = new ZButton("Ranking Question", "rank");
    private ZButton jbtMatching = new ZButton("Matching Question", "map");
    private JButton jbtPrev = new JButton("Previous");

    JPanel outter;


    public SecondMenuPanel(JPanel controlledPanel, JPanel outter) {
        super(controlledPanel);
        this.outter = outter;
        setLayout(new GridLayout(7, 1));
        this.add(jbtTF);
        this.add(jbtMC);
        this.add(jbtSA);
        this.add(jbtEssay);
        this.add(jbtRanking);
        this.add(jbtMatching);
        this.add(jbtPrev);

        jbtPrev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //return to the first Menu
                CardLayout card = (CardLayout) outter.getLayout();
                card.show(outter, "1");
                controlledPanel.removeAll();

            }
        });

    }
}