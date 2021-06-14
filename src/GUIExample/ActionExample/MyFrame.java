package GUIExample.ActionExample;

import java.awt.*;

public class MyFrame extends Frame {
    MyFrame(){
        TextField textField = new TextField();
        add(textField);

        textField.addActionListener(e -> {
            TextField t = (TextField)e.getSource();
            System.out.println(t.getText());
            t.setText("");
        });

        textField.setEchoChar('*');
        setVisible(true);
        pack();
    }
}
