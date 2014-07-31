package Beans;

import javax.swing.*;

public class Test
{
    public static void main(String[] args)
    {
        final ImageIcon icon = new ImageIcon("/home/paras/Desktop/t2.jpg");
        
        JOptionPane.showMessageDialog(null, "", "TransferringFile", JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
