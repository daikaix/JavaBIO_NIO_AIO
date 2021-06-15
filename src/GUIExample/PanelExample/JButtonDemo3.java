package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo3 extends JFrame {
    public JButtonDemo3(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        URL url = JButtonDemo3.class.getResource("1.jpg");
        ImageIcon icon = new ImageIcon(url);

        JCheckBox button1 = new JCheckBox("01");
        JCheckBox button2 = new JCheckBox("02");
        JCheckBox button3 = new JCheckBox("03");
        JCheckBox button4 = new JCheckBox("04");

        container.add(button1,BorderLayout.EAST);
        container.add(button2,BorderLayout.WEST);
        container.add(button3,BorderLayout.SOUTH);
        container.add(button4,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new JButtonDemo3();
    }
}
