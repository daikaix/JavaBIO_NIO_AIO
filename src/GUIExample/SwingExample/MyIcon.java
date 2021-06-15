package GUIExample.SwingExample;

import javax.swing.*;
import java.awt.*;

public class MyIcon extends JFrame implements Icon{
    private int width;
    private int height;

    public MyIcon(){
    }

    public MyIcon(int width,int height){
        this.width = width;
        this.height = height;
    }


    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x,y,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    public void init(){
        MyIcon myIcon = new MyIcon(15,15);
        JLabel label = new JLabel("icontest",myIcon,SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(label);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
