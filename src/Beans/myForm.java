package Beans;

import java.awt.*;
import javax.swing.*;

public class myForm{
    public static void main(String[] args) {       
        JFrame myFrame = new JFrame("SingSong");
        myFrame.setLocation(100,100);
        myFrame.setSize(new Dimension(1024,800));
        myFrame.setLayout(new BorderLayout());
        JPanel jp = new JPanel();
        jp.setBackground(new Color(0x00FF00FF));
        JPanel jp2 = new JPanel(new BorderLayout());
        jp2.setBackground(new Color(0x00000000));

        jp.setPreferredSize(new Dimension(100,400));
        jp2.setPreferredSize(new Dimension(100,400));
        jp2.setLocation(0, 512);

        myFrame.add(jp2, BorderLayout.SOUTH);
        myFrame.add(jp, BorderLayout.NORTH);
    }
} 
