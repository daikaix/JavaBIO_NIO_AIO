package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;

public class JScrollDemo extends JFrame {
    public JScrollDemo(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();


        JTextArea jTextArea = new JTextArea(20,50);
        jTextArea.setText("asdasdasd");
        JScrollPane pane = new JScrollPane(jTextArea);
        container.add(pane);
    }

    public static void main(String[] args) {
        new JScrollDemo();
    }
}
