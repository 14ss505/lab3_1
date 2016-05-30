import java.awt.*;

import javax.swing.*;

public class SystemFrame extends JFrame {
	public JPanel leftPanel=new JPanel();
	public JPanel rightPanel=new JPanel();


	public SystemFrame() {
		this.setSize(900, 600);
		setLayout(new BorderLayout());
		this.setTitle("TestSystem");
		add(leftPanel, BorderLayout.WEST);
		add(rightPanel, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initLeftPanel();
	}

    public void initLeftPanel() {
        CardLayout card=new CardLayout();
        leftPanel.setLayout(card);
		leftPanel.setBorder (BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));

		FirstMenuPanel firstMenuPanel=new FirstMenuPanel(leftPanel,rightPanel);
		SecondMenuPanel secondMenuPanel=new SecondMenuPanel(rightPanel,leftPanel);

        leftPanel.add("1",firstMenuPanel);
        leftPanel. add("2",secondMenuPanel);
		
	}

}
