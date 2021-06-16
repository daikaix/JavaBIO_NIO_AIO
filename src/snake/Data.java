package snake;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Data {
    public static URL headerURL = Data.class.getResource("statics/header.png");
    public static ImageIcon getHeader(){
        ImageIcon header = new ImageIcon(headerURL);
        header.setImage(header.getImage().getScaledInstance(850, 60, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        return header;
    }


    public static URL upURL = Data.class.getResource("statics/up.png");
    public static URL downURL = Data.class.getResource("statics/down.png");
    public static URL leftURL = Data.class.getResource("statics/left.png");
    public static URL rightURL = Data.class.getResource("statics/right.png");
    public static ImageIcon getDown(){
        ImageIcon imageIcon = new ImageIcon(downURL);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        return imageIcon;
    }public static ImageIcon getUp(){
        ImageIcon imageIcon = new ImageIcon(upURL);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        return imageIcon;
    }public static ImageIcon getLeft(){
        ImageIcon imageIcon = new ImageIcon(leftURL);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        return imageIcon;
    }
    public static ImageIcon getRight(){
        ImageIcon imageIcon = new ImageIcon(rightURL);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        return imageIcon;
    }

    public static URL bodyURL = Data.class.getResource("statics/body.png");
    public static URL foodURL = Data.class.getResource("statics/food.png");
    public static ImageIcon getBody(){
        ImageIcon imageIcon = new ImageIcon(bodyURL);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        return imageIcon;
    }
    public static ImageIcon getFood(){
        ImageIcon imageIcon = new ImageIcon(foodURL);
        imageIcon.setImage(imageIcon.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT ));//可以用下面三句代码来代替
        return imageIcon;
    }


}
