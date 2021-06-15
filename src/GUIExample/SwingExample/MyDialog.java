package GUIExample.SwingExample;

import javax.swing.*;
import java.awt.*;

public class MyDialog extends JDialog {
    public MyDialog(MyJFrame2 frame){
        super(frame,"第一个JDialog窗体",true);
        setBounds(100,100,500,500);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.add(new JLabel("这是一个对话框"));
        setVisible(true);
    }
}
