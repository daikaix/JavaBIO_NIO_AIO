package GUIExample.PanelExample;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ComboBoxDemo2 extends JFrame {
    public ComboBoxDemo2(){
        setBounds(10,10,200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();

        String[] contents = {"1","2","3"};
        //Vector contents = new Vector();
        JList jList = new JList(contents);

        container.add(jList);

        jList.addListSelectionListener(e -> {
            JList list = (JList)e.getSource();
            System.out.println(list.getSelectedIndex()+" "+list.getSelectedValue());
        });
    }

    public static void main(String[] args) {
        new ComboBoxDemo2();
    }
}
