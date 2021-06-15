package GUIExample.SwingExample;

import javax.swing.*;
import java.awt.*;

public class MyJFrame2 extends JFrame{
    public MyJFrame2(){
        setBounds(10,10,200,200);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(null);
        container.setBackground(Color.green);

        JButton button = new JButton("点击");
        button.setBounds(30,30,200,50);

        container.add(button);

        //监听事件
        button.addActionListener(e -> {
            new MyDialog(this);
        });

        setVisible(true);
    }
}
