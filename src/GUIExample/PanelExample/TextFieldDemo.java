package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;

public class TextFieldDemo extends JFrame {
    public TextFieldDemo(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();

        JTextField jTextField = new JTextField("Hello");
        JTextField jTextField2 = new JTextField("world",20);


        container.add(jTextField,BorderLayout.NORTH);
        container.add(jTextField2,BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new TextFieldDemo();
    }
}
