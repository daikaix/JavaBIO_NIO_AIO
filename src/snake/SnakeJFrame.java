package snake;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SnakeJFrame extends JFrame {
    public SnakeJFrame(){
        setBounds(10,10,900,720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        add(new GamePanel());
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new SnakeJFrame();
    }
}
