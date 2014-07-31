package Beans;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GUIFirst {
	
	public GUIFirst()
	{
		JFrame frame=new JFrame("FirstPage");
		
		
		
		frame.setSize(600, 400);
		frame.setLayout(new FlowLayout());
		frame.setVisible(true);
	}

}
