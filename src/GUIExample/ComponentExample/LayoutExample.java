package GUIExample.ComponentExample;

import javafx.scene.layout.Pane;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 第一个界面
public class LayoutExample {
    public static void main(String[] args) {
        Frame frame = new Frame("戴凯旋");

        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        frame.add(panel1,BorderLayout.NORTH);
        frame.add(panel2,BorderLayout.SOUTH);

        Button button1 = new Button("Button");
        Button button2 = new Button("Button");
        Button button3 = new Button("Button");
        Button button4 = new Button("Button");
        Button button5 = new Button("Button");
        Button button6 = new Button("Button");
        Button button7 = new Button("Button");
        Button button8 = new Button("Button");
        Button button9 = new Button("Button");
        Button button10 = new Button("Button");

        Panel panel1_1 = new Panel();
        panel1.add(button1,BorderLayout.WEST);
        panel1.add(panel1_1,BorderLayout.CENTER);
        panel1.add(button2,BorderLayout.EAST);

        Panel panel2_1 = new Panel();
        panel2.add(button3,BorderLayout.WEST);
        panel2.add(panel2_1,BorderLayout.CENTER);
        panel2.add(button4,BorderLayout.EAST);

        panel1_1.setLayout(new GridLayout(1,2));
        panel2_1.setLayout(new GridLayout(2,2));
        panel1_1.add(button5);
        panel1_1.add(button6);
        panel2_1.add(button7);
        panel2_1.add(button8);
        panel2_1.add(button9);
        panel2_1.add(button10);

        frame.pack(); // 最优布局
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}