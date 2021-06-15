package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo2 extends JFrame {
    public JButtonDemo2(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        URL url = JButtonDemo2.class.getResource("1.jpg");
        ImageIcon icon = new ImageIcon(url);

        JRadioButton button1 = new JRadioButton("01");
        JRadioButton button2 = new JRadioButton("02");
        JRadioButton button3 = new JRadioButton("03");
        JRadioButton button4 = new JRadioButton("04");

        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);

        container.add(button1,BorderLayout.EAST);
        container.add(button2,BorderLayout.WEST);
        container.add(button3,BorderLayout.SOUTH);
        container.add(button4,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new JButtonDemo2();
    }
}
