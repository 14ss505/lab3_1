package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Chow on 2016/5/30.
 */
public class DisplayPanel extends JPanel {
    JTextArea jta=new JTextArea();

    DisplayPanel(String content) {
    //参数是可以显示test或survey内容的数据类的实例
        setLayout(new BorderLayout());
        jta.setText(content);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
        jta.setEditable(false);
        JScrollPane scrollPane=new JScrollPane(jta);
       setBorder (BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
        add(scrollPane,BorderLayout.CENTER);

    }
}
