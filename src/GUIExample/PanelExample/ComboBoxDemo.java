package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ComboBoxDemo extends JFrame {
    public ComboBoxDemo(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();

        JComboBox status = new JComboBox();
        status.addItem(null);
        status.addItem("123");
        status.addItem("455");
        status.addItem("1232");

        status.addActionListener(e -> {
            System.out.println(""+e.getActionCommand()+e.getModifiers());
            JComboBox box = (JComboBox)e.getSource();
            System.out.println(box.getSelectedIndex()+" "+box.getSelectedItem());

        });

        container.add(status);
    }

    public static void main(String[] args) {
        new ComboBoxDemo();
    }
}
