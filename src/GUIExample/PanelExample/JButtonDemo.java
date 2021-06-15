package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo extends JFrame {
    public JButtonDemo(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        URL url = JButtonDemo.class.getResource("1.jpg");
        ImageIcon icon = new ImageIcon(url);

        JButton button = new JButton();
        button.setIcon(icon);
        button.setToolTipText("图片按钮");

        container.add(button);
    }

    public static void main(String[] args) {
        new JButtonDemo();
    }
}
