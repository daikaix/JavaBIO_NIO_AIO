package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;

public class JPanelDemo extends JFrame {
    public JPanelDemo(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new GridLayout(2,1,10,10));

        JPanel panel1 = new JPanel(new GridLayout(1,3));
        panel1.add(new JButton("1"));
        panel1.add(new JButton("2"));
        panel1.add(new JButton("3"));

        container.add(panel1);
    }

    public static void main(String[] args) {
        new JPanelDemo();
    }
}
