package GUIExample.ComponentExample;

import java.awt.*;

public class MyFrame extends Frame {
    private static int id = 0;
    MyFrame(int x, int y, int w, int h, Color color){
        super("Myframe+"+(++id));
        setVisible(true);
        setBounds(x,y,w,h);
        setBackground(color);
    }
}
