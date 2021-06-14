package GUIExample.ComponentExample;

import java.awt.*;

// 第一个界面
public class GridLayoutTest {
    public static void main(String[] args) {
        Frame frame = new Frame("戴凯旋");

        // Command+D
        Button button1 = new Button("East");
        Button button2 = new Button("West");
        Button button3 = new Button("South");
        Button button4 = new Button("North");
        Button button5 = new Button("Center");
        Button button6 = new Button("Center");

        // split Horizontally
        frame.setLayout(new GridLayout(3,2));
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);
        frame.add(button6);

        frame.pack(); // 最优布局
        frame.setVisible(true);
    }
}