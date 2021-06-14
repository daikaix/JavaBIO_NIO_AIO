package GUIExample.ActionExample;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculate extends Frame {
    Calculate(){
        TextField textField1 = new TextField(10);
        TextField textField2 = new TextField(10);
        TextField textField3 = new TextField(20);
        Label label = new Label("+");
        Button button = new Button("=");

        setLayout(new FlowLayout());
        add(textField1);
        add(label);
        add(textField2);
        add(button);
        add(textField3);


        //addAction
        button.addActionListener(e -> {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());

            textField3.setText(""+(num1+num2));
            textField1.setText("");
            textField2.setText("");
        });

        setSize(500,500);
        setVisible(true);
        pack();
        windowClose(this);
    }

    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
