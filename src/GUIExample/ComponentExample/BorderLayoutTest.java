package GUIExample.ComponentExample;

import java.awt.*;

// 第一个界面
public class BorderLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("戴凯旋");

        // Command+D
        Button button1 = new Button("East");
        Button button2 = new Button("West");
        Button button3 = new Button("South");
        Button button4 = new Button("North");
        Button button5 = new Button("Center");

        frame.add(button1,BorderLayout.EAST);
        frame.add(button2,BorderLayout.WEST);
        frame.add(button3,BorderLayout.SOUTH);
        frame.add(button4,BorderLayout.NORTH);
        frame.add(button5,BorderLayout.CENTER);

        frame.setSize(300,300);
        frame.setVisible(true);
    }
}