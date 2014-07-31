package Beans;

import javax.swing.*;

import java.awt.*;
import java.io.IOException;

public class ButtonImage extends JFrame {

    JButton b;
    JPanel p;

    ButtonImage() {
        p = new JPanel(null);
        b = new JButton();
        b.setBounds(80, 40, 400, 250);
        b.setBackground(Color.black);
        ImageIcon img = new ImageIcon("/home/paras/Desktop/transfer2.jpg");
        b.setIcon(img);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        p.add(b);
        add(p);
       validate();

   }
    public static void main(String args[]) throws IOException {
        ButtonImage ob = new ButtonImage();
        ob.setVisible(true);
    }
}
