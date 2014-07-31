package View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.UIManager;

public class StartPro implements ActionListener{

	
	JFrame frame;
	JButton b1;
	JButton b3;
	JLabel l1;
	JPanel panel;
	public StartPro()
	{
		panel=new JPanel();
		
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    } catch (Exception evt) {}
		frame = new JFrame("Demand_Paging");
		ImageIcon imageForOne = new ImageIcon(getClass().getResource("Capture1.JPG"));
		//frame.setContentPane(new JLabel(imageForOne));
		l1=new JLabel(imageForOne);
		l1.setSize(500, 500);
		panel.add(l1);
		panel.setBounds(25, 25, 500, 400);
		//panel.setContentPane(new JLabel(imageForOne));
	   frame.add(panel);
		
		b1=new JButton("Simulation");
		b3=new JButton("Exit");
		//b1.setForeground(Color.red);
		b1.setBounds(100, 450, 170, 50);
		
		b3.setBounds(300, 450, 150,50);
		
		b1.addActionListener(this);
		
		b3.addActionListener(this);
		//b1.setOpaque(true);
		frame.add(b3);
		frame.add(b1);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(550, 550);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
			frame.setVisible(false);
			SplitPane sp=new SplitPane();
			sp.run(null);
		}
		
		if(e.getSource()==b3)
		{
			System.exit(0);
		}
	}
}
